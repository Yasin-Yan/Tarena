package service;

import java.util.List;

import dto.AppointExecution;
import entity.Book;

/**
 * ҵ��ӿ�
 */
public interface BookService {
	/**
	 * ��ѯһ��ͼ��
	 * @param bookId
	 * @return
	 */
	public Book getById(long bookId);
	
	/**
	 * ��ѯ����ͼ��
	 * @return
	 */
	public List<Book> getList();
	
	/**
	 * ԤԼͼ��
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	public AppointExecution appoint(long bookId, long studentId);
}
