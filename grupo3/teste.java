package funcionario;

import java.util.Scanner;



public class teste {
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		double salario ; 
		double calculo_INSS = 0 ;
		double calculo_IMP = 0 ;
		double rest = 0 ;
		double liquido = 0;
		double fgts ;
	    int parentes ;
		System.out.print("Sistema de Calculo de Salario Liquido --------- Padrão 2018\n\n");
		System.out.println("Digite seu salario bruto: ");
	    salario = ler.nextFloat();
	   
	    //inss
	    if(salario > 5645.80) {
    		calculo_INSS =  621.04;
    	}
	    else 
	    	if ( salario <= 1693.72)
	    {
	        calculo_INSS = salario * 0.08;
	    }
	    else
	        if ( salario >= 1693.73 && salario <= 2822.90f)
	        {
	            calculo_INSS = salario * 0.09;
	        }
	        else 
	        	if ((salario >= 2822.91) && (salario <= 5645.80))
	            {
	                calculo_INSS = salario * 0.11;
	            }
	  
	    		System.out.printf("O Imposto INSS a ser aplicado = %.2f %n", calculo_INSS);
	    		
	    		
	    		 
	    	 {

	    		 
	    		 //imposto de renda
	    		 System.out.print("------imposto de renda------ ");
	    		 System.out.println("Digite o numero de Dependentes: ");
	    		 parentes = ler.nextInt();
	    		 calculo_IMP = salario - (parentes * 189.59);
	    		   if( calculo_IMP <= 1903.98 )
	    		    {
	    			   calculo_IMP = 0;

	    		    }
	    		    else
	    		        if ( calculo_IMP >= 1903.99 &&  calculo_IMP <= 2826.65)
	    		        {
	    		            rest = calculo_IMP * 0.075 - 142.80;
	    		        }
	    		        else
	    		            if ( calculo_IMP >= 2826.66  &&  calculo_IMP <= 3751.05 )
	    		            {
	    		                rest = calculo_IMP * 0.15 - 354.80;
	    		            }
	    		            else
	    		                if ( calculo_IMP >= 3751.06  &&  calculo_IMP <= 4664.68 )
	    		                {
	    		                    rest = calculo_IMP * 0.225- 636.13;
	    		                }else {
	    		                	rest = calculo_IMP *0.275-869.36;
	    		                }
	    		   			System.out.printf("O Imposto IR a ser aplicado com a deducao de dependentes é de = %.2f %n",( rest));
	    		
	    	 }
	    	 //salario liquido
	    	    liquido = salario - (rest + calculo_INSS);
	   			System.out.printf("O seu salario liquido é de = %.2f %n",( liquido));
	   			//fgts
	   			fgts= salario * 0.08;
	   			System.out.printf("o valor do seu  fundo de garantia é de = %.2f %n", (fgts));

	    	 
	}
}