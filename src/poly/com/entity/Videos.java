package poly.com.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Videos database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Videos.findAll", query="SELECT v FROM Videos v")
	
})
@NamedNativeQueries({
	@NamedNativeQuery(name="Videos.top10viewer", query="Select top 10 * from Videos Order By viewer DESC",resultClass = Videos.class),
	@NamedNativeQuery(name = "Videos.random10", query = "Select top 10 * from Videos Order by NEWID()",resultClass = Videos.class),
	@NamedNativeQuery(name = "Videos.random1", query = "Select top 1 * from Videos Order by NEWID()",resultClass = Videos.class),
	@NamedNativeQuery(name = "Videos.kinhdi", query = "select * from Videos where theloai=N'Kinh dị'",resultClass = Videos.class),
	@NamedNativeQuery(name = "Videos.hanhdong", query = "select * from Videos where theloai=N'Hành động'",resultClass = Videos.class),
	@NamedNativeQuery(name = "Videos.hoathinh", query = "select * from Videos where theloai=N'Hoạt hình'",resultClass = Videos.class),
	@NamedNativeQuery(name = "Videos.khvt", query = "select * from Videos where theloai=N'Khoa học viễn tưởng'",resultClass = Videos.class)
})
public class Videos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(unique=true, nullable=false, length=11)
	private String idvs;
	private boolean active;
	private String cmt;
	private String poster;
	private String tittle;
	private String video;
	private int viewer;
	private String theloai;
	public String getTheloai() {
		return theloai;
	}
	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}
	@OneToMany(mappedBy="video")
	private List<Favorite> favorites;

	@OneToMany(mappedBy="video")
	private List<Share> shares;
	
	@OneToMany(mappedBy="video")
	private List<Comment> comments;
	public Videos() {
	}
	public String getIdvs() {
		return this.idvs;
	}
	public void setIdvs(String idvs) {
		this.idvs = idvs;
	}
	public boolean getActive() {
		return this.active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getCmt() {
		return this.cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getPoster() {
		return this.poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTittle() {
		return this.tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getVideo() {
		return this.video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public int getViewer() {
		return this.viewer;
	}
	public void setViewer(int viewer) {
		this.viewer = viewer;
	}
	public List<Favorite> getFavorites() {
		return this.favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setVideo(this);
		return favorite;
	}
	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setVideo(null);
		return favorite;
	}
	public List<Share> getShares() {
		return this.shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	public Share addShare(Share share) {
		getShares().add(share);
		share.setVideo(this);
		return share;
	}
	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setVideo(null);
		return share;
	}

}