package com.everis.micro.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Step {
    private final String name;
    private final String time;

    public Step() {
        this.name = "";
        this.time = "";
    }

    public String getName() {

        return name;
    }

    public String getTime() {
        return time;
    }

    public Step(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public Step(String name) {
        this.name = name;

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.time = dateFormat.format(date);
    }
}
