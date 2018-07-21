package de.diedavids.cuba.cefev.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Party implements EnumClass<String> {

    EMPLOYEE("EMPLOYEE"),
    COMPANY("COMPANY"),
    OTHER("OTHER");

    private String id;

    Party(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Party fromId(String id) {
        for (Party at : Party.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}