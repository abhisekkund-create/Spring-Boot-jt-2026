import axios from "axios";
import React, { useState } from "react";
const ExpenseForm=({getExpenses})=>{

const[title,setTitle]=useState('')
const[category,setCategory]=useState('')
const[price,setPrice]=useState('')
const[date,setDate]=useState('')

const handleSubmit= async(e)=>{
    e.preventDefault();
    if(!validate()) return
    const expense={
        id:0,
        title,
        price,
        category,
        date

    }

    await creatExpense( expense)

  
    
}

 async function creatExpense(expense){
    try{
 const response= await axios.post("http://localhost:1200/expenses",expense)
    if(response.status===201){
        getExpenses()
        clearForm()

    }else{
        console.log("something went wrong...");
        
    }
    }catch(err){
        console.log("some error occured",err);
        
    }
   

    
}
const[errors,setErrors]=useState({})
const validate=()=>{
    const newErrors={}
    if(!title){
errors.title="Title ia missing "
    }else if(title.length<=3){
        newErrors.title="title must have 3 characters"
    }

    if(!category){
        newErrors.category="please choose a valid category..."
    }

    if(!price || isNaN(price) ||price<=0){
        newErrors.price="price must be greater than 0 "
    }

    if(!date){
        newErrors.date="Date is required..."
    }
    setErrors(newErrors)

    return Object.keys(newErrors).length===0
}

const clearForm=()=>{
    setTitle('')
    setCategory('')
    setPrice('')
    setDate('')
}


const  handleChange=(e)=>{
    console.log(e.target.name,'->',e.target.value);
    const {name,value}=e.target
   switch(name){

    case 'title':
    setTitle(value)
    setErrors(prev =>({...prev,title:''}))
    break;

     case 'category':
    setCategory(value)
     setErrors(prev =>({...prev,category:''}))
    break;

     case 'price':
    setPrice(value)
     setErrors(prev =>({...prev,price:''}))
    break;

     case 'date':
    setDate(value)
     setErrors(prev =>({...prev,date:''}))
    break;
   }
    
}
   
    return(
       <div className="bg-white rounded-2xl shadow-md p-6 mb-6">
      
        <h2 className="text-xl font-semibold text-gray-700 mb-4">Add Expense</h2>

        <form action={"#"} onSubmit={handleSubmit} className="grid grid-cols-1 md:grid-cols-2 gap-4">


{/* Title */}
            <div>
                <label htmlFor="" className="block font-medium text-gray-600">Title</label>
                <input placeholder="House-rent" type="text" className="border w-full border-gray-300 rounded-lg
                px-3 py-2 focus:outline-none focus:border-blue-500 mb-1 " onChange={handleChange} name="title" value={title}/>
                {
                    errors.title &&(
                        <p className="text-red-500 mt-1 text-sm">{errors.title}</p>
                    )
                }
            </div>


{/* Category */}
             <div>
                <label htmlFor="" className="block font-medium text-gray-600">Category</label>
                <select  id="" className="border w-full border-gray-300 rounded-lg
                px-3 py-2 focus:outline-none focus:border-blue-500 mb-1" onChange={handleChange} name='category' value={category} >
                      {
                    errors.category &&(
                        <p className="text-red-500 mt-1 text-sm">{errors.category}</p>
                    )
                }
                    <option value="">-- Select Category --</option>
                    <option value="food">Food</option>
                    <option value="travel" >Travel</option>
                    <option value="utilities" >utilities</option>
                    <option value="shopping" >Shopping</option>
                    <option value="entertaiment">Entertainment</option>
                    <option value="health" >Helath</option>
                    <option value="education">Education</option>
                    <option value="others">Others</option>
                </select>
                {/* <input type="text" className="border w-full border-gray-300 rounded-lg
                px-3 py-2 focus:outline-none focus:border-blue-500"/> */}
            </div>

{/* Price */}
               <div>
                <label htmlFor="" className="block font-medium text-gray-600">Price</label>
                <input placeholder=" e.g:5000.99" type="text" className="border w-full border-gray-300 rounded-lg
                px-3 py-2 focus:outline-none focus:border-blue-500 mb-1" onChange={handleChange} name="price" value={price}/>

                    {
                    errors.price &&(
                        <p className="text-red-500 mt-1 text-sm">{errors.price}</p>
                    )
                }
                   

            </div>


{/* Date */}
             <div>
                <label htmlFor="" className="block font-medium text-gray-600">Date</label>
                <input type="date" className="border w-full border-gray-300 rounded-lg
                px-3 py-2 focus:outline-none focus:border-blue-500 mb-1" onChange={handleChange} name="date" value={date}/>

                    {
                    errors.date &&(
                        <p className="text-red-500 mt-1 text-sm">{errors.date}</p>
                    )
                }
            </div>

            
              {/* Add Expense Button */}
              <div className="mt-5" >
              <button className="bg-green-500 hover:bg-green-600 px-6 py-3 rounded-lg
              text-white text-lg font-medium transition-colors duration-200">Add Expense</button>
              </div>


         </form>
       
       </div>
    )
}
export default ExpenseForm