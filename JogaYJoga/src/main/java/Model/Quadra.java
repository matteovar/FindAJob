package Model;

import java.time.LocalDate;

public class Quadra {
    private String nome;
    private String descricao;
    private Agendas agenda;
    private Quadra aluguel;
    private String valor;

    public Quadra(String nome, String descricao,Agendas agenda, String valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.agenda = agenda;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Agendas getAgenda() {
        return agenda;
    }

    public void setDiasHorarios(Agendas diasHorarios) {
        this.agenda = diasHorarios;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

   
    public void reservarHorario(LocalDate data, String horario) {
        agenda.reservaHorario(data, horario);
        
    }
}