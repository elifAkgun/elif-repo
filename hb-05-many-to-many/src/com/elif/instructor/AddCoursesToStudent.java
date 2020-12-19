package com.elif.instructor;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elif.instructor.entity.Course;
import com.elif.instructor.entity.Instructor;
import com.elif.instructor.entity.InstructorDetail;
import com.elif.instructor.entity.Review;
import com.elif.instructor.entity.Student;

public class AddCoursesToStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {// start a transaction
			session.beginTransaction();

			Course tempCourse = session.get(Course.class, 19);

			Course tempCourse1 = session.get(Course.class, 20);


			Student tempStudent = session.get(Student.class, 5);

			tempStudent.addCourse(Arrays.asList(tempCourse, tempCourse1));
			session.save(tempStudent);


			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
