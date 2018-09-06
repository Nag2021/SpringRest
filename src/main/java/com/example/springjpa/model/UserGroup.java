package com.example.springjpa.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author nageswara.eluri
 *
 */
@Entity
@Table(name = "user_group")
public class UserGroup {

	public UserGroup() {

	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long groupId;
	@NotBlank
	private String groupName;
	@OneToMany(mappedBy="userGroups")
	private List<User> user;
	
	@OneToOne(mappedBy="userGroups")
	private UserRights userRights;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public UserRights getUserRights() {
		return userRights;
	}
	public void setUserRights(UserRights userRights) {
		this.userRights = userRights;
	}
	@Override
	public String toString() {
		return "UserGroup [groupId=" + groupId + ", groupName=" + groupName + "]";
	}
}
