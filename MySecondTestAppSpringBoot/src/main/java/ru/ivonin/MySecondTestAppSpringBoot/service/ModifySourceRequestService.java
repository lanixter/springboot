package ru.ivonin.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.ivonin.MySecondTestAppSpringBoot.model.Request;

@Service("ModifySourceRequestService")
public class ModifySourceRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {
        request.setSource("New Source Value");
    }
}