package com.myspring.startspringio.bootstrap;

import com.myspring.startspringio.domain.Author;
import com.myspring.startspringio.domain.Book;
import com.myspring.startspringio.domain.Publisher;
import com.myspring.startspringio.repositories.AuthorRepository;
import com.myspring.startspringio.repositories.BookRepository;
import com.myspring.startspringio.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Publisher amOved = new Publisher("Am Oved", "Bnei Efraim 33", "TA", "4533234", "Israel");
        publisherRepository.save(amOved);
        authorRepository.save(eric);
        Book book1 = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book1);
        amOved.getBooks().add(book1);
        book1.getAuthors().add(eric);
        book1.setPublisher(amOved);
        bookRepository.save(book1);

        Book bookLord = new Book("Lord of the Rings", "123120");
        Author tolkien = new Author("JRR", "Tolkien");
        authorRepository.save(tolkien);
        bookLord.getAuthors().add(tolkien);
        bookLord.setPublisher(amOved);
        amOved.getBooks().add(bookLord);
        bookRepository.save(bookLord);
/*
        eric.getBooks().add(book1);
        amOved.getBooks().add(book1);
        book1.getAuthors().add(eric);
        book1.setPublisher(amOved);

        authorRepository.save(eric);
        publisherRepository.save(amOved);
        bookRepository.save(book1);



        Book bookLord = new Book("Lord of the Rings", "123120");
        Author tolkien = new Author("JRR", "Tolkien");
        amOved.getBooks().add(bookLord);
        bookLord.getAuthors().add(tolkien);
        tolkien.getBooks().add(bookLord);
        bookLord.setPublisher(amOved);

        authorRepository.save(tolkien);
        publisherRepository.save(amOved);
        bookRepository.save(bookLord);
*/

        System.out.println("Started in bootStrap");
        System.out.println(String.format("Number of books in booksRepository is: %s", bookRepository.count()));
        System.out.println(String.format("In authorsRepository there are %s authors", authorRepository.count()));
        System.out.println(String.format("In publisherRepository there are %s publishers", publisherRepository.count()));

    }
}
