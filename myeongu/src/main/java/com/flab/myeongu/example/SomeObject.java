package com.flab.myeongu.example;

import com.flab.myeongu.example.annotation.Command;
import org.springframework.stereotype.Component;

@Component
public class SomeObject {

    @Command(action = "say")
    public String doSay(String word) {
        return "say" + " " + word;
    }

    @Command(action = "tell")
    public String doTell(String word) {
        return "tell" + " " + word;
    }

    @Command(action = "think")
    public String thinkAbout(String word) {
        return "think about" + " " + word;
    }

}
