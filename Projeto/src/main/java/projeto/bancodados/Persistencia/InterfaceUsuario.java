package projeto.bancodados.Persistencia;

import projeto.bancodados.Entidades.Aplicativo;
import projeto.bancodados.Entidades.Carro;
import projeto.bancodados.Entidades.Time;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    CarrosDAO dao1;
    AplicativoDAO dao2;
    TimeDAO dao3;
    Scanner in;

    public InterfaceUsuario(CarrosDAO daoCarro, AplicativoDAO daoAplicativo, TimeDAO daoTime) {
        this.dao1 = daoCarro;
        this.dao2 = daoAplicativo;
        this.dao3 = daoTime;
        this.in = new Scanner(System.in);
    }

    public void Iniciar() {
        imprimirMenuNomes();
    }

    private void imprimirMenuNomes() {
        int opc = 0;
        do {
            System.out.println("\n Olá, escolha uma categoria para prosseguir!");
            System.out.println("\n1. Aplicativos");
            System.out.println("\n2. Carros");
            System.out.println("\n3. Times");
            System.out.println("\n4. Sair");
            System.out.println("\nDigite um número: ");
            opc = in.nextInt();
            System.out.println("\n------------------------------------");

            in.nextLine();

            switch (opc) {
                case 1:
                    imprimirMenu("Aplicativos");
                    break;
                case 2:
                    imprimirMenu("Carros");
                    break;
                case 3:
                    imprimirMenu("Times");
                    break;
                case 4:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (opc != 4);
    }

    private void imprimirMenu(String Nome) {
        int opc = 0;
        do {
            System.out.println("\n1. Criar " + Nome);
            System.out.println("\n2. Deletar " + Nome);
            System.out.println("\n3. Atualizar " + Nome);
            System.out.println("\n4. Ver " + Nome);
            System.out.println("\n5. Voltar ao menu inicial");
            System.out.println("\n6. Sair");
            System.out.println("\nEscolha uma opção: ");
            opc = in.nextInt();
            System.out.println("\n------------------------------------");


            in.nextLine();

            switch (opc) {
                case 1:
                    if (Nome == "Aplicativos") {
                        this.create("Aplicativos");
                    } else if (Nome == "Carros") {
                        this.create("Carros");
                    } else {
                        this.create("Times");
                    }
                    break;
                case 2:
                    if (Nome == "Aplicativos") {
                        this.delete("Aplicativos");
                    } else if (Nome == "Carros") {
                        this.delete("Carros");
                    } else {
                        this.delete("Times");
                    }
                    break;
                case 3:
                    if (Nome == "Aplicativos") {
                        this.update("Aplicativos");
                    } else if (Nome == "Carros") {
                        this.update("Carros");
                    } else {
                        this.update("Times");
                    }
                    break;
                case 4:
                    if (Nome == "Aplicativos") {
                        this.read("Aplicativos");
                    } else if (Nome == "Carros") {
                        this.read("Carros");
                    } else {
                        this.read("Times");
                    }
                    break;
                case 5:
                    Iniciar();
                    break;
                case 6:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (opc != 6);
    }

    private void create(String categoria) {
        Aplicativo aplicativos = new Aplicativo();
        Carro carros = new Carro();
        Time times = new Time();


        if (categoria == "Aplicativos") {
                System.out.println("Informe o ID: ");
                aplicativos.setId(in.next());

                in.nextLine();

                System.out.println("Informe o nome que deseja inserir: ");
                aplicativos.setNome(in.next());

                System.out.println("Informe o desenvolvedor que deseja inserir: ");
                aplicativos.setDesenvolvedor(in.next());

                System.out.println("Informe o numero de downloads que deseja inserir: ");
                aplicativos.setNumeroDownloads(in.nextInt());

                if (dao2.create(aplicativos)) {
                System.out.println("Aplicativo adicionado com sucesso");
            } else {
                System.out.println("Problema ao adionar Aplicativo");
            }
        }

        if (categoria == "Carros") {
                System.out.println("Informe o ID: ");
                carros.setId(in.nextLine());

                System.out.println("Informe o modelo que deseja inserir: ");
                carros.setModelo(in.nextLine());

                System.out.println("Informe a marca que deseja inserir: ");
                carros.setMarca(in.nextLine());

                System.out.println("Informe o ano que deseja inserir: ");
                carros.setAno(in.nextLine());

                System.out.println("Informe a categoria que deseja inserir: ");
                carros.setCategoria(in.nextLine());
                if (dao1.create(carros)) {
                System.out.println("Carro adicionado com sucesso");
                } else {
                    System.out.println("Problema ao adionar Carro");
                }
        }

        if (categoria == "Times") {
                System.out.println("Informe o ID: ");
                times.setIdTime(in.nextLine());

                System.out.println("Informe o Nome que deseja inserir: ");
                times.setNome(in.nextLine());

                System.out.println("Informe o ano que deseja inserir: ");
                times.setAnoFund(in.nextInt());

                in.nextLine();

                System.out.println("Informe a cidade que deseja inserir: ");
                times.setCidade(in.nextLine());

                System.out.println("Informe o estado que deseja inserir: ");
                times.setEstado(in.nextLine());


                if (dao3.create(times)) {
                System.out.println("Time adicionado com sucesso");
                } else {
                System.out.println("Problema ao adionar Time");
                }
        }
    }

    private void read(String categoria) {
        if (categoria == "Carros") {
            List<Carro> carros1 = dao1.read();

            System.out.println("\n----------------------------------");
            System.out.println("---  Lista de Carros Cadastrados ---");
            System.out.println("------------------------------------");
            for (Carro carros : carros1) {
                System.out.println(carros);
            }
        } else if (categoria == "Aplicativos") {
            List<Aplicativo> aplicativos1 = dao2.read();

            System.out.println("\n---------------------------------------");
            System.out.println("---  Lista de Aplicativos Cadastrados ---");
            System.out.println("-----------------------------------------");
            for (Aplicativo aplicativos : aplicativos1) {
                System.out.println(aplicativos);
            }
        } else {
            List<Time> times1 = dao3.read();

            System.out.println("\n----------------------------------");
            System.out.println("---  Lista de Times Cadastrados ---");
            System.out.println("------------------------------------");
            for (Time times : times1) {
                System.out.println(times);
            }
        }
    }

    private void update(String categoria) {
        if (categoria == "Carros") {
            read("Carros");
            Carro carros3 = new Carro();
            System.out.println("Informe o ID: ");
            carros3.setId(in.next());

            in.nextLine();

            System.out.println("Informe o modelo que deseja atualizar: ");
            carros3.setModelo(in.next());

            System.out.println("Informe a marca que deseja atualizar: ");
            carros3.setMarca(in.next());

            System.out.println("Informe o ano que deseja atualizar: ");
            carros3.setAno(in.next());

            System.out.println("Informe a categoria que deseja atualizar: ");
            carros3.setCategoria(in.next());


            if (dao1.update(carros3)) {
                System.out.println("Carro ID " + carros3.getId() +
                        " Atualizado com sucesso");
            } else {
                System.out.println("Falha ao tentar atualizar");
            }
        } else if (categoria == "Aplicativos") {
            read("Aplicativos");
            Aplicativo aplicativo3 = new Aplicativo();
            System.out.println("Informe o ID: ");
            aplicativo3.setId(in.next());

            in.nextLine();

            System.out.println("Informe o novo nome: ");
            aplicativo3.setNome(in.next());

            System.out.println("Informe o novo desenvolvedor: ");
            aplicativo3.setDesenvolvedor(in.next());

            System.out.println("Informe o novo número de downloads: ");
            aplicativo3.setNumeroDownloads(in.nextInt());


            if (dao2.update(aplicativo3)) {
                System.out.println("Aplicativo ID " + aplicativo3.getId() +
                        " Atualizado com sucesso");
            } else {
                System.out.println("Falha ao tentar atualizar");
            }
        } else {
            read("Times");
            Time time3 = new Time();
            System.out.println("Informe o ID: ");
            time3.setIdTime(in.next());

            in.nextLine();

            System.out.println("Informe o novo nome: ");
            time3.setNome(in.next());

            System.out.println("Informe o novo ano de fundação: ");
            time3.setAnoFund(in.nextInt());

            System.out.println("Informe a nova cidade: ");
            time3.setCidade(in.next());

            System.out.println("Informe o novo estado: ");
            time3.setEstado(in.next());


            if (dao3.update(time3)) {
                System.out.println("Time ID " + time3.getIdTime() +
                        " Time com sucesso");
            } else {
                System.out.println("Falha ao tentar atualizar");
            }
        }
    }

    private void delete(String categoria) {
        if (categoria == "Carros") {
            List<Carro> carros1 = dao1.read();

            while (true) {
                System.out.println("\n----------------------------------");
                System.out.println("---  Lista de Carros Cadastrados ---");
                System.out.println("------------------------------------");
                int e = 0;
                for (Carro carros : carros1) {
                    System.out.println((e) + " - " + carros + "\n------------------------------------");
                    e++;
                }
                System.out.println("9090 - Cancelar operação");

                System.out.print("Qual Carro deseja remover? (Digite o ID)");
                int opc2 = in.nextInt();
                in.nextLine();

                if (opc2 == 9090) {
                    break;
                }

                if (opc2 >= carros1.size() || opc2 < 0) {
                    System.out.println("Esta opção não é válida");
                } else {
                    if (dao1.delete(carros1.get(opc2))) {
                        System.out.println("Carro " + carros1.get(opc2).getId() +
                                " Removido com sucesso");
                    } else {
                        System.out.println("Falha ao tentar remover");
                    }
                    //Isso para o while infinito
                    break;
                }
            }
        } else if (categoria == "Aplicativos") {
            List<Aplicativo> aplicativo1 = dao2.read();

            while (true) {
                System.out.println("\n----------------------------------");
                System.out.println("---  Lista de Aplicativos Cadastrados --");
                System.out.println("------------------------------------");
                int e = 0;
                for (Aplicativo aplicativos : aplicativo1) {
                    System.out.println((e) + " - " + aplicativos + "\n------------------------------------");
                    e++;
                }
                System.out.println("9090 - Cancelar operação");

                System.out.println("Qual Aplicativo deseja remover? (Digite o ID)");
                int opc2 = in.nextInt();
                in.nextLine();

                if (opc2 == 9090) {
                    break;
                }

                if (opc2 >= aplicativo1.size() || opc2 < 0) {
                    System.out.println("Esta opção não é válida");
                } else {
                    if (dao2.delete(aplicativo1.get(opc2))) {
                        System.out.println("Aplicativo " + aplicativo1.get(opc2).getId() + " Removido com sucesso");
                    } else {
                        System.out.println("Falha ao tentar remover");
                    }
                    break;
                }

            }
        }
        else{
            List<Time> time1 = dao3.read();

            while (true) {
                System.out.println("\n----------------------------------");
                System.out.println("---  Lista de Times Cadastrados --");
                System.out.println("------------------------------------");
                int e = 0;
                for (Time times : time1) {
                    System.out.println((e) + " - " + times + "\n------------------------------------");
                    e++;
                }
                System.out.println("9090 - Cancelar operação");

                System.out.println("Qual Time deseja remover? (Digite o ID)");
                int opc2 = in.nextInt();
                in.nextLine();

                if (opc2 == 9090) {
                    break;
                }

                if (opc2 >= time1.size() || opc2 < 0) {
                    System.out.println("Esta opção não é válida");
                } else {
                    if (dao3.delete(time1.get(opc2))) {
                        System.out.println("Time" + time1.get(opc2).getIdTime() + "Removido com sucesso");
                    } else {
                        System.out.println("Falha ao tentar remover");
                    }
                    break;
                }
            }
        }
    }
}
