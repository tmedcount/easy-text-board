package com.sbs.example.easytextboard.container;

import java.util.Scanner;

import com.sbs.example.easytextboard.controller.ArticleController;
import com.sbs.example.easytextboard.controller.MemberController;
import com.sbs.example.easytextboard.dao.ArticleDao;
import com.sbs.example.easytextboard.dao.MemberDao;
import com.sbs.example.easytextboard.service.ArticleService;
import com.sbs.example.easytextboard.service.MemberService;
import com.sbs.example.easytextboard.session.Session;

public class Container {

	public static Scanner scanner;
	public static Session session;
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	public static MemberService memberService;
	public static ArticleController articleController;
	public static MemberController memberController;
	
	static {
		scanner = new Scanner(System.in);
		session = new Session();
		
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		
		articleService = new ArticleService();
		memberService = new MemberService();
		
		articleController = new ArticleController();
		memberController = new MemberController();
	}
}
