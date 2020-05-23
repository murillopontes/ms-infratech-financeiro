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
	@Path("/getTotalPessoasAdimplentes/{idEmpresa}")
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
	@Path("/getTotalPessoasInadimplentes/{idEmpresa}")
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
	@Path("/getSaldoTotalDisponivelResgate/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSaldoTotalDisponivelResgate(@PathParam("idEmpresa") Long idEmpresa)
			throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaSaldoTotalDisponivelResgate(idEmpresa));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getSaldoPromocionalDisponivel/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSaldoPromocionalDisponivel(@PathParam("idEmpresa") Long idEmpresa) throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaSaldoPromocionalDisponivel(idEmpresa));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/getDataHoraUltimaAtualizacaoProcessamentoFinanceiro/{idEmpresa}")
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
	@Path("/getTotalCobrancasPrevistas/{idEmpresa}")
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
	@Path("/getTotalCobrancasVencidas/{idEmpresa}")
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
	@Path("/getTotalCobrancasRecebidas/{idEmpresa}")
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
	@Path("/getFaturamentoTotalPrevisto/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFaturamentoTotalPrevisto(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/getFaturamentoTotalConfirmado/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFaturamentoTotalConfirmado(@PathParam("idEmpresa") Long idEmpresa,
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
	@Path("/getFaturamentoTotalRecebido/{idEmpresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFaturamentoTotalRecebido(@PathParam("idEmpresa") Long idEmpresa,
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
