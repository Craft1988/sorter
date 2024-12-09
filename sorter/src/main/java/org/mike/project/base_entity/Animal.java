package org.mike.project.base_entity;

import org.mike.project.interfaces.SortableCustomClass;

import java.util.Comparator;

public class Animal implements SortableCustomClass {
    private final String type;
    private final Boolean isWool;
    private final String eyeColor;

    private Animal(AnimalBuilder builder) {
        this.type = builder.type;
        this.isWool = builder.isWool;
        this.eyeColor = builder.eyeColor;
    }

    public static class AnimalBuilder {
        private String type;
        private Boolean isWool;
        private String eyeColor;
        public AnimalBuilder setType(String type) {
            this.type = type;
            return this;
        }
    }

    public String getType() {
        return type;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", isWool=" + isWool +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }

    @Override
    public Comparator<Animal> getCustomComparator() {
        return Comparator.comparing(Animal::getType).thenComparing(Animal::getEyeColor);
    }
}