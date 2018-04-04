import java.util.Scanner;

public class SalarioFuncionario {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Nome do Funcionario: ");
		String nome = scan.next();
		
		double salarioB = obterSalario();
		
		int numDependentes = obterDependentes();
				
	}

	private static double obterSalario() {
		System.out.print("Salário Bruto: ");
		String entrada = scan.nextLine();
		try{
			double salario = Double.parseDouble(entrada);
			if(salario <= 0){
				throw new Exception();
			}
			return salario;
		} catch (Exception e){
			System.out.println("Informe um valor real e positivo.");
			return obterSalario();
		}
	}

	private static int obterDependentes() {
		System.out.print("Nº de Dependentes: ");
		String entrada = scan.nextLine();
		try{
			int NDeDependentes = Integer.parseInt(entrada);
			if(NDeDependentes < 0){
				throw new Exception();
			}
			return NDeDependentes;
		} catch (Exception e){
			System.out.println("Informe um inteiro maior ou igual a zero.");
			return obterDependentes();
		}
	}

}