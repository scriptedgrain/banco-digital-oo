public class ContaSalario extends Conta {

	public ContaSalario(Cliente cliente) {
		super(cliente);
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Salário ===");
		super.imprimirInfosComuns();
	}
}