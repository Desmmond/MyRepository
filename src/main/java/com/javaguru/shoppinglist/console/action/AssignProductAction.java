package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Scanner;

@Component
public class AssignProductAction implements Action {

    private static final String ACTION_NAME = "Assign product to user";

    private final ProductService productService;
    private final UserService userService;

    AssignProductAction(ProductService productService, UserService userservice) {
        this.productService = productService;
        this.userService = userservice;
    }

    @Override
    @Transactional
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id:");
        Long userId = scanner.nextLong();
        System.out.println("Enter product id: ");
        Long productId = scanner.nextLong();

        Product product = productService.findProductById(productId);
        userService.addProductToUser(product, userId);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
