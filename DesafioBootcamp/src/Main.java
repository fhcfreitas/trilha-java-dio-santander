import modelos.Bootcamp;
import modelos.Curso;
import modelos.Dev;
import modelos.Mentoria;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curso cursoPOO = new Curso();
        cursoPOO.setTitulo("Programação Orientada a Objetos");
        cursoPOO.setDescricao("Descrição do curso de POO");
        cursoPOO.setCargaHoraria(10);

        Curso collections = new Curso();
        collections.setTitulo("Coleções em Java");
        collections.setDescricao("Descrição do curso de coleções");
        collections.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Descrição da mentoria");
        mentoria.setDataMentoria(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Santander DIO");
        bootcamp.setDescricao("Descrição Bootcamp Java");
        bootcamp.getConteudos().add(cursoPOO);
        bootcamp.getConteudos().add(collections);
        bootcamp.getConteudos().add(mentoria);

        Dev devFabio = new Dev();
        devFabio.setNome("Fabio");
        devFabio.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + devFabio.getConteudosInscritos());
        devFabio.progredir();
        devFabio.progredir();
        devFabio.progredir();
        System.out.println("Conteúdos Inscritos: " + devFabio.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + devFabio.getConteudosConcluidos());
        System.out.println("XP: " + devFabio.calcularTotalXp());
    }
}