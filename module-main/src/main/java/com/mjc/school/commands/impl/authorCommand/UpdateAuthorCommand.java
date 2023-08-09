package com.mjc.school.commands.impl.authorCommand;

import com.mjc.school.MessageHandler;
import com.mjc.school.commands.Command;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.service.dto.AuthorDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

@Component("9")
public class UpdateAuthorCommand implements Command {
    @Autowired
    AuthorController controller;
    @Autowired
    Scanner scanner;

    @Override
    public void execute() throws InvocationTargetException, IllegalAccessException {
        Method method = MessageHandler.get(9);
        System.out.println("Operation: Update author by id.\n" + "Enter author id:");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Author's name:");
        String name = scanner.nextLine();
        method.invoke(controller, new AuthorDTORequest(id, name));
    }
}
