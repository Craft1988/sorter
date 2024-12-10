package org.mike.project.data;

public enum AnimalData {
    TYPES(new String[]{"Tiger", "Crocodile", "Snake", "Dog", "Lion"}),
    EYE_COLORS(new String[]{"red", "orange", "yellow", "green", "blue"});

    AnimalData(final String[] values) {
        this.values = values;
    }

    private final String[] values;

    public String getRandomValue() {
        return values[(int) (Math.random() * values.length)];
    }
}
