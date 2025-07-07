package com.example.minor_project1.dtos;

import com.example.minor_project1.models.Author;
import com.example.minor_project1.models.Book;
import com.example.minor_project1.models.Genre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class CreateBookRequest {

    @NotBlank        // name != null && name.length() > 0
//    @NotNull         // name != null
    private String name;

    @NotNull
    private Genre genre;

    private Boolean isAvailable;

    @NotBlank(message = "author name is empty or blank")
    private String authorName;

    @NotBlank
    @Email
    private String authorEmail;

    private String authorCountry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry;
    }

//    public Book convertToBook(){
//
//        return Book.builder()
//                .name(this.name)
//                .genre(this.genre)
//                .isAvailable(this.isAvailable == null ? true: this.isAvailable)
//                .issueCount(0L)
//                .author(
//                        Author.builder()
//                                .name(this.authorName)
//                                .email(this.authorEmail)
//                                .country(this.authorCountry)
//                                .build()
//                )
//                .build();
//    }

    public Book convertToBook(){

        Author author = new Author();
        author.setName(this.authorName);
        author.setCountry(this.authorCountry);
        author.setEmail(this.authorEmail);

        Book book = new Book();
        book.setName(this.getName());
        book.setGenre(this.getGenre());
        book.setAvailable(this.isAvailable == null ? true: this.isAvailable);
        book.setIssueCount(0L);
        book.setAuthor(author);
        return book;
    }
}
