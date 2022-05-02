package com.example.todoApp.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="todos")
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
	
	@Id
	//GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private String id;
	
	@Column(name="title")
    private String title;
    
	@Column(name="completed")
    private Boolean completed;
}
