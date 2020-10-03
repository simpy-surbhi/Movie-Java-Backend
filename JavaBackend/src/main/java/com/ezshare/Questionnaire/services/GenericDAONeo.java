package com.ezshare.Questionnaire.services;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import java.lang.reflect.Type;

public abstract class GenericDAONeo<T, I> {

	@PersistenceContext(unitName="unitpostgress")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void create(T object) {
		em.persist(object);
	}

	@Transactional(value = TxType.REQUIRED)
	public void update(T object) {
		em.merge(object);
	}

	@Transactional
	public void delete(I id) {
		em.remove(em.find(getEntityClass(), id));
	}
	
	@Transactional
	public void deleteChild(I id,String column) {
		int deletedCount = em.createQuery("DELETE FROM " + getClassName() + " where " + column + "=" + id).executeUpdate();
		System.out.println(deletedCount);
	}

	private String getQuery(String ColumnName) {
		return "from " + getClassName() + " where " + ColumnName + "= :pTitle";
	}

	public abstract void setParameters(Map<String, Object> parameters, T criteria);

	@SuppressWarnings({ "unchecked" })
	public List<T> search(T criteria, String ColumnName) {
		Query searchQuery = em.createQuery(getQuery(ColumnName));
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		setParameters(parameters, criteria);
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			searchQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return searchQuery.getResultList();
	}

	public T getById(I id) {
		return em.find(getEntityClass(), id);
	}
	
	public List<T> getAll() {
		String query = "from " + getClassName();
		return em.createQuery(query,getEntityClass()).getResultList();
	}
	
	public List<T> getByOtherColumnId(I id, String columnName) {
		String query = "from " + getClassName() + " where " + columnName + " = " + id;
		return em.createQuery(query,getEntityClass()).getResultList();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {

		Type genericSuperClass = getClass().getGenericSuperclass();

		ParameterizedType parametrizedType = null;
		while (parametrizedType == null) {
			if ((genericSuperClass instanceof ParameterizedType)) {
				parametrizedType = (ParameterizedType) genericSuperClass;
			} else {
				genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
			}
		}
		return (Class<T>) parametrizedType.getActualTypeArguments()[0];
	}

	private String getClassName() {
		String test = getEntityClass().getSimpleName();
		test = test.substring(test.lastIndexOf('.') + 1);
		return test;
	}
}
