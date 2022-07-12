import br.com.projeto.dio.dominio.Bootcamp;
import br.com.projeto.dio.dominio.Curso;
import br.com.projeto.dio.dominio.Dev;
import br.com.projeto.dio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso java script");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCaroline = new Dev();
        devCaroline.setNome("Caroline");
        devCaroline.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Caroline " + devCaroline.getConteudosInscritos());
        devCaroline.progredir();
        System.out.println("--");
        System.out.println("Conteúdos Inscritos Caroline " + devCaroline.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Caroline" + devCaroline.getConteudosInscritos());
        System.out.println("XP: " + devCaroline.calcularTotalXp());


        System.out.println("----------");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("--");
        System.out.println("Conteúdos Inscritos João " + devCaroline.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João" + devJoao.getConteudosInscritos());
        System.out.println("XP: " + devJoao.calcularTotalXp());
    }
}