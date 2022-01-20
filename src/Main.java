import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        Conta cc = new Conta(1);
        Conta cc2 = new Conta(2);
        Conta cc3 = new Conta(3);
        Conta cc4 = new Conta(4);
        Conta cc5 = new Conta(5);
        Conta cc6 = new Conta(6);

        cc.depositar(2);
        cc2.depositar(15);
        cc3.depositar(-20.2);
        cc4.depositar(45);
        cc5.depositar(15000);



        Data.AtualizarConta(cc);
        Data.AtualizarConta(cc2);
        Data.AtualizarConta(cc3);
        Data.AtualizarConta(cc4);
        Data.AtualizarConta(cc5);
        Data.AtualizarConta(cc6);


    }
}
