package ru.ivonin.MySecondTestAppSpringBoot.service;


import org.springframework.stereotype.Service;
import ru.ivonin.MySecondTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);


}
