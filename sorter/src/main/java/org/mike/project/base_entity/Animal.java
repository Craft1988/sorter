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

        public AnimalBuilder setWool(boolean isWool) {
            this.isWool = isWool;
            return this;
        }

        public AnimalBuilder setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Animal build() {
            return new Animal(this);
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
        return
                type + " with " + eyeColor + " eyes, and" + (isWool ? " with wool" : " without wool");
    }

    @Override
    public Comparator<Animal> getCustomComparator() {
        return Comparator.comparing(Animal::getType).thenComparing(Animal::getEyeColor);
    }
}