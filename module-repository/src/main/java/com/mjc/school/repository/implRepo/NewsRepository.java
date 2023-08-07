package com.mjc.school.repository.implRepo;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.database.DataSource;
import com.mjc.school.repository.model.impl.NewsModel;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class NewsRepository implements BaseRepository<NewsModel, Long> {

    List<NewsModel> newsModels = DataSource.getInstance().getModels();
    @Override
    public List<NewsModel> readAll() {
        return newsModels;
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return newsModels.stream()
                .filter(newsModel -> newsModel.getId().equals(id))
                .findFirst();
    }

    @Override
    public NewsModel create(NewsModel entity) {
        NewsModel model = readById(entity.getId()).get();
        model.setId(newsModels.size() + 1L);
        model.setCreateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        newsModels.add(model);
        return model;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        NewsModel model = readById(entity.getId()).get();
        model.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return model;
    }

    @Override
    public boolean deleteById(Long id) {
        if (existById(id)) {
            if (readById(id).isPresent()) {
                return newsModels.remove(readById(id).get());
            }
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return newsModels.stream().anyMatch(newsModel -> newsModel.getId().equals(id));
    }
}
