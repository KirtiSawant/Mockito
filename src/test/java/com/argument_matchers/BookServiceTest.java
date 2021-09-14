package com.argument_matchers;


import com.tutorial.argument_matchers.Book;
import com.tutorial.argument_matchers.BookRepository;
import com.tutorial.argument_matchers.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;



    @Test
    public void TestUpdatePrice(){
        Book book1=new Book("1234","Mockito",300, LocalDate.now());
        Book book2=new Book("1234","Mockito",500, LocalDate.now());
        when(bookRepository.findBookById(any())).thenReturn(book1);
        bookService.updatePrice("1234",500);
        verify(bookRepository).save(book2);
    }

    @Test
    public void TestArgumentMatchersBook(){
        Book book=new Book("1234","Mockito",300, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(),anyInt(),anyBoolean())).thenReturn(book);
        Book actualBook=bookService.getBookByTitleAndPriceAndIsDigital("Mockito",300,true);
        assertEquals("Mockito",actualBook.getTitle());

    }

    @Test
    public void TestCollectionTypeArgument(){
        List<Book> books=new ArrayList<>();
        Book book=new Book("1234","Mockito",300, LocalDate.now());
        books.add(book);
        bookService.addBook(books);
        verify(bookRepository).saveAll(anyList());

    }
}
