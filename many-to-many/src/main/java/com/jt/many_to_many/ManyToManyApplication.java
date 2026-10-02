package com.jt.many_to_many;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyApplication {

	private final StudentRepository studentRepository;
	private final SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			oneWayBinding();


			//save
			Student student1=Student.builder().StudentName("Rakesh")
					.StudentEmail("rakesh@gmail.com").build();
			Student student2=Student.builder().StudentName("pallab")
					.StudentEmail("pallab.gmail.com")
					.build();
			Student student3=Student.builder().StudentName("Ramesh")
					.StudentEmail("ramesh@gmail.com")
					.build();

			Subject subject1=Subject.builder().SubjectName("java").build();
			Subject subject2=Subject.builder().SubjectName("Ruby").build();
			Subject subject3=Subject.builder().SubjectName("php").build();


//			studentRepository.saveAll(List.of(student1,student2,student3));
//			subjectRepository.saveAll(List.of(subject1,subject2,subject3));


			//extract
//			subjectRepository.findAll().forEach(subject -> {
//				subject.getStudents().forEach(student -> {
//					System.out.println(subject.getSubjectName()+"\t->\t"+student.getStudentName());
//				});
//			});


		};
	}


			private void oneWayBinding () {

				//save
				Subject subject1 = Subject.builder().SubjectName("c").build();
				Subject subject2 = Subject.builder().SubjectName("java").build();
				Subject subject3 = Subject.builder().SubjectName("python").build();
				Subject subject4 = Subject.builder().SubjectName(".net").build();


				Student student1 = Student.builder()
						.StudentName("Abhishek")
						.StudentEmail("abhishekkunduel@gmail.com")
						.Subjects(List.of(subject2, subject3))
						.build();

				Student student2 = Student.builder()
						.StudentName("Rohan")
						.StudentEmail("rohan@gmail.com")
						.Subjects(List.of(subject2, subject3))
						.build();


				Student student3 = Student.builder()
						.StudentName("Rakesh")
						.StudentEmail("rakesh@gmail.com")
						.Subjects(List.of(subject3, subject4))
						.build();
//		studentRepository.saveAll(List.of(student1,student2,student3));

				//update
				Subject updateSubject = subjectRepository.findById(2).orElseThrow();
				updateSubject.setSubjectName("AdvancedPython");

				updateSubject.getStudents().forEach(student -> {
					if(student.getStudentId()==1){
						student.setStudentName("ms Dhoni");
						student.setStudentEmail("ms@gmail.com");
					}
				});
				subjectRepository.save(updateSubject);



				//delete

				//Extract
				studentRepository.findAll().forEach(student -> {
					System.out.println("student name is" + student.getStudentName());
					student.getSubjects().forEach(subject -> {
						System.out.println(student.getStudentName() + "\t->\t" + subject.getSubjectName());
					});
				});


			}


		}

