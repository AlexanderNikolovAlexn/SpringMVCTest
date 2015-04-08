package com.samodeika.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/samodeika/spring/test/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

		try {
			/*
			Offer offerNew = new Offer("Dave", "dave@caveofprogramming.com", "Coding Java");
			
			if (offersDao.create(offerNew)){
				System.out.println("Dave has been created");
			}
			else{
				System.out.println("Dave was not created due to some error");
			}
			
			Offer offerUpdate = new Offer(10005, "Updated Dave", "dave@caveofprogramming.com", "Coding Java");
			
			if(offersDao.update(offerUpdate) > 0){
				System.out.println("Object updated!");
			}
			else{
				System.out.println("Cannot update Dave");
			}
			
			if (offersDao.delete(10003)) {
				System.out.println("deleted");
			}
			else {
				System.out.println("id is already deleted");
			}*/
			
			List<Offer> newOffers = new ArrayList<Offer>();
			newOffers.add(new Offer("Dave", "dave@caveofprogramming.com", "Cash for food"));
			newOffers.add(new Offer("Alex", "alex@blabla.com", "Coding Java for Fun"));
			
			int[] returnIds =  offersDao.create(newOffers);
			
			for (int i = 0; i < returnIds.length; i++) {
				System.out.println("New row created: " + (returnIds[i] == 1));
			}
			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffer(2);
			System.out.println("Should be Mike: " + offer);			
			
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
			System.out.println("Cannot get database connection!");
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

}
