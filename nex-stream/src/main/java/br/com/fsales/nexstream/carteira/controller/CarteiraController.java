package br.com.fsales.nexstream.carteira.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

    @GetMapping
    public Mono<String> helloWord(){

        return Mono.just("Hello Word");
    }
}
