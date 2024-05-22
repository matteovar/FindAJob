
package JogaYJoga.Pacotao;
import java.util.ArrayList;


//Exibir a lista de todas as quadras
//Excluir umaa quadra da lista
//Adicionar uma quadra
public class ListaQuadras {
   public ArrayList<Quadra2> listaOpcoes = new ArrayList();
   
   
   public ListaQuadras(){
   }
   public ListaQuadras(Quadra2 quadra){
       listaOpcoes.add(quadra);
   }
   
   public int tamanho(){
       return listaOpcoes.size();
   }
   
   public void adicionarQuadras(Quadra2 quadra){
       listaOpcoes.add(quadra);
   }
   
   public void exibirNomeQuadras(){
       int tamanho = listaOpcoes.size();
       for(int i=0;i < tamanho; i++){
           System.out.println("["+i+"]"+listaOpcoes.get(i).getNome());
       }
   }
  
   
   public void exibirDescricaoQuadras(int posicao){
       int tamanho = listaOpcoes.size();
       for(int i=0;i < tamanho;i++){
           if(posicao == i){
                System.out.println(listaOpcoes.get(i).getDescricao());
           }
       }
   }
   
   public void exibirDiasDisponiveis(int posicao){
       int tamanho = listaOpcoes.size();
       for(int i=0;i < tamanho;i++){
           if(posicao == i){
                System.out.println(listaOpcoes.get(i).getDias());
           }
       }
   }
   
   public void exibirValor(int posicao){
        int tamanho = listaOpcoes.size();
        for (int i =0; i<tamanho; i++){
            if (posicao == i){
                System.out.println(listaOpcoes.get(i).getValor());
            }
        }
    }

}
