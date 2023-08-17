package tw.midterm.model.score;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="OrderList2")
@Component
public class Score {

	@Id @Column(name="OrderListID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderlistid;
	
	@Column(name="OrderFormID")
	private int orderformid;
	
	@Column(name="ClassID")
	private int classid;
	
	@Column(name="StudentReviewScore")
	private int studentreviewsore;
	
	@Column(name="StudentReviewContent")
	private String studentreviewcontent;
	
	@Column(name="StudentReviewDate")
	private String studentreviewdate;

	public Score(int orderlistid, int orderformid, int classid, int studentreviewsore, String studentreviewcontent,
			String studentreviewdate) {
		this.orderlistid = orderlistid;
		this.orderformid = orderformid;
		this.classid = classid;
		this.studentreviewsore = studentreviewsore;
		this.studentreviewcontent = studentreviewcontent;
		this.studentreviewdate = studentreviewdate;
	}
	
	

	public Score(int orderformid, int classid, int studentreviewsore, String studentreviewcontent,
			String studentreviewdate) {
		this.orderformid = orderformid;
		this.classid = classid;
		this.studentreviewsore = studentreviewsore;
		this.studentreviewcontent = studentreviewcontent;
		this.studentreviewdate = studentreviewdate;
	}






	public Score() {
	}

	public int getOrderlistid() {
		return orderlistid;
	}

	public void setOrderlistid(int orderlistid) {
		this.orderlistid = orderlistid;
	}

	public int getOrderformid() {
		return orderformid;
	}

	public void setOrderformid(int orderformid) {
		this.orderformid = orderformid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public int getStudentreviewsore() {
		return studentreviewsore;
	}

	public void setStudentreviewsore(int studentreviewsore) {
		this.studentreviewsore = studentreviewsore;
	}

	public String getStudentreviewcontent() {
		return studentreviewcontent;
	}

	public void setStudentreviewcontent(String studentreviewcontent) {
		this.studentreviewcontent = studentreviewcontent;
	}

	public String getStudentreviewdate() {
		return studentreviewdate;
	}

	public void setStudentreviewdate(String studentreviewdate) {
		this.studentreviewdate = studentreviewdate;
	}
	
	
}
