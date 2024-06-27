package com.exam.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.exam.dto.Member;

@Repository
public class MemberMyBatisRepository {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	SqlSessionTemplate sqlSessionTemplate;
	
	public MemberMyBatisRepository(SqlSessionTemplate sqlSessionTemplate) {
		logger.info("logger:{}", "MemberMyBatisRepository");
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public Member idCheck(String userid) {
		return sqlSessionTemplate.selectOne("com.exam.config.MemberMapper.idCheck", userid);
	}
	
	public Member authenticate(Map<String, String> map) {
		return sqlSessionTemplate.selectOne("com.exam.config.MemberMapper.authenticate", map);
	}
	
	public Member save(Member mem) {
		sqlSessionTemplate.insert("com.exam.config.MemberMapper.save", mem);
		return mem;
	}
	
	public Member findById(String userid) {
		return sqlSessionTemplate.selectOne("com.exam.config.MemberMapper.findById", userid);
	}

}
