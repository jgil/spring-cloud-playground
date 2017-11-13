package com.everis.micro.domain;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private final List<Step> steps;

    public Context(List<Step> steps) {
        this.steps = steps;
    }

    public Context() {
        steps = new ArrayList<Step>();
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void addStep(Step s) {
        steps.add(s);
    }

    public void addContext(Context c) {
        steps.addAll(c.getSteps());
    }
}
