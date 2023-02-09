import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		List<Conta> lista = new ArrayList<>();

		System.out.println("Bem vindo\n-----");
		boolean estado = true;
		do {
		System.out.println("Digite\n1-Criar Conta Corrente\n2-Criar Conta Poupanca\n3-Fazer Deposito\n4-Transferir ");
		int op = leia.nextInt();
		String nome = null;


			while (op < 1 || op > 4) {

				System.out.println("Opcao inválida");
				System.out.println("Digite\n1-Criar Conta Corrente\n2-Criar Conta Poupanca\n3-Fazer Deposito\n4-Transferir\n5- Ver todas as contas ");
				op= leia.nextInt();

			}
			if(op == 1) {
				System.out.println("Digite o nome do cliente");
				nome = leia.next();
				Cliente cliCC = new Cliente();
				cliCC.setNome(nome);


				lista.add(new ContaCorrente(cliCC));

				System.out.println("Conta crada com sucesso, com o número " + lista.get(lista.size()-1).numero);

			} else if(op ==2) {
				System.out.println("Digite o nome do cliente");
				nome = leia.next();
				Cliente cliP = new Cliente();
				cliP.setNome(nome);

				lista.add(new ContaPoupanca(cliP));

				System.out.println("Conta criada com sucesso, com o numero " + lista.get(lista.size() -1).numero);

			} else if(op == 3) {
				System.out.println("Digite o número da conta que irá ser feito o deposito");
				int n = leia.nextInt();
				System.out.println("Digite o valor a ser depositado ");
				double valor = leia.nextDouble();
				lista.get(lista.indexOf(n)).depositar(valor);

			} else if(op ==4){


			}else if(op ==5) {
				for( Conta ele : lista) {
					System.out.println(ele.cliente);
					System.out.println(ele.numero);
					System.out.println(ele.getSaldo());
				}
			}

			  System.out.println("Deseja fazer uma nova operacao ? S/N");
			  char esco = leia.next().charAt(0);
			  if(esco == 'n' || esco == 'N') {
				  estado = false;
			  }



		} while (estado);

		System.out.println("Até mais ! ");


	}
}

