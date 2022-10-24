package com.mytechapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//for DOCKER_USERNAME and DOCKER_PASSWORD
// go to your git login
// go to ur project repo -> settings ->secrets->actions then add
// add your docker username/pwd with above two keys
// when u commit code to ur repo in git then it will
// start build and connect to docker from given secrets username/pwd and build image in docker
@RestController
@RequestMapping("/book")
public class BooksController {

    Set<String> books = null;

    @GetMapping("/get")
    public ResponseEntity<String> getBooks(){
        return new ResponseEntity<>("getBooks() need to implement..!!", HttpStatus.OK);
    }

    @PostMapping(value="/add/{bookName}")
    public ResponseEntity<Set<String>> addBook(@PathVariable("bookName") String bookName){
        if(Objects.isNull(books)){
            books = new HashSet<>();
        }
        books.add(bookName);
        return new ResponseEntity<>(books,HttpStatus.ACCEPTED);

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
