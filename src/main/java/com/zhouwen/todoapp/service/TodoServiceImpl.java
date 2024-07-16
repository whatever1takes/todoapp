package com.zhouwen.todoapp.service;

import com.zhouwen.todoapp.dao.TodoRepository;
import com.zhouwen.todoapp.domain.Todo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Resource
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setCompleted(updatedTodo.isCompleted());
                    return todoRepository.save(todo);
                }).orElseGet(() -> {
                    updatedTodo.setId(id);
                    return todoRepository.save(updatedTodo);
                });
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
