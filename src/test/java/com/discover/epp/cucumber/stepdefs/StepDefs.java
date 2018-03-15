package com.discover.epp.cucumber.stepdefs;

import com.discover.epp.TransacationdetailsApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = TransacationdetailsApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
