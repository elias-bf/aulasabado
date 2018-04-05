import java.util.Scanner;

public class SalarioFuncionario {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.print("Nome do Funcionario: ");
		String nome = scan.nextLine();
		
		double salarioBruto = obterSalario();
		
		int numDependentes = obterDependentes();
		
		// Jefson
		double calculoInss = calculoInss(salarioBruto);
		
		// Mathues Cardoso
		double calculoFgts = calculoFgts(salarioBruto);
		
		// Mathues Dos Santos
		double calculoIr = calculoIr(salarioBruto);
		
		// Joao 
		double salarioLiquido = obterSalarioLiquido(salarioBruto, calculoInss, calculoFgts, calculoIr);
		
		System.out.println("Salario Bruto: " + String.format("R$ %.2f", salarioBruto));
		System.out.println("INSS: " + String.format("R$ %.2f", calculoInss));
		System.out.println("FGTS: " + String.format("R$ %.2f", calculoFgts));
		System.out.println("Imposto de Renda: " + String.format("R$ %.2f", calculoIr));
		System.out.println("Salario Liquido: " + String.format("R$ %.2f", salarioLiquido));
				
	}

	private static double obterSalarioLiquido(double salarioBruto, double calculoInss, double calculoFgts,
			double calculoIr) {
		//salarioLiquido = salarioBruto - calculoFgts - calculoINSS - calculoIr
		return salarioBruto - calculoInss - calculoFgts - calculoIr;
	}

	private static double calculoIr(double salarioBruto) {
		//É descontado sobre uma aliquota
		//salario bruto abaixo de 1.903,98 é ISENTO
		//Salario bruto entre 1.903,99 e 2.826,65 é descontado 7,5 %
		//salario bruto entre 2.826,66 e 3.751,05 é descontado 15,0%
		//salario bruto entre 3.751,06 e 4.664,68 é descontado 22,5%
		//salario bruto acima de 6.645,80 é descontado 27,5%
		double descontoIR = 0;
		if(salarioBruto < 1903.98) {
			System.out.println("ISENTO");
		}else if(salarioBruto >= 1903.99 && salarioBruto <= 2826.65){
			descontoIR = salarioBruto * 0.075;
		}else if(salarioBruto >= 2826.66 && salarioBruto <= 3751.05) {
			descontoIR = salarioBruto * 0.15;
		}else if(salarioBruto >= 3751.06 && salarioBruto <= 4664.68) {
			descontoIR = salarioBruto * 0.225;
		}else if(salarioBruto > 4664.68) {
			descontoIR = salarioBruto * 0.275;
		}
		
		return descontoIR;
	}

	private static double calculoFgts(double salarioBruto) {
		//É descontado 8% sobre o salario bruto | resultado = salariobruto - (salariobruto * 0,08)
		//valordesconto = salariobruto*0,08
		//
		
		return 0;
	}

	private static double calculoInss(double salarioBruto) {
		//o calculo pode ser feito utilizando if e else
		//salario bruto até 1.693,72 é descontado 8% do salario bruto
		//salario bruto entre 1.693,73 e 2.822,90 é descontado 9% do salario bruto
		//salario bruto entre 2.822,91 e 5.645,80 é descontado 11%
		//acima de 5.645,81 é descontado o valor de R$621,04
		double descontoInss = 0;
		if(salarioBruto <= 1693.72) {
			descontoInss = salarioBruto * 0.08;
		}else if(salarioBruto >= 1693.73 && salarioBruto <= 2822.90) {
			descontoInss = salarioBruto * 0.09;
		}else if(salarioBruto >= 2822.91 && salarioBruto <= 5645.80) {
			descontoInss = salarioBruto * 0.11;
		}else if(salarioBruto >= 5645.81) {
			descontoInss = 621.04;
		}		
		return descontoInss;
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
