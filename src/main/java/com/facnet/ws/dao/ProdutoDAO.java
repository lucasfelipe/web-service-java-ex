package com.facnet.ws.dao;

import java.util.List;

import com.facnet.ws.model.Produto;

public interface ProdutoDAO {
	
	public List<Produto> fetchAll();
	
	public Produto fetch(int id);
	
	public Produto create(Produto produto);
	
	public boolean delete(int id);
	
	public Produto update(Produto produto);

}
