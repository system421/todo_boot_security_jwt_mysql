package com.exam.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.exam.dto.Member;
import com.exam.repository.MemberMyBatisRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	MemberMyBatisRepository memberMyBatisRepository;
	
	public AuthenticationServiceImpl(MemberMyBatisRepository memberMyBatisRepository) {
		this.memberMyBatisRepository = memberMyBatisRepository;
	}


	@Override
	public Member authenticate(Map<String, String> map) {
		return memberMyBatisRepository.authenticate(map);
	}


	@Override
	public Member findById(String userid) {
		return memberMyBatisRepository.findById(userid);
	}

}
