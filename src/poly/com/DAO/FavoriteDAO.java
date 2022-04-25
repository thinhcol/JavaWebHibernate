package poly.com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.com.entity.Favorite;
import poly.com.ults.JPAUtils;

public class FavoriteDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	public void insert(Favorite entity) {
		
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

	
	public void update(Favorite entity) {
		
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

	
	public void delete(Long key){
		try {
			trans.begin();
			Favorite Favorite = em.find(Favorite.class,key);
			if(Favorite!=null) {
				em.remove(Favorite);
			}else {
				throw new Exception("This Favorite does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}
	

	public List<Favorite> findAll() {
		TypedQuery<Favorite> query = em.createNamedQuery("FavoritefindAll", Favorite.class);
		return query.getResultList();
	}
	public Favorite findByfav(String userID,String videoId) {
		String jqpl = "Select f from Favorite f where f.user.userid = :userID and f.video.idvs = :videoId";
		TypedQuery<Favorite> query = em.createQuery(jqpl, Favorite.class);
		query.setParameter("userID", userID);
		query.setParameter("videoId", videoId);
		List<Favorite> result = query.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	public List<Integer> getYearForFavoriteVids(){
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<Integer> query = em.createNamedQuery("GetYear.FavoriteVideos", Integer.class);
		return query.getResultList();
	}

	public Favorite findByID(String FavoriteID) {
		Favorite Favorite = em.find(Favorite.class, FavoriteID);
		return Favorite;
	}
}
