package com.jt.intro_to_rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

// @Controller
// @ResponseBody
@RestController
public class studentController {
    private ObjectMapper mapper;

    public studentController(ObjectMapper mapper){
        this.mapper=mapper;

    }

    @RequestMapping(value = "/student",method=RequestMethod.GET)
    // @ResponseBody//it tails spring boot to return a json object instead of a html page(view page)
    public student getStudent(){
        student student1= new student(101,"Ankit",new String[]{"java","python"});
        System.out.println("/////"+student1);
        return student1;

    }

    @RequestMapping("/student1")
    public void convertjavaobjtojson() throws JacksonException {
        student student1= new student(101,"Ankit",new String[]{"java","python"});

      String json=  mapper.writeValueAsString(student1);
      System.out.println("java to json"+json);
    }


      @RequestMapping("/student2")
    public void convertjsontojsvsobj() throws JacksonException {
       String json="""
               {

               "id":102,
               "name":"Aniket",
               "courses":["c","java"]
                }
               """;

               student student1=mapper.readValue(json,student.class);
               System.out.println("after converting json to java objeect"+student1);
    }

@RequestMapping("/fruits")
// @ResponseBody
    public List<String>geStrings(){
        return List.of("Appel","Mango","grapes");
    }
    
}
    

