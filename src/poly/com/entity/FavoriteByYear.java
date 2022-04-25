package poly.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;



@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name ="fav.favoriteByYear",procedureName = "sp_FavoriteByYear",parameters = {
				@StoredProcedureParameter(name="year", type = Integer.class)},resultClasses = {FavoriteByYear.class})
})
public class FavoriteByYear implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String group;
	private Long likes;
	private Date newest;
	private Date oldest;
	
	

	public FavoriteByYear() {
		
	}
	public FavoriteByYear(String group, Long likes, Date newest, Date oldest) {
		super();
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}


	
	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public Long getLikes() {
		return this.likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}   
	public Date getNewest() {
		return this.newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}   
	public Date getOldest() {
		return this.oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}
}
