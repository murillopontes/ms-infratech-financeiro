package br.com.infratech.financeiro.servicos;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.infratech.financeiro.persistencia.FinanceiroRepository;

@ApplicationScoped
public class FinanceiroService {

	@Inject
	private FinanceiroRepository financeiroRepository;

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
			Boolean isColaborador) {
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
			Boolean isColaborador) {
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

}
