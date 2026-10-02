package com.example.methods_of_jpa;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  
public class OrderService {

    private final productRepository productRepository;
    private final OrdersRepository ordersRepository;


@Transactional 
    public void placeOrder(int productId,int quantity){
       var product= productRepository.findById(productId).orElseThrow();


       product.setQuantity(product.getQuantity()-quantity);
       productRepository.save(product);

       if(quantity==10){
        throw new RuntimeException("some error occured...");
       }


       var order=Orders.builder()
       .productId(productId)
       .quantity(quantity)
       .totalPrice(product.getProductPrice()*quantity)
       .build();
       ordersRepository.save(order);

    }
    
}
