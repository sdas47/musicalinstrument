package com.example.controller;

import com.example.controller.bean.BasicAuthenticationBean;
import com.example.model.Instrument;
import com.example.repository.InstrumentRepository;
import com.example.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BasicAuthController {

    @GetMapping("/basicauth")
    public BasicAuthenticationBean getAllInstruments() {
        return new BasicAuthenticationBean("You are authenticated");
    }

}
