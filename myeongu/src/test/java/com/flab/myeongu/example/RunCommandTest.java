package com.flab.myeongu.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.InvocationTargetException;


@SpringBootTest
class RunCommandTest {

    @Autowired
    RunCommand runCommand;

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