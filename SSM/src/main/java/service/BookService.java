package service;

import java.util.List;

import dto.AppointExecution;
import entity.Book;

/**
 * 业务接口
 */
public interface BookService {
	/**
	 * 查询一本图书
	 * @param bookId
	 * @return
	 */
	public Book getById(long bookId);
	
	/**
	 * 查询所有图书
	 * @return
	 */
	public List<Book> getList();
	
	/**
	 * 预约图书
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	public AppointExecution appoint(long bookId, long studentId);
}
