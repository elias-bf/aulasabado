import java.util.Scanner;

public class SalarioFuncionario {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		
		System.out.println("Nome do Funcionario: ");
		String nome = read.next();
		
		System.out.println("Salário Bruto:");
		double salarioB = read.nextDouble();
		
		System.out.println("Nº de Dependentes: ");
		int numDependentes = read.nextInt();
				
	}

}
