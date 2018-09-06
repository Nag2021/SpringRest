package com.example.springjpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author nageswara.eluri
 *
 */
@Entity
@Table(name = "user_rights")
public class UserRights {

	public UserRights() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rightId;
	@NotBlank
	private String rightName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "group_id")
	private UserGroup userGroups;
	@ManyToMany(mappedBy = "userRights")
	private List<User> users;
	
	public Long getRightId() {
		return rightId;
	}
	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public UserGroup getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(UserGroup userGroups) {
		this.userGroups = userGroups;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "UserRights [rightId=" + rightId + ", rightName=" + rightName + "]";
	}
}
