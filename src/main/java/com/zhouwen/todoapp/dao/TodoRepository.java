package com.zhouwen.todoapp.dao;

import com.zhouwen.todoapp.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
