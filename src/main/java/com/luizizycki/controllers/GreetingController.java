package com.luizizycki.controllers;

//Importa o model Greeting, que é o tipo de retorno no endpoint
import com.luizizycki.model.Greeting;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
// é um long só que mais seguro, não tem overflow

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController //indica que essa classe é um controller REST, vai responder requisições HTTP

public class GreetingController {


    private static final String template = "Hello, %s!";

    // cria o counter, que é um contador de requisições com o tipo AtomicLong
    private final AtomicLong counter = new AtomicLong();


    // http://localhost:8080/greeting?name=Luiz
    @RequestMapping("/greeting") //nome do endpoint

    public Greeting greeting(
        @RequestParam(value = "name") //extrai o parâmetro name da URL
        String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
        //retorna o objeto Greeting com o id sendo incrementado cada vez, e o content sendo o template formatado com o nome
    }
}
