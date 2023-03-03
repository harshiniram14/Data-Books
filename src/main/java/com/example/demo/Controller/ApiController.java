package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Book;
import com.example.demo.Service.ApiService;


@RestController
public class ApiController {
	@Autowired
	ApiService a;
	
	@GetMapping("/get")
	public List<Book> showDetails(){
		return a.getDetails();
	}
	
	@PostMapping("/post")
	public String addDetails(@RequestBody Book b) {
		a.add(b);
		return "Added movie "+b.getId();
	}
	
	@GetMapping("product/{field}")
	public List<Book> getWithSort(@PathVariable String field){
		return a.getSorted(field);
	}
	
	@GetMapping("/product/{offset}/{pageSize}")
	public List<Book> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		return a.getWithPagination(offset, pageSize);
	}
	
	@PutMapping("/updateDetails")
	public Book updateInfo(@RequestBody Book bk1)
	{
		return a.updateDetails(bk1);
	}
	@DeleteMapping("/deleteDetails/{id}")
	public String deleteInfo(@PathVariable("id") int id)
	{
		a.deleteDetails(id);
		return "Deleted the Element";
	}
}
