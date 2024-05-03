package com.Database.ExamportalProject.Dao;

import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Students;

public class MarksDao 
{
//	Scanner sc = new Scanner(System.in);
//	public void insert() 
//	{
//		Transaction tx = null;
//		try(Session session=HibernateUtil.getSessionFactory().openSession())
//		{
//			tx=session.beginTransaction();
//			Marks m = new Marks();
//			
//			System.out.println("Enter marks Id");
//			m.setMarksId(sc.nextInt());
//			System.out.println("Enter marks Score");
//			m.setMarksScore(sc.nextInt());
//			System.out.println("Enter marks Remarks");
//			m.setMarksRemark(sc.next());
//			session.save(m);
//			tx.commit();			
//		}
//		catch (Exception e) 
//		{
//			if(tx!=null)
//			{
//				tx.rollback();
//				System.out.println(e.getMessage());
//			}
//		}
//	}
	
	public void insertMarkDetails(Marks marks) 
	{
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(marks);
            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();
            }
            e.printStackTrace();
            
        }
	}
	
	
	
	public void deleteStudentById(int id) 
	{
		Transaction tx = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            
	            tx = session.beginTransaction();
	            
	            Marks m=session.get(Marks.class, id);
	            if(m!=null)
	            {
	            	session.delete(m);
	            }
	            tx.commit();
	        } 
	        catch (Exception e) 
	        {
	            if (tx != null) 
	            {
	                tx.rollback();
	            }
	            e.printStackTrace();
	            
	        }
	
	}
	
}
