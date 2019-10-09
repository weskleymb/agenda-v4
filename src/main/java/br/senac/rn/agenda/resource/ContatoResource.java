package br.senac.rn.agenda.resource;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contatos-ws")
public class ContatoResource {

    @Autowired
    private ContatoService service;

    @GetMapping
    public List<Contato> findAll() {
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable("id") Long id) {
        try {
            Contato contato = service.listaPorId(id);
            return ResponseEntity.ok(contato);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contato> cria(@RequestBody Contato contato,
                                        HttpServletResponse response) {

        Contato c = service.salva(contato);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequestUri()
                    .path("/{id}")
                    .buildAndExpand(c.getId())
                    .toUri();

        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(c);
    }

}
