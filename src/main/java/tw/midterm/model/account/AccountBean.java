package tw.midterm.model.account;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "Account")
@Component
public class AccountBean {

	@Id @Column(name = "UserID") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "UserName") 
	private String userName;
	@Column(name = "UserPassword") 
	private String password;
	@Column(name = "FamilyName") 
	private String familyName;
	@Column(name = "GivenName") 
	private String givenName;
	@Column(name = "NameViewType") 
	private int nameViewType;
	@Column(name = "Email") 
	private String email;
	@Column(name = "Gender") 
	private int gender;
	@Column(name = "Nationality") 
	private String nationality;
	@Column(name = "Birthday") 
	private Date birthday;
	@Column(name = "IsTeacher") 
	private boolean isTeacher = false;
	@Column(name = "IsAdmin") 
	private boolean isAdmin = false;
	@Column(name = "TutorCoin") 
	private BigDecimal tutorCoin = new BigDecimal(0);
	@Column(name = "AccountCreatDate") 
	private Date accountCreatDate;
	
	public AccountBean() {
	}

	public AccountBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public AccountBean(String userName, String password, String familyName, String givenName, int nameViewType,
			String email, int gender, String nationality, Date birthday) {
		this.userName = userName;
		this.password = password;
		this.familyName = familyName;
		this.givenName = givenName;
		this.nameViewType = nameViewType;
		this.email = email;
		this.gender = gender;
		this.nationality = nationality;
		this.birthday = birthday;
	}

	public AccountBean(int userId, String userName, String password, String familyName, String givenName,
			int nameViewType, String email, int gender, String nationality, Date birthday, boolean isTeacher,
			boolean isAdmin, BigDecimal tutorCoin, Date accountCreatDate) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.familyName = familyName;
		this.givenName = givenName;
		this.nameViewType = nameViewType;
		this.email = email;
		this.gender = gender;
		this.nationality = nationality;
		this.birthday = birthday;
		this.isTeacher = isTeacher;
		this.isAdmin = isAdmin;
		this.tutorCoin = tutorCoin;
		this.accountCreatDate = accountCreatDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public int getNameViewType() {
		return nameViewType;
	}

	public void setNameViewType(int nameViewType) {
		this.nameViewType = nameViewType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public BigDecimal getTutorCoin() {
		return tutorCoin;
	}

	public void setTutorCoin(BigDecimal tutorCoin) {
		this.tutorCoin = tutorCoin;
	}

	public Date getAccountCreatDate() {
		return accountCreatDate;
	}

	public void setAccountCreatDate(Date accountCreatDate) {
		this.accountCreatDate = accountCreatDate;
	}


	
}
