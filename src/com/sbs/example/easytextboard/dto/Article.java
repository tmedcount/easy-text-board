package com.sbs.example.easytextboard.dto;

public class Article {
	public int id;
	public int boardId;
	public int memberId;
	public String title;
	public String body;

	@Override
	public String toString() {
		return "Article [id=" + id + ", boardId=" + boardId + ", memberId=" + memberId + ", title=" + title + ", body="
				+ body + "]";
	}
}
