package com.cg.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="trainee")
public class Trainee 
{
	@Id
	@Column(name="trainee_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="trainee_id_seq", allocationSize=1)
	private Integer traineeId;

	@NotEmpty(message="Name of Trainee is mandatory.")
	@Pattern(regexp="[A-Za-z]{3,20}", message="Name should contain a minimum of 3 and maximum of 20 letters")
	@Column(name="trainee_name")
	private String traineeName;
	
	@NotEmpty(message="Domain of Trainee is mandatory.")
	@Column(name="trainee_dom")
	private String traineeDom;
	
	@NotEmpty(message="Location of Trainee is mandatory.")
	@Column(name="trainee_loc")
	private String traineeLoc;

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeDom() {
		return traineeDom;
	}

	public void setTraineeDom(String traineeDom) {
		this.traineeDom = traineeDom;
	}

	public String getTraineeLoc() {
		return traineeLoc;
	}

	public void setTraineeLoc(String traineeLoc) {
		this.traineeLoc = traineeLoc;
	}
	
	
	
}
