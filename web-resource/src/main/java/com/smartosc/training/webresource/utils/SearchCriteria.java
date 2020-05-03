package com.smartosc.training.webresource.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SearchCriteria implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    private String key;
    private SearchOperation operation;
    private transient Object value;
    private boolean orPredicate;

    public SearchCriteria(String orPredicate, String key, SearchOperation operation, Object value) {
        super();
        this.orPredicate = orPredicate != null && orPredicate.equals(SearchOperation.OR_PREDICATE_FLAG);
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

}
