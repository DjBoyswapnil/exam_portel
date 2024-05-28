package com.ExamPortal.Portal.Dao;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ExamPortal.Portal.Model.PreviousYearPaper;
import com.ExamPortal.Portal.Utility.HibernateUtil;

public class PreviousYearPaperDao 
{
	Scanner sc=new Scanner(System.in);
	public void InsertDataIntoPreviousYearPaper(PreviousYearPaper previousYearPaper)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(previousYearPaper);
			transaction.commit();
		}
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
	public void UpdateDataIntoPreviousYearPaper(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			PreviousYearPaper previousYearPaper=session.get(PreviousYearPaper.class, id);
			if(previousYearPaper!=null)
			{
				System.out.println("What do you want to update");
            	System.out.println("1) Update Paper Board Name");
            	System.out.println("2) Update Paper Subject");
            	System.out.println("3) Update Paper Year");
            	int choice=sc.nextInt();
            	switch (choice)
            	{
				case 1:
					System.out.println("Enter New Update Paper Board Name ");
					previousYearPaper.setBoardName(sc.next());
					break;
				case 2:
					System.out.println("Enter New Update Paper subject");
					previousYearPaper.setPaperSubject(sc.next());
					break;
				case 3:
					System.out.println("Enter New Update Paper Year");
					previousYearPaper.setPaperYear(sc.nextInt());
					break;
				default:
					System.out.println("Wrong Input");
					break;
				}
			}
			
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
	public void DeleteDataFromPreviousYearPaper(int id)
	{

		Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            
			 transaction = session.beginTransaction();
	            
	            PreviousYearPaper previousYearPaper =session.get(PreviousYearPaper.class, id);
	            if(previousYearPaper!=null)
	            {
	            	session.delete(previousYearPaper);
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
	public void DisplayDataFromPreviousYearPaper()
	{
Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            List<PreviousYearPaper> li=session.createQuery("from Papers").getResultList();
            
            System.out.println("PaperId\t\tPaperName\tPaperSubject\tPaperType");
            for(PreviousYearPaper previousYearPaperg:li)
            {
            	System.out.println(previousYearPaperg.getPerviousPaperId()+"\t\t"+previousYearPaperg.getBoardName()+"\t\t"+previousYearPaperg.getPaperSubject()+"\t\t"+previousYearPaperg.getPaperYear());
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
