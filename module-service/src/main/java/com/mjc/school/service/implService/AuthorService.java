package com.mjc.school.service.implService;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.implRepo.AuthorRepository;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDTORequest;
import com.mjc.school.service.dto.AuthorDTOResponse;
import com.mjc.school.service.mapper.AuthorMapper;

import java.util.List;

public class AuthorService implements BaseService<AuthorDTORequest, AuthorDTOResponse, Long> {
    BaseRepository repository = new AuthorRepository();
    @Override
    public List<AuthorDTOResponse> readAll() {
        return repository.readAll().stream()
                .map(AuthorMapper.INSTANCE::modelToDto)
                .toList();
    }

    @Override
    public AuthorDTOResponse readById(Long id) {
        return null;
    }

    @Override
    public AuthorDTOResponse create(AuthorDTORequest createRequest) {
        return null;
    }

    @Override
    public AuthorDTOResponse update(AuthorDTORequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
