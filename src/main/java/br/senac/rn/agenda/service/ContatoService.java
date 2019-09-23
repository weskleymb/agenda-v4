package br.senac.rn.agenda.service;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<Contato> listaTodos() {
        return repository.findAll();
    }

    public Contato salva(Contato contato) {
        return repository.save(contato);
    }

    public void removePorId(Long id) {
        repository.deleteById(id);
    }

    public Contato listaPorId(Long id) {
        return repository.findById(id).get();
    }

}
