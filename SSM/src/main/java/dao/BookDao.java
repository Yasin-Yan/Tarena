package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Book;

public interface BookDao {
	
	/**
	 * 通过ID查询单本图书
	 * @param id
	 * @return
	 */
	public Book queryById(long id); 
	
	/**
	 * 查询所有图书
	 * @param offset 查询起始位置
	 * @param limit	 查询条数
	 * @return
	 */
	public List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 减少馆藏量
	 * @param bookId
	 * @return 如果影响行数>=1,表示更新的记录行数
	 */
	public int reduceNumber(long bookId);
	
}
