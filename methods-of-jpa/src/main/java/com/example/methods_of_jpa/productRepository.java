package com.example.methods_of_jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

import java.util.List;


public interface productRepository extends JpaRepository<product,Integer> {



    //custome query method
    Optional<product>findByProductName(String name);


    List<product>findAllByProductPriceBetween(double startPrice,double endPrice);

    Optional<product>findByProductNameAndProductBrand(String name,String brand);


    //JPQL->java persistancy Query Language

    // @Query ("select  p FROM product p WHERE p.productName=:name AND p.productBrand=:brand")//positional parameter
    //  Optional<product>getProduct(String name,String brand);






    //Raw sql
     @Query(nativeQuery = true,
        value = "select * from product where product_name=? AND product_brand=?")
          Optional<product>getProduct(String name,String brand);



         @Modifying 
         @Transactional //:-while using any DML query or performing multiple DB Operation
          @Query (nativeQuery = true,
            value="update product set product_price=:price where product_id=:id")
            int updatePrice(int id,double price);


            // @Transactional-only used service layer and repository layer





    
}
