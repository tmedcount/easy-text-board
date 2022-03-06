package com.sbs.example.easytextboard.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.example.easytextboard.dto.Article;

public class ArticleDao {

	private List<Article> articles;
	private int lastId;
	
	public ArticleDao() {
		articles = new ArrayList<>();
		lastId = 0;
		
		makeTestData();
	}

	private void makeTestData() {
		for(int i=1; i<=5; i++) {
			write(1, "제목" + i, "내용" + 1);
		}
		
		for(int i=6; i<=10; i++) {
			write(2, "제목" + i, "내용" + 1);
		}		
	}

	public int write(int loginedMembeId, String title, String body) {
		Article article = new Article();
		
		article.id = lastId + 1;
		article.memberId = loginedMembeId;
		article.title = title;
		article.body = body;
		
		articles.add(article);
		
		// System.out.println(article);
				
		lastId = article.id;
		
		return article.id;
	}

}
