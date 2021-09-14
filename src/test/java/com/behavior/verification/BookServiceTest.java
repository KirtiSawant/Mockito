package com.behavior.verification;

import com.tutorial.behavior.verification.Book;
import com.tutorial.behavior.verification.BookRepository;
import com.tutorial.behavior.verification.BookRequest;
import com.tutorial.behavior.verification.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;



    @Test
    public void TestSave(){
        Book book1=new Book(null,"Mockito",300, LocalDate.now());
                bookService.addBook(book1);
                verify(bookRepository).saveAll(book1);

    }

    @Test
    public void TestSaveBooks(){
        BookRequest bookRequest=new BookRequest("Mockito",300, LocalDate.now());
        Book book=new Book(null,"Mockito",300, LocalDate.now());
        bookService.addBooks(bookRequest);
        verify(bookRepository,times(0)).save(book);

    }
    @Test
    public void TestSaveBook(){
        BookRequest bookRequest=new BookRequest("Mockito",600, LocalDate.now());
        Book book=new Book(null,"Mockito",600, LocalDate.now());
        bookService.addBooks(bookRequest);
        bookService.addBooks(bookRequest);
        verify(bookRepository,times(2)).save(book);

    }
    @Test
    public void TestSaveBook1(){
        BookRequest bookRequest=new BookRequest("Mockito",300, LocalDate.now());
        Book book=new Book(null,"Mockito",300, LocalDate.now());
        bookService.addBooks(bookRequest);
        verify(bookRepository,never()).save(book);

    }
    @Test
    public void TestUpdateBook(){
        Book book=new Book("1234","Mockito",300,LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updateBook("1234",200);
        verify(bookRepository).findBookById("1234");
        verify(bookRepository).save(book);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void TestUpdateBook2(){
        Book book=new Book("1234","Mockito",300,LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updateBook("1234",200);
        InOrder inOrder= Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findBookById("1234");
        inOrder.verify(bookRepository).save(book);

    }

    @Test
    public void TestSaveBook2(){
        BookRequest bookRequest=new BookRequest("Mockito",600, LocalDate.now());
        Book book=new Book(null,"Mockito",600, LocalDate.now());
        bookService.addBooks(bookRequest);
        bookService.addBooks(bookRequest);
       // verify(bookRepository,atLeast(1)).save(book);
      //  verify(bookRepository,times(2)).save(book);
       verify(bookRepository,atMost(2)).save(book);

    }
}
