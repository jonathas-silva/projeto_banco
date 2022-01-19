/*Classe criada para gerenciar o nosso banco de dados rudimentar,
 * sob a forma de texto*/

import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;

public class Data {
    //Verifica se uma conta já existe
    public static void JaExiste(Conta conta){
        try{
            File f = new File("conta.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            boolean condicao = false;
            String linha = "";
            String teste = "numero: " + conta.numero;

            while(br.ready()){
                linha = br.readLine();
                if(linha.contains(teste)) {
                    condicao = true;
                    break;
                }
            }
            if (condicao){
                System.out.println("Conta encontrada!!");
                System.out.println(linha);
            }else{
                System.out.println("Conta não encontrada!");

            }

        br.close();
        }catch (IOException e){
            System.out.println("problema para ler o arquivo");
        }

    }


    public static int GeradorNumero(){
        return 0;
    }


    public static void AdicionarConta(Conta conta) {
       try {
            File f = new File("conta.txt");
            BufferedWriter br = new BufferedWriter(new FileWriter(f, true));
            //O FileWriter com o parâmetro true faz com que escrevamos no arquivo sem apagar o conteúdo anterior
           LocalDateTime data = LocalDateTime.now();
           String escrever = "Agencia: " + conta.agencia +
                    "  numero: " + conta.numero +
                    "  Data: " + data.toString() +"\n";
            br.write(escrever);
            br.close();
        }catch (IOException e){
           System.out.println(e.getMessage());
       }

    }
}
