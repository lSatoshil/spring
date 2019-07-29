package com.didispace.springboothello.web;

import com.didispace.springboothello.bean.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/book")
    public Book book() {
        Book book = new Book();
        return book;
    }
}
