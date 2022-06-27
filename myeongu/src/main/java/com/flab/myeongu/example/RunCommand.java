package com.flab.myeongu.example;

import com.flab.myeongu.example.annotation.Command;
import com.flab.myeongu.example.annotation.LogExecutionTimeCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RunCommand {

    private final Map<String, Method> methodMap = new LinkedHashMap<>();
    private final SomeObject someObject;

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

    @LogExecutionTimeCheck
    public void printCommands() {

        for (String s : methodMap.keySet()) {
            System.out.println(s + " => " + methodMap.get(s).getName());
        }

    }

    @LogExecutionTimeCheck
    public void doCommand(String action, String word) throws InvocationTargetException, IllegalAccessException {

        Method method = methodMap.get(action);

        if (method == null) {
            throw new IllegalArgumentException("존재하지 않는 action 입니다.");
        }

        method.invoke(someObject, word);
    }

}
