package com.sbs.example.easytextboard.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.dto.Article;
import com.sbs.example.easytextboard.dto.Board;

public class ArticleDao {

	private List<Article> articles;
	private int lastId;
	private List<Board> boards;
	private int lastBoardId;
	
	public ArticleDao() {
		articles = new ArrayList<>();
		lastId = 0;
		
		boards = new ArrayList<>();
		lastBoardId = 0;
		
		makeTestData();
	}

	private void makeTestData() {
		int boardId = makeBoard("공지사항");
		
		Container.session.selectedBoardId = boardId;
		
		for(int i=1; i<=5; i++) {
			write(boardId, 1, "제목" + i, "내용" + 1);
		}
		
		for(int i=6; i<=10; i++) {
			write(boardId, 2, "제목" + i, "내용" + 1);
		}		
	}

	public int write(int boardId, int memberId, String title, String body) {
		Article article = new Article();
		
		article.id = lastId + 1;
		article.boardId = boardId;
		article.memberId = memberId;
		article.title = title;
		article.body = body;
		
		articles.add(article);
		
		// System.out.println(article);
				
		lastId = article.id;
		
		return article.id;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public int makeBoard(String name) {
		Board board = new Board();
		
		board.id = lastBoardId + 1;
		board.name = name;
		
		boards.add(board);
		
		lastBoardId = board.id;
		
		return board.id;
	}

}
