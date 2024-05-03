package com.Database.ExamportalProject;

import java.util.Scanner;

import com.Database.ExamportalProject.Dao.MarksDao;
import com.Database.ExamportalProject.Dao.PaperDao;
import com.Database.ExamportalProject.Dao.StudentsDao;
import com.Database.ExamportalProject.Dao.TeacherDao;
import com.Database.ExamportalProject.model.Marks;
import com.Database.ExamportalProject.model.Papers;
import com.Database.ExamportalProject.model.Students;
import com.Database.ExamportalProject.model.Teachers;
//import com.Database.ExamportalProject.Dao.PaperDao;
//import com.Database.ExamportalProject.Dao.StudentsDao;
//import com.Database.ExamportalProject.Dao.TeachersDao;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc = new Scanner(System.in);

	
	public void insertintoStudents_Marks()
	{
				
	    	Students s = new Students();
			System.out.println("Enter students Name");
			s.setStudentsName(sc.next());
			System.out.println("Enter students age");
			s.setStudentsAge(sc.nextInt());
			System.out.println("Enter students Class");
			s.setStudentsClass(sc.next());
			System.out.println("Enter Students Password ");
			s.setStudentsPass(sc.next());
	    	
			Marks m = new Marks();
			
	    	System.out.println("Enter marks Score");
			m.setMarksScore(sc.next());
			System.out.println("Enter marks Remarks");
			m.setMarksRemark(sc.next());
			
	    	m.setStudentId(s);
	    	s.setMarks(m);
	
	    	MarksDao md = new MarksDao();
	    	md.insertMarkDetails(m);
	    	
	//    	StudentsDao sd = new StudentsDao();
	//    	sd.savestudentsDetails(s);
	}
	
			public void insertintoTeachers_Paper()
			{
				Teachers t = new Teachers();
				System.out.println("Enter Teachers Name");
				t.setTeacherName(sc.next());
				System.out.println("Enter Teachers Age");
				t.setTeacherAge(sc.nextInt());
				System.out.println("Enter Teacher Password");
				t.setTeacherPass(sc.next());
				
				
				Papers p = new Papers();
				System.out.println("Enter paper Name");
				p.setPaperName(sc.next());
				System.out.println("Enter paper Type");
				p.setPaperType(sc.next());
				System.out.println("Enter paper Subject ");
				p.setPaperType(sc.next());
				
				p.setTeachersId(t);
				t.setPaper(p);
				
				PaperDao pd = new PaperDao();
				pd.insertPaperDetails(p);
			}
	
	
	public void delete ()
	{
		
		System.out.println("Choose from below to delete an operation from");
		System.out.println("1) To delete a Student");
		System.out.println("2) To delete a Marks");
		System.out.println("2) To delete a Paper");
		System.out.println("2) To delete a Teachers");
		int choice=sc.nextInt();
		switch (choice) 
		{
		case 1:
			StudentsDao sd = new StudentsDao();
			System.out.println("Enter a id to delete");
			int sid=sc.nextInt();
			sd.deleteStudentById(sid);
			break;
		case 2:
			MarksDao md = new MarksDao();
			System.out.println("Enter a id to delete");
			int mid=sc.nextInt();
			md.deleteStudentById(mid);
			break;
		case 3:
			PaperDao pd = new PaperDao();
			System.out.println("Enter a id to delete");
			int pid=sc.nextInt();
			pd.deleteStudentById(pid);
			break;
		case 4:
			TeacherDao td = new TeacherDao();
			System.out.println("Enter a id to delete");
			int tid=sc.nextInt();
			td.deleteStudentById(tid);
			break;

		default:
			System.out.println("Wrong input ");
			break;
		}
		
	}
			
			
			
    public static void main( String[] args )
    {
    	App a = new App();
    	a.delete();
    		
    }
    
}
