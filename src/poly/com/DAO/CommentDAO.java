package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.com.entity.Comment;

import poly.com.ults.JPAUtils;

public class CommentDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	public void insert(Comment entity) {
		
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

	
	public void update(Comment entity) {
		
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
			Comment Comment = em.find(Comment.class,key);
			if(Comment!=null) {
				em.remove(Comment);
			}else {
				throw new Exception("This Comment does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}


	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("CommentfindAll", Comment.class);
		return query.getResultList();
	}


	public Comment findByID(String CommentID) {
		Comment Comment = em.find(Comment.class, CommentID);
		return Comment;
	}
	public List<Comment> binhluantheovideo(String id){
		String jqpl = "Select c from Comment c where c.video.idvs = :IDvs ";
		TypedQuery<Comment> query = em.createQuery(jqpl, Comment.class);
		query.setParameter("IDvs", id);
		return query.getResultList();
	}
}
