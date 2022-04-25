package poly.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import poly.com.ults.DateHelper;

@Entity
@Table(name="Comment")
@NamedQuery(name="CommentfindAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idcmt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cmtdate = new Date();
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	@ManyToOne
	@JoinColumn(name="idvs")
	private Videos video;
	private String comment;
	public long getIdcmt() {
		return idcmt;
	}
	public void setIdcmt(long idcmt) {
		this.idcmt = idcmt;
	}
	public Date getCmtdate() {
		return cmtdate;
	}
	public void setCmtdate(Date cmtdate) {
		this.cmtdate = cmtdate;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
