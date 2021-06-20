package com.cg.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.application.exception.BooksException;
import com.cg.application.model.Books;
import com.cg.application.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	BooksRepository booksrepository;

	public Books insertBooks(Books books) throws BooksException {
		Books b1 = new Books();
		b1.setBookId(books.getBookId());
		b1.setQuantity(books.getQuantity());
		b1.setBookName(books.getBookName());
		b1.setGenre(books.getGenre());

		return booksrepository.save(b1);
	}

	public void updateBook(Integer id, Books books) throws BooksException {
		Optional<Books> booksList = booksrepository.findById(id);
		if (booksList.isEmpty())
			throw new BooksException();
		Books b1 = new Books();
		b1.setBookId(books.getBookId());
		b1.setBookName(books.getBookName());
		b1.setGenre(books.getGenre());
		b1.setQuantity(books.getQuantity());
		booksrepository.save(b1);
	}

	public void deleteBook(Integer id) throws BooksException {
		Optional<Books> books = booksrepository.findById(id);
		if (books.isEmpty())
			throw new BooksException();
		booksrepository.deleteById(id);
	}

	public List<Books> viewBooks() throws BooksException {
		java.util.List<Books> booksList = booksrepository.findAll();
		if (booksList.isEmpty())
			throw new BooksException();
		return booksList;
	}

	public List<Books> viewBooksByType(String genre) throws BooksException {
		List<Books> booksList = booksrepository.findByGenre(genre);
		if (booksList.isEmpty())
			throw new BooksException();
		return booksList;
	}

}
