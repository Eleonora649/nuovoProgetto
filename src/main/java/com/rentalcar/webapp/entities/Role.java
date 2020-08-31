package com.rentalcar.webapp.entities;

import java.io.Serializable;
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String APPLICATION_ROLE = null;

	@Id
	@Column(name="id_role")
	private int idRole;

	@Column(name="description")
	private String description;

	@Column(name="name_role")
	private String nameRole;

	@ManyToMany(mappedBy = "roles",targetEntity=UserEntity.class,
            cascade=CascadeType.ALL)
//	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="id_user")}, inverseJoinColumns={@JoinColumn(name="id_role")})
	private Set<UserEntity> users; 

	public Role() {
		super();
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
	
}
