package br.senac.rn.agenda.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_contatos")
public class Contato {

    @Id
    @Column(name = "con_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "con_nome", nullable = false)
    private String nome;

    @Column(name = "con_fone", nullable = false)
    private String fone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return id.equals(contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
