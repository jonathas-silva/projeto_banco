/*Classe criada para gerenciar o nosso banco de dados rudimentar,
 * sob a forma de texto*/

import java.io.*;
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

    /**Método varre o conteúdo do arquivo conta.txt até encontrar o número da conta.
     * Para de ler, coloca os dados atualizados, retorna a leitura e grava em dados.txt.*/

    public static void AtualizarConta(Conta conta){
        try{
            File f = new File("conta.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String conteudo = "";
            String continuacao = "";
            String jaExiste = JaExiste(conta);
            String linha = "";
            LocalDateTime data = LocalDateTime.now();
            String criacao = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
            String escrever = String.format("%d\t\t\t%d\t\t\t%+10.2f\t\t%s\n", conta.numero, conta.agencia, conta.saldo, criacao);


            if(jaExiste!=null)
            {
                while (br.ready()) {
                    linha = br.readLine();
                    if (linha.substring(0,2).equals(jaExiste.substring(0,2))) {
                        break;
                    }
                    conteudo = conteudo + linha + "\n";
                }
                while(br.ready()){
                    linha = br.readLine();
                    continuacao = continuacao + linha + "\n";

                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                conteudo = conteudo + escrever + continuacao;
                System.out.println("Base de dados atualizada: ");
                System.out.println(conteudo);
                bw.write(conteudo);
                bw.close();



            } else{
                System.out.println("Essa conta não existe");
            }


            br.close();
        }catch (IOException e){
            System.out.println("ERRO NA ABERTURA DO ARQUIVO");
        }

    }

    //Adiciona uma conta, se ela ainda não existir
    public static void AdicionarConta(Conta conta) {
       try {
           if(Data.JaExiste(conta)==null){
               File f = new File("conta.txt");
               BufferedWriter br = new BufferedWriter(new FileWriter(f, true));
               //O FileWriter com o parâmetro true faz com que escrevamos no arquivo sem apagar o conteúdo anterior
               LocalDateTime data = LocalDateTime.now();
               String criacao = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
               String escrever = String.format("%d\t\t\t%d\t\t\t%+10.2f\t\t%s\n", conta.numero, conta.agencia, conta.saldo, criacao);
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
