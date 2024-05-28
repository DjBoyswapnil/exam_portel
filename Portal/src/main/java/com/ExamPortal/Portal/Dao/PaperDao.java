package com.ExamPortal.Portal.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ExamPortal.Portal.Model.Paper;
import com.ExamPortal.Portal.Utility.HibernateUtil;

public class PaperDao 
{
	Scanner sc = new Scanner (System.in);
	public void InsertDataIntoPaper(Paper paper)
	{
		Transaction transaction = null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(paper);
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
	public void UpdateDataIntoPaper(int id)
	{
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            Paper paper = session.get(Paper.class, id);
	   
	            if(paper!=null)
	            {
	            	System.out.println("What do you want to update");
	            	System.out.println("1) Update Paper Name");
	            	System.out.println("2) Update Paper Subject");
	            	System.out.println("3) Update Paper Type");
	            	int choice=sc.nextInt();
	            	switch (choice) 
	            	{
					case 1:
						System.out.println("Enter new Paper name To update the data");
						paper.setPaperName(sc.next());
						break;
					case 2:
						System.out.println("Enter new Paper Subject To update the data");
						paper.setPaperSubject(sc.next());
						break;
					case 3:
						System.out.println("Enter new Paper type To update the data");
						paper.setPaperType(sc.next());
						break;

					default:
						System.err.println("Wrong Input");
						break;
					}
	            }
	            // save the student object
	            session.update(paper);
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
	public void DeleteDataFromPaper(int id)
	{
		Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            
			 transaction = session.beginTransaction();
	            
	            Paper paper =session.get(Paper.class, id);
	            if(paper!=null)
	            {
	            	session.delete(paper);
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
	public void DisplayDataFromPaper()
	{
		 Transaction transaction = null;
	        
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            List<Paper> li=session.createQuery("from Paper").getResultList();
	            
	            System.out.println("PaperId\t\tPaperName\tPaperSubject\tPaperType");
	            for(Paper paper:li)
	            {
	            	System.out.println(paper.getPaerId()+"\t\t"+paper.getPaperName()+"\t\t"+paper.getPaperSubject()+"\t\t"+paper.getPaperType());
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

