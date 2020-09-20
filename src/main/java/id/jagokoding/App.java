package id.jagokoding;

import javax.persistence.EntityManager;

public class App {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		// Check database version
		String sql = "select version()";

		String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
		System.out.println(result);

		entityManager.getTransaction().commit();
		entityManager.close();

		JPAUtil.shutdown();
	}
}
