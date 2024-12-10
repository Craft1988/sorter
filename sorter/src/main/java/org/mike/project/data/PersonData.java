package org.mike.project.data;

public enum PersonData {
    MALE_FIRST_NAMES(new String[]{"Aleksandr", "Andrey", "Mikhail", "Sergey"}),
    MALE_LAST_NAMES(new String[]{"Ivanov", "Petrov", "Vasiliev", "Borisov"}),
    FEMALE_FIRST_NAMES(new String[]{"Aleksandra", "Christina", "Milana", "Svetlana"}),
    FEMALE_LAST_NAMES(new String[]{"Ivanova", "Petrova", "Vasilieva", "Borisova"});

    private PersonData(final String[] values) {
        this.values = values;
    }

    private final String[] values;

    public String getRandomValue() {
        return values[(int) (Math.random() * values.length)];
    }
}
