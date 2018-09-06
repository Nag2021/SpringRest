package com.example.springjpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author nageswara.eluri
 *
 */
@Entity
@Table(name = "user_details")
public class User {

	public User() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_group_id")
	private UserGroup userGroups;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_right", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "right_id"))
	private List<UserRights> userRights;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserGroup getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(UserGroup userGroups) {
		this.userGroups = userGroups;
	}

	public List<UserRights> getUserRights() {
		return userRights;
	}

	public void setUserRights(List<UserRights> userRights) {
		this.userRights = userRights;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userGroups=" + userGroups
				+ ", userRights=" + userRights + "]";
	}
}
