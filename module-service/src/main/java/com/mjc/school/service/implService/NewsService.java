package com.mjc.school.service.implService;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.implRepo.NewsRepository;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDTORequest;
import com.mjc.school.service.dto.NewsDTOResponse;
import com.mjc.school.service.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NewsService implements BaseService<NewsDTORequest, NewsDTOResponse, Long> {
    @Autowired
    BaseRepository<NewsModel, Long> repository = new NewsRepository();
    @Override
    public List<NewsDTOResponse> readAll() {
        return repository.readAll().stream()
                .map(NewsMapper.INSTANCE::modelToDto)
                .toList();
    }

    @Override
    public NewsDTOResponse readById(Long id) {
        if (repository.readById(id).isPresent()) {
            return NewsMapper.INSTANCE.modelToDto(repository.readById(id).get());
        }
        return null;
    }

    @Override
    public NewsDTOResponse create(NewsDTORequest createRequest) {
        NewsModel model = NewsMapper.INSTANCE.dtoToModel(createRequest);
        repository.create(model);
        return NewsMapper.INSTANCE.modelToDto(model);
    }

    @Override
    public NewsDTOResponse update(NewsDTORequest updateRequest) {
        NewsModel model = NewsMapper.INSTANCE.dtoToModel(updateRequest);
        repository.update(model);
        return NewsMapper.INSTANCE.modelToDto(model);
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
