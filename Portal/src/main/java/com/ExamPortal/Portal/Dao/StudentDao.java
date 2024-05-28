package com.ExamPortal.Portal.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ExamPortal.Portal.Model.Student;
import com.ExamPortal.Portal.Utility.HibernateUtil;

public class StudentDao 
{
	Scanner sc=new Scanner(System.in);
	public void InsertDataIntoStudent(Student student)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			
			session.save(student);
			
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
	public void UpdateDataIntoStudent(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			Student student=session.get(Student.class, id);
			if(student!=null)
			{
				System.out.println("What do you want to update");
            	System.out.println("1) Update Students Age");
            	System.out.println("2) Update Students Name");
            	System.out.println("3) Update Students Class");
            	System.out.println("4) Update Students Password");
            	int choice=sc.nextInt();
            	switch (choice) 
            	{
				case 1:
					System.out.println("Enter new Age To update the data");
					student.setStudentAge(sc.nextInt());
					break;
				case 2:
					System.out.println("Enter new Name To update the data");
					student.setStudentName(sc.next());
					break;
				case 3:
					System.out.println("Enter new Class To update the data");
					student.setStudentClass(sc.nextInt());
					break;
				case 4:
					System.out.println("Enter new Password To update the data");
					student.setStudentPassword(sc.next());
					break;

				default:
					System.err.println(":( Sorry Wrong Input");
					break;
				}
			}
			session.update(student);
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
	public void DeleteDataFromStudent(int id)
	{
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			Student student=session.get(Student.class, id);
			if(student!=null)
			{
				session.delete(student);
			}
			
			session.beginTransaction().commit();
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
	
	public void CustomizedListOfStudent()
	{
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			Student student=new Student();
			System.out.println("Choose from Below");
        	System.out.println("1) Customize Table By Students Id");
        	System.out.println("2) Customize Table by Students Name");
        	System.out.println("3) Customize Table by Students Age");
        	System.out.println("4) Customize Table by Students Class");
        	int choice=sc.nextInt();
        	switch (choice) 
        	{
			case 1:
				System.out.println("Enter the Id that you want to display");
				int id=sc.nextInt();
				
				Student student2=session.get(Student.class, id);
				
				
				if(student2!=null)
				{
					 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
					 System.out.println(student2.getSudentId()+"\t\t"+student2.getStudentName()+"\t\t"+student2.getStudentAge()+"\t\t"+student2.getStudentClass()+"\t\t"+student2.getStudentPassword());
				}
				break;
			case 2:
				System.out.println("Enter the name that you want to dispaly");
				String Name=sc.next();
				 
				List<Student> list=session.createQuery("from Student where StudentName=:Name").
						setParameter("Name", Name).getResultList();
				
				 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
				 
				 for(Student student3:list)
				 {
					 System.out.println(student3.getSudentId()+"\t\t"+student3.getStudentName()+"\t\t"+student3.getStudentAge()+"\t\t"+student3.getStudentClass()+"\t\t"+student3.getStudentPassword());
				 }
				
				break;
			case 3:
				System.out.println("Enter the Age that you want to display");
				int age=sc.nextInt();
				
				List<Student> list2=session.createQuery("from Student where StudentAge=:age").
						setParameter("age", age).getResultList();
				
				 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
				 
				 for(Student student4:list2)
				 {
					 System.out.println(student4.getSudentId()+"\t\t"+student4.getStudentName()+"\t\t"+student4.getStudentAge()+"\t\t"+student4.getStudentClass()+"\t\t"+student4.getStudentPassword());
				 }
				break;
			case 4:
				System.out.println("Enter the Class that you want to display");
				String Sclass=sc.next();
				
				List<Student> list3=session.createQuery("from Student where StudentClass=:Sclass").
						setParameter("Sclass", Sclass).getResultList();
				
				 System.out.println("StudentsId\tStudentsName\tStudentsAge\tStudentsClass\tStudentsPass");
				 
				 for(Student student5:list3)
				 {
					 System.out.println(student5.getSudentId()+"\t\t"+student5.getStudentName()+"\t\t"+student5.getStudentClass()+"\t\t"+student5.getStudentAge()+"\t\t"+student5.getStudentPassword());
				 }
				break;

			default:
				System.err.println("Wrong Input");
				break;
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue");
		}
	}
	public void DisplayDataFromStudent()
	{
		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			List<Student> li=session.createQuery("from Student").getResultList();
            
            System.out.println("StudentsId\t\tStudentsName\t\tStudentsAge\t\tStudentsClass\t\tStudentsPass");
            for(Student student6:li)
            {
            	System.out.println(student6.getSudentId()+"\t\t"+student6.getStudentName()+"\t\t"+student6.getStudentAge()+"\t\t"+student6.getStudentClass()+"\t\t"+student6.getStudentPassword());
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

