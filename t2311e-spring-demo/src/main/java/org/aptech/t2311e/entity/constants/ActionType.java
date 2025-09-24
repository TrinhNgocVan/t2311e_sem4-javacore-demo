package org.aptech.t2311e.entity.constants;

public enum ActionType
{

    SAVE_CLASSROOM("SAVE_CLASSROOM"),
    SEARCH_CLASSROOM("SEARCH_CLASSROOM"),
    ;

    private final String val;

    ActionType(String val) {
        this.val = val;
    }
}
