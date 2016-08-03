package br.com.thiagoft.springrestwstest.dao;

import br.com.thiagoft.springrestwstest.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagofonseca.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        users.add(new User("user1","password1","email1"));
        users.add(new User("user2","password2","email2"));

        return users;
    }
}
