package com.exam.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dto.Todo;
import com.exam.repository.TodoMyBatisRepository;

@Service
public class TodoMyBatisServiceImpl implements TodoMyBatisService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	TodoMyBatisRepository todoJdbcRepository;
	
	public TodoMyBatisServiceImpl(TodoMyBatisRepository todoJdbcRepository) {
		logger.info("logger:{}", "TodoServiceImpl");
		this.todoJdbcRepository = todoJdbcRepository;
	}

	@Override
	public Todo save(Todo todo) {
		return todoJdbcRepository.save( todo);
	}

	@Override
	public void deleteById(long id) {
		todoJdbcRepository.deleteById(id);
	}

	@Override
	public Todo findById(long id) {
		return todoJdbcRepository.findById(id);
	}

	@Override
	public List<Todo> listAllTodos(String userid) {
		return todoJdbcRepository.listAllTodos(userid);
	}

	@Override
	public void update(Todo todo) {
		todoJdbcRepository.update(todo);
	}
	
}
