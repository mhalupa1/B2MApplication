package hr.b2m.mhalupa.b2mapplication.controller;

import hr.b2m.mhalupa.b2mapplication.model.User;
import hr.b2m.mhalupa.b2mapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/saveUser")
    public ResponseEntity saveUser(@RequestBody User user){
        User newUser = service.saveUser(user.getFirstName(), user.getLastName());
        return ResponseEntity.ok(newUser);
    }

}
