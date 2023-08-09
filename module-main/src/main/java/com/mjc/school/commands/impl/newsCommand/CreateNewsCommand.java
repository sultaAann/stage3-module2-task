package com.mjc.school.commands.impl.newsCommand;

import com.mjc.school.MessageHandler;
import com.mjc.school.commands.Command;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.NewsDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

@Component("3")
public class CreateNewsCommand implements Command {
    @Autowired
    NewsController controller;
    @Autowired
    Scanner scanner;

    @Override
    public void execute() throws InvocationTargetException, IllegalAccessException {
        Method method = MessageHandler.get(3);
        System.out.println("Operation: Create news.\n" + "Enter news title:");
        String title = scanner.nextLine();
        System.out.println("Enter news content:");
        String content = scanner.nextLine();
        System.out.println("Enter author ID");
        Long authorID = Long.parseLong(scanner.nextLine());
        method.invoke(controller, new NewsDTORequest(null, title, content, authorID));
    }
}
