package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.com.entity.Share;
import poly.com.ults.JPAUtils;

public class ShareDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	public void insert(Share entity) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
		
	}

	
	public void update(Share entity) {
		
		try {
			trans.begin();
			em.merge(entity);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
		
	}

	
	public void delete(String key){
		
		
		try {
			trans.begin();
			Share Share = em.find(Share.class,key);
			if(Share!=null) {
				em.remove(Share);
			}else {
				throw new Exception("This Share does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}


	public List<Share> findAll() {
		TypedQuery<Share> query = em.createNamedQuery("SharefindAll", Share.class);
		return query.getResultList();
	}


	public Share findByID(String ShareID) {
		Share Share = em.find(Share.class, ShareID);
		return Share;

	}
}
