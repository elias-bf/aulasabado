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
		double calculoAliquotaIR = calculoAliquotaIR(salarioBruto, numDependentes, calculoInss);
		
		double calculoIr = calculoIr(calculoAliquotaIR);
		
		// Joao 
		double salarioLiquido = obterSalarioLiquido(salarioBruto, calculoFgts, calculoInss, calculoIr);
		
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Salario Bruto: " + String.format("R$ %.2f", salarioBruto));
		System.out.println("-------------------------------------------------------");
		System.out.println("INSS: " + String.format("R$ %.2f", calculoInss));
		System.out.println("FGTS: " + String.format("R$ %.2f", calculoFgts));
		if(calculoIr <= 0) {
			System.out.println("IRRF: ISENTO");
		}else {
			System.out.println("Aliquota do IRRF: " + String.format("R$ %.2f", calculoAliquotaIR));
			System.out.println("IRRF: " + String.format("R$ %.2f", calculoIr));
		}
		System.out.println("Salario Liquido: " + String.format("R$ %.2f", salarioLiquido));
		System.out.println("-------------------------------------------------------");
		
		
	}

	private static double calculoAliquotaIR(double salarioBruto, int numDependentes, double calculoInss) {
		
		return (salarioBruto - calculoInss - (187.80 * numDependentes));
		
	}

	private static double obterSalarioLiquido(double salarioBruto, double calculoInss, double calculoFgts,
			double calculoIr) {

		return salarioBruto - calculoInss - calculoFgts - calculoIr;
	}

	private static double calculoIr(double calculoAliquotaIR) {
	
		double descontoIR = 0;
		if(calculoAliquotaIR < 1903.98) {
			descontoIR = calculoAliquotaIR * 0;
		}else if(calculoAliquotaIR >= 1903.99 && calculoAliquotaIR <= 2826.65){
			descontoIR = calculoAliquotaIR * 0.075 - 142.80;
			
		}else if(calculoAliquotaIR >= 2826.66 && calculoAliquotaIR <= 3751.05) {
			descontoIR = calculoAliquotaIR * 0.15 - 354.80;
		}else if(calculoAliquotaIR >= 3751.06 && calculoAliquotaIR <= 4664.68) {
			descontoIR = calculoAliquotaIR * 0.225 - 636.13;
		}else if(calculoAliquotaIR > 4664.68) {
			descontoIR = calculoAliquotaIR * 0.275 - 869.36;
		}
		return descontoIR;
	}

	private static double calculoFgts(double salarioBruto) {
		//É descontado 8% sobre o salario bruto | resultado = salariobruto - (salariobruto * 0,08)
		//valordesconto = salariobruto*0,08
		double descontoFgts;
		descontoFgts = salarioBruto * 0.08;
		
		return descontoFgts;
	}

	private static double calculoInss(double salarioBruto) {
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
