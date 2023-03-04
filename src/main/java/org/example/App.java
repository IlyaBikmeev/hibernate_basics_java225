package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Создание дампа
 * pg_dump -h hostname -U username -F format -f dumpfile dbname
 *
 * Выгрузка дампа в бд (если файл дампа не текстовый)
 * pg_restore -h hostname -U username -F format -d dbname dumpfile
 *
 * Если файл текстовый - выгружаем через psql.
 *
 */
public class App {
    public static void main( String[] args ) {
        //Спарсим конфигурацию
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        //Здесь ваш код, который делает запросы к бд.
        System.out.println("Автор с id = 1:");
        Author author = session.get(Author.class, 1);
        System.out.println(author.getName());
        System.out.println("Все книги автора с id = 1:");
        author.getBooks().forEach(book -> System.out.println(book.getTitle()));

        System.out.println("Книга с id = 7:");
        Book book = session.get(Book.class, 7);
        System.out.println(book.getTitle());
        System.out.println("Автор книги с id = 7:");
        System.out.println(book.getAuthor().getName());

        //Создание новой книги
//        Query query = session.createQuery("FROM Author WHERE name = 'Достоевский Ф.М.'");
//        Author author1 = (Author) query.getSingleResult();
//        Book book1 = new Book("Записки из подполья", 564.5, 644, author1);
//
//        session.save(book1);

        //Все книги, дороже 450 рублей

//        System.out.println("Книги, дороже 450 рублей:");
//        List<Book> books = session.createQuery("FROM Book WHERE price > 450")
//            .getResultList();
//
//        books.forEach(b -> System.out.println(b.getAuthor() + " : " + b.getTitle()));

//        Author newAuthor = new Author("Пауло Коэльо");
//        Book newBook1 = new Book("Алхимик", 657.6, 64, newAuthor);
//        Book newBook2 = new Book("Дневник мага", 686.6, 64, newAuthor);
//        newAuthor.setBooks(new ArrayList<>(List.of(newBook1, newBook2)));
//        session.save(newAuthor);
//

        session.close();
    }
}
