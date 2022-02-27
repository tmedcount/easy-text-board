package com.sbs.example.easytextboard;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		while(true) {
			System.out.print("명령어) ");
			String command = sc.nextLine();
			
			if(command.equals("article add")) {
				System.out.println("== 게시물 등록 ==");
				
				int id = lastArticleId + 1;
				String title;
				String body;
				
				System.out.print("제목 : ");
				title = sc.nextLine();
				System.out.print("내용 : ");
				body = sc.nextLine();
				
				System.out.println("== 생성된 게시물 정보 ==");
				System.out.printf("번호 : %d\n", id);
				System.out.printf("제목 : %s\n", title);
				System.out.printf("내용 : %s\n", body);
				
				lastArticleId = id;
				
			} else if(command.equals("article list")) {
				System.out.println("== 게시물 리스트 ==");
			} else if(command.equals("system exit")) {
				System.out.println("== 프로그램 종료 ==");
				break;
			} else {
				System.out.println("== 존재하지 않는 명령어 ==");
			}
		}
		
		sc.close();
	}
}
