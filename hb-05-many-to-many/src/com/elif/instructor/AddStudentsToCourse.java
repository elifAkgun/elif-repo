package com.elif.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elif.instructor.entity.Course;
import com.elif.instructor.entity.Instructor;
import com.elif.instructor.entity.InstructorDetail;
import com.elif.instructor.entity.Review;
import com.elif.instructor.entity.Student;

public class AddStudentsToCourse {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {// start a transaction
			session.beginTransaction();

			Course tempCourse = new Course("How to write code beginner");

			Student tempStudent = new Student("Elif", "Akgun", "elif.akgun13@gmail.com");
			session.save(tempStudent);

			Student tempStudent1 = new Student("Ayse", "Elmaci", "ayse.elma@gmail.com");
			session.save(tempStudent1);

			Student tempStudent2 = new Student("Fatma", "Kara", "fatma@gmail.com");
			session.save(tempStudent2);
			
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			session.save(tempCourse);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
