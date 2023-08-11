package com.mjc.school.repository.utils;

import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.model.impl.NewsModel;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static List<AuthorModel> readAuthors(String fileName) {
        List<AuthorModel> res = new ArrayList<>();
        for (String el : readFile(fileName)) {
            long id = res.size() + 1;
            AuthorModel author = new AuthorModel();
            author.setId(id);
            author.setName(el);
            author.setCreatedDate(LocalDateTime.now());
            res.add(author);
        }
        return res;
    }

    public static List<NewsModel> readNews(String newsFile, String contentFile) {
        List<NewsModel> res = new ArrayList<>();
        List<String> news = readFile(newsFile);
        List<String> contents = readFile(contentFile);
        for (int i = 0; i < news.size(); i++) {
            long id = res.size() + 1;
            NewsModel newsModel = new NewsModel();
            newsModel.setId(id);
            newsModel.setCreateDate(LocalDateTime.now());
            newsModel.setTitle(news.get(i));
            newsModel.setContent(contents.get(i));
            Random rand = new Random();
            newsModel.setAuthorId((long) 1 + rand.nextInt(31 - 1));
            res.add(newsModel);
        }
        return res;
    }

    private static List<String> readFile(String path) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(path);
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }
        return result;
    }
}
