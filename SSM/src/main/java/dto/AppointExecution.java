package dto;

import entity.Appointment;
import enums.AppointStateEnum;

/**
 * ��װԤԼִ�к���
 */
public class AppointExecution {
	
	private long bookId;
	
//	��ɱԤԼ���״̬
	private int state;
	
//	״̬��ʶ
	private String stateInfo;
	
//	ԤԼ�ɹ�����
	private Appointment appointment;
	
	public AppointExecution() {
		// TODO Auto-generated constructor stub
	}
	
//	ԤԼʧ�ܵĹ�����
	public AppointExecution(long bookId, AppointStateEnum stateEnum) {
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	
//	ԤԼ�ɹ��Ĺ�����
	public AppointExecution(long bookId, AppointStateEnum stateEnum, Appointment appointment) {
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.appointment = appointment;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "AppointExecution [bookId=" + bookId + ", state=" + state + ", stateInfo=" + stateInfo + ", appointment="
				+ appointment + "]";
	}
	
	
}
