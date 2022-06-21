package com.flab.myeongu.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // solve to
        // a) define annotation @Command
        // b) write function RunCommand.printCommands(), RunCommand.doCommand()
        // java reflection

        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        RunCommand runCommand = ac.getBean("runCommand", RunCommand.class);

        runCommand.printCommands();
        // print out below example
        // say => doSay
        // tell => doTell
        // think => thinkAbout

        runCommand.doCommand("say", "hello");
        // say hello
        runCommand.doCommand("think", "world");
        // think about world

      }
}
