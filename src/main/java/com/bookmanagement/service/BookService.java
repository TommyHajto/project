package com.bookmanagement.service;

import com.bookmanagement.dao.BookDAO;
import com.bookmanagement.model.Book;

import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService() {
        this.bookDAO = new BookDAO();
    }

    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void removeBook(Book book) {
        bookDAO.removeBook(book);
    }

    public List<Book> searchBooks(String regex) {
        return bookDAO.searchBooks(regex);
    }

    public List<Book> sortBooksByTitle() {
        return bookDAO.sortBooksByTitle();
    }

    public List<Book> sortBooksByAuthor() {
        return bookDAO.sortBooksByAuthor();
    }

    public List<Book> sortBooksByYear() {
        return bookDAO.sortBooksByYear();
    }

    public List<Book> sortBooksByGenre() {
        return bookDAO.sortBooksByGenre();
    }
}
