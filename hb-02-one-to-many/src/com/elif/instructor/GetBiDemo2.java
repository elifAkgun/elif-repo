package com.elif.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elif.instructor.entity.Instructor;
import com.elif.instructor.entity.InstructorDetail;


public class GetBiDemo2 {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			// start a transaction
			session.beginTransaction();

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);
			
			// get the instructor object
						System.out.println("Get the instructor detail..." + instructorDetail);
				
			
			// get the instructor object
			System.out.println("Get the instructor..." + instructorDetail.getInstructor());
	
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			session.close();
			factory.close();
		}
	}

}




