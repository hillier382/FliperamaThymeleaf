package com.fliperamaestudio.fliperamaestudio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {

    @GetMapping("/cadastro")
    public String returCadastro(){
        return "cadastro";
    }
}
