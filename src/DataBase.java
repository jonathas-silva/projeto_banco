/*Classe criada para gerenciar o nosso banco de dados rudimentar.*/

import java.io.*;

public class DataBase {

    public static void AdicionaConta(Conta conta) {
        try{
            File f = new File("dados");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(conta);
            System.out.println("Conta gravada com sucesso");

            oos.close();
        }catch (IOException e){
            System.out.println("ERRO NA CRIAÇÃO DO ARQUIVO");
        }








        }

}
