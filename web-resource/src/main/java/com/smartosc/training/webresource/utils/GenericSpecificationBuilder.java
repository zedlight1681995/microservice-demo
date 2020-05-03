package com.smartosc.training.webresource.utils;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class GenericSpecificationBuilder<T> {

    private List<SearchCriteria> params;

    public GenericSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public GenericSpecificationBuilder<T> with(
            String orPredicate, String key, String operation, Object value, String prefix, String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) {
                boolean startWithAsterisk = prefix.contains("*");
                boolean endWithAsterisk = suffix.contains("*");

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.END_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.START_WITH;
                }
            }
            params.add(new SearchCriteria(orPredicate, key, op, value));
        }
        //set condition status == 1
        params.add(new SearchCriteria(null, "status", SearchOperation.EQUALITY, 1));
        return this;
    }

    public Specification<T> build() {
        if (CollectionUtils.isEmpty(params)) {
            return null;
        }

        Specification<T> result = new GenericSpecification<>(params.get(0));
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new GenericSpecification<>(params.get(i)))
                    : Specification.where(result).and(new GenericSpecification<>(params.get(i)));
        }
        return result;
    }

}
