package com.jt.one_to_one_mapping;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToOneApplication {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToOneApplication.class);
    }


    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
        OneWayBinding();
//
//            Teacher newteacher=Teacher.builder().teacherName("Ankit").build();
//
//            Subject subject1=Subject.builder().subjectName("Html").teacher(newteacher).build();
//            Subject subject2=Subject.builder().subjectName("css").teacher(newteacher).build();
//            Subject subject3=Subject.builder().subjectName("js").teacher(newteacher).build();
//
//            newteacher.setSubjects(List.of(subject1,subject2,subject3));
////            teacherRepository.save(newteacher);
//
//            //Extract
//
//            teacherRepository.findById(1)
//                    .orElseThrow()
//                    .getSubjects()
//                    .forEach((sub->{
//                        System.out.println(sub.getTeacher().getTeacherName()+"\t->\t"+sub.getSubjectName());
//                    }));



        };
    }



    //create a method
    private void OneWayBinding(){
//save
        Teacher teacher=Teacher.builder().teacherName("Amit").build();
       Subject subject1=Subject.builder().subjectName("java").teacher(teacher).build();
        Subject subject2=Subject.builder().subjectName("c++").teacher(teacher).build();
        Subject subject3=Subject.builder().subjectName(".net").teacher(teacher).build();

//       teacherRepository.save(teacher);

       subjectRepository.saveAll(List.of(subject1,subject2,subject3));

        //update
//        Subject exitistingSubject=subjectRepository.findById(2).orElseThrow();
//        exitistingSubject.setSubjectName(".net");
//       Teacher existingTeacher=  exitistingSubject.getTeacher();
//       existingTeacher.setTeacherName("Ankit");
//       existingTeacher.setTeacherId(2);
////        subjectRepository.save(exitistingSubject);



        // ,Delete
        subjectRepository.deleteById(2);

        //Extract
        subjectRepository.findAll().forEach((sub)->{
            System.out.println(sub.getSubjectName()+"\t->\t"+sub.getTeacher().getTeacherName());
        });

    }
}
