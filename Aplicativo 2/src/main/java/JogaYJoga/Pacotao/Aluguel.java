package JogaYJoga.Pacotao;

import java.time.LocalDate;

public class Aluguel {
    private Cliente cliente;
    private Quadra2 quadra;
    private LocalDate data;
    private String horario;

    public Aluguel(Cliente cliente, Quadra2 quadra, LocalDate data, String horario) {
        this.cliente = cliente;
        this.quadra = quadra;
        this.data = data;
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quadra2 getQuadra() {
        return quadra;
    }

    public LocalDate getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public void exibirDetalhes() {
        System.out.println("Detalhes do Aluguel:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Quadra: " + quadra.getNome());
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
    }
}
