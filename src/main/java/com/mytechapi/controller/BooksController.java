package com.mytechapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;
// Commands to commit code to git hub
//create a new repository on the command line
//        echo "# springboot-github-cicd" >> README.md
//        git init
//        git add README.md
//        git commit -m "first commit"
//        git branch -M main
//        git remote add origin https://github.com/anandputhanikar/springboot-github-cicd.git
//        git push -u origin main
//        …or push an existing repository from the command line
//        git remote add origin https://github.com/anandputhanikar/springboot-github-cicd.git
//        git branch -M main
//        git push -u origin main

//BASIC USAGE ( docker action) - add below in maven.yml
// - uses: mr-smithers-excellent/docker-build-push@v5
//    name: Build & push Docker image
//            with:
//            image: repo/image
//            tags: v1, latest
//            registry: registry-url.io
//            dockerfile: Dockerfile.ci
//            username: ${{ secrets.DOCKER_USERNAME }}
//            password: ${{ secrets.DOCKER_PASSWORD }}
@RestController
public class BooksController {

    Set<String> books = null;

    @GetMapping("/")
    public String getBooks(){
        return "getBooks() need to implement..!!";
    }

    @PostMapping(value="/add/{bookName}")
    public Set<String> addBook(@PathVariable("bookName") String bookName){
        if(Objects.isNull(books)){
            books = new HashSet<>();
        }
        books.add(bookName);
        return books;

    }

    @PostMapping("/addAllBooks")
    public Set<String> addListOfBooks(@RequestBody Map<String,List<String>> booksMap){

        List<String> bookNames = !booksMap.isEmpty()? booksMap.getOrDefault("books",null):null;

        if(Objects.isNull(books)){
            books = new HashSet<>();
        }
        if(!Objects.isNull(bookNames))
            books.addAll(bookNames);
        return books;

    }
}
