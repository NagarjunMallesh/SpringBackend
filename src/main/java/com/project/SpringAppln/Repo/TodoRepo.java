package com.project.SpringAppln.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SpringAppln.Model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long>{

	
	
}

