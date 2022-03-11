package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.UserDAO;
import hr.b2m.mhalupa.b2mapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO dao;

    public User saveUser(String firstName, String lastName){
        User user = new User(firstName, lastName);
        return dao.save(user);
    }
}
