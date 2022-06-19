package com.flab.myeongu.example;

import org.springframework.stereotype.Component;

@Component
public class SomeObjectImpl implements SomeObject{

    @Command(action = "say")
    public void doSay(String word) {
        System.out.println("say " + word);
    }

    @Command(action = "tell")
    public void doTell(String word) {
        System.out.println("tell " + word);
    }

    @Command(action = "think")
    public void thinkAbout(String word) {
        System.out.println("think about " + word);
    }

}
