package com.sbs.example.easytextboard.service;

import java.util.List;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.dao.ArticleDao;
import com.sbs.example.easytextboard.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int write(int boardId, int memberId, String title, String body) {
		return articleDao.write(boardId, memberId, title, body);
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

	public int makeBoard(String name) {
		return articleDao.makeBoard(name);
	}

}
