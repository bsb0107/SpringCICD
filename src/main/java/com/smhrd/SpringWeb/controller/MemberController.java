package com.smhrd.SpringWeb.controller;

import com.smhrd.SpringWeb.dto.Cloud_Member;
import com.smhrd.SpringWeb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping("/")
    public String main(Model model){
        // 회원목록 보기
        List<Cloud_Member> list = service.memberList();
        System.out.println(list.toString());
        model.addAttribute("list", list);
        return "main";
    }

    // 회원등록 페이지 이동
    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }

    // 회원등록 기능
    @PostMapping("/insert")
    public String insert(Cloud_Member dto){
        service.memberInsert(dto);
        return "redirect:/";
    }

    // 회원삭제 기능
    @GetMapping("/delete")
    public String delete(Long id){
        System.out.println(id);
        service.memberDelete(id);
        return "redirect:/";
    }

    // 회원수정 페이지 이동
    @GetMapping("/update")
    public String update(Long id, Model model){
        Cloud_Member dto = service.memberSelect(id);
        model.addAttribute("dto", dto);
        System.out.println(dto.toString());
        return "update";
    }

    // 회원정보 수정 기능
    @PostMapping("/update")
    public String update(Cloud_Member dto){
        service.memberUpdate(dto);
        return "redirect:/";
    }

}
