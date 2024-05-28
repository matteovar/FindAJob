package Model;

public class Aluguel {
    private Cliente cliente;
    private Quadra quadra;
    private Agendas agendas;
    //precisa arrumar essa parte

    public Aluguel(Cliente cliente, Quadra quadra) {
        this.cliente = cliente;
        this.quadra = quadra;
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    public Agendas getAgendas(){
        return agendas;
    }

    public void exibirDetalhes() {
        System.out.println("Detalhes do Aluguel:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Quadra: " + quadra.getNome());
        System.out.println("Data: " + Agendas.getDiasHorarios());
    }
}