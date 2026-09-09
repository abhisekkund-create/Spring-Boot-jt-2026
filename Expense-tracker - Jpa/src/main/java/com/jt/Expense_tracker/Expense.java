package com.jt.Expense_tracker;

import java.time.LocalDate;

// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity 
public class Expense {
    @Id 
    @GeneratedValue (strategy =GenerationType.IDENTITY )
    private int id;
    private String title;
    private String category;
    private double price;
    private LocalDate date;

    // private String description;

    


}