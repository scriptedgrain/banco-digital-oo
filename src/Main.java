public class Main {

	public static void main(String[] args) {
		Cliente cl1 = new Cliente();
		Cliente cl2 = new Cliente();
		cl1.setNome("Lucca");
		cl2.setNome("Cássia");

		
		Conta cc = new ContaCorrente(cl1);
		Conta trabalho = new ContaSalario(cl2);

		cc.depositar(100);
		cc.transferir(100, trabalho);
		trabalho.guardar(100);
		
		((ContaCorrente)cc).imprimirExtrato();
		((ContaSalario)trabalho).imprimirExtrato();

	}
}