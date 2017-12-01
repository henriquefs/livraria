package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@WebService
@Stateless
public class LivrariaWS {

	@Inject
	LivroDao livroDao;

	@Inject
	AutorDao autorDao;

	@WebResult(name = "livros")
	public List<Livro> getLivrosPorTitulo(@WebParam(name = "titulo") String titulo) {

		System.out.println("[LivrariaWS] procurando Livro pelo título...");

		return livroDao.getLivrosPorTitulo(titulo);
	}

	@WebResult(name = "autores")
	public List<Autor> getTodosAutores() {

		System.out.println("[LivrariaWS] buscando todos os autores...");

		return autorDao.todosAutores();
	}

}
