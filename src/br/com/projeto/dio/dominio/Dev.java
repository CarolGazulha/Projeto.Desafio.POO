package br.com.projeto.dio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String mome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private String nome;

    public void InscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(Bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
       Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
       if(conteudo.isPresent()) {
           this.conteudosConcluidos.add(conteudo.get());
           this.conteudosInscritos.remove(conteudo.get());
       } else {
           System.err.println("Você não está matriculado em nenhum conteúdo!");
       }
    }

    public double calcularTotalXp() {
        this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
        return 0;
    }

    public String getMome() {
        return mome;
    }

    public void setMome(String mome) {
        this.mome = mome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(mome, dev.mome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mome, conteudosInscritos, conteudosConcluidos);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
    }
}
