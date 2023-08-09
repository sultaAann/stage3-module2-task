package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDTORequest;
import com.mjc.school.service.dto.NewsDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NewsController implements BaseController<NewsDTORequest, NewsDTOResponse, Long> {
    @Autowired
    BaseService<NewsDTORequest, NewsDTOResponse, Long> service;

    @Override
    @CommandHandler(commandNumber = 1)
    public List<NewsDTOResponse> readAll() {
        service.readAll().forEach(System.out::println);
        return service.readAll();
    }

    @Override
    @CommandHandler(commandNumber = 2)
    public NewsDTOResponse readById(Long id) {
        NewsDTOResponse res = service.readById(id);
        System.out.println(res);
        return res;
    }

    @Override
    @CommandHandler(commandNumber = 3)
    public NewsDTOResponse create(NewsDTORequest createRequest) {
        NewsDTOResponse res = service.create(createRequest);
        System.out.println(res);
        return res;
    }

    @Override
    @CommandHandler(commandNumber = 4)
    public NewsDTOResponse update(NewsDTORequest updateRequest) {
        NewsDTOResponse res = service.update(updateRequest);
        System.out.println(res);
        return res;
    }

    @Override
    @CommandHandler(commandNumber = 5)
    public boolean deleteById(Long id) {
        Boolean res = service.deleteById(id);
        System.out.println(res);
        return res;
    }
}
