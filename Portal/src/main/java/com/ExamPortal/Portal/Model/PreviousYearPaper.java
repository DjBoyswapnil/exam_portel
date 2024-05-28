package com.ExamPortal.Portal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PreviousYearPaper")
public class PreviousYearPaper 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 120)
	private int PerviousPaperId;
	@Column(length = 50)
	private String BoardName;
	public PreviousYearPaper(int perviousPaperId, String boardName, int paperYear, String paperSubject) {
		super();
		PerviousPaperId = perviousPaperId;
		BoardName = boardName;
		PaperYear = paperYear;
		PaperSubject = paperSubject;
	}
	@Override
	public String toString() {
		return "PreviousYearPaper [PerviousPaperId=" + PerviousPaperId + ", BoardName=" + BoardName + ", PaperYear="
				+ PaperYear + ", PaperSubject=" + PaperSubject + "]";
	}
	public PreviousYearPaper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPerviousPaperId() {
		return PerviousPaperId;
	}
	public void setPerviousPaperId(int perviousPaperId) {
		PerviousPaperId = perviousPaperId;
	}
	public String getBoardName() {
		return BoardName;
	}
	public void setBoardName(String boardName) {
		BoardName = boardName;
	}
	public int getPaperYear() {
		return PaperYear;
	}
	public void setPaperYear(int paperYear) {
		PaperYear = paperYear;
	}
	public String getPaperSubject() {
		return PaperSubject;
	}
	public void setPaperSubject(String paperSubject) {
		PaperSubject = paperSubject;
	}
	@Column(length = 50)
	private int PaperYear;
	@Column(length = 40)
	private String PaperSubject;
}
