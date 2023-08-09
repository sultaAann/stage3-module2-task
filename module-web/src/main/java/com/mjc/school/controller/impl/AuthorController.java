package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDTORequest;
import com.mjc.school.service.dto.AuthorDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController implements BaseController<AuthorDTORequest, AuthorDTOResponse, Long> {
    @Autowired
    BaseService<AuthorDTORequest, AuthorDTOResponse, Long> service;


    @Override
    @CommandHandler(commandNumber = 6)
    public List<AuthorDTOResponse> readAll() {
        service.readAll().forEach(System.out::println);
        return service.readAll();
    }

    @Override
    @CommandHandler(commandNumber = 7)
    public AuthorDTOResponse readById(Long id) {
        AuthorDTOResponse res = service.readById(id);
        System.out.println(res);
        return res;
    }

    @Override
    @CommandHandler(commandNumber = 8)
    public AuthorDTOResponse create(AuthorDTORequest createRequest) {
        AuthorDTOResponse res = service.create(createRequest);
        System.out.println(res);
        return res;
    }

    @Override
    @CommandHandler(commandNumber = 9)
    public AuthorDTOResponse update(AuthorDTORequest updateRequest) {
        AuthorDTOResponse res = service.update(updateRequest);
        System.out.println(res);
        return res;
    }

    @Override
    @CommandHandler(commandNumber = 10)
    public boolean deleteById(Long id) {
        Boolean res = service.deleteById(id);
        System.out.println(res);
        return res;
    }
}
