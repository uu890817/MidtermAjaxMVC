package tw.midterm.model.report;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Report")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ReportID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportID;

	@Column(name = "ComplainantID")
	private int complainantID;

	@Column(name = "DefendantID")
	private int defendantID;

	@Column(name = "ClassID")
	private int classID;

	@Column(name = "OrderListID")
	private int orderListID;

	@Column(name = "ReportType")
	private int reportType;

	@Column(name = "ReportContent")
	private String reportContent;

	@Column(name = "ReportDate")
	private Date reportDate;

	public Report() {
	}

	public int getReportID() {
		return reportID;
	}

	public Report(int reportID, int complainantID, int defendantID, int classID, int orderListID, int reportType,
			String reportContent, Date reportDate) {
		super();
		this.reportID = reportID;
		this.complainantID = complainantID;
		this.defendantID = defendantID;
		this.classID = classID;
		this.orderListID = orderListID;
		this.reportType = reportType;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public int getComplainantID() {
		return complainantID;
	}

	public void setComplainantID(int complainantID) {
		this.complainantID = complainantID;
	}

	public int getDefendantID() {
		return defendantID;
	}

	public void setDefendantID(int defendantID) {
		this.defendantID = defendantID;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getOrderListID() {
		return orderListID;
	}

	public void setOrderListID(int orderListID) {
		this.orderListID = orderListID;
	}

	public int getReportType() {
		return reportType;
	}

	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}