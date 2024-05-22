/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JogaYJoga.Pacotao;
import java.util.ArrayList;

public class Quadra2 {
    private String nome;
    private String descricao;
    private String dias;
    private String horarios;
    private String valor;

    public Quadra2(String nome, String descricao, String dias, String horarios, String valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.dias = dias;
        this.horarios = horarios;
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

    public String getDias() {
        return dias;
    }
    public void setDias(String Dias) {
        this.dias = Dias;
    }

    public String getHorarios() {
        return horarios;
    }
    public void setHorarios(String Horarios) {
        this.horarios = Horarios;
    }
    
    public String getValor(){
        return valor;
    }

    public void setValor(String valor){
        this.valor = valor;
    }
    
            
   
    
    
   
}
