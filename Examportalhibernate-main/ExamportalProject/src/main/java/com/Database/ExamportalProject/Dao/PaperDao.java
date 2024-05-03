package com.Database.ExamportalProject.Dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Papers;

public class PaperDao 
{
	public void insertPaperDetails(Papers paper)
	{
		Transaction tx = null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			session.save(paper);
			tx.commit();
		}
		catch (Exception e) 
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void deleteStudentById(int id) 
	{
		Transaction tx = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            
	            tx = session.beginTransaction();
	            
	            Papers p =session.get(Papers.class, id);
	            if(p!=null)
	            {
	            	session.delete(p);
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
