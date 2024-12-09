package org.mike.project.container;

import org.mike.project.interfaces.SortableCustomClass;

import java.util.List;

public class ContentHolder<T extends SortableCustomClass>{
    private List<T> content;
    private boolean isSorted;
    private static ContentHolder<SortableCustomClass> instance = null;

    public static ContentHolder getInstance() {
        if (instance == null) {
            instance = new ContentHolder<>();
        }
        return instance;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }

    public List<T> getContent() {
        return content;
    }

    public boolean isSorted() {
        return isSorted;
    }
}
