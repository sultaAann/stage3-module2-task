package com.mjc.school.commands.impl.newsCommand;

import com.mjc.school.MessageHandler;
import com.mjc.school.commands.Command;
import com.mjc.school.controller.impl.NewsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

@Component("2")
public class ReadByIdNewsCommand implements Command {
    @Autowired
    NewsController controller;
    @Autowired
    Scanner scanner;

    @Override
    public void execute() throws InvocationTargetException, IllegalAccessException {
        Method method = MessageHandler.get(2);
        System.out.println("Operation: Get news by id.\n" + "Enter news id:");
        long id = Long.parseLong(scanner.nextLine());
        method.invoke(controller, id);
    }
}
