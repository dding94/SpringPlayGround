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
    private RunCommand runCommand;

    @Test
    void printCommands() {
        runCommand.printCommands();
    }

    @Test
    void doCommand() throws InvocationTargetException, IllegalAccessException {
        //given
        String actionSay = "say";
        String actionThink = "think";
        String noAction = "";

        //when
        String resultSay = runCommand.doCommand(actionSay, "hello");
        String resultThink = runCommand.doCommand(actionThink, "world");

        //then
        assertThat(resultSay).isEqualTo("say hello");
        assertThat(resultThink).isEqualTo("think about world");
        assertThrows(IllegalArgumentException.class,
                () -> runCommand.doCommand(noAction, "think"));
    }
}