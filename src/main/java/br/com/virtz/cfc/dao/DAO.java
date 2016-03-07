package br.com.virtz.cfc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.virtz.cfc.entidades.Entidade;

import com.google.inject.Inject;

public abstract class DAO<T> {

	@Inject
	private EntityManager manager;
	
	protected EntityManager getEntityManager() {
		return 	manager;
	}
	
	public T recuperarPorId(Long id) {
		return (T) getEntityManager().find(getTypeClass(), id);
	}
	
	public T salvar(T t) throws Exception {
		if(t instanceof Entidade){
			if(((Entidade)t).getId() == null){
				getEntityManager().persist(t);
				return t;
			}
			return getEntityManager().merge(t);
		} else {
			throw new Exception("Entidade não compatível para salvamento.");
		}
	}
	
	
	public void remover(Long id) {
		T entityRemove = (T) getEntityManager().find(getTypeClass(), id);
		getEntityManager().remove(entityRemove);
	}
	
	public List<T> recuperarTodos() {
		return (List<T>) getEntityManager().createQuery("FROM "+getTypeClass().getName()+" entity ").getResultList();
	}
	
	private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
   
}
