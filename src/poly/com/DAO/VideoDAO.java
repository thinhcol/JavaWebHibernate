package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import poly.com.entity.FavoriteByYear;
import poly.com.entity.Videos;
import poly.com.ults.JPAUtils;

public class VideoDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	public void insert(Videos entity) {
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

	
	public void update(Videos entity) {
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
			Videos Videos = em.find(Videos.class,key);
			if(Videos!=null) {
				em.remove(Videos);
			}else {
				throw new Exception("This Videos does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}


	public List<Videos> findAll() {
		TypedQuery<Videos> query = em.createNamedQuery("Videos.findAll", Videos.class);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Videos> top10random() {
		javax.persistence.Query query = em.createNamedQuery("Videos.random10");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> top1random() {
		javax.persistence.Query query = em.createNamedQuery("Videos.random1");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> top10viewer() {
		javax.persistence.Query query = em.createNamedQuery("Videos.top10viewer");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> kinhdi() {
		javax.persistence.Query query = em.createNamedQuery("Videos.kinhdi");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> hanhdong() {
		javax.persistence.Query query = em.createNamedQuery("Videos.hanhdong");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> hoathinh() {
		javax.persistence.Query query = em.createNamedQuery("Videos.hoathinh");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Videos> khoahoc() {
		javax.persistence.Query query = em.createNamedQuery("Videos.khvt");
		return query.getResultList();
	}

	public Videos findByID(String VideosID) {
		Videos Videos = em.find(Videos.class, VideosID);
		return Videos;
	}
	public List<Videos> findByTitle(String title) {
		String jqpl = "Select v from Videos v where v.tittle like:getTitle";
		TypedQuery<Videos> query = em.createQuery(jqpl, Videos.class);
		query.setParameter("getTitle","%"+title+"%");
		return query.getResultList();
	}
	public List<Videos> videoyeuthichuserid(String id){
		String jqpl = "Select f.video from Favorite f where f.user.userid = :userID ";
		TypedQuery<Videos> query = em.createQuery(jqpl, Videos.class);
		query.setParameter("userID", id);
		return query.getResultList();
	}
	public List<FavoriteByYear> reportFavoriteByYear(int year){
		StoredProcedureQuery query = em.createStoredProcedureQuery("sp_FavoriteByYear",FavoriteByYear.class);
		query.registerStoredProcedureParameter("year",Integer.class, ParameterMode.IN);
		query.setParameter("year", year);
		return query.getResultList();
	}
}
