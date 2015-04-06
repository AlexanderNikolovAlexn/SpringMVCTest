package com.samodeika.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/samodeika/spring/test/beans/beans.xml");
		
		//Person person = (Person)context.getBean("person");				
		//person.setTaxId(666);		
		//System.out.println(person1);
		//System.out.println(person);		
		//Address address2 = (Address)context.getBean("address2");
		//System.out.println(address2);
		
		//0208 Setting List Values
		FruitBasket fruitBasket = (FruitBasket)context.getBean("basket");
		System.out.println(fruitBasket);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
