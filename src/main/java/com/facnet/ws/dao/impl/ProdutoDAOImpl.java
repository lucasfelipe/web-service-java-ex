package com.facnet.ws.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.facnet.ws.dao.ProdutoDAO;
import com.facnet.ws.model.Produto;

public class ProdutoDAOImpl extends BaseJPADAO implements ProdutoDAO {

	public List<Produto> fetchAll() {
		Query query = getEntityManager().createNamedQuery("Produto.findAll");
		List<Produto> produtos = query.getResultList();
		closeEntityManager();
		return produtos;
	}

	public Produto fetch(int id) {
		Produto produto = getEntityManager().find(Produto.class, id);
		closeEntityManager();
		return produto;
	}

	public Produto update(Produto produto) {
		if (produto == null || produto.getId() == 0) {
			return null;
		}

		EntityTransaction transaction = getEntityManager().getTransaction();

		Produto produtoUpdate = getEntityManager().find(Produto.class,
				produto.getId());
		if (!transaction.isActive()) {
			transaction.begin();
		}

		produtoUpdate.setCategoria(produto.getCategoria());
		produtoUpdate.setDescricao(produto.getDescricao());
		produtoUpdate.setNome(produto.getNome());
		produtoUpdate.setQuantidade(produto.getQuantidade());

		transaction.commit();
		closeEntityManager();

		return produto;
	}

	public Produto create(Produto produto) {
		EntityTransaction transaction = getEntityManager().getTransaction();

		if (!transaction.isActive()) {
			transaction.begin();
		}

		getEntityManager().persist(produto);
		transaction.commit();
		closeEntityManager();

		return produto;
	}

	public boolean delete(int id) {

		if (id == 0) {
			return false;
		}

		Produto produto = fetch(id);

		if (produto == null) {
			return false;
		}

		EntityTransaction transaction = getEntityManager().getTransaction();

		if (!transaction.isActive()) {
			transaction.begin();
		}

		getEntityManager().remove(getEntityManager().merge(produto));

		transaction.commit();
		closeEntityManager();

		return true;

	}

}
