import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente(33);

        Data.AdicionarConta(cc);
    }
}
