package com.deloitte;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentUpdate {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter <rollNo> of student");
		int rollNo = scan.nextInt();
		// Student stud = new Student(scan.next(),scan.next());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("stud");
		EntityManager em = emf.createEntityManager();
		// em.getTransaction().begin();
		// em.persist(stud);
		Student stud = em.find(Student.class, rollNo);
		// em.getTransaction().commit();
		// System.out.println("Student saved");

		if (stud != null) {
			System.out.println(stud);
			System.out.println("Enter the new subject");
			String subject = scan.next();
			stud.setSubject(subject);
			em.getTransaction().begin();
			em.merge(stud);
			em.getTransaction().commit();
			System.out.println("student update");
		} else
			System.out.println("Student with rollNo " + rollNo + " not found.");
	}

}