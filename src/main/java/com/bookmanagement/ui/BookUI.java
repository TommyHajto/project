package com.bookmanagement.ui;

import com.bookmanagement.model.Book;
import com.bookmanagement.service.BookService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookUI {
    private BookService bookService;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public BookUI() {
        bookService = new BookService();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Book Management");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Title", "Author", "Year", "Genre"}, 0);
        table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Book");
        JButton searchButton = new JButton("Search");
        JButton sortTitleButton = new JButton("Sort by Title");
        JButton sortAuthorButton = new JButton("Sort by Author");
        JButton sortYearButton = new JButton("Sort by Year");
        JButton sortGenreButton = new JButton("Sort by Genre");

        panel.add(addButton);
        panel.add(removeButton);
        panel.add(searchButton);
        panel.add(sortTitleButton);
        panel.add(sortAuthorButton);
        panel.add(sortYearButton);
        panel.add(sortGenreButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBook();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBooks();
            }
        });

        sortTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortBooksByTitle();
            }
        });

        sortAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortBooksByAuthor();
            }
        });

        sortYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortBooksByYear();
            }
        });

        sortGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortBooksByGenre();
            }
        });

        loadBooks();
        frame.setVisible(true);
    }

    private void loadBooks() {
        tableModel.setRowCount(0);
        List<Book> books = bookService.getBooks();
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()});
        }
    }

    private void addBook() {
        String title = JOptionPane.showInputDialog("Enter Title");
        String author = JOptionPane.showInputDialog("Enter Author");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Year"));
        String genre = JOptionPane.showInputDialog("Enter Genre");
        Book book = new Book(title, author, year, genre);
        bookService.addBook(book);
        loadBooks();
    }

    private void removeBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String title = (String) tableModel.getValueAt(selectedRow, 0);
            String author = (String) tableModel.getValueAt(selectedRow, 1);
            int year = (int) tableModel.getValueAt(selectedRow, 2);
            String genre = (String) tableModel.getValueAt(selectedRow, 3);
            Book book = new Book(title, author, year, genre);
            bookService.removeBook(book);
            loadBooks();
        } else {
            JOptionPane.showMessageDialog(frame, "Select a book to remove");
        }
    }

    private void searchBooks() {
        String regex = JOptionPane.showInputDialog("Enter search pattern");
        List<Book> books = bookService.searchBooks(regex);
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()});
        }
    }

    private void sortBooksByTitle() {
        List<Book> books = bookService.sortBooksByTitle();
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()});
        }
    }

    private void sortBooksByAuthor() {
        List<Book> books = bookService.sortBooksByAuthor();
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()});
        }
    }

    private void sortBooksByYear() {
        List<Book> books = bookService.sortBooksByYear();
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()});
        }
    }

    private void sortBooksByGenre() {
        List<Book> books = bookService.sortBooksByGenre();
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre()});
        }
    }

    public static void main(String[] args) {
        new BookUI();
    }
}
