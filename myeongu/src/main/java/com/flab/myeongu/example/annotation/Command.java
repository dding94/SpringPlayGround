package com.flab.myeongu.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)// 컴파일 이후에도 JVM에 의해서 참조가 가능
@Target(ElementType.METHOD) //어노테이션을 메소드에 제한하기 위함
public @interface Command {
    String action() default "";
}
