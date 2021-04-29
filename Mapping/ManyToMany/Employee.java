package com.example.Mapping.ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	private int eid;
	private String name;
	
	@ManyToMany
	@JoinTable(
				name = "emp_learn", // 'name' will rename the join table of both employee and project
				joinColumns = {@JoinColumn(name="eid")}, // change the name of 1st column in join table
				inverseJoinColumns = {@JoinColumn(name="pid")} // change the name of 2nd column in join table
			  ) 
	private List<Project> projects;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String name, List<Project> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}	
	
}
