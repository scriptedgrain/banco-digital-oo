public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int id = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double saldoGuardado;
	protected double faturaCartao;
	protected double limiteCartao;
	protected Cliente cliente;	

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = id++;
		this.cliente = cliente;
		this.limiteCartao = 1000;
	}

	public void sacar(double valor) {
		if(valor > saldo)
			System.out.println("Saldo insuficiente!");
		else
			saldo -= valor;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public void guardar(double valor) {
		this.sacar(valor);
		saldoGuardado += valor;		
	}

	public void cartaoCredito(double valor) {
		if((faturaCartao += valor) > limiteCartao || valor > limiteCartao)
			System.out.println("Transação não autorizada!");
		else
			faturaCartao += valor;	
	}

	public void pagarFaturaCartao() {
		sacar(faturaCartao);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getSaldoGuardado() {
		return saldoGuardado;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Saldo em separado: %.2f", this.saldoGuardado));
	}
}
