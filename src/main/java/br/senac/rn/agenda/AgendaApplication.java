package br.senac.rn.agenda;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

	@Autowired
	ContatoRepository repository;

	@Override
	public void run(String... args) throws Exception {
		for (Contato c : repository.findByFonePart("1111")) {
			System.out.println(c.getNome());
		}
	}

}
