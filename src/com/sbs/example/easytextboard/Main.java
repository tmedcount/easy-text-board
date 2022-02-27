package com.sbs.example.easytextboard;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		int article1_id = 0;
		String article1_title = "";
		String article1_body = "";
		
		int article2_id = 0;
		String article2_title = "";
		String article2_body = "";

		while(true) {
			System.out.print("명령어) ");
			String command = sc.nextLine();
			
			if(command.equals("system exit")) {
				System.out.println("== 프로그램 종료 ==");
				break;
			} else if(command.equals("article add")) {
				System.out.println("== 게시물 등록 ==");
				
				int id = lastArticleId + 1;
				String title; 
				String body;
				
				System.out.print("제목 : ");
				title = sc.nextLine();
				System.out.print("내용 : ");
				body = sc.nextLine();
				
				//System.out.printf("제목 : %s, 내용 : %s\n", title, body);
				
				if(id == 1) {
					article1_id = id;
					article1_title = title;
					article1_body = body;
				}
				
				if(id == 2) {
					article2_id = id;
					article2_title = title;
					article2_body = body;
				}
								
				System.out.printf("%d번 게시물이 생성되었습니다.\n", id);
				
				lastArticleId = id;
			} else if(command.equals("article list")) {
				System.out.println("== 게시물 리스트 ==");
				
				if(lastArticleId == 0) {
					System.out.println("게시물이 없습니다.");
					continue;
				}
				
				System.out.println("번호 / 제목");
				
				if(lastArticleId >= 1) {
					System.out.printf("%d / %s\n", article1_id, article1_title);
				}
				
				if(lastArticleId >= 2) {
					System.out.printf("%d / %s\n", article2_id, article2_title);
				}
			}
		}
		
		sc.close();
	}
}