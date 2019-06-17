package com.thebestkitchen.restaurant.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(QueryUtil.class);
	
	public static Query replaceParameters(StringBuilder queryString, Map<String, Object> parametersMap, Class<?> mappingClass, EntityManager entityManager) {
		if (mappingClass != null) {
			return queryBuilder(queryString, parametersMap, entityManager.createNativeQuery(queryString.toString(), mappingClass));
		}
		
		return queryBuilder(queryString, parametersMap, entityManager.createNativeQuery(queryString.toString()));
	}
	
	private static Query queryBuilder(StringBuilder queryString, Map<String, Object> parametersMap, Query query) {
		String queryAux = queryString.toString();
		
		Iterator<Entry<String, Object>> parameterIterator = parametersMap.entrySet().iterator();
		while (parameterIterator.hasNext()) {
			Entry<String, Object> e = parameterIterator.next();
			query.setParameter(e.getKey(), e.getValue());
			
			queryAux = queryAux.replaceFirst( new StringBuilder(":").append(e.getKey()).toString(), 
					new StringBuilder("'").append(e.getValue().toString()).append("'").toString());	
		}
		logger.debug("QUERY REPLACE: {}", queryAux);
		return query;
	}
}