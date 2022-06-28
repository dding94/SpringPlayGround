package com.flab.myeongu.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


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
        String doSay = runCommand.doCommand("say", "hello");
        String thinkWorld = runCommand.doCommand("think", "world");

        assertThat(doSay).isEqualTo("say hello");
        assertThat(thinkWorld).isEqualTo("think about world");
        assertThrows(IllegalArgumentException.class,
                () -> runCommand.doCommand("noAction", "think"));
    }
}