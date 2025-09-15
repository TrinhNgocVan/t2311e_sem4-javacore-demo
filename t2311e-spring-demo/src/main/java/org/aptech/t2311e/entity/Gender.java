package org.aptech.t2311e.entity;

public enum Gender {
    MALE(1),
    FEMALE(2),
    ORTHER(3);

    private final Integer val;

    Gender(Integer val) {
        this.val = val;
    }
}
