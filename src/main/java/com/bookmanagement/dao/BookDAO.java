package com.bookmanagement.dao;

import com.bookmanagement.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BookDAO {
    private List<Book> books;

    public BookDAO() {
        books = new ArrayList<>();
        initializeBooks();
    }

    private void initializeBooks() {
        books.add(new Book("The Road", "Cormac McCarthy", 2006, "Post-apocalyptic Sci-Fi"));
        books.add(new Book("Life of Pi", "Yann Martel", 2001, "Adventure"));
        books.add(new Book("The Kite Runner", "Khaled Hosseini", 2003, "Historical Fiction"));
        books.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 2005, "Crime"));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008, "Science-Fiction"));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003, "Thriller"));
        books.add(new Book("The Book Thief", "Markus Zusak", 2005, "Historical Fiction"));
        books.add(new Book("A Thousand Splendid Suns", "Khaled Hosseini", 2007, "Historical Fiction"));
        books.add(new Book("The Night Circus", "Erin Morgenstern", 2011, "Fantasy"));
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012, "Thriller"));
        books.add(new Book("The Fault in Our Stars", "John Green", 2012, "Romance"));
        books.add(new Book("The Help", "Kathryn Stockett", 2009, "Historical Fiction"));
        books.add(new Book("The Martian", "Andy Weir", 2011, "Science Fiction"));
        books.add(new Book("Ready Player One", "Ernest Cline", 2011, "Science Fiction"));
        books.add(new Book("The Lovely Bones", "Alice Sebold", 2002, "Fiction"));
        books.add(new Book("The Goldfinch", "Donna Tartt", 2013, "Fiction"));
        books.add(new Book("The Lightning Thief", "Rick Riordan", 2005, "Fantasy"));
        books.add(new Book("Cloud Atlas", "David Mitchell", 2004, "Science-Fiction"));
        books.add(new Book("The Road", "Cormac McCarthy", 2006, "Fiction"));
        books.add(new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "Fantasy"));
        books.add(new Book("Big Little Lies", "Liane Moriarty", 2014, "Fiction"));
        books.add(new Book("Divergent", "Veronica Roth", 2011, "Science-Fiction"));
        books.add(new Book("The Girl on the Train", "Paula Hawkins", 2015, "Thriller"));
        books.add(new Book("All the Light We Cannot See", "Anthony Doerr", 2014, "Historical Fiction"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchBooks(String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return books.stream()
                .filter(book -> pattern.matcher(book.getTitle()).find() ||
                        pattern.matcher(book.getAuthor()).find() ||
                        pattern.matcher(book.getGenre()).find() ||
                        pattern.matcher(String.valueOf(book.getYear())).find())
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByTitle() {
        return books.stream()
                .sorted((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByAuthor() {
        return books.stream()
                .sorted((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByYear() {
        return books.stream()
                .sorted((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByGenre() {
        return books.stream()
                .sorted((b1, b2) -> b1.getGenre().compareToIgnoreCase(b2.getGenre()))
                .collect(Collectors.toList());
    }
}
