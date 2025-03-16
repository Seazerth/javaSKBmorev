package ru.morev.education.controller;

import ru.morev.education.model.RequestData;
import ru.morev.education.service.RequestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JsonController {

    private final RequestService requestService;

    public JsonController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/process")
    public RequestData processJson(@RequestBody RequestData requestData) {
        return requestService.processRequest(requestData);
    }
}