package com.mjc.school.commands.impl.authorCommand;

import com.mjc.school.MessageHandler;
import com.mjc.school.commands.Command;
import com.mjc.school.controller.impl.AuthorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

@Component("10")
public class DeleteAuthorCommand implements Command {
    @Autowired
    AuthorController controller;
    @Autowired
    Scanner scanner;

    @Override
    public void execute() throws InvocationTargetException, IllegalAccessException {
        Method method = MessageHandler.get(10);
        System.out.println("Operation: Delete author by id.\n" + "Enter author id:");
        long id = Long.parseLong(scanner.nextLine());
        method.invoke(controller, id);
    }
}
