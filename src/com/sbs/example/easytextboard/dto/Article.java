package com.sbs.example.easytextboard.dto;

public class Article {
	public int id;
	public int memberId;
	public String title;
	public String body;
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", memberId=" + memberId + ", title=" + title + ", body=" + body + "]";
	}
	
	
}
