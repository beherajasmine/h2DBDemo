package com.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApiRequestService {

 @Autowired
 private ApiRequestDao apiRequestDao;
 
 @Transactional
 public void create(ApiRequest apiRequest) {
 apiRequestDao.create(apiRequest);
 }
}