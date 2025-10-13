package org.aptech.t2311e.entity.constants;

public enum RoleEnum {
    ADMIN("ADMIN"),
    USER("USER"),
    OPERATOR("OPERATOR");

    private final String name;

    RoleEnum(String name) {
        this.name = name;
    }
}
