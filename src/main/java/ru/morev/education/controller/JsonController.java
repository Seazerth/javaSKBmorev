package ru.morev.education.controller;

import org.springframework.web.bind.annotation.*;
import ru.morev.education.model.RequestData;
import ru.morev.education.model.ResponseData;
import ru.morev.education.service.RequestService;

@RestController
@RequestMapping("/api")
public class JsonController {

    private final RequestService requestService;

    public JsonController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/process")
    public ResponseData processJson(@RequestBody RequestData requestData) {
        return requestService.processRequest(requestData);
    }
}
