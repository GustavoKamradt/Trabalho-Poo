import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final Despeza[] gastos = new Despeza[30];
    private static final Receita[] ganhos = new Receita[30];

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Programa Financeiro de Tom");

        while(true){
            System.out.println(LocalDate.now());
            System.out.println("Escolha uma opção:");
            System.out.println("1: Adicionar gasto");
            System.out.println("2: Adicionar ganho");
            System.out.println("3: relatorio de gastos");
            System.out.println("4: relatorio de ganhos");
            System.out.println("5: relatorio mensal");
            int opt = sc.nextInt();
            switch (opt){
                case 1 ->{
                    System.out.println("Adicione o nome da despeza");
                    String nome = sc.next();
                    System.out.println("Adicione o tipo da despeza");
                    String tipo = sc.next();
                    System.out.println("Adicione a dia da despeza");
                    int dia = sc.nextInt();
                    System.out.println("Adicione a mês da despeza");
                    int mes = sc.nextInt();
                    System.out.println("Adicione a ano da despeza");
                    int ano = sc.nextInt();
                    LocalDate data = LocalDate.of(ano,mes,dia);

                    format.format(data);
                    System.out.println("Adicione o valor da despeza");
                    double valor = sc.nextDouble();
                    System.out.println("Adicione a Forma de pagamento da despeza");
                    String formadepagamento = sc.next();
                    adicionarGasto(nome,tipo,data,valor,formadepagamento);
                }
                case 2 -> {
                    System.out.println("Adicione o nome da ganho");
                    String nome = sc.next();
                    System.out.println("Adicione o tipo da ganho");
                    String tipo = sc.next();
                    System.out.println("Adicione a dia da ganho");
                    int dia = sc.nextInt();
                    System.out.println("Adicione a mês da ganho");
                    int mes = sc.nextInt();
                    System.out.println("Adicione a ano da ganho");
                    int ano = sc.nextInt();
                    LocalDate data = LocalDate.of(ano,mes,dia);
                    format.format(data);
                    System.out.println("Adicione o valor da ganho");
                    double valor = sc.nextDouble();
                    adicionarGanho(nome, tipo, data, valor);
                }
                case 3 ->{
                    relatoriodeGastos();
                }
                case 4 ->{
                    relatoriodeGanhos();
                }
                case 5 ->{
                    relatorioMensal();
                }
            }
        }
    }

    public static void adicionarGasto(String nome,String tipo,LocalDate data,double valor,String formadePagamento){
        int i = 0;
        while(i < gastos.length){
            if(gastos[i] == null){
                gastos[i] = new Despeza(nome,tipo,data,valor,formadePagamento);
                return;
            }
        }
        System.out.println("Não foi possivel adicionar mais gastos à despezas");
    }
    public static void adicionarGanho(String nome,String tipo,LocalDate data,double valor){
        int i = 0;
        while(i < ganhos.length){
            if(ganhos[i] == null){
                ganhos[i] = new Receita(nome,tipo,data,valor);
                return;
            }
        }

        System.out.println("Não foi possivel adicionar mais ganhos à receita");
    }
    public static void relatoriodeGastos(){
        for(int i = 0; i < gastos.length;i++){
            if(gastos[i] != null){
                System.out.println(i + ":");
                System.out.println("Gasto: " + gastos[i].getNome());
                System.out.println("Tipo: " + gastos[i].getTipo());
                System.out.println("Data: " + gastos[i].getData());
                System.out.println("Valor: " + gastos[i].getValor());
                System.out.println("Forma de pagamento: " + gastos[i].getFormadePagamento());
                System.out.println("");
            }
        }
    }
    public static void relatoriodeGanhos(){
        for(int i = 0; i < ganhos.length;i++){
            if(ganhos[i] != null){
                System.out.println(i + ":");
                System.out.println("Gasto: " + ganhos[i].getNome());
                System.out.println("Tipo: " + ganhos[i].getTipo());
                System.out.println("Data: " + ganhos[i].getData());
                System.out.println("Valor: " + ganhos[i].getValor());
                System.out.println("");
            }
        }
    }
    public static void relatorioMensal(){
        double gastototal = 0;
        double ganhototal = 0;

        for(int i =0;i < gastos.length;i++){
            if(gastos[i] != null) {
                if (LocalDate.now().getMonth() == gastos[i].getData().getMonth()
                        && LocalDate.now().getYear() == gastos[i].getData().getYear()) {
                    gastototal += gastos[i].getValor();
                }
            }
        }
        for(int i = 0;i < ganhos.length;i++){
            if(ganhos[i] != null){
                if(LocalDate.now().getMonth() == ganhos[i].getData().getMonth()
                        && LocalDate.now().getYear() == ganhos[i].getData().getYear()) {
                    ganhototal += ganhos[i].getValor();
                }
            }
        }

        System.out.println("Ganho total: " + "R$ "+ ganhototal);
        System.out.println("Gasto total: " + "R$ "+ gastototal);
        System.out.println("Valor final: " + "R$ "+ (ganhototal - gastototal));
    }
}