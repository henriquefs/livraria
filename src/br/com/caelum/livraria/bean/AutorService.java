package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
// Atributo padrão, não é necessária a anotação. Feito só por fins ditáticos
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorService {

	@Inject
	private AutorDao autorDao;

	// Atributo padrão, não é necessária a anotação. Feito só por fins ditáticos
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(Autor autor) {
		autorDao.salva(autor);

		//throw new LivrariaException();
	}

	public List<Autor> todosAutores() {
		return autorDao.todosAutores();
	}
}
