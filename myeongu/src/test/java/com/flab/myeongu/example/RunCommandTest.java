package com.flab.myeongu.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class RunCommandTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
    RunCommand runCommand = ac.getBean("runCommand", RunCommand.class);

    @Test
    void printCommands() {
        runCommand.printCommands();
    }

    @Test
    void doCommand() throws InvocationTargetException, IllegalAccessException {
        runCommand.doCommand("say", "hello");
        runCommand.doCommand("think", "world");
    }
}