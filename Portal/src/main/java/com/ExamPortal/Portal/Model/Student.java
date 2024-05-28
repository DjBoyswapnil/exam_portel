package com.ExamPortal.Portal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 150)
	private int SudentId;
	@Column(length = 60)
	private String StudentName;
	@Column(length = 20)
	private int StudentAge;
	@Column(length = 40)
	private int StudentClass;
	@Column(length = 40)
	private String StudentPassword;
	
	@Override
	public String toString() {
		return "Student [SudentId=" + SudentId + ", StudentName=" + StudentName + ", StudentAge=" + StudentAge
				+ ", StudentClass=" + StudentClass + ", StudentPassword=" + StudentPassword + ", marks=" + marks + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sudentId, String studentName, int studentAge, int studentClass, String studentPassword,
			Marks marks) {
		super();
		SudentId = sudentId;
		StudentName = studentName;
		StudentAge = studentAge;
		StudentClass = studentClass;
		StudentPassword = studentPassword;
		this.marks = marks;
	}

	public int getSudentId() {
		return SudentId;
	}

	public void setSudentId(int sudentId) {
		SudentId = sudentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public int getStudentAge() {
		return StudentAge;
	}

	public void setStudentAge(int studentAge) {
		StudentAge = studentAge;
	}

	public int getStudentClass() {
		return StudentClass;
	}

	public void setStudentClass(int studentClass) {
		StudentClass = studentClass;
	}

	public String getStudentPassword() {
		return StudentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}

	@OneToOne
	@JoinColumn(name = "MarksId")
	private Marks marks;
}
