package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.repository.HibernateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class UserService {

    private final HibernateUserRepository userRepository;

    @Autowired
    public UserService(HibernateUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found, id: " + userId));
    }

    public void addProductToUser(Product product, Long userId) {
        User user = findUserById(userId);
        user.getProducts().add(product);
        userRepository.update(user);
    }
}
