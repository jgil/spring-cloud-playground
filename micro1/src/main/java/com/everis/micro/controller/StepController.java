package com.everis.micro.controller;

import com.everis.micro.client.StepClient;
import com.everis.micro.domain.Context;
import com.everis.micro.domain.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;


@RestController
public class StepController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${step.next}")
    private String next;

    @Autowired
    private StepClient stepClient;

    @RequestMapping("/step")
    public Context step1(@RequestBody Context c) throws URISyntaxException {
        if (!"END".equals(next)) {
            c = stepClient.step(next, c);
        }
        Step s = new Step(appName);
        c.addStep(s);
        return c;
    }
}
