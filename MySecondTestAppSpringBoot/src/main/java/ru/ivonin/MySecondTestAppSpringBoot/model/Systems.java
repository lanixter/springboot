package ru.ivonin.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");

    private final String description;

    Systems(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

    // Метод для получения Systems на основе описания
    public static Systems fromDescription(String description) {
        for (Systems system : Systems.values()) {
            if (system.getDescription().equalsIgnoreCase(description)) { // Используем ignoreCase для чувствительности к регистру
                return system;
            }
        }
        throw new IllegalArgumentException("Unknown description: " + description);
    }
}