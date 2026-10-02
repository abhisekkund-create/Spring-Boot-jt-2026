package com.jt.one_to_one_mapping;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentRoll;

    private String studentEmail;

    private String studentName;


    //    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//default type is eager
    @JoinColumn(name = "address_Id")
    private Address address;

}
