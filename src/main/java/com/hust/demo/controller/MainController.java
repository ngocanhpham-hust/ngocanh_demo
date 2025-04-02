package com.hust.demo.controller;

import com.hust.demo.model.Person;
import com.hust.demo.model.ServiceResponse;
import com.hust.demo.service.MainService;
import com.hust.demo.service.impl.MainServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;


@RestController
@RequestMapping(value ="/api/v1/main" )
public class MainController {

    @Resource
    MainService mainService;

    @GetMapping(value = "/search")
    public String getProfile(@RequestParam String user) {
        MainServiceImpl main = new MainServiceImpl();
        return "Hello world: " + user;
    }

    @PostMapping(value = "/save")
    public ServiceResponse saveData(@RequestBody Person detail) {
        ServiceResponse response = mainService.saveData(detail);
        return response;
    }

    @GetMapping(value = "/detail")
    public String getDetail(@RequestParam String user) {
        MainServiceImpl main = new MainServiceImpl();
        return "Thông tin của " + user + " đã lưu thành công";
    }



}
