package com.java.spring;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRequestController {

    @Autowired
    private ApiRequestService apiRequestService;

    //private static final Logger logger = LoggerFactory.getLogger(ApiRequestController.class);

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getHome() {
       // logger.info("Api request received");

        Map<String, String> response = new HashMap<String, String>();
        try {
            ApiRequest apiRequest = new ApiRequest(new Date());
            System.out.println(apiRequest);
            apiRequestService.create(apiRequest);
            response.put("status", "success");
        } catch (Exception e) {
        	e.printStackTrace();
            //logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }

        return response;
    }
}