package poly.com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import poly.com.ults.DateHelper;



/**
 * The persistent class for the Favorite database table.
 * 
 */
@Entity
@NamedQuery(name="FavoritefindAll", query="SELECT f FROM Favorite f")
@SqlResultSetMappings({
    @SqlResultSetMapping(name = "alertMapping", columns = {
        @ColumnResult(name = "getYear")})
})
@NamedNativeQueries({
	@NamedNativeQuery(name= "GetYear.FavoriteVideos",query="Select year(f.likedate) as 'getYear' from Favorite f group by year(f.likedate)",
			resultSetMapping = "alertMapping")
	
})
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idfv;
	@Temporal(TemporalType.TIMESTAMP)
	private Date likedate  = new Date();

	//bi-directional many-to-one association to Users
	
	@JoinColumn(name="userid")
	@ManyToOne
	private Users user;

	
	@JoinColumn(name="idvs")
	@ManyToOne
	private Videos video;

	public Favorite() {
	}

	public long getIdfv() {
		return this.idfv;
	}

	public void setIdfv(long idfv) {
		this.idfv = idfv;
	}


	public Date getLikedate() {
		return this.likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Videos getVideo() {
		return this.video;
	}

	public void setVideo(Videos video) {
		this.video = video;
	}

}