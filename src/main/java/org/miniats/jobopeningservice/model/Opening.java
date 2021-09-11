package org.miniats.jobopeningservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Opening {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max=256, message="Title must be max 256 characters long")
	private String title;
	
	@Column(name="head_count")
	@Min(value=0, message="Head count must be equals to or greater than one")
	private Long headCount;
	
	@Column(name="min_salary")
	@Min(value=0, message="Minimum salary must be equals to or greater than one")
	private Long minSalary;
	
	@Column(name="max_salary")
	@Min(value=0, message="Maximum salary must be equals to or greater than one")
	private Long maxSalary;
	
	@Column(nullable=false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean open = true;
}
