package br.com.fiap.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Filme;

public class FilmeDao {

	@Inject
	private EntityManager manager;
	
	public void create(Filme filme) {
		
		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
	public List<Filme> listAll() {
		
		TypedQuery<Filme> query = 
				manager.createQuery("SELECT s FROM Filme s", Filme.class);
		
		return query.getResultList();
		
	}

	public void remove(Filme filme) {	
		manager.getTransaction().begin();
		manager.remove(filme);
		manager.getTransaction().commit();
	}

	public void update(Filme filme) {
		manager.getTransaction().begin();
		filme = manager.merge(filme);
		manager.getTransaction().commit();
	}

}
