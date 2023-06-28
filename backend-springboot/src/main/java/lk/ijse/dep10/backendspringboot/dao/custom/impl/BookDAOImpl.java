package lk.ijse.dep10.backendspringboot.dao.custom.impl;

import lk.ijse.dep10.backendspringboot.dao.custom.BookDAO;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import lk.ijse.dep10.backendspringboot.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static lk.ijse.dep10.backendspringboot.dao.util.Mapper.BOOK_ROW_MAPPER;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        return jdbcTemplate.query("SELECT * FROM book",BOOK_ROW_MAPPER);
    }

    @Override
    public Book save(Book book) throws Exception {
        jdbcTemplate.update("INSERT INTO book (isbn,title) VALUES (?,?)",book.getIsbn(),book.getTitle());
        return book;
    }
}
