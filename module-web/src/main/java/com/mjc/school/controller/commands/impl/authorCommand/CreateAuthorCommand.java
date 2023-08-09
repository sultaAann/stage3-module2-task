package com.mjc.school.controller.commands.impl.authorCommand;


import com.mjc.school.controller.MessageHandler;
import com.mjc.school.controller.commands.Command;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.service.dto.AuthorDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


@Component("8")
public class CreateAuthorCommand implements Command {
    @Autowired
    AuthorController controller;
    @Autowired
    Scanner scanner;

    @Override
    public void execute() throws InvocationTargetException, IllegalAccessException {
        Method method = MessageHandler.get(8);
        System.out.println("Operation: Create author. \n" + "Enter Author's name:");
        String name = scanner.nextLine();
        method.invoke(controller, new AuthorDTORequest(null, name));
    }
}
