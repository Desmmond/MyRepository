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
                        String name = scanner.nextLine();

                        if(name.length() >= 3 && name.length() <= 32) {
                            product.setName(name);
                        }else {
                            System.out.println("Name cannot be less than 3 characters and more than 32. Please try again|");
                            break;
                        }

                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        if(price.intValue()> 0) {
                            product.setPrice(price);
                        }else{
                            System.out.println("Product price cannot be less than zero. Please try again|");
                            break;
                        }

                        System.out.println("Enter product category: ");
                         String category = scanner.nextLine();
                         product.setCategory(category);

                        System.out.println("Enter product discount: ");
                        int discount = scanner.nextInt();
                        if(discount <= 100 && discount >= 0) {
                            product.setDiscount(discount);
                        }else {
                            System.out.println("The discount cannot be more than 100 percent and less then 0.");
                            break;
                        }
                        
                        scanner.nextLine();
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        product.setDescription(description);



                        product.setId(productIdSequence);
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
