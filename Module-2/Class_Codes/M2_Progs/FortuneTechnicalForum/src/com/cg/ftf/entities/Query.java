package com.cg.ftf.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

//Entity mapping
@Entity
@Table(name="query_master")			//mapping table name with class
public class Query 
{
	@Id					//Mapping and validation with class var and table column
	@NotNull(message="Query ID is mandatory.")
	@Column(name="query_id")
	private Integer queryId;
	
	@Column(name="technology")		//Mapping with class var and table column
	private String technology;
	
	@Column(name="query_raised_by")		//Mapping with class var and table column
	private String queryRaisedBy;
	
	@Column(name="query")		//Mapping with class var and table column
	private String query;

	public Integer getQueryId() {
		return queryId;
	}

	//proper getters and setters
	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getQueryRaisedBy() {
		return queryRaisedBy;
	}

	public void setQueryRaisedBy(String queryRaisedBy) {
		this.queryRaisedBy = queryRaisedBy;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
