package tw.midterm.model.lesson;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity@Table(name="Class")
@Component
public class Lessons {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLASSID")
	private int classid;
	@Column(name="TEACHERID")
	private int teacherid;
	@Column(name="CLASSTYPEID")
	private int classtypeid;
	@Column(name="CLASSCONTENT")
	private String classcontent;
	@Column(name="CLASSNAME")
	private String classname;
	@Column(name="CLASSINFO")
	private String classinfo;
	@Column(name="LESSONTYPE")
	private String lessontype;
	@Column(name="PRICE")
	private double price;
	
	public Lessons() {
		
	}

	public Lessons(int teacherid, int classtypeid, String classcontent, String classname, String classinfo,
			String lessontype, double price) {
		this.teacherid = teacherid;
		this.classtypeid = classtypeid;
		this.classcontent = classcontent;
		this.classname = classname;
		this.classinfo = classinfo;
		this.lessontype = lessontype;
		this.price = price;
	}

	public Lessons(int classid, int teacherid, int classtypeid, String classcontent, String classname, String classinfo,
			String lessontype, double price) {
		this.classid = classid;
		this.teacherid = teacherid;
		this.classtypeid = classtypeid;
		this.classcontent = classcontent;
		this.classname = classname;
		this.classinfo = classinfo;
		this.lessontype = lessontype;
		this.price = price;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public int getClasstypeid() {
		return classtypeid;
	}

	public void setClasstypeid(int classtypeid) {
		this.classtypeid = classtypeid;
	}

	public String getClasscontent() {
		return classcontent;
	}

	public void setClasscontent(String classcontent) {
		this.classcontent = classcontent;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassinfo() {
		return classinfo;
	}

	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}

	public String getLessontype() {
		return lessontype;
	}

	public void setLessontype(String lessontype) {
		this.lessontype = lessontype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	
	
}
