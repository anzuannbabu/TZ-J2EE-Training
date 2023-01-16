package com.pivotalsoft.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {

  @Autowired
  private FileStorageService fileStorageService;

  @Autowired
  private ObjectMapper objectMapper;
  
  @Autowired
  UserService userService;

  @PostMapping("/user")
  public User uploadFile(@RequestParam("model") String jsonObject, @RequestParam("file") MultipartFile file) {

    User response = null;

    try {

      String fileName = fileStorageService.storeFile(file);
      ServletUriComponentsBuilder.fromCurrentContextPath().path(fileName).toUriString();
      response = objectMapper.readValue(jsonObject, User.class);
      response.setImage(file.getOriginalFilename());
      userService.saveOrUpdate(response);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return response;
  }
}