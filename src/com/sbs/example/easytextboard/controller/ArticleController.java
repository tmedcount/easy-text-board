package com.sbs.example.easytextboard.controller;

import java.util.List;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.dto.Article;
import com.sbs.example.easytextboard.dto.Member;
import com.sbs.example.easytextboard.service.ArticleService;
import com.sbs.example.easytextboard.service.MemberService;

public class ArticleController extends Controller {

	private ArticleService articleService;
	private MemberService memberService;
	
	public ArticleController() {
		articleService = Container.articleService;
		memberService = Container.memberService;
	}

	public void doCommand(String cmd) {
		if(cmd.equals("article makeBoard")) {
			makeBoard(cmd);
		} else if(cmd.equals("article list")) {
			list(cmd);
		} else if(cmd.equals("article add")) {
			add(cmd);
		}
	}

	private void makeBoard(String cmd) {
		System.out.println("== 게시판 생성 ==");
		
		String name;
		
		System.out.print("게시판 이름 : ");
		name = Container.scanner.nextLine();
		
		int boardId = articleService.makeBoard(name);
		
		System.out.printf("공지사항(%d)번 게시판이 생성되었습니다.\n", boardId);
	}

	private void list(String cmd) {
		System.out.println("== 게시물 목록 ==");
		
		List<Article> articles = articleService.getArticles();
		
		System.out.println("게시판 번호 / 게시글 번호 / 작성자 / 제목");
		for(Article article : articles) {
			Member member = memberService.getMemberById(article.memberId);
			
			System.out.printf("%d / %d / %s / %s\n", article.boardId, article.id, member.name, article.title);
		}
	}

	private void add(String cmd) {
		System.out.println("== 게시물 등록 ==");
		
		if(!Container.session.isLogined()) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}
		
		String title;
		String body;
		
		System.out.print("제목 : ");
		title = Container.scanner.nextLine();
		System.out.print("내용 : ");
		body = Container.scanner.nextLine();
		
		int boardId = Container.session.selectedBoardId;
		int memberId = Container.session.loginedMemberId;
		
		int id = articleService.write(boardId, memberId, title, body);
		
		System.out.printf("%d번 글이 생성되었습니다.\n", id);
	}

}
