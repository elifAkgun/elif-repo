package com.elif.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elif.instructor.entity.Course;
import com.elif.instructor.entity.Instructor;
import com.elif.instructor.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {// start a transaction
			session.beginTransaction();

			// create a student object
			System.out.println("Creating new Employee object...");
			Instructor tempInstructor = new Instructor("Maria", "Black", "mar.cat@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("homemade channels", "hommade stuff");

			tempInstructor.setInstructorDetail(instructorDetail);
			
			session.save(tempInstructor);

			Course tempCourse1 = new Course("Code Lesson");
			Course tempCourse2 = new Course("Advance Code Lesson");

			tempInstructor.addCourse(tempCourse1);
			tempInstructor.addCourse(tempCourse2);


			// save the student object
			System.out.println("Saving the instructor..." + tempInstructor);
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
			
			} finally {
			factory.close();
		}
	}

}
