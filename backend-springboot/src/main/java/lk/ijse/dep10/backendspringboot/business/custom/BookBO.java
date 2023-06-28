package lk.ijse.dep10.backendspringboot.business.custom;

import lk.ijse.dep10.backendspringboot.dto.BookDTO;

import java.util.List;

public interface BookBO {

    BookDTO saveBook(BookDTO bookDTO) throws Exception;

    List<BookDTO> getAllBooks() throws Exception;
}
