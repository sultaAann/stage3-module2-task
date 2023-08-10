package com.mjc.school.repository.database;

import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.model.impl.NewsModel;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class DataSource {
    private static DataSource INSTANCE;
    private final List<NewsModel> models = new ArrayList<>();
    private final List<AuthorModel> authors = new ArrayList<>();

    private DataSource() {
        readDefaultData();
    }

    public static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSource();
        }
        return INSTANCE;
    }

    public List<NewsModel> getModels() {
        return models;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    private void readDefaultData() {
        readAuthors();
        readContentsAndNews();
    }
    private void readAuthors() {
        try (Scanner scanner = new Scanner(new File("module-repository/src/main/resources/authors"))) {
            while (scanner.hasNextLine()) {
                long id = authors.size() + 1;
                AuthorModel author = new AuthorModel();
                author.setId(id);
                author.setName(scanner.nextLine());
                author.setCreatedDate(LocalDateTime.now());
                authors.add(author);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void readContentsAndNews() {
        try (Scanner content = new Scanner(new File("module-repository/src/main/resources/content"));
             Scanner news = new Scanner(new File("module-repository/src/main/resources/news"))) {
            while (content.hasNextLine() && news.hasNextLine()) {
                long id = models.size() + 1;
                NewsModel newsModel = new NewsModel();
                newsModel.setId(id);
                newsModel.setCreateDate(LocalDateTime.now());
                newsModel.setTitle(news.nextLine());
                newsModel.setContent(content.nextLine());
                Random rand = new Random();
                newsModel.setAuthorId((long) rand.nextInt(30));
                models.add(newsModel);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
