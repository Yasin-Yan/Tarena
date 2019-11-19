package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.AppointmentDao;
import dao.BookDao;
import dto.AppointExecution;
import entity.Appointment;
import entity.Book;
import service.BookService;

//junit启动时加载springIoC容器
@RunWith(SpringJUnit4ClassRunner.class)

//说明配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class TestCase {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private BookService bookService;
	
	@Test
	public void testQueryById() throws Exception{
		long bookId = 1000;
		Book book = bookDao.queryById(bookId);
		System.out.println(book);
	}
	
	@Test
	public void testQueryAll() throws Exception{
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
	
	@Test
	public void testReduceNumber() throws Exception{
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}
	
	@Test
	public void testInsertAppointment() throws Exception{
		long bookId = 1000;
		long studentId = 12345678910L;
		int insert = appointmentDao.insertAppointment(bookId, studentId);
		System.out.println(insert);
	}
	
	@Test
	public void testQueryByKeyWithBook() throws Exception{
		long bookId = 1000;
		long studentId = 12345678910L;
		Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
		System.out.println(appointment);
		System.out.println(appointment.getBook());
	}
	
	@Test
	public void testAppoint() throws Exception{
		long bookId = 1001;
		long studentId = 12345678913L;
		AppointExecution execution = bookService.appoint(bookId, studentId);
		System.out.println(execution);
	}
	
	
}
