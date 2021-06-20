package com.cg.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.application.exception.BooksException;
import com.cg.application.model.Books;
import com.cg.application.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksService booksService;

	@PostMapping("/saveBook")
	public String insertBooks(@RequestBody Books books) throws BooksException {
		booksService.insertBooks(books);
		return "Books added successfully";
	}

	@PutMapping("/editBook/{id}")
	public String updateBook(@PathVariable("id") Integer id, @RequestBody Books books) throws BooksException {
		booksService.updateBook(id, books);
		return "Book updated Successfully";
	}

	@DeleteMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable("id") Integer id) throws BooksException {
		booksService.deleteBook(id);
		return "Book Deleted Sucessfully";
	}

	@GetMapping("/getBooks")
	public List<Books> viewBooks() throws BooksException {
		return booksService.viewBooks();
	}

	@GetMapping("/getByType/{genre}")
	public List<Books> viewBooksByType(@PathVariable("genre") String genre) throws BooksException {
		return booksService.viewBooksByType(genre);
	}

}
