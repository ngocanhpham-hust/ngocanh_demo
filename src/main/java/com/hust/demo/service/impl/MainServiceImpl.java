package com.hust.demo.service.impl;

import com.hust.demo.common.MainValidate;
import com.hust.demo.model.Person;
import com.hust.demo.model.ServiceResponse;
import com.hust.demo.service.MainService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainValidate mainValidate;
//@Resource

    @Override
    public String getName(String name){
        return "Phúc";
    }

    @Override
    public ServiceResponse saveData(Person person) {
        ServiceResponse serviceResponse = new ServiceResponse();
        // validate

        serviceResponse = mainValidate.validatePerson(person);
        if (serviceResponse.getCode() == 0) {
            return serviceResponse;
        }

        // process logic

    //phan tích idNumber. Trả ra các thong so nhu sau
        //https://thuvienphapluat.vn/phap-luat/ho-tro-phap-luat/ma-63-tinh-thanh-pho-su-dung-tren-the-can-cuoc-cong-dan-gan-chip-y-nghia-ma-so-can-cuoc-cong-dan-ga-986546-31326.html
        //037xxxxxx
        System.out.println("Tinh: Ninh binh" );


        return serviceResponse;


    }

}
