package com.facnet.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.facnet.ws.dao.ProdutoDAO;
import com.facnet.ws.dao.impl.ProdutoDAOImpl;
import com.facnet.ws.model.Produto;

@Path("/resource")
public class ProdutoResource {
	private ProdutoDAO produtoDAO = new ProdutoDAOImpl();

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Produto getProduto(@PathParam("id") String id) {
		return produtoDAO.fetch(Integer.parseInt(id));
	}

	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Produto> getAll() {
		return produtoDAO.fetchAll();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response add(Produto produto) {
		if (produtoDAO.create(produto) != null) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}

	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response edit(Produto produto) {
		if (produtoDAO.update(produto) != null) {
			Response.ok().build();
		}
		return Response.serverError().build();
	}

	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response delete(Produto produto) {
		if (produtoDAO.delete(produto.getId())) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}

}
