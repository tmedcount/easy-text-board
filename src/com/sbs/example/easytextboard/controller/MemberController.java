package com.sbs.example.easytextboard.controller;

import java.util.Scanner;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.service.MemberService;

public class MemberController {
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}

	public void doCommand(String cmd) {
		if(cmd.equals("member join")) {
			join(cmd);
		} else if(cmd.equals("member login")) {
			
		}
	}

	private void join(String cmd) {
		Scanner sc = Container.scanner;
		
		String loginId;
		String loginPw;
		String name;
		
		System.out.print("아이디 : ");
		loginId = sc.nextLine();
		
		boolean isJoinableLoginId = memberService.isJoinableLoginId(loginId);
		
		if(isJoinableLoginId == false) {
			System.out.printf("%s(은)는 이미 사용 중인 아이디 입니다.\n", loginId);
			return;
		}
		
		System.out.print("비밀번호 : ");
		loginPw = sc.nextLine();
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		// System.out.printf("%s, %s, %s\n", loginId, loginPw, name);
		
		int id = memberService.join(loginId, loginPw, name);
		
		System.out.printf("%d번 회원이 생성되었습니다.\n", id);
	}

}
