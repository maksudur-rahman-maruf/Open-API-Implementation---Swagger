package com.maruf.openapiimplementation.controller;

import com.maruf.openapiimplementation.Entity.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class Controller {

                                                 // OpenAPI descriptions -> http://localhost:8080/v3/api-docs/
    @Operation(summary = "Get a book by its id") // API-Documentation(By swagger UI)->  http://localhost:8080/swagger-ui.html
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return new Book(100, "Lord Of The Rings", "Fantasy");
    }


    @GetMapping("/")
    public List<Book> findAll() {
        return Arrays.asList(new Book(100, "Lord Of The Rings", "Fantasy"),
                new Book(200, "Harry Potter", "Horror"),
                new Book(300, "Game Of Thrones", "Fantasy/Drama")
        );
    }


    @PostMapping("/")
    public List<Book> save() {
        return Arrays.asList(new Book(1, "Lord Of The Rings", "Fantasy"),
                new Book(1, "Harry Potter", "Horror"),
                new Book(1, "Game Of Thrones", "Fantasy/Drama")
        );
    }

}
