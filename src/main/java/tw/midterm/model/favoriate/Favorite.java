package tw.midterm.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "FavoriteList")
@Component
public class Favorite {
	
	@Id @Column(name = "FavoriteListID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favoritelistid;
	
	@Column(name = "UserID")
	private int userid;
	
	@Column(name = "ClassID")
	private int classid;
	
	@Column(name = "FavoriteDate")
	private String favoritedate;
	
	@Column(name = "ClassName")
	private String classname;
	
	@Column(name = "ClassPrice")
	private int classprice;

	
	public Favorite(int favoritelistid, int userid, int classid, String favoritedate, String classname,
			int classprice) {
		this.favoritelistid = favoritelistid;
		this.userid = userid;
		this.classid = classid;
		this.favoritedate = favoritedate;
		this.classname = classname;
		this.classprice = classprice;
	}

	public void setFavoritelistid(int favoritelistid) {
		this.favoritelistid = favoritelistid;
	}

	public int getFavoritelistid() {
		return favoritelistid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getFavoritedate() {
		return favoritedate;
	}

	public void setFavoritedate(String favoritedate) {
		this.favoritedate = favoritedate;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public int getClassprice() {
		return classprice;
	}

	public void setClassprice(int classprice) {
		this.classprice = classprice;
	}

	public Favorite() {
	}

}
