package com.controller.rest;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.entity.Account;
import com.entity.Authority;
import com.service.Service_Account;
import com.service.Service_Authority;
import com.service.Service_Upload;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/register")
public class RestController_Register {

    @Autowired
    Service_Account ad;
    @PostMapping()
    public Account create(@RequestBody Account account) {
        return ad.create(account);
    }
}
