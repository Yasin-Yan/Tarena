# Spring
## XML配置
+ 获取容器、关闭容器
``` java
String config = "ApplicationContext.xml";
ApplicationContext ac = new ClassPathXmlApplication(config); //获取Spring容器
ExampleBean bean1 = ac.getBean("exampleBean", ExampleBean.class);//通过容器获取bean对象
AbstractApplicationContext ctx = (AbstractApplicationContext)ac;//ApplicationContext本身没有close方法，调用其抽象类的close方法关闭
ctx.close(); //关闭容器
```
## 组件扫描 注解的使用
+ @Component 通用组件
+ @Repositroy 持久层组件
+ @Service 服务组件
+ @Value 参数注入
+ @Autowired+@Qualifier/@Inject+@Named/@Resource 对象注入
+ @Scope("singleton")/@Scope("prototype") 将bean注解为单例/原型，默认为单例
+ @PostConstruct 初始化方法
+ @PreDestroy 销毁方法

