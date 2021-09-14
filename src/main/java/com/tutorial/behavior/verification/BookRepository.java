package com.tutorial.behavior.verification;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBooks(int days) ;

    Book findBookById(String bookId);

    void saveAll(Book book);
    void save(Book book);


}
