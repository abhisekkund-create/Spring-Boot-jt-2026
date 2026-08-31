package com.jt.intero_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;


// @Controller:-1-it makes the clss is a contorller class 
//2-which means thta class is responsible  to handel http request
//@ReuestMapping:-This annotation handels the custome path inside the controller class

@Controller
public class Hellocontroller {
    
 @RequestMapping("/home")
    public void sayhello(PrintWriter writer){
        System.out.println("hello web....");
        writer.println("<h1>Hello spring web</h1> <p>Welcome Home</p>");
    }

    @RequestMapping
    public void landingpage(PrintWriter writer){
        System.out.println("landing page");
        writer.println("Landing page");
    }

     @RequestMapping("/contact")
    public String contact(){
        return "contact-page";
       
    }
@RequestMapping("/fat")
    public void fat(PrintWriter writer){
        System.out.println("fat page...");
        writer.println("what is api..");

    }
@RequestMapping("/form")
    public String form(){
        return"form";
    }


      // @RequestMapping("/submit-details")
  // public String submitDetails(HttpServletRequest request, Model model) {
  // System.out.println("Submit Details handled");

  // String name = request.getParameter("name");
  // String phone = request.getParameter("phone");

  // // System.out.println("name is:- " + name);
  // // System.out.println("phone is:- " + phone);

  // model.addAttribute("name1", name);
  // model.addAttribute("phone", phone);

  // return "details-page";
  // }

 @RequestMapping("/submit-details")
public String submitDetails(
        @RequestParam(value = "name1") String name1,
        @RequestParam String phone,
        Model model) {

    model.addAttribute("name1", name1);
    model.addAttribute("phone", phone);

    return "details-page";
}
}




    

