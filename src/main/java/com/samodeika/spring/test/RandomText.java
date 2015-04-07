package com.samodeika.spring.test;

import java.util.Random;

public class RandomText {

	private static String[] texts = {
		"I`ll be back",
		"Get out",
		"I want your car"
	};
	
	public String getText(){
		Random random = new Random();
		
		return texts[random.nextInt(texts.length)];
	}
}
