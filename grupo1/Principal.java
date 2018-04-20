import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		double salario = 0;
		int dependente = 0;
		int opcao = 1;
		double taxaFgts = 0.08;
		double valorInss = 0;
		double valorFgts = 0;
		double deduDependente = 0;
		double salarioBaseIrr = 0;
		double deducaoIr = 0;
		double salarioLiq = 0;
		DecimalFormat df = new DecimalFormat("0.##");
		Scanner s = new Scanner(System.in);

		while (opcao == 1) {
			System.out.println("Digite o valor do salario:");
			salario = s.nextDouble();
			System.out.println("Digite a quantidade de dependentes:");
			dependente = s.nextInt();
			while (salario < 954.00) {
				System.out.println("O valor do salario não pode ser menor que o salario minimo!!!!!"
						+ "Digite o valor do salario novamente:");
				salario = s.nextDouble();
				System.out.println("Digite a quantidade de dependentes:");
				dependente = s.nextInt();
			}
			while (dependente < 0) {
				System.out.println("O numero de dependentes não pode ser menor que 0!!!!!!!!!"
						+ "Digite novamente a quantidade de dependentes:");
				dependente = s.nextInt();
			}
			// Calculando o FGTS

			valorFgts = salario * taxaFgts;

			// Calculando o INSS
			if (salario <= 1693.72) {
				valorInss = salario * 0.08;

			} else if ((salario > 1693.72) && (salario <= 2822.90)) {
				valorInss = salario * 0.09;

			} else if ((salario > 2822.90) && (salario <= 5645.80)) {
				valorInss = salario * 0.11;

			} else if (salario > 5645.80) {
				valorInss = 621.04;
			}
			// Calculando o IR
			deduDependente = dependente * 189.59;
			salarioBaseIrr = salario - (valorInss + deduDependente);
			if (salarioBaseIrr <=1903.98) {
				System.out.println("O empregado é isento do desconto de Imposto de Renda!!!!!!");
			} else if ((salarioBaseIrr > 1903.98) && (salarioBaseIrr <= 2826.65)) {
				deducaoIr = (salarioBaseIrr * 0.075) - 142.80;

			} else if ((salarioBaseIrr > 2826.65) && (salarioBaseIrr <=3751.05)) {
				deducaoIr = (salarioBaseIrr * 0.15) - 354.80;

			} else if ((salarioBaseIrr > 3751.05) && (salarioBaseIrr <= 4664.68)) {
				deducaoIr = (salarioBaseIrr * 0.225) - 636.13;

			} else if (salarioBaseIrr > 4664.68) {
				deducaoIr = (salarioBaseIrr * 0.275) - 869.6;

			}
			// Calculando o salario liquido
			salarioLiq = salario - (valorInss + deducaoIr);

			System.out.println("O valor a ser deduzido do FGTS é: " + df.format(valorFgts));
			System.out.println("O valor a ser deduzido do INSS é: " + df.format(valorInss));
			System.out.println("O valor a ser deduzido pelos dependentes é: " + df.format(deduDependente));
			System.out.println("Salario base para a dedução do IR: " + df.format(salarioBaseIrr));
			System.out.println("O valor a ser reduzido para o IR é:" + df.format(deducaoIr));
			System.out.println("O valor do salario liquido é " + df.format(salarioLiq));

			System.out.println("Digite 1 para continuar ou 2 para sair do programa.");
			opcao = s.nextInt();

		}
	}

}