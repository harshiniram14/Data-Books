package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Book;
import com.example.demo.Repositories.BookRepo;

@Service
public class ApiService {
	@Autowired
	BookRepo bkRepo;
	
	public String add(Book b) {
		bkRepo.save(b);
		return "Added";
	}
	public List<Book> getDetails(){
		return bkRepo.findAll();
	}
	public List<Book> getSorted(String field){
		return bkRepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Book> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Book> page =bkRepo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	
	public Book updateDetails(Book b1)
	{
		return bkRepo.saveAndFlush(b1);
	}
	public void deleteDetails(int id)
	{
		bkRepo.deleteById(id);
	}

}
