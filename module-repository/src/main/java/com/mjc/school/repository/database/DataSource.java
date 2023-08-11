package com.mjc.school.repository.database;

import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.repository.utils.Utils;

import java.util.List;

public class DataSource {
    private static DataSource INSTANCE;
    private final List<NewsModel> models;
    private final List<AuthorModel> authors;

    private DataSource() {
        this.authors = Utils.readAuthors("authors");
        this.models = Utils.readNews("news", "content");
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
}
