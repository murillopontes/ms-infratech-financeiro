package br.com.infratech.financeiro;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.infratech.financeiro.servicos.FinanceiroService;

@Path("/financeiro")
public class FinanceiroEndPoint {

	@Inject
	private FinanceiroService finaceiroService;

	@GET
	@Path("/getQuantidadeTotalPessoasAdimplentes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalPessoasAdimplentes(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("false") @QueryParam("isCliente") Boolean isCliente,
			@DefaultValue("false") @QueryParam("isFornecedor") Boolean isFornecedor,
			@DefaultValue("false") @QueryParam("isColaborador") Boolean isColaborador,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaTotalPessoasAdimplentes(idEmpresa, isCliente,
					isFornecedor, isFornecedor, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getQuantidadeTotalPessoasInadimplentes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalPessoasInadimplentes(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("false") @QueryParam("isCliente") Boolean isCliente,
			@DefaultValue("false") @QueryParam("isFornecedor") Boolean isFornecedor,
			@DefaultValue("false") @QueryParam("isColaborador") Boolean isColaborador,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaTotalPessoasInadimplentes(idEmpresa, isCliente,
					isFornecedor, isFornecedor, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getQuantidadeTotalCobrancasPrevistas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalCobrancasPrevistas(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaTotalCobrancasPrevistas(idEmpresa, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getQuantidadeTotalCobrancasVencidas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalCobrancasVencidas(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaTotalCobrancasVencidas(idEmpresa, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getQuantidadeTotalCobrancasRecebidas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalCobrancasRecebidas(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaTotalCobrancasRecebidas(idEmpresa, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getValorTotalFaturamentoPrevisto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalFaturamentoPrevisto(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaFaturamentoTotalPrevisto(idEmpresa, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getValorTotalFaturamentoConfirmado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalFaturamentoConfirmado(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaFaturamentoTotalConfirmado(idEmpresa, isEsteMes,
					isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getValorTotalFaturamentoRecebido")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalFaturamentoRecebido(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaFaturamentoTotalRecebido(idEmpresa, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getValorSaldoDisponivelResgate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorSaldoDisponivelResgate(@PathParam("idEmpresa") Long idEmpresa)
			throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaSaldoTotalDisponivelResgate(idEmpresa));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getValorSaldoPromocionalDisponivel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorSaldoPromocionalDisponivel(@PathParam("idEmpresa") Long idEmpresa)
			throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaSaldoPromocionalDisponivel(idEmpresa));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getDataHoraUltimaAtualizacaoProcessamentoFinanceiro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDataHoraUltimaAtualizacaoProcessamentoFinanceiro(@PathParam("idEmpresa") Long idEmpresa)
			throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaDataHoraUltimaAtualizacaoProcessamentoFinanceiro(idEmpresa));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getValorTotalDividasPorPessoa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalDividasPorPessoa(@PathParam("idPessoa") Long idPessoa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalDividaPorPessoa(idPessoa));
	}

	@GET
	@Path("/getValorTotalAReceberPorPessoa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalAReceberPorPessoa(@PathParam("idPessoa") Long idPessoa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalAReceber(idPessoa));
	}

	@GET
	@Path("/getValorTotalRecebidoPorPessoa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalRecebidoPorPessoa(@PathParam("idPessoa") Long idPessoa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalRecebido(idPessoa));
	}

	@GET
	@Path("/getValorTotalDividasPorEmpresa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalDividasPorEmpresa(@PathParam("idEmpresa") Long idEmpresa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalDividaPorEmpresa(idEmpresa));
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	private Response criarRespostaSucesso(Object object) {
		return Response.status(Response.Status.OK).entity(object).build();
	}

}
