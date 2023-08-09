package com.mjc.school.controller.commands.impl.newsCommand;


import com.mjc.school.controller.MessageHandler;
import com.mjc.school.controller.commands.Command;
import com.mjc.school.controller.impl.NewsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component("1")
public class ReadAllNewsCommand implements Command {
    @Autowired
    NewsController controller;

    @Override
    public void execute() throws InvocationTargetException, IllegalAccessException {
//        controller.readAll().forEach(System.out::println);
        Method method = MessageHandler.get(1);
        method.invoke(controller);
    }
}
