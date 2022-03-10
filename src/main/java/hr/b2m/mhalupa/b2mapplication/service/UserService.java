package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO dao;
}
