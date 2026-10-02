package com.jt.one_to_one_mapping;



import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class onetoonemapping {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    public static void main(String[] args)

    {
        SpringApplication.run(onetoonemapping.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(){

        return args -> {
//            OwingSideOperation();

            //inverse side operation
            Student newstudent=Student.builder()
                    .studentName("Rohan")
                    .studentEmail("rohan@gmail.com")
                    .build();


            Address newAddress=Address.builder()
                    .city("jajpur")
                    .state("odisha")
                    .country("india")
                    .build();

            newstudent.setAddress(newAddress);
            addressRepository.save(newAddress);
//            studentRepository.save(newstudent);


            //retrive
            Address address=addressRepository.findById(1).orElseThrow();
            System.out.println("Address city"+address.getCity());
            System.out.println("Address state"+address.getState());
            System.out.println("Address country"+address.getCountry());

            Student throughAddressReference=address.getStudent();
            System.out.println("student name"+throughAddressReference.getStudentName());
            System.out.println("student email"+throughAddressReference.getStudentEmail());


            //update
            Address allAddressUpdate=addressRepository.findById(1).orElseThrow();
            allAddressUpdate.setCountry("india");
            allAddressUpdate.setCity("Medulla");
            allAddressUpdate.setState("pakistan");

            Student allStudent=allAddressUpdate.getStudent();
            allStudent.setStudentEmail("abhisekkunduel@gmail.com");
            allStudent.setStudentName("Abhishek kundu");
            addressRepository.save(allAddressUpdate);

            //Remove
            addressRepository.deleteById(1);




        };

    }

    private void OwingSideOperation(){

        Address address=Address.builder()
                    .city("Jajpr")
                    .state("Odisha")
                    .country("India")
                    .build();


            Student student=Student.builder()
                    .studentName("balua")
                    .studentEmail("balua@gmail.com")
                    .address(address)
                    .build();



            addressRepository.save(address);


//		   studentRepository.save(student);//because when we try to save owing side ,reverse side must be present in the database


//        1.Manually save Address Object then save Student Object
			 addressRepository.save(address);
			 studentRepository.save(student);

//        2.use Cascading
            studentRepository.save(student);

//        UPDATE
			Student existingStudent=studentRepository.findById(4).orElseThrow();
			existingStudent.setStudentName("Baladev3");
			existingStudent.setStudentEmail("B3@gmail.com");
			Address existingAddress=existingStudent.getAddress();
			existingAddress.setCity("CTC");
//			addressRepository.save(existingAddress);

			studentRepository.save(existingStudent);

//        REMOVE
			studentRepository.deleteById(3);

            //Retrieve
            Student studentWithRoll2=studentRepository.findById(2).orElseThrow();
            System.out.println("student Name:-"+studentWithRoll2.getStudentName());
            System.out.println("student Email:-"+studentWithRoll2.getStudentEmail());

            Address studentWithRoll2Address=studentWithRoll2.getAddress();
            System.out.println("Address city"+studentWithRoll2Address.getCity());
            System.out.println("Address State"+studentWithRoll2Address.getState());
            System.out.println("Address country"+studentWithRoll2Address.getCountry());




            Address extractStudentDetails=addressRepository.findById(1).orElseThrow();




    }

}
