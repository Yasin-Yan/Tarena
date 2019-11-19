package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AppointmentDao;
import dao.BookDao;
import dto.AppointExecution;
import entity.Appointment;
import entity.Book;
import enums.AppointStateEnum;
import exception.AppointException;
import exception.NoNumberException;
import exception.RepeatAppointException;
import service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	注入Dao依赖
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Book getById(long bookId) {
		// TODO Auto-generated method stub
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return bookDao.queryAll(0, 1000);
	}

	@Override
	public AppointExecution appoint(long bookId, long studentId) {
		try {
//			减库存
			int update = bookDao.reduceNumber(bookId);
			if(update <= 0) {//库存不足
				throw new NoNumberException("no number");
			}else {
				//执行预约操作
				int insert = appointmentDao.insertAppointment(bookId, studentId);
				if(insert <= 0) {//重复预约
					throw new RepeatAppointException("repeat appoint");
				}else {//预约成功
					Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
					return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
				}
			}
		}catch(NoNumberException e) {
			throw e;
		}catch(RepeatAppointException e) {
			throw e;
		}catch(Exception e) {
//			所有编译器异常转换为运行期异常
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}

}
