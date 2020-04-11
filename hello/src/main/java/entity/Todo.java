package entity;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty(message = "Task must be set")
	@Size(min = 10, message = "Task should not be less 10 characters ")
	private String task;
	
	@FutureOrPresent(message = "Due date must be in present or future")
	@JsonbDateFormat(value = "yyyyMMdd")
	private LocalDate dueDate;
	
	
	private boolean isCompleted;
	private LocalDate completedDate;
	private LocalDate createDate;
	
	//This method is called when the object is created
	@PrePersist
	private void init() {
		setCreateDate(LocalDate.now());
	}
	
}
