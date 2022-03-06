package com.sbs.example.easytextboard.controller;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.service.ArticleService;

public class ArticleController {

	private ArticleService articleService;
	
	public ArticleController() {
		articleService = new ArticleService();
	}

	public void doCommand(String cmd) {
		if(cmd.equals("article add")) {
			System.out.println("== 게시물 등록 ==");
			
			if(!Container.session.isLogined()) {
				System.out.println("로그인 후 이용해 주세요.");
				return;
			}
			
			String title;
			int loginedMembeId = Container.session.loginedMemberId;
			String body;
			
			System.out.print("제목 : ");
			title = Container.scanner.nextLine();
			System.out.print("내용 : ");
			body = Container.scanner.nextLine();
			
			int id = articleService.write(loginedMembeId, title, body);
			
			System.out.printf("%d번 글이 생성되었습니다.\n", id);
		}
		
	}

}
