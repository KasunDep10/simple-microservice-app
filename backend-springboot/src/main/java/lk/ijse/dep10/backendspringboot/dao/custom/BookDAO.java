package lk.ijse.dep10.backendspringboot.dao.custom;

import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import lk.ijse.dep10.backendspringboot.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getAllBooks() throws Exception;

    Book save(Book book) throws Exception;
}
