package com.sbs.example.easytextboard.controller;

import java.util.Scanner;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.dto.Member;
import com.sbs.example.easytextboard.service.MemberService;

public class MemberController extends Controller {
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}

	public void doCommand(String cmd) {
		if(cmd.equals("member login")) {
			login(cmd);
		} else if(cmd.equals("member join")) {
			join(cmd);
		} else if(cmd.equals("member logout")) {
			logout(cmd);
		} else if(cmd.equals("member whoami")) {
			whoami(cmd);
		}
	}

	private void logout(String cmd) {
		if(!Container.session.isLogined()) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}
		
		Container.session.logout();
		
		System.out.println("로그아웃 되었습니다.");
		
	}

	private void whoami(String cmd) {
		if(!Container.session.isLogined()) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}
		
		int loginedMemberId = Container.session.loginedMemberId;
		
		Member loginedMember = memberService.getMemberById(loginedMemberId);
		
		System.out.println("== 로그인 된 사용자 정보 ==");
		System.out.printf("아이디 : %s\n", loginedMember.loginId);
		System.out.printf("이름 : %s\n", loginedMember.name);
	}

	private void login(String cmd) {
		Scanner sc = Container.scanner;
		
		String loginId;
		String loginPw;
		
		System.out.print("아이디 : ");
		loginId = sc.nextLine();
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			System.out.printf("%s(은)는 존재하지 않는 아이디 입니다.\n", loginId);
			return;
		}
		
		System.out.print("비밀번호 : ");
		loginPw = sc.nextLine();
		
		if(!member.loginPw.equals(loginPw)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		Container.session.login(member.id);
		
		System.out.printf("%s님, 환영합니다!\n", member.name);
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
