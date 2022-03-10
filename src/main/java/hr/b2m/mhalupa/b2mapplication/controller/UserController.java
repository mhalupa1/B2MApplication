package hr.b2m.mhalupa.b2mapplication.controller;

import hr.b2m.mhalupa.b2mapplication.model.User;
import hr.b2m.mhalupa.b2mapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

}
