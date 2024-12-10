package org.mike.project.base_entity;

import org.mike.project.data.AnimalData;
import org.mike.project.interfaces.IAutobuilder;
import org.mike.project.interfaces.ISortableCustomClass;

import java.util.Comparator;

public class Animal implements ISortableCustomClass {
    private final String type;
    private final Boolean isWool;
    private final String eyeColor;

    private Animal(AnimalBuilder builder) {
        this.type = builder.type;
        this.isWool = builder.isWool;
        this.eyeColor = builder.eyeColor;
    }

    public static class AnimalBuilder implements IAutobuilder {
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


        @Override
        public AnimalBuilder randomAutoSet() {
            this.type = AnimalData.TYPES.getRandomValue();
            this.eyeColor = AnimalData.EYE_COLORS.getRandomValue();
            this.isWool = (int) (Math.random() * 100) > 50;
            return this;
        }

        @Override
        public AnimalBuilder fromFileAutoSet() {
            //TODO: add a fill from file implementation
            return null;
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