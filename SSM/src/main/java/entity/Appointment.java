package entity;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable{
	private static final long serialVersionUID = 1L;
	private long bookId;
	private long studentId;
	private Date appointTime;
	
//	多对一的复合属性
	private Book book;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(long bookId, long studentId, Date appoinTime) {
		super();
		this.bookId = bookId;
		this.studentId = studentId;
		this.appointTime = appoinTime;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public Date getAppoinTime() {
		return appointTime;
	}
	public void setAppoinTime(Date appoinTime) {
		this.appointTime = appoinTime;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Appointment [bookId=" + bookId + ", studentId=" + studentId + ", appointTime=" + appointTime + "]";
	}
	
}
