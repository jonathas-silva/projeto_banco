import java.io.Serializable;

public class Conta implements IConta {
    protected static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta(int numero) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = numero;
        this.saldo = 0;
    }


    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        /*Vemos uma aplicação clara de OO nessa etapa, onde reaproveitamos métodos
         * já criados dentro dessa classe em outro método.*/
    }

}

