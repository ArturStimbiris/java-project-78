package hexlet.code.schemas;

public class StringSchema {
    private boolean isRequired = false;
    private int minLength = 0;
    private String containsSubstring = null;

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.containsSubstring = substring;
        return this;
    }

    public boolean isValid(String value) {
        if (isRequired) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        }

        if (value != null && value.length() < minLength) {
            return false;
        }

        if (containsSubstring != null && value != null && !value.contains(containsSubstring)) {
            return false;
        }

        return true;
    }
}
