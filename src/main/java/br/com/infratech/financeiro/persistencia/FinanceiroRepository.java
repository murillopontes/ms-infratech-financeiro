package br.com.infratech.financeiro.persistencia;

import java.math.BigInteger;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.Panache;


@ApplicationScoped	
public class FinanceiroRepository  {

	/**
	 * Recupera o total de clientes Adiplemtes.
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public long recuperaTotalClientesAdiplemtes(Long idEmpresa) {

		StringBuilder sql = new StringBuilder();

		sql.append("select ");
		sql.append("	count(pessoa.*)	 ");
		sql.append("from ");
		sql.append("	public.pessoa pessoa, ");
		sql.append("	public.fin_divida fin_divida, ");
		sql.append("	public.fin_parcela fin_parcela ");
		sql.append("where ");
		sql.append("	fin_divida.id_fornecedor_cliente = pessoa.id_pessoa ");
		sql.append("and fin_parcela.id_divida = fin_divida.id_divida ");
		sql.append("and fin_parcela.valor_pago is not null ");
		sql.append("and fin_parcela.data_pagamento is not null ");
		sql.append("and pessoa.id_empresa = " + idEmpresa);

		return executeSqlNativeQueryCountResult(sql);
	}

	/**
	 * Recupera o total de clientes Inadimplemntes.
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public long recuperaTotalClientesInadimplentes(Long idEmpresa) {

		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("	count(pessoa.*)	 ");
		sql.append("from ");
		sql.append("	public.pessoa pessoa, ");
		sql.append("	public.fin_divida fin_divida, ");
		sql.append("	public.fin_parcela fin_parcela ");
		sql.append("where ");
		sql.append("	fin_divida.id_fornecedor_cliente = pessoa.id_pessoa ");
		sql.append("and fin_parcela.id_divida = fin_divida.id_divida ");
		sql.append("and fin_parcela.valor_pago is null ");
		sql.append("and fin_parcela.data_vencimento < current_date ");
		sql.append("and pessoa.id_empresa = " + idEmpresa);

		return executeSqlNativeQueryCountResult(sql);
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	private float executeSqlNativeQuerySumResult(StringBuilder sql) {
		Object valorTotal = (Object) Panache.getEntityManager().createNativeQuery(sql.toString()).getSingleResult();
		if (valorTotal != null) {
			return ((float) valorTotal);
		}
		return 0.0f;
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	private long executeSqlNativeQueryCountResult(StringBuilder sql) {
		BigInteger valorTotal = (BigInteger) Panache.getEntityManager().createNativeQuery(sql.toString())
				.getSingleResult();
		if (valorTotal != null) {
			return ((long) valorTotal.longValue());
		}
		return new Long(0);
	}

	// ########### MIGRAR PARA OUTRO MICRO SERVICO #####################

	/**
	 * TODO Recupera o Saldo Total Disponivel para Resgate, falta estruturar a
	 * funcionalidade de resgate e soma dos pagamentos/confirmacao de pagamentos.
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public float sumAvailableBalanceToRedeem(Long idEmpresa) {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("	sum(fin_parcela.valor_pago) ");
		sql.append("FROM  ");
		sql.append("	public.fin_parcela fin_parcela, ");
		sql.append("	public.pessoa pessoa, ");
		sql.append("	public.fin_divida fin_divida ");
		sql.append("WHERE ");
		sql.append("	fin_divida.id_fornecedor_cliente = pessoa.id_pessoa ");
		sql.append("AND fin_parcela.id_divida = fin_divida.id_divida ");
		sql.append("AND fin_parcela.valor_pago is not null ");
		sql.append("AND fin_divida.id_fornecedor_cliente = " + idEmpresa);

		return executeSqlNativeQuerySumResult(sql);
	}
}
