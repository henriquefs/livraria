package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.AuditoriaInterceptador;
import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

//@Interceptors({LogInterceptador.class, AuditoriaInterceptador.class})
@Stateless
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	public void salva(Autor autor) {

		System.out.println("[INFO] Salvando o ator " + autor.getNome());
		/*
		 * try { Thread.sleep(20000); // 20 segundos } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		manager.persist(autor);

		System.out.println("[INFO] Autor " + autor.getNome() + " salvo");
		// Algum erro externo (WS por exemplo)
		// throw new RuntimeException("[ERRO] serviço não disponível!");
	}

	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return manager.find(Autor.class, autorId);
	}

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado.");
	}
}
