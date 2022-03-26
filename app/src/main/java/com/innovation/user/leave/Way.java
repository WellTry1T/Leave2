package com.innovation.user.leave;

import java.util.ArrayList;
import java.util.List;

public class Way extends ArrayList<String> {
    String titleWay;
    String titleMain;
    int iconCircle;
    int floatingActionButton;
    int description;
    public List<Description> newList = new ArrayList<>();

    public Way(String titleWay,
               String titleMain,
               int iconCircle,
               int floatingActionButton,
               int description) {
        this.titleWay = titleWay;
        this.titleMain = titleMain;
        this.iconCircle = iconCircle;
        this.floatingActionButton = floatingActionButton;
        this.description = description;

    }

    public boolean isImageChanged;

    public boolean isImageChanged() {
        return isImageChanged;
    }

    public void setImageChanged(boolean imageChanged) {
        isImageChanged = imageChanged;
    }

    @Override
    public String toString() {
        return "Way{" +
                "titleWay='" + titleWay + '\'' +
                ", titleMain='" + titleMain + '\'' +
                ", iconCircle=" + iconCircle +
                ", floatingActionButton=" + floatingActionButton +
                ", description=" + description +
                ", newList=" + newList +
                ", isImageChanged=" + isImageChanged +
                '}';
    }
}

