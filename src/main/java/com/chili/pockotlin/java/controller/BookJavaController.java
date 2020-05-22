package com.chili.pockotlin.java.controller;

import com.chili.pockotlin.java.model.User;
import com.chili.pockotlin.model.BookModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
class BookJavaController {

    @GetMapping("/book_java")
    public void bookJava(@RequestParam(value = "author") String name) {
        BookModel bookModel = new BookModel(UUID.randomUUID().toString(), "Il visconte dimezzato", "Italo Calvini", 1935);
        System.out.println("Book " + bookModel.getId() + " with name " + bookModel.getTitle());

        User user = new User("1", "Nicola");
        System.out.println("User" + user.getId() + " with name " + user.getName());
    }
}