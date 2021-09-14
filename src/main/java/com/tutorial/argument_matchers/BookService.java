package com.tutorial.argument_matchers;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getNewBookWithDiscount(int discountRate, int days){
        List<Book> newBooks=bookRepository.findNewBooks(days);
        for(Book book:newBooks){
            int price=book.getPrice();
            int newPrice=price-(discountRate+price/100);
            book.setPrice(newPrice);
        }
        return newBooks;
    }
    public int calculateTotalCost(List<String> bookIds){
        int total=0;
        for(String bookId :bookIds){
            Book book=bookRepository.findBookById(bookId);
            total=total+book.getPrice();
        }
        return total;
    }

    public void updatePrice(String bookId,int updatedPrice){

        Book book=bookRepository.findBookById(bookId);
        book.setPrice(updatedPrice);
        bookRepository.save(book);

    }

    public Book getBookByTitleAndPriceAndIsDigital(String title,int price,boolean isDigital){
        return bookRepository.findBookByTitleAndPriceAndIsDigital(title,price,isDigital);
    }

    public void addBook(List<Book> books){
        bookRepository.saveAll(books);
    }
}
