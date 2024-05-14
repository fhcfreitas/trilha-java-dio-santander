package main.map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventos;

    public AgendaEventos() {
        this.agendaEventos = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        agendaEventos.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventos);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        LocalDate diaAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        if(!agendaEventos.isEmpty()){
            for(Map.Entry<LocalDate, Evento> entry : agendaEventos.entrySet()){
                LocalDate dataEvento = entry.getKey();
                if (dataEvento.isEqual(diaAtual) || dataEvento.isAfter(diaAtual)) {
                    if (proximaData == null || dataEvento.isBefore(proximaData)) {
                        proximaData = dataEvento;
                        proximoEvento = entry.getValue();
                    }
                }
            }
            if (proximoEvento != null){
                System.out.println("O próximo evento é o " + proximoEvento.getNome() + " que ocorrerá no dia " + proximaData);
            } else {
                System.out.println("Não há eventos futuros.");
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agenda = new AgendaEventos();

        agenda.adicionarEvento(LocalDate.of(2024, Month.JUNE, 10) , "Rock in Rio", "Cantores Internacionais");
        agenda.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 20), "Rock The Mountain", "Cantores Nacionais");
        agenda.adicionarEvento(LocalDate.of(2024, Month.NOVEMBER, 15), "Love Sessions", "Djs");

        System.out.println("Lista de Eventos:");
        agenda.exibirAgenda();

        System.out.println("\nQual será o próximo evento?");
        agenda.obterProximoEvento();

    }

}
