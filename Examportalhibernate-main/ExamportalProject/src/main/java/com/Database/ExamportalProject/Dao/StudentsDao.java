package com.Database.ExamportalProject.Dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Students;

public class StudentsDao 
{
	
//	Scanner sc = new Scanner(System.in);
//	public void insert()
//	{
//		Transaction tx = null;
//		try (Session session=HibernateUtil.getSessionFactory().openSession())
//		{
//			tx=session.beginTransaction();
//			
//			Students s = new Students();
//			
//			System.out.println("Enter students Id");
//			s.setStudentId(sc.nextInt());
//			System.out.println("Enter students Name");
//			s.setStudentName(sc.next());
//			System.out.println("Enter students age");
//			s.setStudentAge(sc.nextInt());
//			System.out.println("Enter students Class");
//			s.setStudentClass(sc.next());
//			System.out.println("Enter Students Password ");
//			s.setStudentPassword(sc.next());
//			System.out.println("Enter marks id of that Student");
//			int markid=sc.nextInt();
//			
//			Marks m =session.get(Marks.class, markid);
//			
//			if(m!=null)
//			{
//				s.setMarksId(m);
//				session.save(s);
//				tx.commit();
//			}
//			else
//			{
//				System.err.println("Id not Found ");
//			}
//	
//		}
//		catch (Exception e) 
//		{
//			if(tx!=null)
//			{
//				tx.rollback();
//				e.printStackTrace();
//			}
//		}
//	}
	
	
	
	public void insertstudentsDetails(Students students) 
	{
		Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            tx = session.beginTransaction();
            // save the student object
            session.save(students);
            // commit transaction
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

	public void deleteStudentById(int id) 
	{
		Transaction tx = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            
	            tx = session.beginTransaction();
	            
	            Students s=session.get(Students.class, id);
	            if(s!=null)
	            {
	            	session.delete(s);
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
