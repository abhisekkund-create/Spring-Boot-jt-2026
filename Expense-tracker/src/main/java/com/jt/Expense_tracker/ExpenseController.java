package com.jt.Expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
// @RequiredArgsConstructor
@AllArgsConstructor

public class ExpenseController {
    private final JdbcTemplate jdbcTemplate;
    private static final String EXPENSES_TABEL="expenses";

    // public ExpenseController(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate=jdbcTemplate;
    // }


    @RequestMapping(value="/expenses", method= RequestMethod.GET)

    public List<Expense> getExpenses(){
         String sql="select * from %s".formatted(EXPENSES_TABEL);
        //  List<Expense> expenses=new ArrayList<>();
        //  jdbcTemplate.query(query, (resultSet) -> {
        // //  System.out.println("id is" + resultSet.getInt("id"));
        // //   System.out.println("title is" + resultSet.getString("title"));
        // //    System.out.println("category is" + resultSet.getString("category"));

        //  var id = resultSet.getInt("id");
        //   var title = resultSet.getString("title");
        //     var category= resultSet.getString("category");
        //       var price = resultSet.getDouble("price");
        //         var date = resultSet.getDate("date").toLocalDate();


        //  var expense =new Expense(id, title, query, price, date);

        // va
        // expenses.add(expense);


        // });


        // List<Expense> expenses=jdbcTemplate.query(query, new BeanPropertyRowMapper<Expense>(Expense.class));
       
        // return expenses;

          return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
       
      

    }

    //Dynamic Routing

    @RequestMapping(value = "/expenses/{id}", method =RequestMethod.GET)
    public Expense getExpenseById(@PathVariable int id){

     System.out.println("id is"+id);
     var sql="select * from %s where id=?".formatted(EXPENSES_TABEL);
    Expense expense= jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Expense.class),id);
    return expense;

    }


    //@RequestBody-convert json to java object because @RestController conntain 2 annotation like @Controller,@ResponseBody

    @RequestMapping(value = "/expenses",method =RequestMethod.POST )
    public Expense createExpense(@RequestBody Expense expense){
        var sql="insert into %s (title,category,price,date) values(?,?,?,?)"
        .formatted(EXPENSES_TABEL);
        jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(),
        expense.getDate() );
        return expense;
    }
    
}
