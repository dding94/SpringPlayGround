package com.flab.myeongu.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class RunCommand {

    private final Map<String, Method> methodMap = new LinkedHashMap<>();
    private final SomeObject someObject;

    @Autowired
    public RunCommand(SomeObject someObject) {
        this.someObject = someObject;
    }

    @PostConstruct
    public void init() {
        Method[] methods = someObject.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Command.class)) {
                String action = method.getDeclaredAnnotation(Command.class).action();
                methodMap.put(action, method);
            }
        }
    }

    public void printCommands() {

        for (String s : methodMap.keySet()) {
            System.out.println(s + " => " + methodMap.get(s).getName());
        }

    }

    public void doCommand(String action, String word) throws InvocationTargetException, IllegalAccessException {

        Method method = methodMap.get(action);

        if (method == null) {
            throw new IllegalArgumentException("존재하지 않는 action 입니다.");
        }

        method.invoke(someObject, word);
    }

}
