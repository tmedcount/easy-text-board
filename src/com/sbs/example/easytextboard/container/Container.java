package com.sbs.example.easytextboard.container;

import java.util.Scanner;

import com.sbs.example.easytextboard.service.MemberService;

public class Container {

	public static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
}
