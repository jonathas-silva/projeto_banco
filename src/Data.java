/*Classe criada para gerenciar o nosso banco de dados rudimentar,
 * sob a forma de texto*/

import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
    //Verifica se uma conta já existe
    public static String JaExiste(Conta conta){
        try{
            File f = new File("conta.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            boolean condicao = false;
            String linha = "";
            String retorno = null;
            String teste = conta.numero + "\t\t\t" + conta.agencia;

            while(br.ready()){
                linha = br.readLine();
                if(linha.contains(teste)) {
                    condicao = true;
                    retorno = linha;

                    break;
                }
            }
            br.close();
            return retorno;
        }catch (IOException e){
            System.out.println("problema para ler o arquivo");
            return null;
        }

    }

    //terminar implementação
    public static int GeradorNumero(){
        try{
            File f = new File("conta.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linha = "";

            while(br.ready()){
                linha = br.readLine();
            }
            System.out.println(linha);


        }catch (IOException e){
            System.out.println("ERRO NA ABERTURA DO ARQUIVO");
        }

        return 0;
    }

    //Adiciona uma conta, se ela ainda não existir
    public static void AdicionarConta(Conta conta) {
       try {
           if(Data.JaExiste(conta)==null){
               File f = new File("conta.txt");
               BufferedWriter br = new BufferedWriter(new FileWriter(f, true));
               //O FileWriter com o parâmetro true faz com que escrevamos no arquivo sem apagar o conteúdo anterior
               LocalDateTime data = LocalDateTime.now();
               String escrever = conta.numero + "\t\t\t" +
                       conta.agencia + "\t\t\t" +
                       data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")) + "\n";
               br.write(escrever);
               System.out.println("A seguinte entrada foi adicionada com sucesso: ");
               System.out.println(escrever);
               br.close();
           }else{
               System.out.println("A conta já existe: ");
               System.out.println(Data.JaExiste(conta));
           }
        }catch (IOException e){
           System.out.println(e.getMessage());
       }

    }
}
