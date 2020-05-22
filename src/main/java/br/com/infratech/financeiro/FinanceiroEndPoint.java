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
			@DefaultValue("false") @QueryParam("isColaborador") Boolean isColaborador) throws NumberFormatException {
		try {
			return criarRespostaSucesso(
					finaceiroService.recuperaTotalPessoasAdimplentes(idEmpresa, isCliente, isFornecedor, isFornecedor));
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
			@DefaultValue("false") @QueryParam("isColaborador") Boolean isColaborador) throws NumberFormatException {
		try {
			return criarRespostaSucesso(finaceiroService.recuperaTotalPessoasInadimplentes(idEmpresa, isCliente,
					isFornecedor, isFornecedor));
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

	/**
	 * TODO Funcionalidade Icompleta, falta estruturar a disponibilizacao do Saldo
	 * Promocional .
	 * 
	 * @param idEmpresa
	 * @return
	 * @throws NumberFormatException
	 */
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

	/**
	 * 
	 * @param object
	 * @return
	 */
	private Response criarRespostaSucesso(Object object) {
		return Response.status(Response.Status.OK).entity(object).build();
	}

}
