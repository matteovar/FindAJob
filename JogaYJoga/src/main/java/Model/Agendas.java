package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agendas {

    private static Map<LocalDate, ArrayList<String>> diasHorarios = new HashMap<>();
    private ArrayList<String> horariosReservados = new ArrayList();
    
    public static Map<LocalDate, ArrayList<String>> getDiasHorarios() {
        return diasHorarios;
    }
    
    public Map<LocalDate, ArrayList<String>> getData(){
        //StringBuilder agenda = new StringBuilder();
        return diasHorarios;
    }
    
    public ArrayList<String> getHorariosDisponiveis(LocalDate data) {
        return diasHorarios.getOrDefault(data, new ArrayList<>());
    }
    
    public String getHorariosDisponiveis(){
        StringBuilder dias = new StringBuilder();
        dias.append(diasHorarios.toString());
        return dias.toString();
    }
    
    public String getHorariosReservados() {
        StringBuilder horarios = new StringBuilder();
        if (horariosReservados.isEmpty()) {
            horarios.append("-> Não há horários reservados");
        } else {
            for (int i = 0; i < horariosReservados.size(); i++) {
                horarios.append(horariosReservados.get(i));
                if (i != horariosReservados.size() - 1) {
                    horarios.append(", "); 
                }
            }
        }
        return horarios.toString();
    }
    
    
    public Map<LocalDate, ArrayList<String>> getDiasHorario(){
        return diasHorarios;
    }
    
    public void AdicionarDias(LocalDate dia,ArrayList horario){
        diasHorarios.put(dia,horario);
    }
    
    public boolean reservaHorario(LocalDate data, String horario) {
        ArrayList<String> horarios = diasHorarios.get(data);
        if (horarios != null && horarios.contains(horario)) {
            horariosReservados.add(horario);
            horarios.remove(horario);
            diasHorarios.put(data, horarios);
            return true;
        }
        return false;
    }
}