package com.hust.demo.service;

import com.hust.demo.model.Person;
import com.hust.demo.model.ServiceResponse;
import org.springframework.stereotype.Component;

public interface MainService {

     String getName(String name);

    ServiceResponse saveData(Person request);


}
