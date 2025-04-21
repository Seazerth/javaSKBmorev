package ru.morev.education.service;

import org.springframework.stereotype.Service;
import ru.morev.education.model.RequestData;
import ru.morev.education.model.ResponseData;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class RequestService {

    private final AtomicLong idCounter = new AtomicLong(1);

    public ResponseData processRequest(RequestData requestData) {
        ResponseData response = new ResponseData();
        response.setPrice(requestData.getPrice());

        ResponseData.Info info = new ResponseData.Info();
        info.setId(idCounter.getAndIncrement());
        info.setDate(requestData.getInfo() != null ? requestData.getInfo().getDate() : null);

        response.setInfo(info);
        return response;
    }
}
