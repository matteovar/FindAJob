package JogaYJoga.Pacotao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Quadra {
    private List<String> listaOpcoes;
    private Map<String, Map<String, List<String>>> quadras;

    public Quadra(List<String> diasDisponiveis, List<String> horariosDisponiveis) {
        listaOpcoes = new ArrayList<>();
        listaOpcoes.add("Quadra 1");
        listaOpcoes.add("Quadra 2");
        listaOpcoes.add("Quadra 3");

        quadras = new HashMap<>();
        for (String quadra : listaOpcoes) {
            Map<String, List<String>> diasHorarios = new HashMap<>();
            for (String dia : diasDisponiveis) {
                diasHorarios.put(dia, new ArrayList<>(horariosDisponiveis));
            }
            quadras.put(quadra, diasHorarios);
        }
    }

    public String cadastarQuadras() {
        return String.join(", ", listaOpcoes);
    }

    public void selecionarQuadras(String quadra, String dia, String horario) {
        if (quadras.containsKey(quadra)) {
            Map<String, List<String>> diasHorarios = quadras.get(quadra);
            if (diasHorarios.containsKey(dia)) {
                List<String> horariosDisponiveis = diasHorarios.get(dia);
                if (horariosDisponiveis.contains(horario)) {
                    horariosDisponiveis.remove(horario);
                    System.out.println("Horário reservado com sucesso para a " + quadra + " no dia " + dia + " às " + horario);
                } else {
                    System.out.println("O horário " + horario + " não está disponível para a " + quadra + " no dia " + dia);
                }
            } else {
                System.out.println("Dia inválido");
            }
        } else {
            System.out.println("Quadra inválida");
            
        }
    }

    public String horariosDisponiveis(String quadra, String dia) {
        if (quadras.containsKey(quadra)) {
            Map<String, List<String>> diasHorarios = quadras.get(quadra);
            if (diasHorarios.containsKey(dia)) {
                List<String> horariosDisponiveis = diasHorarios.get(dia);
                return String.join(", ", horariosDisponiveis);
            } else {
                return "Dia inválido";
            }
        } else {
            return "Quadra inválida";
        }
    }
}