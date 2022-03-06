package com.sbs.example.easytextboard;

import java.util.Scanner;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.controller.ArticleController;
import com.sbs.example.easytextboard.controller.Controller;
import com.sbs.example.easytextboard.controller.MemberController;

public class App {
	MemberController memberController;
	ArticleController articleController;
	
	public App() {
		memberController = new MemberController();
		articleController = new ArticleController();
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
