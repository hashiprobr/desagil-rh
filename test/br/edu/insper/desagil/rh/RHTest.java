package br.edu.insper.desagil.rh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RHTest {
	private static double DELTA = 0.000001;

	private RH rh;

	@BeforeEach
	public void setUp() {
		rh = new RH();
	}

	@Test
	public void folhaVazia() {
		assertEquals(0, rh.calculaMedia(), DELTA);
	}

	@Test
	public void tresFuncionarios() {
		rh.contrata(new Funcionario(0, "Maria", 10.00));
		rh.contrata(new Funcionario(0, "João", 25.25));
		rh.contrata(new Funcionario(0, "Mariana", 50.50));
		assertEquals(85.75, rh.calculaMedia(), DELTA);
	}

	@Test
	public void tresGerentes() {
		rh.contrata(new Gerente(0, "Maria", 10.00));
		rh.contrata(new Gerente(0, "João", 25.25));
		rh.contrata(new Gerente(0, "Mariana", 50.50));
		assertEquals(85.75, rh.calculaMedia(), DELTA);
	}

	@Test
	public void tresDiretores() {
		rh.contrata(new DiretorDeMarketing(0, "Maria", 10.00));
		rh.contrata(new DiretorDeVendas(0, "João", 25.25));
		DiretorDeVendas diretor = new DiretorDeVendas(0, "Mariana", 50.50);
		diretor.incrementaFaturamento(75.00);
		rh.contrata(diretor);
		assertEquals(179.00, rh.calculaMedia(), DELTA);
	}

	@Test
	public void quatroDiferentes() {
		rh.contrata(new Funcionario(0, "Maria", 10.00));
		rh.contrata(new Gerente(0, "João", 25.25));
		rh.contrata(new DiretorDeMarketing(0, "Mariana", 50.50));
		rh.contrata(new DiretorDeVendas(0, "José", 75.00));
		assertEquals(286.25, rh.calculaMedia(), DELTA);
	}
}
