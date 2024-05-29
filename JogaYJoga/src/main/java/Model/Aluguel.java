package Model;

public class Aluguel {
    private ListaQuadras listaQuadras;
    //precisa arrumar essa parte

    public Aluguel(ListaQuadras listaQuadras) {
        this.listaQuadras = listaQuadras;
    }

    public int getTotalQuadras() {
        return listaQuadras.tamanho();
    }

    public ListaQuadras getObjetolista() {
        return this.listaQuadras;
    }
}