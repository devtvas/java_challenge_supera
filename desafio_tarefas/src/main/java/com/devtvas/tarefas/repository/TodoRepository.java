package com.devtvas.tarefas.repository;

import com.devtvas.tarefas.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
