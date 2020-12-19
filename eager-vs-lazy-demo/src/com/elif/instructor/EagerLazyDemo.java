package com.elif.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elif.instructor.entity.Course;
import com.elif.instructor.entity.Instructor;
import com.elif.instructor.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			

			// start a transaction
			session.beginTransaction();

			// create a student object
			System.out.println("Getting new Employee object...");
			
			Instructor tempInstructor = session.get(Instructor.class, 4);

			System.out.println(tempInstructor);
			


		

			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println(tempInstructor.getCourses());

			System.out.println("Done!");
		
		} finally {
			factory.close();
		}
	}

}
