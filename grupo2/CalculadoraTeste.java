package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import negocio.Calculadora;

public class CalculadoraTeste {

	@Test
	public void verificaSomaDeDoisNumerosInteiros() {
		Calculadora calc = new Calculadora();
		double resultadoDoMetodo = calc.soma(8, 6);
		assertEquals(14,resultadoDoMetodo,0);
	}

}
