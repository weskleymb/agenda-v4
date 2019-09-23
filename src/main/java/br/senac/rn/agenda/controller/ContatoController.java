package br.senac.rn.agenda.controller;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping
    public String listaTodos(Model model) {
        Contato contato = new Contato();
        model.addAttribute("contato", contato);
        List<Contato> contatos = service.listaTodos();
        model.addAttribute("contatos", contatos);
        return "contatos";
    }

    @PostMapping
    public String salva(Contato contato) {
        service.salva(contato);
        return "redirect:/contatos";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        service.removePorId(id);
        return "redirect:/contatos";
    }

    @GetMapping("/{id}/edita")
    public String edita(@PathVariable("id") Long id, Model model) {
        Contato contato = service.listaPorId(id);
        model.addAttribute("contato", contato);
        List<Contato> contatos = service.listaTodos();
        model.addAttribute("contatos", contatos);
        return "contatos";
    }

}
