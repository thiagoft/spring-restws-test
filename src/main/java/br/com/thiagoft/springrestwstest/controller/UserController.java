package br.com.thiagoft.springrestwstest.controller;

import br.com.thiagoft.springrestwstest.dao.UserRepository;
import br.com.thiagoft.springrestwstest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thiagofonseca.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listAll() {
        return userRepository.listAll();
    }

}
