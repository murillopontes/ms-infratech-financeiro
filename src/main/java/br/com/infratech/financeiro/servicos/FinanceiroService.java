package br.com.infratech.financeiro.servicos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FinanceiroService {

//	@Inject
//	private FinanceiroRepository financeiroRepository;

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
		retorno.put("totalPessoasAdimplentes", new Long(18));
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
		retorno.put("totalPessoasInadimplentes", new Long(8));
		// return financeiroRepository.recuperaTotalClientesInadimplentes(idEmpresa);
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
	 * @param idEmpresa
	 * @param isCliente
	 * @param isFornecedor
	 * @param isColaborador
	 * @return
	 */
	public Map<String, Long> recuperaTotalCobrancasRecebidas(Long idEmpresa, boolean isEsteMes, boolean isEsteAno,
			boolean isDesdeInicio) {
		Map<String, Long> retorno = new HashMap<String, Long>();
		retorno.put("totalCobrancasRecebidas", new Long(38));
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
		retorno.put("totalCobrancasVencidas", new Long(23));
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
		retorno.put("totalCobrancasPrevistas", new Long(73));
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
		retorno.put("valorFaturamentoTotalPrevisto", new Float(45347.53f));
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
		retorno.put("valorFaturamentoTotalConfirmado", new Float(13579.55f));
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
		retorno.put("valorFaturamentoTotalRecebido", new Float(73823.88f));
		return retorno;
	}

}
