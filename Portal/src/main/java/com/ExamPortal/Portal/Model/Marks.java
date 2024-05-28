package com.ExamPortal.Portal.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Marks")
public class Marks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 150)
	private int MarksId;
	@Column(length = 90)
	private int Scoore;
	@Column(length = 60)
	private String Grade;
	
	
	@Override
	public String toString() {
		return "Marks [MarksId=" + MarksId + ", Scoore=" + Scoore + ", Grade=" + Grade + ", StudentId=" + StudentId
				+ "]";
	}


	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Marks(int marksId, int scoore, String grade, Student studentId) {
		super();
		MarksId = marksId;
		Scoore = scoore;
		Grade = grade;
		StudentId = studentId;
	}


	public int getMarksId() {
		return MarksId;
	}


	public void setMarksId(int marksId) {
		MarksId = marksId;
	}


	public int getScoore() {
		return Scoore;
	}


	public void setScoore(int scoore) {
		Scoore = scoore;
	}


	public String getGrade() {
		return Grade;
	}


	public void setGrade(String grade) {
		Grade = grade;
	}


	public Student getStudentId() {
		return StudentId;
	}


	public void setStudentId(Student studentId) {
		StudentId = studentId;
	}


	@OneToOne(mappedBy = "marks",cascade = CascadeType.PERSIST)
	private Student StudentId;
}
