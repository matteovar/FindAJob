package Model;

public class Locador extends Pessoa {
    private String cnpj;
    private ListaQuadras listaQuadras;

    public Locador(String nome, String email, String senha, String cnpj) {
        super(nome, email, senha);
        this.cnpj = cnpj;
        listaQuadras = new ListaQuadras();
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
        if(this.listaQuadras == null){
            return 0;
        }
        return listaQuadras.tamanho();
    }

    public Quadra getQuadra(int posicao){
         return listaQuadras.getQuadra(posicao);
    }

    public void adicionarQuadras(Quadra quadra){
        listaQuadras.adicionarQuadras(quadra);
    }
}
