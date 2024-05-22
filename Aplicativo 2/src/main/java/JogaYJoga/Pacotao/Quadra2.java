package JogaYJoga.Pacotao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quadra2 {
    private String nome;
    private String descricao;
    private Map<LocalDate, ArrayList<String>> diasHorarios;
    private String valor;

    public Quadra2(String nome, String descricao, Map<LocalDate, ArrayList<String>> diasHorarios, String valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.diasHorarios = diasHorarios;
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

    public Map<LocalDate, ArrayList<String>> getDiasHorarios() {
        return diasHorarios;
    }

    public void setDiasHorarios(Map<LocalDate, ArrayList<String>> diasHorarios) {
        this.diasHorarios = diasHorarios;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<String> getHorariosDisponiveis(LocalDate data) {
        return diasHorarios.getOrDefault(data, new ArrayList<>());
    }

    public boolean reservarHorario(LocalDate data, String horario) {
        ArrayList<String> horarios = diasHorarios.get(data);
        if (horarios != null && horarios.contains(horario)) {
            horarios.remove(horario);
            diasHorarios.put(data, horarios);
            return true;
        }
        return false;
    }
}
