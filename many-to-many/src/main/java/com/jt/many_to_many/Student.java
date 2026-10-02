package com.jt.many_to_many;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentId;

    private String StudentName;

    private String StudentEmail;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "students_subjects",
    joinColumns =@JoinColumn(name = "Student_id"),
            inverseJoinColumns = @JoinColumn(name = "Subject_id")
    )
    private List<Subject> Subjects;
}
