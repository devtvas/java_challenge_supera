package com.devtvas.tarefas.service;

import com.devtvas.tarefas.entity.Todo;
import com.devtvas.tarefas.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

   public List<Todo> create(Todo todo){
         todoRepository.save(todo);
         return list();
   }

    public List<Todo> list() {
      Sort sort =  Sort.by(Sort.Order.desc("favoritos"), Sort.Order.asc("titulo"));
      return   todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public  List<Todo> delete(Long id){
        todoRepository.deleteById(id);
       return list();}
}
