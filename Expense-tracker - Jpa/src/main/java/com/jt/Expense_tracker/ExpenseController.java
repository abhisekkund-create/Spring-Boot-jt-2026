package com.jt.Expense_tracker;

// import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;

@RestController

@AllArgsConstructor
@CrossOrigin ("http://localhost:5173")
@RequestMapping ("/expenses")

public class ExpenseController {
   
    private final ExpenseService expenseService;
    

    


   
@GetMapping 
    public List<Expense> getExpenses(){
        //  String sql="select * from %s".formatted(EXPENSES_TABEL);
       
        //   return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
       
    //  var savedExpenses= expenseRepository.findAll();
    //  return savedExpenses;
    return expenseService.getExpenses();

    }

   

    @RequestMapping(value = "/{id}", method =RequestMethod.GET)
    public Expense getExpenseById(@PathVariable int id){

   //findById(id) return optional class object
//    1st way
    // Optional<Expense> optExp =expenseRepository.findById(id);
    // Expense expense=optExp.orElseThrow(()->new RuntimeException
    // ("unable to find Expenses with id"+id));
    // return expense;

    //2nd way
  
    return expenseService.getExpenseById(id);

    }



   
       @PostMapping
       @ResponseStatus (code = HttpStatus.CREATED)
    public Expense createExpense(@RequestBody Expense expense){
    //   return  expenseRepository.save(expense);
    return expenseService.addExpense(expense);
    }



@DeleteMapping("/{id}")
@ResponseStatus (value = HttpStatus.NO_CONTENT)//it create a status code
    public void deleteExpenses(@PathVariable int id){

//1st way to delete
    //    Expense tobeDeletedExpense= getExpenseById(id);
    //    expenseRepository.delete(tobeDeletedExpense);


    //2nd way
    //    expenseRepository.deleteById(id);
    expenseService.deleteExpenseById(id);
    }

    
    //partially update 
    @PutMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Expense updateExpense(@RequestBody Expense expense){
        
    return expenseService.updateExpense(expense);
    


    }
    
}
