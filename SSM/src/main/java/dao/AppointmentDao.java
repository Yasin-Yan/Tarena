package dao;

import org.apache.ibatis.annotations.Param;

import entity.Appointment;

public interface AppointmentDao {
	/**
	 * ����ԤԼͼ���¼
	 * @param bookId
	 * @param studentId
	 * @return ����ĺ���
	 */
	public int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);
	
	/**
	 * ͨ��������ѯԤԼͼ���¼������Я��ͼ��ʵ��
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	public Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
	
	
}
