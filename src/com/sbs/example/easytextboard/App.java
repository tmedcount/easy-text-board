package com.sbs.example.easytextboard;

import java.util.Scanner;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.controller.ArticleController;
import com.sbs.example.easytextboard.controller.Controller;
import com.sbs.example.easytextboard.controller.MemberController;
import com.sbs.example.easytextboard.service.ArticleService;
import com.sbs.example.easytextboard.service.MemberService;

public class App {
	MemberController memberController;
	ArticleController articleController;
	
	public App() {
		memberController = Container.memberController;
		articleController = Container.articleController;
		
		makeTestData();
		
		init();
	}
	
	private void init() {
		ArticleService articleService = Container.articleService;
		
		Container.session.selectedBoardId = articleService.getFirstBoardId();
	}

	private void makeTestData() {
		MemberService memberService = Container.memberService;
		int fristMemberId = memberService.join("user1", "user1", "유저1");
		int secondMemberId = memberService.join("user2", "user2", "유저2");
		
		ArticleService articleService = Container.articleService;
		int noticeBoardId = articleService.makeBoard("공지사항");
		
		for(int i=1; i<=5; i++) {
			articleService.write(noticeBoardId, fristMemberId, "제목" + i, "내용" + i);
		}
		
		for(int i=1; i<=5; i++) {
			articleService.write(noticeBoardId, secondMemberId, "제목" + i, "내용" + i);
		}
	}

	public void run() {
		Scanner sc = Container.scanner;
		
		
		while(true) {
			
			System.out.print("명령어) ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("system exit")) {
				System.out.print("== 프로그램 종료 ==");
				break;
			}
			
			Controller controller = getControllerByCmd(cmd);
			
			if(controller == null) {
				System.out.println("명령어를 잘못 입력했습니다. ");
				continue;
			}
			
			controller.doCommand(cmd);
		}
		
		sc.close();
	}

	private Controller getControllerByCmd(String cmd) {
		if(cmd.startsWith("article ")) {
			return articleController;
		} else if(cmd.startsWith("member ")) {
			return memberController;
		}
		
		return null;
	}

}
