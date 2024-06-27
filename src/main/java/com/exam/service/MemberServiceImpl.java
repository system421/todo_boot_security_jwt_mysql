package com.exam.service;

import org.springframework.stereotype.Service;

import com.exam.dto.Member;
import com.exam.repository.MemberMyBatisRepository;

@Service
public class MemberServiceImpl implements MemberService{

	MemberMyBatisRepository memberMyBatisRepository;
	
	
	public MemberServiceImpl(MemberMyBatisRepository memberMyBatisRepository) {
		this.memberMyBatisRepository = memberMyBatisRepository;
	}


	@Override
	public Member save(Member member) {
		return memberMyBatisRepository.save(member);		
	}

}
