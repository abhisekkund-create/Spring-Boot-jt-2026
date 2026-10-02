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
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SubjectId;

    private String SubjectName;


    @ManyToMany(mappedBy = "Subjects",cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private List<Student> students;

}
