package br.com.infratech.financeiro.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jboss.logging.Logger;

public class FinanceiroDAO {

	private static final Logger LOG = Logger.getLogger(FinanceiroDAO.class);

	private Connection connection;

	public FinanceiroDAO() {
		connection = SingleConnection.getConnection();
	}

	/**
	 * Recupera o total de clientes Adiplemtes.
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public long contaTotalClientesAdiplemtes(Long idEmpresa) {

		StringBuilder sql = new StringBuilder();

		sql.append("select ");
		sql.append("	count(pessoa.*)	 as count ");
		sql.append("from ");
		sql.append("	public.pessoa pessoa, ");
		sql.append("	public.divida divida, ");
		sql.append("	public.parcela parcela ");
		sql.append("where ");
		sql.append("	divida.id_pessoa = pessoa.id_pessoa ");
		sql.append("and parcela.id_divida = divida.id_divida ");
		sql.append("and parcela.valor_pago is not null ");
		sql.append("and parcela.data_pagamento is not null ");
		sql.append("and pessoa.id_empresa = " + idEmpresa);

		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return rs.getLong("count");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Recupera o total de clientes Inadimplemntes.
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public long contaTotalClientesInadimplentes(Long idEmpresa) {

		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("	count(pessoa.*) as count ");
		sql.append("from ");
		sql.append("	public.pessoa pessoa, ");
		sql.append("	public.divida divida, ");
		sql.append("	public.parcela parcela ");
		sql.append("where ");
		sql.append("	divida.id_pessoa = pessoa.id_pessoa ");
		sql.append("and parcela.id_divida = divida.id_divida ");
		sql.append("and parcela.valor_pago is null ");
		sql.append("and parcela.data_vencimento < current_date ");
		sql.append("and pessoa.id_empresa = " + idEmpresa);

		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return rs.getLong("count");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Soma o valor total de todas as dividas da pessoa
	 * 
	 * @param idPessoa
	 * @return
	 */
	public float somaValorTotalTodasAsDividasDaPessoa(Long idPessoa) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("  sum(divida.valor) as valor ");
		sql.append("from	");
		sql.append("  public.divida divida ");
		sql.append("where ");
		sql.append("  divida.id_pessoa = " + idPessoa);

		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return rs.getFloat("valor");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0f;
	}

	/**
	 * Soma o valor total de todas as dividas da pessoa
	 * 
	 * @param idPessoa
	 * @return
	 */
	public float somaValorTotalTodasAsDividasDaEmpresa(Long idEmpresa) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("	sum(d.valor) as valor ");
		sql.append("from ");
		sql.append("	public.divida d, ");
		sql.append("	public.pessoa p ");
		sql.append("where ");
		sql.append("	d.id_pessoa = p.id_pessoa ");
		sql.append("	and p.id_empresa = " + idEmpresa);

		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return rs.getFloat("valor");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0f;
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
		sql.append("	sum(fin_parcela.valor_pago) as valor ");
		sql.append("FROM  ");
		sql.append("	public.fin_parcela fin_parcela, ");
		sql.append("	public.pessoa pessoa, ");
		sql.append("	public.fin_divida fin_divida ");
		sql.append("WHERE ");
		sql.append("	fin_divida.id_fornecedor_cliente = pessoa.id_pessoa ");
		sql.append("AND fin_parcela.id_divida = fin_divida.id_divida ");
		sql.append("AND fin_parcela.valor_pago is not null ");
		sql.append("AND fin_divida.id_fornecedor_cliente = " + idEmpresa);

		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return rs.getFloat("valor");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0f;
	}

	public Double sumAllValueDividas(Long idEmpresaContratante) {
		return new Double(123.120);
	}

	/**
	 * Soma o valor total de todos os pagamentos recebido por cliente.
	 * 
	 * @param idFornecedorCliente
	 * @return
	 */
	public float sumTotalAmountReceivedByIdClient(Long idFornecedorCliente) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("	SUM(fin_parcela.valor_pago) as valor ");
		sql.append("FROM ");
		sql.append("	public.fin_parcela fin_parcela, ");
		sql.append("	public.fin_divida fin_divida ");
		sql.append("WHERE ");
		sql.append("	fin_parcela.id_divida = fin_divida.id_divida ");
		sql.append("AND fin_parcela.valor_pago IS NOT NULL ");
		sql.append("AND fin_divida.id_fornecedor_cliente = " + idFornecedorCliente);

		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return rs.getFloat("valor");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0f;
	}

	/**
	 * Soma o valor total a Receber por Cliente. Parcelas em aberto
	 * 
	 * @param idFornecedorCliente
	 * @return
	 */
	public float sumTotalAmountReceivableByIdClient(Long idFornecedorCliente) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("	SUM(fin_parcela.valor_parcela) as valor");
		sql.append("FROM ");
		sql.append("	public.fin_parcela fin_parcela, ");
		sql.append("	public.fin_divida fin_divida ");
		sql.append("WHERE ");
		sql.append("	fin_parcela.id_divida = fin_divida.id_divida ");
		sql.append("AND fin_parcela.valor_pago IS NULL ");
		sql.append("AND fin_divida.id_fornecedor_cliente = " + idFornecedorCliente);

		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return rs.getFloat("valor");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0f;

	}

//	public Long incluir(Empresa empresa) throws Exception {
//
//		StringBuilder sql = new StringBuilder("INSERT INTO public.empresa("
//				+ "            cnpj, email, contabilidade, fat_anual, fax, imagem_logo, "
//				+ "            insc_estadual, insc_municipal, nome_fantasia, num_suframa, razao_social, "
//				+ "            regime_tributario, site, slogan, celular, id_documentofiscal, "
//				+ "            id_endereco, id, id_projeto) " + "    VALUES (?, ?, ?, ?, ?, ?,  "
//				+ "            ?, ?, ?, ?, ?,  " + "            ?, ?, ?, ?, ?,  " + "            ?, ?, ?); ");
//
//		try (PreparedStatement stmt = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
//			stmt.setString(1, empresa.getCnpj());
//			stmt.setString(2, empresa.getEmail());
//			stmt.setInt(3, EnumEscritorioContabil.CONTABILIDADE_A.getCodigo());
//			stmt.setFloat(4, empresa.getFaturamentoDozeMeses());			
//			stmt.setBytes(6, empresa.getImagemlogo());
//			stmt.setString(7, empresa.getInscEstadual());
//			stmt.setString(8, empresa.getInscMunicipal());
//			stmt.setString(9, empresa.getNomeFantasia());
//			stmt.setString(10, empresa.getNumSuframa());
//			stmt.setString(11, empresa.getRazaoSocial());
//			// stmt.setInt(12, empresa.getRegimeTributario());
//			stmt.setString(13, empresa.getSite());
//			stmt.setString(14, empresa.getSlogan());
//			stmt.setString(15, empresa.getCelular());
//
////            stmt.setInt(16, empresa.get // documentoFiscal
////            stmt.setInt(17, empresa.getE // endereco
////            stmt.setInt(18, empresa.get // projeto 
//
//			stmt.executeUpdate();
//
//			try (ResultSet rs = stmt.getGeneratedKeys()) {
//				if (rs.next()) {
//					return rs.getLong(1);
//				} else {
//					throw new Exception("Erro ao inserir registro na tabela negociacao.enriquecer.");
//				}
//			}
//		}
//
//		// return empresa;
//
//	}
}
