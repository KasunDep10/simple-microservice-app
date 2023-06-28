package lk.ijse.dep10.backendspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    @NotBlank(message = "isbn can't be empty or null")
    @Pattern(regexp = "\\d{10,13}",message = "Invalid isbn")
    private String isbn;
    @NotBlank(message = "title can't be empty or null")
    private String title;
}
