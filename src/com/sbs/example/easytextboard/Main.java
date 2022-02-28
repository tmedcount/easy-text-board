package com.sbs.example.easytextboard;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		Article article1 = new Article();
		
		Article article2 = new Article();

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
					article1.id = id;
					article1.title = title;
					article1.body = body;
				}
				
				if(id == 2) {
					article2.id = id;
					article2.title = title;
					article2.body = body;
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
					System.out.printf("%d / %s\n", article1.id, article1.title);
				}
				
				if(lastArticleId >= 2) {
					System.out.printf("%d / %s\n", article2.id, article2.title);
				}
			} else if(command.startsWith("article detail ")) {
				int inputedId = Integer.parseInt(command.split(" ")[2]);
				
				System.out.println("== 게시물 상세 ==");
				
				if(inputedId == 1) {
					if(article1.id == 0) {
						System.out.printf("%d번 게시물은 존재하지 않습니다.\n", inputedId);
						continue;
					}
					
					System.out.printf("번호 : %d\n", article1.id);
					System.out.printf("제목 : %s\n", article1.title);
					System.out.printf("내용 : %s\n", article1.body);
				} else if(inputedId == 2) {
					if(article2.id == 0) {
						System.out.printf("%d번 게시물은 존재하지 않습니다.\n", inputedId);
						continue;
					}
					
					System.out.printf("번호 : %d\n", article2.id);
					System.out.printf("제목 : %s\n", article2.title);
					System.out.printf("내용 : %s\n", article2.body);
				} else {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", inputedId);
				}
			}
		}
		
		sc.close();
	}
}