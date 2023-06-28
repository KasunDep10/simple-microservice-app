package lk.ijse.dep10.backendspringboot.business.custom.impl;

import lk.ijse.dep10.backendspringboot.business.custom.BookBO;
import lk.ijse.dep10.backendspringboot.business.util.Transformer;
import lk.ijse.dep10.backendspringboot.dao.custom.BookDAO;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import lk.ijse.dep10.backendspringboot.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class BookBOImpl implements BookBO {

    private final Transformer transformer;
    private final BookDAO bookDAO;

    public BookBOImpl(Transformer transformer, BookDAO bookDAO) {
        this.transformer = transformer;
        this.bookDAO = bookDAO;
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) throws Exception {
        return transformer.fromBookEntity(bookDAO.save(transformer.toBookEntity(bookDTO)));
    }

    @Override
    public List<BookDTO> getAllBooks() throws Exception {
        return bookDAO.getAllBooks().stream().map(transformer::fromBookEntity).collect(Collectors.toList());

    }
}
