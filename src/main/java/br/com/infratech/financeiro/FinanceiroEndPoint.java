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
	@Path("/recuperaTotalPessoasAdimplentes/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaTotalPessoasAdimplentes(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/recuperaTotalPessoasInadimplentes/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaTotalPessoasInadimplentes(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/recuperaSaldoTotalDisponivelResgate/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaSaldoTotalDisponivelResgate(@PathParam("idEmpresa") Long idEmpresa)
			throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaSaldoTotalDisponivelResgate(idEmpresa));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/recuperaSaldoPromocionalDisponivel/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaSaldoPromocionalDisponivel(@PathParam("idEmpresa") Long idEmpresa)
			throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaSaldoPromocionalDisponivel(idEmpresa));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/recuperaDataHoraUltimaAtualizacaoProcessamentoFinanceiro/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaDataHoraUltimaAtualizacaoProcessamentoFinanceiro(@PathParam("idEmpresa") Long idEmpresa)
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
	@Path("/recuperaTotalCobrancasPrevistas/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaTotalCobrancasPrevistas(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/recuperaTotalCobrancasVencidas/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaTotalCobrancasVencidas(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/recuperaTotalCobrancasRecebidas/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaTotalCobrancasRecebidas(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/recuperaFaturamentoTotalPrevisto/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaFaturamentoTotalPrevisto(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/recuperaFaturamentoTotalConfirmado/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaFaturamentoTotalConfirmado(@PathParam("idEmpresa") Long idEmpresa,
			@DefaultValue("true") @QueryParam("isEsteMes") Boolean isEsteMes,
			@DefaultValue("false") @QueryParam("isEsteAno") Boolean isEsteAno,
			@DefaultValue("false") @QueryParam("isDesdeInicio") Boolean isDesdeInicio) throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaFaturamentoTotalConfirmado(idEmpresa, isEsteMes, isEsteAno, isDesdeInicio));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/recuperaFaturamentoTotalRecebido/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperaFaturamentoTotalRecebido(@PathParam("idEmpresa") Long idEmpresa,
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
	

	/**
	 * 
	 * @param object
	 * @return
	 */
	private Response criarRespostaSucesso(Object object) {
		return Response.status(Response.Status.OK).entity(object).build();
	}

}
