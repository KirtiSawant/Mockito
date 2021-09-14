package com.tutorial.argument_matchers;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBooks(int days) ;

    Book findBookById(String bookId);

    void save(Book book);

    Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital);

    void saveAll(List<Book> books);
}
