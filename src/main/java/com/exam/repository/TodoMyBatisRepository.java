package com.exam.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.exam.dto.Todo;

@Repository
public class TodoMyBatisRepository {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	SqlSessionTemplate sqlSessionTemplate;
	
	public TodoMyBatisRepository(SqlSessionTemplate sqlSessionTemplate) {
		logger.info("logger:{}", "TodoJdbcRepository");
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public Todo save(Todo todo) {
		sqlSessionTemplate.insert("com.exam.config.TodoMapper.save", todo);
		return todo;
	}
	
	public void update(Todo todo) {
		sqlSessionTemplate.update("com.exam.config.TodoMapper.update", todo);
	}
	public void deleteById(long id) {
		sqlSessionTemplate.delete("com.exam.config.TodoMapper.deleteById", id);
	}
	
	public Todo findById(long id) {
		return sqlSessionTemplate.selectOne("com.exam.config.TodoMapper.findById", id);
	}
	
	public List<Todo> listAllTodos(String userid) {
		return sqlSessionTemplate.selectList("com.exam.config.TodoMapper.findAll", userid);
		
	}
}
