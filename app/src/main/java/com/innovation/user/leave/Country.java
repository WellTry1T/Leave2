package com.innovation.user.leave;

import java.util.ArrayList;
import java.util.List;

class Country {
    String title;
    String titleHeader;
    String titleHeaderCountry;
    String titleHeaderCountryBelow;
    int img;

    public Country(String title,
                   String titleHeader,
                   String titleHeaderCountry,
                   String titleHeaderCountryBelow,
                   int img) {
        this.title = title;
        this.titleHeader = titleHeader;
        this.titleHeaderCountry = titleHeaderCountry;
        this.titleHeaderCountryBelow = titleHeaderCountryBelow;
        this.img = img;
    }
}

