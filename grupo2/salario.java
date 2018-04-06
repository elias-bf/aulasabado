import java.text.DecimalFormat;
import java.util.Scanner;

public class salario {

	public static void main(String[] args) {

		int qtdDependente = 0;
		double salarioBase = 0;
		int opcao = 1;
		double deducaoDep = 0;
		double baseIrrf = 0;
		double deducaoIrrf = 0;
		double salarioFinal = 0;
		double aliqFgts = 0.08;
		double inssFinal = 0;
		double fgtsFinal = 0;
		
		DecimalFormat df = new DecimalFormat("0.##");
		Scanner input = new Scanner(System.in);

		System.out.println("***Bem vindo(a)***\n\n");
		
		
		while (opcao == 1) {
			System.out.println("Digite o valor do salario:");
			salarioBase = input.nextDouble();
			System.out.println("Digite a quantidade de dependentes:");
			qtdDependente = input.nextInt();
			while (salarioBase < 954.00) {
				System.out.println("O valor do salario não pode ser menor que o salario minimo!!!!!"
						+ "Digite o valor do salario novamente:");
				salarioBase = input.nextDouble();
			}
			while (qtdDependente < 0) {
				System.out.println("O numero de dependentes não pode ser menor que 0!!!!!!!!!"
						+ "Digite novamente a quantidade de dependentes:");
				qtdDependente = input.nextInt();
			}
			// Calculando o FGTS

			fgtsFinal = salarioBase * aliqFgts;

			// Calculando o INSS
			if (salarioBase <= 1693.72) {
				inssFinal = salarioBase * 0.08;

			} else if ((salarioBase > 1693.72) && (salarioBase <= 2822.90)) {
				inssFinal = salarioBase * 0.09;

			} else if ((salarioBase > 2822.90) && (salarioBase <= 5645.80)) {
				inssFinal = salarioBase * 0.11;

			} else if (salarioBase > 5645.80) {
				inssFinal = 621.04;
			}
			// Calculando o IR
			deducaoDep = qtdDependente * 189.59;
			baseIrrf = salarioBase - (fgtsFinal + deducaoDep);
			if (baseIrrf < 1903.98) {
				System.out.println("O empregado é isento do desconto de Imposto de Renda!!!!!!");
			} else if ((baseIrrf >= 1903.99) && (baseIrrf < 2826.65)) {
				deducaoIrrf = (baseIrrf * 0.075) - 142.80;

			} else if ((baseIrrf > 2826.65) && (baseIrrf < 3751.05)) {
				deducaoIrrf = (baseIrrf * 0.15) - 354.80;

			} else if ((baseIrrf > 3751.05) && (baseIrrf < 4664.68)) {
				deducaoIrrf = (baseIrrf * 0.225) - 636.13;

			} else if (baseIrrf > 4664.68) {
				deducaoIrrf = (baseIrrf * 0.275) - 869.6;

			}
			// Calculando o salario liquido
			salarioFinal = salarioBase - (inssFinal + deducaoIrrf);

			System.out.println("FGTS: " + df.format(fgtsFinal));
			System.out.println("INSS: " + df.format(inssFinal));
			System.out.println("Valor a ser deduzido por dependente: " + df.format(deducaoDep));
			System.out.println("Salario base IRRF: " + df.format(baseIrrf));
			System.out.println("Valor a ser reduzido: " + df.format(deducaoIrrf));
			System.out.println("Salário Líquido: " + df.format(salarioFinal));

			System.out.println("Digite 1 para continuar ou 2 para sair do programa.");
			opcao = input.nextInt();

		}
		
		System.out.println("***Fim do Sistema***");
	}

}