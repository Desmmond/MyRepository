package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        Product product = new Product();
                        System.out.println("Enter product name: ");
                        Scanner scan = new Scanner(System.in);
                        String name = scan.nextLine();
                        System.out.println(name);
                        if(name.length() >= 3 && name.length() <= 32) {
                            product.setName(name);
                        }else {
                            System.out.println("Invalid name");
                        }

                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        //Product product = new Product();
                        if(price.intValue()> 0) {
                            product.setPrice(price);
                        }else{
                            System.out.println("Invalid price");
                            break;
                        }




                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        System.out.println("Enter product discount");
                        int discount = scanner.nextInt();
                        System.out.println("Enter product description");
                        String description = scanner.nextLine();

                        if(discount > 100 || discount < 0) {
                            product.setDiscount(discount);
                        }else {
                            System.out.println("Invalid discount");
                        }
                        product.setId(productIdSequence);
                        product.setCategory(category);
                        product.setDescription(description);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
