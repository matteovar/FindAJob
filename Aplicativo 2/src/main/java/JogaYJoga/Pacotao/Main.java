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

    public static void operacoesCliente(Cliente cliente, ListaQuadras listaQuadras) {
        Scanner teclado = new Scanner(System.in);
        int resposta;

        while (true) {
            System.out.println("Bem vindo de volta, " + cliente.getNome().toUpperCase());
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao inicio \n[2] Alugar uma quadra");

            resposta = teclado.nextInt();
            while (resposta != 1 && resposta != 2) {
                System.out.print("Digite uma opção válida: ");
                resposta = teclado.nextInt();
            }

            clear();
            if (resposta == 1) {
                return; // Voltar ao menu principal
            } else if (resposta == 2) {
                System.out.println("--> Exibindo Lista de Quadras:");
                listaQuadras.exibirNomeQuadras();

                System.out.println("Escolha uma Quadra: ");
                int numeroQuadra = teclado.nextInt();

                clear();
                System.out.println("-> Descrição: ");
                listaQuadras.exibirDescricaoQuadras(numeroQuadra);
                System.out.println("Valor: ");
                listaQuadras.exibirValor(numeroQuadra);
                System.out.println("[9] Confirmar [1] Voltar");
                resposta = teclado.nextInt();

                if (resposta == 9) {
                    ArrayList<LocalDate> diasDisponiveis = new ArrayList<>(listaQuadras.getQuadra(numeroQuadra).getDiasHorarios().keySet());
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
                            ArrayList<String> horarios = listaQuadras.getQuadra(numeroQuadra).getHorariosDisponiveis(data);
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
                                    boolean reservado = listaQuadras.getQuadra(numeroQuadra).reservarHorario(data, horarioString);
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
    }

    public static void operacoesLocador(Locador locador, ListaQuadras listaQuadras) {
        Scanner teclado = new Scanner(System.in);
        int resposta = 0;
        System.out.println("===*** Olá " + locador.getNome() + " ***===");

        while (true) {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao inicio \n[2] Meus Locais \n[3] Verificar agenda \n[4] Cadastrar novo local");
            resposta = teclado.nextInt();
            while (resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4) {
                System.out.print("Digite uma opção válida: ");
                resposta = teclado.nextInt();
            }

            clear();
            if (resposta == 1) {
                return; // Voltar ao menu principal
            } else if (resposta == 2) {
                System.out.println("--> Exibindo locais:");
                listaQuadras.exibirNomeQuadras();
                if (listaQuadras.tamanho() == 0) {
                    System.out.println("Não há locais cadastrados");
                } else {
                    System.out.println("\nDigite o Número da quadra para alterar");
                    System.out.println("[1] Voltar");
                }
            } else if (resposta == 3) {
                System.out.println("--> Verificando Agenda:");
                if (listaQuadras.tamanho() == 0) {
                    System.out.println("Você não possui nenhuma quadra cadastrada.");
                } else {
                    for (int i = 0; i < listaQuadras.tamanho(); i++) {
                        Quadra2 quadra = listaQuadras.getQuadra(i);
                        System.out.println("Agenda para a quadra: " + quadra.getNome());
                        quadra.getDiasHorarios().forEach((data, horarios) -> {
                            System.out.println("Data: " + data);
                            if (horarios.isEmpty()) {
                                System.out.println("  Todos os horários estão reservados.");
                            } else {
                                System.out.println("  Horários disponíveis: " + horarios);
                            }
                        });
                        System.out.println();
                    }
                }
            } else if (resposta == 4) {
                System.out.println("Digite o nome da nova quadra:");
                teclado.nextLine(); // consume the newline left-over
                String nome = teclado.nextLine();
            
                if (quadraJaAdicionada(listaQuadras, nome)) {
                    System.out.println("Esta quadra já foi adicionada anteriormente.");
                } else {
                    System.out.println("Digite a descrição da nova quadra:");
                    String descricao = teclado.nextLine();
                    System.out.println("Digite o valor da nova quadra:");
                    String valor = teclado.nextLine();
            
                    Map<LocalDate, ArrayList<String>> diasHorarios = new HashMap<>();
                    ArrayList<String> horariosDia1 = new ArrayList<>();
                    ArrayList<String> horariosDia2 = new ArrayList<>();
                    horariosDia1.add("08:00 - 09:00");
                    horariosDia1.add("10:00 - 11:00");
                    horariosDia2.add("09:00 - 10:00");
                    horariosDia2.add("10:00 - 11:00");
                    diasHorarios.put(LocalDate.of(2024, 5, 31), horariosDia1);
                    diasHorarios.put(LocalDate.of(2024, 5, 30), horariosDia2);
            
                    Quadra2 novaQuadra = new Quadra2(nome, descricao, diasHorarios, valor);
                    listaQuadras.adicionarQuadras(novaQuadra);
            
                    System.out.println("Quadra: == " + novaQuadra.getNome() + " == Adicionada com sucesso");
                }
            }
        }
    }

    public static boolean quadraJaAdicionada(ListaQuadras listaQuadras, String nomeQuadra) {
        for (int i = 0; i < listaQuadras.tamanho(); i++) {
            Quadra2 quadra = listaQuadras.getQuadra(i);
            if (quadra.getNome().equalsIgnoreCase(nomeQuadra)) {
                return true;
            }
        }
        return false;
    }

    public static void menu(ListaQuadras listaQuadras) {
        Cliente cliente1 = new Cliente("Jônatas", "XXX.XXX.XXX.XXX", "@bol", "120");
        Locador locador1 = new Locador("Beach Sports", "@gmail", "321", "bb");
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("------ JOGA Y JOGA Y --------");
            System.out.print("Selecione uma opção: \n[1] Cliente \n[2] Locador \n[3] Sair\n--> ");
            int resposta = teclado.nextInt();
            
            clear();
            if (resposta == 1) {
                operacoesCliente(cliente1, listaQuadras);
            } else if (resposta == 2) {
                operacoesLocador(locador1, listaQuadras);
            } else if (resposta == 3) {
                System.out.println("Obrigado por usar o JogaYJoga");
                break; // Sair do loop e terminar o programa
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        ListaQuadras listaQuadras = new ListaQuadras();
        menu(listaQuadras);
    }
}
