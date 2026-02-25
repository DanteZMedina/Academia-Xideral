package com.bootcamp.week3.ex3;

import java.util.ArrayList;
import java.util.List;

public record ValidationResult(boolean isValid, List<String> errors) {

    public static ValidationResult valid() {
        return new ValidationResult(true, List.of());
    }

    public static ValidationResult invalid(String... errors) {
        return new ValidationResult(false, List.of(errors));
    }

    public ValidationResult merge(ValidationResult other) {

        if (this.isValid && other.isValid) {
            return valid();
        }

        List<String> allErrors = new ArrayList<>(this.errors);
        allErrors.addAll(other.errors);

        return new ValidationResult(false, allErrors);
    }
}