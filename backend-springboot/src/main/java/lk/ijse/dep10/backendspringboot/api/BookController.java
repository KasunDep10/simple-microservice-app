package lk.ijse.dep10.backendspringboot.api;

import lk.ijse.dep10.backendspringboot.business.custom.BookBO;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookBO bookBO;

    public BookController(BookBO bookBO) {
        this.bookBO = bookBO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO saveBook(@RequestBody @Valid BookDTO book) throws Exception {
        return bookBO.saveBook(book);
    }

    @GetMapping
    public List<BookDTO> getAllBooks() throws Exception {
        return bookBO.getAllBooks();
    }
}
