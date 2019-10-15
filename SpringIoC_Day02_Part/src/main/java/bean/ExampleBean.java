package bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope("singleton")
public class ExampleBean {
	public ExampleBean() {
		System.out.println("ʵ����ExamleBean");
	}
	
	public void execute() {
		System.out.println("ִ��ExampleBean����");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("��ʼ��ExampleBean����");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("����ExampleBean����");
	}
}
