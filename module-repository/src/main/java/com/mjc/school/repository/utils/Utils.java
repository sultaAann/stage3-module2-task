package com.mjc.school.repository.utils;

import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.model.impl.NewsModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static List<AuthorModel> readAuthors(String fileName) {
        List<AuthorModel> res = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("module-repository/src/main/resources/" + fileName))) {
            while (scanner.hasNextLine()) {
                long id = res.size() + 1;
                AuthorModel author = new AuthorModel();
                author.setId(id);
                author.setName(scanner.nextLine());
                author.setCreatedDate(LocalDateTime.now());
                res.add(author);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static List<NewsModel> readNews(String newsFile, String contentFile) {
        List<NewsModel> res = new ArrayList<>();
        try (Scanner content = new Scanner(new File("module-repository/src/main/resources/" + contentFile)); Scanner news = new Scanner(new File("module-repository/src/main/resources/" + newsFile))) {
            while (content.hasNextLine() && news.hasNextLine()) {
                long id = res.size() + 1;
                NewsModel newsModel = new NewsModel();
                newsModel.setId(id);
                newsModel.setCreateDate(LocalDateTime.now());
                newsModel.setTitle(news.nextLine());
                newsModel.setContent(content.nextLine());
                Random rand = new Random();
                newsModel.setAuthorId((long) 1 + rand.nextInt(31 - 1));
                res.add(newsModel);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
