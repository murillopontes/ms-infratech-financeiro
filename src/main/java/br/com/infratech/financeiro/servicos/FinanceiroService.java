package br.com.infratech.financeiro.servicos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import br.com.infratech.financeiro.persistencia.FinanceiroDAO;

@ApplicationScoped
public class FinanceiroService {

	
	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Long> recuperaTotalPessoasAdimplentes(Long idEmpresa, Boolean isCliente, Boolean isFornecedor,
			Boolean isColaborador, boolean isEsteMes, boolean isEsteAno, boolean isDesdeInicio) {

		Map<String, Long> retorno = new HashMap<String, Long>();

		if (isEsteMes) {
			retorno.put("totalPessoasAdimplentes", new Long(10));
		}

		if (isEsteAno) {
			retorno.put("totalPessoasAdimplentes", new Long(120));
		}

		if (isDesdeInicio) {
			retorno.put("totalPessoasAdimplentes", new Long(360));
		}

		// return financeiroRepository.recuperaTotalClientesAdiplemtes(idEmpresa);
		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Long> recuperaTotalPessoasInadimplentes(Long idEmpresa, Boolean isCliente, Boolean isFornecedor,
			Boolean isColaborador, boolean isEsteMes, boolean isEsteAno, boolean isDesdeInicio) {
		Map<String, Long> retorno = new HashMap<String, Long>();
		if (isEsteMes) {
			retorno.put("totalPessoasInadimplentes", new Long(8));
		}

		if (isEsteAno) {
			retorno.put("totalPessoasInadimplentes", new Long(96));
		}

		if (isDesdeInicio) {
			retorno.put("totalPessoasInadimplentes", new Long(288));
		}

		// return financeiroRepository.recuperaTotalClientesInadimplentes(idEmpresa);
		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Long> recuperaTotalCobrancasRecebidas(Long idEmpresa, boolean isEsteMes, boolean isEsteAno,
			boolean isDesdeInicio) {
		Map<String, Long> retorno = new HashMap<String, Long>();
		if (isEsteMes) {
			retorno.put("totalCobrancasRecebidas", new Long(38));
		}

		if (isEsteAno) {
			retorno.put("totalCobrancasRecebidas", new Long(456));
		}

		if (isDesdeInicio) {
			retorno.put("totalCobrancasRecebidas", new Long(1368));
		}

		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Long> recuperaTotalCobrancasVencidas(Long idEmpresa, boolean isEsteMes, boolean isEsteAno,
			boolean isDesdeInicio) {
		Map<String, Long> retorno = new HashMap<String, Long>();
		if (isEsteMes) {
			retorno.put("totalCobrancasVencidas", new Long(23));
		}

		if (isEsteAno) {
			retorno.put("totalCobrancasVencidas", new Long(276));
		}

		if (isDesdeInicio) {
			retorno.put("totalCobrancasVencidas", new Long(828));
		}

		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Long> recuperaTotalCobrancasPrevistas(Long idEmpresa, boolean isEsteMes, boolean isEsteAno,
			boolean isDesdeInicio) {
		Map<String, Long> retorno = new HashMap<String, Long>();
		if (isEsteMes) {
			retorno.put("totalCobrancasPrevistas", new Long(73));
		}

		if (isEsteAno) {
			retorno.put("totalCobrancasPrevistas", new Long(876));
		}

		if (isDesdeInicio) {
			retorno.put("totalCobrancasPrevistas", new Long(2628));
		}

		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Float> recuperaFaturamentoTotalPrevisto(Long idEmpresa, boolean isEsteMes, boolean isEsteAno,
			boolean isDesdeInicio) {
		Map<String, Float> retorno = new HashMap<String, Float>();
		if (isEsteMes) {
			retorno.put("valorFaturamentoTotalPrevisto", new Float(1200.53f));
		}

		if (isEsteAno) {
			retorno.put("valorFaturamentoTotalPrevisto", new Float(14406.36f));
		}

		if (isDesdeInicio) {
			retorno.put("valorFaturamentoTotalPrevisto", new Float(4450019.08f));
		}

		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Float> recuperaFaturamentoTotalConfirmado(Long idEmpresa, boolean isEsteMes, boolean isEsteAno,
			boolean isDesdeInicio) {
		Map<String, Float> retorno = new HashMap<String, Float>();
		if (isEsteMes) {
			retorno.put("valorFaturamentoTotalConfirmado", new Float(13579.55f));
		}

		if (isEsteAno) {
			retorno.put("valorFaturamentoTotalConfirmado", new Float(162954.6f));
		}

		if (isDesdeInicio) {
			retorno.put("valorFaturamentoTotalConfirmado", new Float(48943.8f));
		}

		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Float> recuperaFaturamentoTotalRecebido(Long idEmpresa, boolean isEsteMes, boolean isEsteAno,
			boolean isDesdeInicio) {
		Map<String, Float> retorno = new HashMap<String, Float>();
		if (isEsteMes) {
			retorno.put("valorFaturamentoTotalRecebido", new Float(73823.88f));
		}

		if (isEsteAno) {
			retorno.put("valorFaturamentoTotalRecebido", new Float(885922.56f));
		}

		if (isDesdeInicio) {
			retorno.put("valorFaturamentoTotalRecebido", new Float(2657767.68f));
		}

		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public Map<String, Float> recuperaSaldoTotalDisponivelResgate(Long idEmpresa) {
		Map<String, Float> retorno = new HashMap<String, Float>();
		retorno.put("saldoTotalDisponivelResgate", new Float(1378.78f));
		// return financeiroRepository.sumAvailableBalanceToRedeem(idEmpresa);
		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public Map<String, Float> recuperaSaldoPromocionalDisponivel(Long idEmpresa) {
		Map<String, Float> retorno = new HashMap<String, Float>();
		retorno.put("saldoPromocionalDisponivel", new Float(490.56f));
		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public Map<String, Date> recuperaDataHoraUltimaAtualizacaoProcessamentoFinanceiro(Long idEmpresa) {
		Map<String, Date> retorno = new HashMap<String, Date>();
		retorno.put("dataHoraUltimaAtualizacaoProcessamentoFinanceiro", new Date());
		return retorno;
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idPessoa
	 * @return
	 */
	public Float recuperaValorTotalDividasDaPessoa(Long idPessoa) {
		return new FinanceiroDAO().somaValorTotalTodasAsDividasDaPessoa(idPessoa);
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idPessoa
	 * @return
	 */
	public Float recuperaValorTotalDividasPorEmpresa(Long idEmpresa) {
		return new FinanceiroDAO().somaValorTotalTodasAsDividasDaEmpresa(idEmpresa);
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idEmpresaContratanteLogada
	 * @return
	 */
	public Double recupeValorTotalTodasDividasPorEmpresaContratante(Long idEmpresaContratanteLogada) {
		return new FinanceiroDAO().sumAllValueDividas(idEmpresaContratanteLogada);
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idFornecedorCliente
	 * @return
	 */
	public Float recuperaValorTotalAReceber(Long idFornecedorCliente) {
		return new FinanceiroDAO().sumTotalAmountReceivableByIdClient(idFornecedorCliente);
	}

	/**
	 * TODO Funcionalidade Icompleta
	 * 
	 * @param idFornecedorCliente
	 * @return
	 */
	public Float recuperaValorTotalRecebido(Long idFornecedorCliente) {
		return new FinanceiroDAO().sumTotalAmountReceivedByIdClient(idFornecedorCliente);
	}

}
