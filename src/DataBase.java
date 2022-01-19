/*Classe criada para gerenciar o nosso banco de dados rudimentar,
* sob a forma de objeto*/

import java.io.*;

@Deprecated
public class DataBase {

    public static void AdicionaConta(Conta conta) {
        try{
            File f = new File("dados");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(conta);
            oos.defaultWriteObject();
            System.out.println("Conta gravada com sucesso");

            oos.close();
        }catch (IOException e){
            System.out.println("ERRO NA CRIAÇÃO DO ARQUIVO");
        }
    }
    public static void RecuperarConta(Conta conta){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados"));
            Conta leituraConta = (Conta) ois.readObject(); //lendo o objeto
            ois.close();
        }catch(IOException e){
            System.out.println("ERRO NA CRIAÇÃO DO ARQUIVO");
            System.out.println(e.getMessage());

        }catch (ClassNotFoundException e){
            System.out.println("ERRO PARA ENCONTRAR A CLASSE");
            System.out.println(e.getMessage());
        }
    }

}
