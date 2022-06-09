package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	public static void main(String[] args) throws ParseException {
		
		Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("21/06/2018 13:05:44");
		String title1 = "Traveling to New Zealand";
		String content1 = "I'm going to visit this wonderful country!";
		int likes1 = 12;
		String comment1_1 = "Have a nice trip";
		Comment comments1_1 = new Comment(comment1_1);
		String comment1_2 = "Wow that's awesome!";
		Comment comments1_2 = new Comment(comment1_2);
		
		Post post1 = new Post(date1, title1, content1, likes1);
		post1.addComment(comments1_1);
		post1.addComment(comments1_2);
		
		Date date2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("28/07/2018 23:14:19");
		String title2 = "Good night guys";
		String content2 = "See you tomorrow";
		int likes2 = 5;
		String comment2_1 = "Good night";
		Comment comments2_1 = new Comment(comment2_1);
		String comment2_2 = "May the Force be with you";
		Comment comments2_2 = new Comment(comment2_2);
		
		Post post2 = new Post(date2, title2, content2, likes2);
		post2.addComment(comments2_1);
		post2.addComment(comments2_2);
				
		System.out.println(post1);
		
		System.out.println(post2);
		
	}
}
