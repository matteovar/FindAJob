package JogaYJoga.Pacotao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void operacoesCliente(Cliente cliente, ListaQuadras lista_quadras) {
        Scanner teclado = new Scanner(System.in);
        int resposta;

        System.out.println("Bem vindo de volta, " + cliente.getNome().toUpperCase());
        System.out.println("\nSelecione uma opção: ");
        System.out.println("[1] Voltar ao inicio \n[2] Alugar uma quadra");

        resposta = teclado.nextInt();
        while (resposta != 1 && resposta != 2) {
            System.out.print("Digite uma opção válida: ");
            resposta = teclado.nextInt();
        }

        clear();
        if (resposta == 2) {
            System.out.println("--> Exibindo Lista de Quadras:");
            lista_quadras.exibirNomeQuadras();

            System.out.println("Escolha uma Quadra: ");
            int numero_quadra = teclado.nextInt();

            clear();
            System.out.println("-> Descrição: ");
            lista_quadras.exibirDescricaoQuadras(numero_quadra);
            System.out.println("Valor: ");
            lista_quadras.exibirValor(numero_quadra);
            System.out.println("[9] Confirmar [1] Voltar");
            resposta = teclado.nextInt();

            if (resposta == 9) {
                ArrayList<LocalDate> diasDisponiveis = new ArrayList<>(lista_quadras.getQuadra(numero_quadra).getDiasHorarios().keySet());
                if (diasDisponiveis.isEmpty()) {
                    System.out.println("Não há dias disponíveis para esta quadra.");
                } else {
                    System.out.println("Dias disponíveis:");
                    for (int i = 0; i < diasDisponiveis.size(); i++) {
                        System.out.println("[" + (i + 1) + "] - " + diasDisponiveis.get(i));
                    }

                    System.out.print("Escolha um dia: ");
                    int diaEscolhido = teclado.nextInt() - 1;
                    if (diaEscolhido >= 0 && diaEscolhido < diasDisponiveis.size()) {
                        LocalDate data = diasDisponiveis.get(diaEscolhido);
                        ArrayList<String> horarios = lista_quadras.getQuadra(numero_quadra).getHorariosDisponiveis(data);
                        if (horarios.isEmpty()) {
                            System.out.println("Não há horários disponíveis para esta data.");
                        } else {
                            System.out.println("Horários disponíveis para " + data + ":");
                            for (int i = 0; i < horarios.size(); i++) {
                                System.out.println("[" + (i + 1) + "] - " + horarios.get(i));
                            }

                            System.out.print("Escolha um horário: ");
                            int horarioEscolhido = teclado.nextInt() - 1;
                            if (horarioEscolhido >= 0 && horarioEscolhido < horarios.size()) {
                                String horarioString = horarios.get(horarioEscolhido);
                                boolean reservado = lista_quadras.getQuadra(numero_quadra).reservarHorario(data, horarioString);
                                if (reservado) {
                                    System.out.println("Horário " + horarioString + " no dia " + data + " reservado com sucesso.");
                                } else {
                                    System.out.println("Falha ao reservar o horário. Tente novamente.");
                                }
                            } else {
                                System.out.println("Opção de horário inválida.");
                            }
                        }
                    } else {
                        System.out.println("Opção de dia inválida.");
                    }
                }
            }
        }
    }

    public static void operacoesLocador(Locador locador, ListaQuadras lista_quadras) {
        Scanner teclado = new Scanner(System.in);
        int resposta = 0;
        System.out.println("===*** Olá " + locador.getNome() + " ***===");

        while (resposta != 1) {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao inicio \n[2] Meus Locais \n[3] Verificar agenda \n[4] Cadastrar novo local");
            resposta = teclado.nextInt();
            while (resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4) {
                System.out.print("Digite uma opção válida: ");
                resposta = teclado.nextInt();
            }

            clear();
            if (resposta == 2) {
                System.out.println("--> Exibindo locais:");
                lista_quadras.exibirNomeQuadras();
                if (lista_quadras.tamanho() == 0) {
                    System.out.println("Não há locais cadastrados");
                } else {
                    System.out.println("\nDigite o Número da quadra para alterar");
                    System.out.println("[1] Voltar");
                }
            } else if (resposta == 3) {
                System.out.println("--> Quadras Agendadas:");
                if (lista_quadras.tamanho() == 0) {
                    System.out.println("Você não possui nenhuma quadra agendada");
                } else {
                    System.out.println("Atualmente você tem X alocações");
                    System.out.println("Temos que trabalhar nesse método");
                }
            } else if (resposta == 4) {
                Map<LocalDate, ArrayList<String>> diasHorarios = new HashMap<>();
                ArrayList<String> horariosDia1 = new ArrayList<>();
                horariosDia1.add("08:00 - 09:00");
                horariosDia1.add("10:00 - 11:00");

                diasHorarios.put(LocalDate.of(2024, 5, 31), horariosDia1);

                Quadra2 quadraExemplo = new Quadra2("Quadra Futset Pinheiros", "Esta quadra é absurdamente legal", diasHorarios, "R$100.00");
                lista_quadras.adicionarQuadras(quadraExemplo);

                System.out.println("Quadra: == " + quadraExemplo.getNome() + " == Adicionada");
            }
        }
        menu(lista_quadras);
    }

    public static void menu(ListaQuadras lista_quadras) {
        Cliente cliente1 = new Cliente("Jônatas", "XXX.XXX.XXX.XXX", "@bol", "120");
        Locador locador1 = new Locador("Beach Sports", "@gmail", "321", "bb");
        Scanner teclado = new Scanner(System.in);

        System.out.println("------ JOGA Y JOGA Y --------");
        int resposta = 0;
        while (resposta != 1 && resposta != 2) {
            System.out.print("Selecione uma opção: \n[1] Cliente [2] Locador\n--> ");
            resposta = teclado.nextInt();
        }
        clear();
        if (resposta == 1) {
            operacoesCliente(cliente1, lista_quadras);
        } else {
            operacoesLocador(locador1, lista_quadras);
        }
    }

    public static void main(String[] args) {
        ListaQuadras lista_quadras = new ListaQuadras();
        menu(lista_quadras);
    }
}
