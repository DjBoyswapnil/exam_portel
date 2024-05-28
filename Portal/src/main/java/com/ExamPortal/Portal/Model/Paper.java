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
@Table(name = "Paper")
public class Paper 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 150)
	private int PaerId;
	@Column(length = 50)
	private String PaperName;
	@Column(length = 40)
	private String PaperSubject;
	@Column(length = 50)
	private String PaperType;
	
	@OneToOne(mappedBy = "paper",cascade = CascadeType.PERSIST)
	private Teacher TeacherId;

	@Override
	public String toString() {
		return "Paper [PaerId=" + PaerId + ", PaperName=" + PaperName + ", PaperSubject=" + PaperSubject
				+ ", PaperType=" + PaperType + ", TeacherId=" + TeacherId + "]";
	}

	public Paper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paper(int paerId, String paperName, String paperSubject, String paperType, Teacher teacherId) {
		super();
		PaerId = paerId;
		PaperName = paperName;
		PaperSubject = paperSubject;
		PaperType = paperType;
		TeacherId = teacherId;
	}

	public int getPaerId() {
		return PaerId;
	}

	public void setPaerId(int paerId) {
		PaerId = paerId;
	}

	public String getPaperName() {
		return PaperName;
	}

	public void setPaperName(String paperName) {
		PaperName = paperName;
	}

	public String getPaperSubject() {
		return PaperSubject;
	}

	public void setPaperSubject(String paperSubject) {
		PaperSubject = paperSubject;
	}

	public String getPaperType() {
		return PaperType;
	}

	public void setPaperType(String paperType) {
		PaperType = paperType;
	}

	public Teacher getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(Teacher teacherId) {
		TeacherId = teacherId;
	}
}
