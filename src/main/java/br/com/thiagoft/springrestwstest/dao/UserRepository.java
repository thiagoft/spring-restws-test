package br.com.thiagoft.springrestwstest.dao;

import br.com.thiagoft.springrestwstest.entity.User;

import java.util.List;

/**
 * Created by thiagofonseca.
 */
public interface UserRepository {
    List<User> listAll();
}
