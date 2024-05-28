package com.ExamPortal.Portal.Dao;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ExamPortal.Portal.Model.Teacher;
import com.ExamPortal.Portal.Utility.HibernateUtil;

public class TeacherDao 
{
	Scanner sc=new Scanner(System.in);
	public void InsertDataIntoTeacher(Teacher teacher)
	{
		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(teacher);
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
	public void UpdateDataIntoTeacher(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			Teacher teacher=session.get(Teacher.class, id);
			if(teacher!=null)
			{
				System.out.println("What do you want to update");
            	System.out.println("1) Update Teachers Age");
            	System.out.println("2) Update Teachers Name");
            	System.out.println("3) Update Teachers  Password");
            	int choice=sc.nextInt();
            	switch (choice) 
            	{
				case 1:
					System.out.println("Enter new Age To update the data");
					teacher.setTeacherAge(sc.nextInt());
					break;
				case 2:
					System.out.println("Enter new Name To update the data");
					teacher.setTeacherName(sc.next());
					break;
				case 3:
					System.out.println("Enter new Password To update the data");
					teacher.setTeacherPassword(sc.next());
					break;

				default:
					System.err.println("Wrong Input");
					break;
				}
			}
			session.update(teacher);
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
		
	public void DeleteDataFromTeacher(int id)
	{
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			Teacher teacher=session.get(Teacher.class, id);
			if(teacher!=null)
			{
				session.delete(teacher);
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
	
	public void CustomizedListOfTeacher()
	{
		Transaction transaction=null;
		try(Session session= HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			Teacher teacher=new Teacher();
			System.out.println("Choose from Below");
        	System.out.println("1) Customize Table By Teachers Id");
        	System.out.println("2) Customize Table by Teachers Name");
        	System.out.println("3) Customize Table by Teachers Age");
        	int choice=sc.nextInt();
        	switch (choice) 
        	{
			case 1:
				System.out.println("Enter the Id that you want to display");
				int id=sc.nextInt();
				
				Teacher tea=session.get(Teacher.class, id);
				
				if(tea!=null)
				{
					System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");
	            	System.out.println(tea.getTeacherId()+"\t\t"+tea.getTeacherName()+"\t\t"+tea.getTeacherAge()+"\t\t"+tea.getTeacherPassword());

				}
				break;
			case 2:
				System.out.println("Enter the name that you want to dispaly");
				String Name=sc.next();
				 
				List<Teacher> li2=session.createQuery("from Teacher where TeacherName=:Name").
						setParameter("Name", Name).getResultList();
				
				
				System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");
				 for(Teacher s2:li2)
				 {
		            	System.out.println(s2.getTeacherId()+"\t\t"+s2.getTeacherName()+"\t\t"+s2.getTeacherAge()+"\t\t"+s2.getTeacherPassword());

				 }
				
				break;
				
			case 3:
				System.out.println("Enter the name that you want to dispaly");
				int age=sc.nextInt();
				 
				List<Teacher> li3=session.createQuery("from Teacher where TeacherAge=:age").
						setParameter("age", age).getResultList();
				
				
				System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");
				 for(Teacher s2:li3)
				 {
		            	System.out.println(s2.getTeacherId()+"\t\t"+s2.getTeacherName()+"\t\t"+s2.getTeacherAge()+"\t\t"+s2.getTeacherPassword());

				 }
				
				break;
				
			default:
				System.err.println("Wrong Input");
				break;
			}
		}
		catch (Exception e)
		{
			
		}
	}
	public void DisplayDataFromTeacher()
	{
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			 List<Teacher> li=session.createQuery("from Teacher").getResultList();
	            
	            System.out.println("TeachersId\tTeachersName\tTeachersAge\tTeachersPass");
	            
	            for(Teacher t:li)
	            {
	            	System.out.println(t.getTeacherId()+"\t\t"+t.getTeacherName()+"\t\t"+t.getTeacherAge()+"\t\t"+t.getTeacherPassword());
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
		
	}

