package com.innovation.user.leave;

import java.util.ArrayList;

public class Description extends ArrayList<String> {
    String titleDesc;
    String mainDesc;
    int fab;

    public Description(String titleDesc, String mainDesc, int fab) {
        this.titleDesc = titleDesc;
        this.mainDesc = mainDesc;
        this.fab = fab;
    }

    @Override
    public String toString() {
        return "Description{" +
                "titleDesc='" + titleDesc + '\'' +
                ", mainDesc='" + mainDesc + '\'' +
                ", fab=" + fab +
                '}';
    }
}

