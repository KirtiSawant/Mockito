package com.stubbing;

import com.tutorial.stubbing.Book;
import com.tutorial.stubbing.BookRepository;
import com.tutorial.stubbing.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Before
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void TestCalculateTotalCostBook(){
        List<String> bookIds= new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1235");
        Book book1=new Book("1234","Mockito",300, LocalDate.now());
        Book book2=new Book("1235","Junit",300, LocalDate.now());

       /* when(bookRepository.findBookById("1234")).thenReturn(book1);
        when(bookRepository.findBookById("1235")).thenReturn(book2);*/

        doReturn(book1).when(bookRepository).findBookById("1234");
        doReturn(book2).when(bookRepository).findBookById("1235");
        int actualCost=bookService.calculateTotalCost(bookIds);
        assertEquals(600,actualCost);

    }
    @Test
    public void TestUpdatePrice(){
        bookService.updatePrice(null,400);
        verifyNoInteractions(bookRepository);
    }
}
