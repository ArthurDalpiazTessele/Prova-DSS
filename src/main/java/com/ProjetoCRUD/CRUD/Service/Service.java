package com.ProjetoCRUD.CRUD.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ProjetoCRUD.CRUD.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Service
	public class ProdutoService {

	    @Autowired
	    private ProdutoRepository produtoRepository;

	    public Produto create(Produto produto) {
	        return produtoRepository.save(produto);
	    }

	    public Produto read(Long id) {
	        return produtoRepository.findById(id).orElse(null);
	    }

	    public Produto update(Produto produto) {
	        Produto produtoExistente = produtoRepository.findById(produto.getId()).orElse(null);
	        if (produtoExistente != null) {
	            produtoExistente.setNome(produto.getNome());
	            produtoExistente.setPreco(produto.getPreco());
	            return produtoRepository.save(produtoExistente);
	        }
	        return null;
	    }

	    public void delete(Long id) {
	        produtoRepository.deleteById(id);
	    }
	}
	
}