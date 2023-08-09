package com.mjc.school.service.implService;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.implRepo.AuthorRepository;
import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDTORequest;
import com.mjc.school.service.dto.AuthorDTOResponse;
import com.mjc.school.service.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements BaseService<AuthorDTORequest, AuthorDTOResponse, Long> {
    @Autowired
    BaseRepository<AuthorModel, Long> repository = new AuthorRepository();
    @Override
    public List<AuthorDTOResponse> readAll() {
        return repository.readAll().stream()
                .map(AuthorMapper.INSTANCE::modelToDto)
                .toList();
    }

    @Override
    public AuthorDTOResponse readById(Long id) {
        if (repository.readById(id).isPresent()) {
            return AuthorMapper.INSTANCE.modelToDto(repository.readById(id).get());
        }
        return null;
    }

    @Override
    public AuthorDTOResponse create(AuthorDTORequest createRequest) {
        AuthorModel model = AuthorMapper.INSTANCE.dtoToModel(createRequest);
        repository.create(model);
        return AuthorMapper.INSTANCE.modelToDto(model);
    }

    @Override
    public AuthorDTOResponse update(AuthorDTORequest updateRequest) {
        AuthorModel model = AuthorMapper.INSTANCE.dtoToModel(updateRequest);
        repository.create(model);
        return AuthorMapper.INSTANCE.modelToDto(model);
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);

    }
}
