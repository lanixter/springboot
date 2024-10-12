package ru.ivonin.MySecondTestAppSpringBoot.service;

import ru.ivonin.MySecondTestAppSpringBoot.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
