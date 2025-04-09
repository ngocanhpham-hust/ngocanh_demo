package com.hust.demo.service.impl;

import com.hust.demo.model.Person;
import com.hust.demo.model.ServiceResponse;
import com.hust.demo.service.MainService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MainServiceImpl implements MainService {

    @Override
    public String getName(String name){
        return "Phúc";
    }

    @Override
    public ServiceResponse saveData(Person person) {
        ServiceResponse serviceResponse = new ServiceResponse();
        // validate

        // name
        String name = person.getName();
        if (Objects.isNull(name) || name.length() < 10 || name.length() > 100) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Name invalid");
            return serviceResponse;
        }
        Pattern patternNonSpecial = Pattern.compile("[^a-zA-Z ]", Pattern.CASE_INSENSITIVE);
        Matcher matcherName = patternNonSpecial.matcher(name);
        boolean matchName = matcherName.find();
        if(matchName) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Name invalid");
            return serviceResponse;
        }

        // age
        int age = person.getAge();
        if (age <= 0) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Age invalid");
            return serviceResponse;
        }

        //dob
        String dob = person.getDob();
        int age_ = person.getAge();
        if (Objects.isNull(dob)) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Date of birth invalid");
        }

        // address
        String address  = person.getAddress();
        if (Objects.isNull(address) || address.length() < 5 || address.length() > 500){
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Address invalid");
            return serviceResponse;
        }

        // phoneNumber
        String phoneNumber = person.getPhoneNumber();
        if (phoneNumber.length() != 10 || !phoneNumber.startsWith("0") ) {

            serviceResponse.setCode(0);
            serviceResponse.setMsg("Phone number invalid");
            return serviceResponse;
        }

        Pattern patternNumber = Pattern.compile("[^0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcherNumber = patternNumber.matcher(phoneNumber);
        boolean matchFound = matcherNumber.find();
        if(matchFound) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Phone number invalid");
            return serviceResponse;
        }

        // email
        String email = person.getEmail();
        if (Objects.isNull(email) || !email.contains("@")) {} // comment

        // gender
        String gender = person.getGender();
        if (Objects.isNull(gender) || (!gender.equalsIgnoreCase("Nam")) && (!gender.equalsIgnoreCase("Nữ"))){
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Gender invalid");
            return serviceResponse;
        }

        // idNumber
        String idNumber = person.getIdNumber();
        if (idNumber.length() != 12) {

            serviceResponse.setCode(0);
            serviceResponse.setMsg("ID Number invalid");
            return serviceResponse;
        }

        Matcher matcherId = patternNumber.matcher(idNumber);
        boolean matchIdFound = matcherId.find();

        if(matchIdFound) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("ID Number invalid");
            return serviceResponse;
        }

        //issueDate
        String issueDate = person.getIssueDate();
        if (Objects.isNull(issueDate)) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Issue Date invalid");
            return serviceResponse;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(issueDate);
        } catch (ParseException e) {
            serviceResponse.setCode(0);
            serviceResponse.setMsg("Issue Date invalid");
            return serviceResponse;
        }

        return serviceResponse;


    }
}
