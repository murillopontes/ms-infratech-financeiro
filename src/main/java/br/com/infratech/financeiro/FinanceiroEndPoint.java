package br.com.infratech.financeiro;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.infratech.financeiro.servicos.FinanceiroService;

@Path("/financeiro")
@Tag(name = "Financeiro", description = "Consultas de indicadores financeiros, cobranças e saldos.")
public class FinanceiroEndPoint {

	@Inject
	private FinanceiroService finaceiroService;

	@GET
	@Path("/getQuantidadeTotalPessoasAdimplentes")
	@Operation(summary = "Contar pessoas adimplentes", description = "Retorna a quantidade de pessoas adimplentes no período.")
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
	@Operation(summary = "Contar pessoas inadimplentes", description = "Retorna a quantidade de pessoas inadimplentes no período.")
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
	@Operation(summary = "Contar cobranças previstas", description = "Retorna a quantidade de cobranças previstas no período.")
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
	@Operation(summary = "Contar cobranças vencidas", description = "Retorna a quantidade de cobranças vencidas no período.")
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
	@Operation(summary = "Contar cobranças recebidas", description = "Retorna a quantidade de cobranças recebidas no período.")
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
	@Operation(summary = "Consultar faturamento previsto", description = "Retorna o valor total do faturamento previsto no período.")
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
	@Operation(summary = "Consultar faturamento confirmado", description = "Retorna o valor total do faturamento confirmado no período.")
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
	@Operation(summary = "Consultar faturamento recebido", description = "Retorna o valor total do faturamento recebido no período.")
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
	@Operation(summary = "Consultar saldo disponível para resgate", description = "Retorna o saldo total disponível para resgate.")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorSaldoDisponivelResgate(@QueryParam("idEmpresa") Long idEmpresa)
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
	@Operation(summary = "Consultar saldo promocional", description = "Retorna o saldo promocional disponível.")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorSaldoPromocionalDisponivel(@QueryParam("idEmpresa") Long idEmpresa)
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
	@Operation(summary = "Consultar última atualização financeira", description = "Retorna a data e hora da última atualização do processamento financeiro.")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDataHoraUltimaAtualizacaoProcessamentoFinanceiro(@QueryParam("idEmpresa") Long idEmpresa)
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
	@Operation(summary = "Consultar dívidas da pessoa", description = "Retorna o valor total de dívidas associado à pessoa.")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalDividasPorPessoa(@QueryParam("idEmpresa") Long idEmpresa,
			@QueryParam("idPessoa") Long idPessoa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalDividasDaPessoa(idPessoa));
	}

	@GET
	@Path("/getValorTotalAReceberPorPessoa")
	@Operation(summary = "Consultar valor a receber da pessoa", description = "Retorna o valor total a receber da pessoa.")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalAReceberPorPessoa(@QueryParam("idEmpresa") Long idEmpresa,
			@QueryParam("idPessoa") Long idPessoa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalAReceber(idPessoa));
	}

	@GET
	@Path("/getValorTotalRecebidoPorPessoa")
	@Operation(summary = "Consultar valor recebido da pessoa", description = "Retorna o valor total recebido da pessoa.")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalRecebidoPorPessoa(@QueryParam("idEmpresa") Long idEmpresa,
			@QueryParam("idPessoa") Long idPessoa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalRecebido(idPessoa));
	}

	@GET
	@Path("/getValorTotalDividasPorEmpresa")
	@Operation(summary = "Consultar dívidas da empresa", description = "Retorna o valor total de dívidas da empresa.")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValorTotalDividasPorEmpresa(@QueryParam("idEmpresa") Long idEmpresa) {
		return criarRespostaSucesso(finaceiroService.recuperaValorTotalDividasPorEmpresa(idEmpresa));
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
