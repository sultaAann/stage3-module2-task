package com.mjc.school.controller;

import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MessageHandler {

    private static final Map<Integer, Method> COMMANDS = new HashMap<>();

    static {
        Class<NewsController> annotatedMethodsClass = NewsController.class;

        for (Method method : annotatedMethodsClass.getDeclaredMethods()) {

            Annotation annotation = method.getAnnotation(CommandHandler.class);
            CommandHandler command = (CommandHandler) annotation;
            COMMANDS.put(command.commandNumber(), method);
        }
        Class<AuthorController> annotatedMethodsClass1 = AuthorController.class;

        for (Method method : annotatedMethodsClass1.getDeclaredMethods()) {

            Annotation annotation = method.getAnnotation(CommandHandler.class);
            CommandHandler command = (CommandHandler) annotation;
            COMMANDS.put(command.commandNumber(), method);
        }
    }

    public static Method get(int num) {
        return COMMANDS.get(num);
    }
}
