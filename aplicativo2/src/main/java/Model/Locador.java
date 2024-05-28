package Model;

public class Locador extends Pessoa {
    private String cnpj;
    private ListaQuadras listaQuadras;

    public Locador(String nome, String email, String senha, String cnpj, ListaQuadras listaQuadras) {
        super(nome, email, senha);
        this.cnpj = cnpj;
        this.listaQuadras = listaQuadras;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public ListaQuadras getObjetolista(){
        return this.listaQuadras;
    }

    public String getListaQuadras(){
        return listaQuadras.exibirNomeQuadras();
    }

    public int getTotalQuadras() {
        return listaQuadras.tamanho();
    }

    public Quadra getQuadra(int posicao){
        return listaQuadras.getQuadra(posicao);
    }

    public void adicionarQuadras(Quadra quadra){
        listaQuadras.adicionarQuadras(quadra);
    }
}
