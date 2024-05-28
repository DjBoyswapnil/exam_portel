package com.ExamPortal.Portal;

import java.util.Scanner;

import com.ExamPortal.Portal.Dao.MarksDao;
import com.ExamPortal.Portal.Dao.PaperDao;
import com.ExamPortal.Portal.Dao.PreviousYearPaperDao;
import com.ExamPortal.Portal.Dao.StudentDao;
import com.ExamPortal.Portal.Dao.TeacherDao;
import com.ExamPortal.Portal.Model.Marks;
import com.ExamPortal.Portal.Model.Paper;
import com.ExamPortal.Portal.Model.PreviousYearPaper;
import com.ExamPortal.Portal.Model.Student;
import com.ExamPortal.Portal.Model.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{ 
	Scanner sc = new Scanner(System.in);
	
	public void insertDataStudentMakrs() 
	{
		char ans ;
		do
		{
		Student student=new Student();
		
		System.out.println("Enter Student Name");
		student.setStudentName(sc.next());
		System.out.println("Enter Student Age");
		student.setStudentAge(sc.nextInt());
		System.out.println("Enter Student Class");
		student.setStudentClass(sc.nextInt());
		System.out.println("Enter Student Password");
		student.setStudentPassword(sc.next());
		
		Marks marks=new Marks();
		
		System.out.println("Enter Marks Scoore");
		marks.setScoore(sc.nextInt());
		System.out.println("Enter Marks Grade");
		marks.setGrade(sc.next());
		
		marks.setStudentId(student);
		student.setMarks(marks);
		
		MarksDao marksdao=new MarksDao();
		marksdao.InsertDataIntoMarks(marks);
		
		StudentDao studentDao = new StudentDao();
		studentDao.InsertDataIntoStudent(student);
		
		System.out.println("Do you want insert somwthing else (Y/N)");
		ans=sc.next().charAt(0);
		
	}while(ans=='y' || ans=='Y');	
	}
	
	public void insertTeacherPaper()
	{
		
		char ans ;
		do
		{
		Teacher teacher=new Teacher();
		
		System.out.println("Enter teacher Name");
		teacher.setTeacherName(sc.next());
		System.out.println("Enter Teacher Age");
		teacher.setTeacherAge(sc.nextInt());
		System.out.println("Enter Teacher Password");
		teacher.setTeacherPassword(sc.next());
		
		Paper paper = new Paper();
		
		System.out.println("Enter Paper Name");
		paper.setPaperName(sc.next());
		System.out.println("Enter Paper Subject");
		paper.setPaperSubject(sc.next());
		System.out.println("Enter Paper Type");
		paper.setPaperType(sc.next());
		
		paper.setTeacherId(teacher);
		teacher.setPaper(paper);
		
		PaperDao paperDao = new PaperDao();
		paperDao.InsertDataIntoPaper(paper);
		
		TeacherDao teacherDao=new TeacherDao();
		teacherDao.InsertDataIntoTeacher(teacher);
		
		System.out.println("Do you want insert somwthing else (Y/N)");
		ans=sc.next().charAt(0);
		
	}while(ans=='y' || ans=='Y');	
	}
	public void insertpreviousyearpaper()
	{
		PreviousYearPaper previousYearPaper = new PreviousYearPaper();
		
		System.out.println("Enter Previous Year Paper Board Name");
		previousYearPaper.setBoardName(sc.next());
		System.out.println("Enter Paper Year");
		previousYearPaper.setPaperYear(sc.nextInt());
		System.out.println("Enter Paper Subject");
		previousYearPaper.setPaperSubject(sc.next());
		
		PreviousYearPaperDao previousYearPaperDao = new PreviousYearPaperDao();
		//previousYearPaper.InsertDataIntoPreviousYearPaper(previousYearPaper);
	}
	public void delete()
	{
		char ans ;
		do
		{
			System.out.println("Choose from below to delete an operation from");
			System.out.println("1) To delete a Student");
			System.out.println("2) To delete a Marks");
			System.out.println("3) To delete a Paper");
			System.out.println("4) To delete a Teachers");
			System.out.println("5) To delete a Previous Year Paper");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentDao studentDao = new StudentDao();
				System.out.println("Enter Student id to delete");
				int sid=sc.nextInt();
				studentDao.DeleteDataFromStudent(sid);
				break;
			case 2:
				MarksDao marksDao = new MarksDao();
				System.out.println("Enter Marks id to delete");
				int mid=sc.nextInt();
				marksDao.DeleteDataFromMarks(mid);
				break;
			case 3:
				PaperDao paperDao = new PaperDao();
				System.out.println("Enter Paper id to delete");
				int pid=sc.nextInt();
				paperDao.DeleteDataFromPaper(pid);
				break;
			case 4:
				TeacherDao teacherDao = new TeacherDao();
				System.out.println("Enter Teacher id to delete");
				int tid=sc.nextInt();
				teacherDao.DeleteDataFromTeacher(tid);
				break;
			case 5:
				PreviousYearPaperDao previousYearPaperDao= new PreviousYearPaperDao();
				System.out.println("Enter Previous Year Paper id to delete");
				int ppid=sc.nextInt();
				previousYearPaperDao.DeleteDataFromPreviousYearPaper(ppid);
				break;

			default:
				System.out.println("Wrong input ");
				break;
			}
			
			System.out.println("Do you want delete something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}while(ans=='y' || ans=='Y');	
	}
	public void Update()
	{
		char ans ;
		do
		{
			
			System.out.println("Choose from below to delete an operation from");
			System.out.println("1) To Update a Student");
			System.out.println("2) To Update a Marks");
			System.out.println("3) To Update a Paper");
			System.out.println("4) To Update a Teachers");
			System.out.println("5) To Update a Previous Year Paper");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentDao studentDao= new StudentDao();
				System.out.println("Enter the id that you want to update");
				int id1=sc.nextInt();
				studentDao.UpdateDataIntoStudent(id1);
				break;
			case 2:
				MarksDao marksDao= new MarksDao();
				System.out.println("Enter the id that you want to update");
				int id2=sc.nextInt();
				marksDao.UpdateDataIntoMarks(id2);
				break;
			case 3:
				PaperDao paperDao= new PaperDao();
				System.out.println("Enter the id that you want to update");
				int id3=sc.nextInt();
				paperDao.UpdateDataIntoPaper(id3);
				break;
			case 4:
				TeacherDao teacherDao = new TeacherDao();
				System.out.println("Enter the id that you want to update");
				int id=sc.nextInt();
				teacherDao.UpdateDataIntoTeacher(id);
				break;
			
			case 5:
				PreviousYearPaperDao previousYearPaperDao=new PreviousYearPaperDao();
				System.out.println("Enter the id that you want to update");
				int id4=sc.nextInt();
				previousYearPaperDao.UpdateDataIntoPreviousYearPaper(id4);
				break;

			default:
				System.err.println("Wrong Input");
				break;
			}		
			System.out.println("Do you want Update Something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}while(ans=='y' || ans=='Y');		
	}
	public void Display()
	{
		char ans ;
		do
		{
			System.out.println("Choose from below to display an operation from");
			System.out.println("1) To Display the Student Table");
			System.out.println("2) To DIsplay the Marks Table");
			System.out.println("3) To Display the Paper Table");
			System.out.println("4) To Display the Teachers Table");
			System.out.println("4) To Display the Previous Year Pape Table");
			
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentDao studentDao = new StudentDao();
				studentDao.DisplayDataFromStudent();
				break;
			case 2:
				MarksDao marksDao= new MarksDao();
				marksDao.DisplayDataFromMarks();
				break;
			case 3:
				PaperDao paperDao = new PaperDao();
				paperDao.DisplayDataFromPaper();
				break;
			case 4:
				TeacherDao teacherDao=new TeacherDao();
				teacherDao.DisplayDataFromTeacher();
				break;
			case 5:
				PreviousYearPaperDao previousYearPaperDao = new PreviousYearPaperDao();
				previousYearPaperDao.DisplayDataFromPreviousYearPaper();
				break;

			default:
				System.err.println("Wrong Input");
				break;
			}	
			
			System.out.println("Do you want Display something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}while(ans=='y' || ans=='Y');
	}
	public void customized()
	{
		char ans ;
		do
		{
			System.out.println("Choose from below to Display customize Table From ");
			System.out.println("1) Student Table");
			System.out.println("2) Teachers Table");
			int choice=sc.nextInt();
			switch (choice) 
			{
			case 1:
				StudentDao studentDao= new StudentDao();
				studentDao.CustomizedListOfStudent();
				break;
			case 2:
				TeacherDao teacherDao=new TeacherDao();
				teacherDao.CustomizedListOfTeacher();
				break;

			default:
				System.err.println("Wrong Input");
				break;
			}
			System.out.println("Do you want Display Something else (Y/N)");
			ans=sc.next().charAt(0);
			
		}while(ans=='y' || ans=='Y');
	}
	
	public void Operations() 
	{
		char ans ;
		do
		{	
			System.out.println("Choose From Below");
			System.out.println("1) To insert the new data");
			System.out.println("2) To delete the data");
			System.out.println("3) To Update the new data");
			System.out.println("4) To display the Entire Table");
			System.out.println("5) To display the Customize Table");
			int choice=sc.nextInt();
			
			switch (choice) 
			{
			case 1:
				System.out.println("\n1)insert into Students and marks table");
				System.out.println("2)insert into teachers and paper table");
				int choose=sc.nextInt();
				switch (choose) 
				{
				case 1:
					insertDataStudentMakrs();
					break;
				case 2:
					insertTeacherPaper();
					break;

				default:
					System.err.println("Wrong Input");
					break;
				}
				break;
			case 2:
				delete();
				break;
			case 3:
				Update();
				break;
			case 4:
				Display();
				break;
			case 5:
				customized();
				break;

			default:
				break;
			}
			System.out.println("Do you want perform anything else from Main Menu (Y/N)");
			ans=sc.next().charAt(0);
			
		}
		while(ans=='y' || ans=='Y');
		
	}
	public static void main( String[] args )
    {
        System.out.println( "*******Welcome To Exam Portal**********");
        System.out.println("********Let's Learn Together************");
        App app=new App();
        app.Operations();
    }
}
