package com.sbs.example.easytextboard;

import java.util.Scanner;

import com.sbs.example.easytextboard.container.Container;
import com.sbs.example.easytextboard.controller.ArticleController;
import com.sbs.example.easytextboard.controller.MemberController;

public class App {

	public void run() {
		Scanner sc = Container.scanner;
		
		MemberController memberController = new MemberController();
		ArticleController articleController = new ArticleController();
		
		while(true) {
			
			System.out.print("명령어) ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("system exit")) {
				System.out.print("== 프로그램 종료 ==");
				break;
				
			} else if(cmd.startsWith("article ")) {
				articleController.doCommand(cmd);
			}else if(cmd.startsWith("member ")) {
				memberController.doCommand(cmd);
			}
		}
		
		sc.close();
	}

}
