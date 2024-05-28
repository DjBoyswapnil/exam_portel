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
@Table(name="Teacher")
public class Teacher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 150)
	private int TeacherId;
	@Column(length = 60)
	private String TeacherName;
	@Column(length = 20)
	private int TeacherAge;
	@Column(length = 50)
	private String TeacherPassword;
	
	@Override
	public String toString() {
		return "Teacher [TeacherId=" + TeacherId + ", TeacherName=" + TeacherName + ", TeacherAge=" + TeacherAge
				+ ", TeacherPassword=" + TeacherPassword + ", paper=" + paper + "]";
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int teacherId, String teacherName, int teacherAge, String teacherPassword, Paper paper) {
		super();
		TeacherId = teacherId;
		TeacherName = teacherName;
		TeacherAge = teacherAge;
		TeacherPassword = teacherPassword;
		this.paper = paper;
	}

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public int getTeacherAge() {
		return TeacherAge;
	}

	public void setTeacherAge(int teacherAge) {
		TeacherAge = teacherAge;
	}

	public String getTeacherPassword() {
		return TeacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		TeacherPassword = teacherPassword;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	@OneToOne
	@JoinColumn(name = "PaperId")
	private Paper paper;
}
