package com.mjc.school.repository.implRepo;


import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.database.DataSource;
import com.mjc.school.repository.model.impl.AuthorModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

    List<AuthorModel> authorModels = DataSource.getInstance().getAuthors();

    @Override
    public List<AuthorModel> readAll() {
        return authorModels;
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return authorModels.stream()
                .filter(newsModel -> newsModel.getId().equals(id))
                .findFirst();
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        AuthorModel model = readById(entity.getId()).get();
        model.setId(authorModels.size() + 1L);
        model.setCreateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        authorModels.add(model);
        return model;
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        AuthorModel model = readById(entity.getId()).get();
        model.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return model;
    }

    @Override
    public boolean deleteById(Long id) {
        if (existById(id)) {
            if (readById(id).isPresent()) {
                return authorModels.remove(readById(id).get());
            }
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return authorModels.stream().anyMatch(model -> model.getId().equals(id));

    }
}
