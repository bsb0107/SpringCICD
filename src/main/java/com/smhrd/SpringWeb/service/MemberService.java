package com.smhrd.SpringWeb.service;

import com.smhrd.SpringWeb.dto.Cloud_Member;
import com.smhrd.SpringWeb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    // 회원 목록 조회
    public List<Cloud_Member> memberList(){
        return repository.findAll();
    }

    // 회원 등록
    public void memberInsert(Cloud_Member dto){
        repository.save(dto);
    }

    // 회원 삭제
    public void memberDelete(Long id){
        repository.deleteById(id);
    }

    // 회원 조회
    public Cloud_Member memberSelect(Long id){
        return repository.findById(id).get();
    }
    // 회원 수정
    public void memberUpdate(Cloud_Member dto){
        repository.save(dto);
    }
}
