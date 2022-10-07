package com.example.sep26;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name="users")
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","usereducations"})
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;
	
	@Column(nullable = false, updatable = true)
	private String name;
	
	private String address;
	
	private String sex;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", targetEntity = Usereducation.class)
//	
//	@JoinTable(name = "STUDENT_ADDRESS_DETAILS", 
//	  joinColumns = {@JoinColumn(name = "STD_ID", referencedColumnName = "std_id")},
//	  inverseJoinColumns = {@JoinColumn(name = "ADD_ID", referencedColumnName = "add_id")})
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Usereducation> usereducations;// = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Usereducation> getUsereducations() {
		return usereducations;
	}

	public void setUsereducations(List<Usereducation> usereducations) {
		this.usereducations = usereducations;
	}

	protected Users(Integer id, String name, String address, String sex, List<Usereducation> usereducations) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.sex = sex;
		this.usereducations = usereducations;
	}

	protected Users() {
		super();
		// TODO Auto-generated constructor stub
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
//  private List<Email> emails;
	
	
}
