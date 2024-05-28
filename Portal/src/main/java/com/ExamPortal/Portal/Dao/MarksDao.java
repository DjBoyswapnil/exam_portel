package com.ExamPortal.Portal.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ExamPortal.Portal.Model.Marks;
import com.ExamPortal.Portal.Utility.HibernateUtil;

public class MarksDao 
{
	Scanner sc=new Scanner(System.in);
	public void InsertDataIntoMarks(Marks marks)
	{
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(marks);
			transaction.commit();
		} 
		catch (Exception e) 
		{
			 if (transaction != null) 
	            {
	                transaction.rollback();
	            }
		}
		
	}
	public void UpdateDataIntoMarks(int id)
	{
		Transaction transaction=null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Marks marks = session.get(Marks.class, id);
   
            if(marks!=null)
            {
            	System.out.println("What do you want to update");
            	System.out.println("1) Update Marks Score");
            	System.out.println("2) Update Marks Grade");
            	int choice=sc.nextInt();
            	switch (choice) 
            	{
				case 1:
					System.out.println("Enter new Marks Score To update the data");
					marks.setScoore(sc.nextInt());
					break;
				case 2:
					System.out.println("Enter new Grade To update the data");
					marks.setGrade(sc.next());
					break;

				default:
					System.err.println("Wrong Input");
					break;
				}
            }
            // save the student object
            session.update(marks);
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
	public void DeleteDataFromMarks(int id)
	{
		Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            
			 transaction = session.beginTransaction();
	            
	            Marks marks=session.get(Marks.class, id);
	            if(marks!=null)
	            {
	            	session.delete(marks);
	            }
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
	public void DisplayDataFromMarks()
	{
		 Transaction transaction = null;
	        
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            List<Marks> li=session.createQuery("from Marks").getResultList();
	            
	            System.out.println("MarksId\t\tMarksScore\tMarksRemark");
	            for(Marks marks:li)
	            {
	            	System.out.println(marks.getMarksId()+"\t\t"+marks.getScoore()+"\t\t"+marks.getGrade());
	            }
	            
	            
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
}
