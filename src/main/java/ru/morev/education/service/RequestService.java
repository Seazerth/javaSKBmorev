package ru.morev.education.service;

import org.springframework.stereotype.Service;
import ru.morev.education.model.RequestData;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class RequestService {

    private final AtomicLong idCounter = new AtomicLong(1);

    public RequestData processRequest(RequestData requestData) {
        if (requestData.getInfo() == null) {
            requestData.setInfo(new RequestData.Info());
        }
        requestData.getInfo().setId(idCounter.getAndIncrement());
        return requestData;
    }
}