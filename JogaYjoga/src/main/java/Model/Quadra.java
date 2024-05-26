/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;




import java.util.ArrayList;


public class Quadra {
    private String nome;
    private String descricao;
    private ArrayList<String> agenda;
    private String valor;
    //private ArrayList<Quadra> lista;

    
    
    public Quadra(String nome, String descricao,ArrayList<String> agenda, String valor) {
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

    public ArrayList<String> getDiasHorarios() {
        return agenda;
    }

    public void setDiasHorarios(ArrayList<String> agenda) {
        this.agenda = agenda;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}

