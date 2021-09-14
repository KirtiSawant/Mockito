package com.tutorial.behavior.verification;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public void addBook(Book book){
       /* if(book.getPrice()<=500){
            return;
        }*/
        bookRepository.saveAll(book);
    }

    public void addBooks(BookRequest bookRequest){
        if(bookRequest.getPrice()<=500){
            return;
        }
        Book book=new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(book.getPrice());
        book.setPublishDate(book.getPublishDate());
        bookRepository.save(book);
    }
    public void updateBook(String bookId,int updatePrice){
        if(bookId==null){
            return;
        }
        Book book= bookRepository.findBookById(bookId);
       /* if(book.getPrice()==updatePrice){
            return;
        }*/
        book.setPrice(updatePrice);
        bookRepository.save(book);

    }
}
