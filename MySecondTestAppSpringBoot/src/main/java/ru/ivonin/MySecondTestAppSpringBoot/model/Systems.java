package ru.ivonin.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    SERVICE1("Service 1");

    private final String description;

    Systems(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @Override public String toString() {
        return description;
    }

    public static Systems fromDescription(String description) {
        for (Systems system : Systems.values()) {
            if (system.getDescription().equalsIgnoreCase(description)) {
                return system;
            }
        }

        System.err.println("Unknown description received: " + description);
        throw new IllegalArgumentException("Unknown description: " + description);
    }
}