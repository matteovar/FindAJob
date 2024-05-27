package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agendas {
    private static Map<LocalDate, ArrayList<String>> diasHorarios = new HashMap<>();

    static {
        ArrayList<String> horariosDia1 = new ArrayList<>();
        ArrayList<String> horariosDia2 = new ArrayList<>();
        horariosDia1.add("08:00 - 09:00");
        horariosDia1.add("10:00 - 11:00");
        horariosDia2.add("09:00 - 10:00");
        horariosDia2.add("10:00 - 11:00");
        diasHorarios.put(LocalDate.of(2024, 5, 31), horariosDia1);
        diasHorarios.put(LocalDate.of(2024, 5, 30), horariosDia2);
    }

    public static Map<LocalDate, ArrayList<String>> getDiasHorarios() {
        return diasHorarios;
    }
}