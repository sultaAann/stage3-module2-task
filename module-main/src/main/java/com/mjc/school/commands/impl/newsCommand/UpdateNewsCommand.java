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

@Component("4")
public class UpdateNewsCommand implements Command {
    @Autowired
    NewsController controller;
    @Autowired
    Scanner scanner;

    @Override
    public void execute() throws InvocationTargetException, IllegalAccessException {
        Method method = MessageHandler.get(4);
        System.out.println("Operation: Update news.\n" + "Enter news ID");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter news title:");
        String title = scanner.nextLine();
        System.out.println("Enter news content:");
        String content = scanner.nextLine();
        System.out.println("Enter author ID");
        long authorID = Long.parseLong(scanner.nextLine());
        method.invoke(controller, new NewsDTORequest(id, title, content, authorID));
    }
}
