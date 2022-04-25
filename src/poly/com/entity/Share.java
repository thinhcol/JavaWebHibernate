package poly.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import poly.com.ults.DateHelper;


/**
 * The persistent class for the Share database table.
 * 
 */
@Entity
@Table(name="Share")
@NamedQuery(name="SharefindAll", query="SELECT s FROM Share s")
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idsr;
	@Temporal(TemporalType.TIMESTAMP)
	private Date sahredate = new Date();
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	@ManyToOne
	@JoinColumn(name="idvs")
	private Videos video;
	private String email;

	public Share() {
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdsr() {
		return this.idsr;
	}

	public void setIdsr(long idsr) {
		this.idsr = idsr;
	}

	public Date getSahredate() {
		return this.sahredate;
	}

	public void setSahredate(Date sahredate) {
		this.sahredate = sahredate;
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