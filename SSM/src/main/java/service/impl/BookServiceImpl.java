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

//	ע��Dao����
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
//			�����
			int update = bookDao.reduceNumber(bookId);
			if(update <= 0) {//��治��
				throw new NoNumberException("no number");
			}else {
				//ִ��ԤԼ����
				int insert = appointmentDao.insertAppointment(bookId, studentId);
				if(insert <= 0) {//�ظ�ԤԼ
					throw new RepeatAppointException("repeat appoint");
				}else {//ԤԼ�ɹ�
					Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
					return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
				}
			}
		}catch(NoNumberException e) {
			throw e;
		}catch(RepeatAppointException e) {
			throw e;
		}catch(Exception e) {
//			���б������쳣ת��Ϊ�������쳣
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}

}
