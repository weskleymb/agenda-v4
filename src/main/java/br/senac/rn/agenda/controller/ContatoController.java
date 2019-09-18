package br.senac.rn.agenda.controller;

import br.senac.rn.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping("/")
    public String helloWorld() {
        return "index";
    }

}
