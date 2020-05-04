package com.smartosc.training.webresource.utils;

public enum SearchOperation {

    EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, START_WITH, END_WITH, CONTAINS, LIKE;

    public static final String[] SIMPLE_OPERATION_SET = {":", "!", ">", "<", "~"};

    public static final String OR_PREDICATE_FLAG = "'";

    public static SearchOperation getSimpleOperation(final char input) {
        switch (input) {
            case ':':
                return EQUALITY;
            case '!':
                return NEGATION;
            case '>':
                return GREATER_THAN;
            case '<':
                return LESS_THAN;
            case '~':
                return LIKE;
            default:
                return null;
        }
    }

}
