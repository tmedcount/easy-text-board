package com.sbs.example.easytextboard.service;

import java.util.List;

import com.sbs.example.easytextboard.dao.ArticleDao;
import com.sbs.example.easytextboard.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = new ArticleDao();
	}

	public int write(int loginedMembeId, String title, String body) {
		return articleDao.write(loginedMembeId, title, body);
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

}
