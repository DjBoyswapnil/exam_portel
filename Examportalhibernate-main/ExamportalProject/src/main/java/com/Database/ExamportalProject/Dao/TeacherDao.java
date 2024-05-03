package com.Database.ExamportalProject.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Database.ExamportalProject.Utility.HibernateUtil;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Papers;
import com.Database.ExamportalProject.model.Teachers;

public class TeacherDao 
{
	public void insertTeacherDetails(Teachers teacher)
	{
		Transaction tx = null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			session.save(teacher);
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
	            
	           Teachers t =session.get(Teachers.class, id);
	            if(t!=null)
	            {
	            	session.delete(t);
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
