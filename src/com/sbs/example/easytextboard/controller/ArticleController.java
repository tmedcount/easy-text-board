package com.sbs.example.easytextboard.controller;

import java.util.List;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.dto.Article;
import com.sbs.example.easytextboard.dto.Board;
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
		if(cmd.startsWith("article selectBoard ")) {
			selectBoard(cmd);
		} if(cmd.equals("article makeBoard")) {
			makeBoard(cmd);
		} else if(cmd.equals("article list")) {
			list(cmd);
		} else if(cmd.equals("article add")) {
			add(cmd);
		}
	}

	private void selectBoard(String cmd) {
		int boardId = Integer.parseInt(cmd.split(" ")[2]);
		
		Board board = articleService.getBoardById(boardId);
		
		if(board == null) {
			System.out.println("존재하지 않는 게시판 번호입니다.");
			return;
		}
		
		System.out.printf("%s 게시판으로 변경합니다.\n", board.name);
		
		Container.session.selectedBoardId = boardId;
	}

	private void makeBoard(String cmd) {
		System.out.println("== 게시판 생성 ==");
		
		String name;
		
		System.out.print("게시판 이름 : ");
		name = Container.scanner.nextLine();
		
		int boardId = articleService.makeBoard(name);
		
		System.out.printf("%s(%d번) 게시판이 생성되었습니다.\n", name, boardId);
	}

	private void list(String cmd) {
		int boardId = Container.session.selectedBoardId;
		Board board = articleService.getBoardById(boardId);
		List<Article> articles = articleService.getArticles(boardId);
		
		System.out.printf("== %s 게시판 목록 ==\n", board.name);
		
		System.out.println("번호 / 작성자 / 제목");
		for(Article article : articles) {
			Member member = memberService.getMemberById(article.memberId);
			
			System.out.printf("%d / %s / %s\n", article.id, member.name, article.title);
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
