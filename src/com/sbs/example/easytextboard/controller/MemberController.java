package com.sbs.example.easytextboard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbs.example.easytextboard.dto.Member;

public class MemberController extends Controller {
	private List<Member> members;
	private int lastMemberId;
	
	public MemberController() {
		lastMemberId = 0;
		members = new ArrayList<>();
	}
	
	private int join(String loginId, String loginPw, String name) {
		Member member = new Member();
		
		member.id = lastMemberId + 1;
		member.loginId = loginId;
		member.loginPw = loginPw;
		member.name = name;
				
		members.add(member);
		
		lastMemberId = member.id;
		
		return member.id;
	}

	public void run(Scanner sc, String command) {
		System.out.println("== 회원가입 ==");
		
		String loginId;
		String loginPw;
		String name;
		
		System.out.print("아이디 : ");
		loginId = sc.nextLine();
		System.out.print("비밀번호 : ");
		loginPw = sc.nextLine();
		System.out.print("이름 : ");
		name= sc.nextLine();	
		
		int id = join(loginId, loginPw, name);
		
		System.out.printf("%d번 회원이 가입했습니다.\n", id);
		
	}

}
