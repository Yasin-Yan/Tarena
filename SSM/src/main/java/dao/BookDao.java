package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Book;

public interface BookDao {
	
	/**
	 * ͨ��ID��ѯ����ͼ��
	 * @param id
	 * @return
	 */
	public Book queryById(long id); 
	
	/**
	 * ��ѯ����ͼ��
	 * @param offset ��ѯ��ʼλ��
	 * @param limit	 ��ѯ����
	 * @return
	 */
	public List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * ���ٹݲ���
	 * @param bookId
	 * @return ���Ӱ������>=1,��ʾ���µļ�¼����
	 */
	public int reduceNumber(long bookId);
	
}
