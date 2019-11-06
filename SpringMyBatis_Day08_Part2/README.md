## Spring + SpringMVC + MyBatis

+ **web.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">
  <display-name>SpringMyBatis_Day08_Part2</display-name>
  
  <servlet>
  	<servlet-name>springmvc</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	<init-param>
  		<param-name>contextConfigLocation</param-name>
  		<param-value>classpath:applicationContext.xml</param-value>
  	</init-param>
  	<load-on-startup>1</load-on-startup>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
    
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

+ **spring配置文件**
``` xml
	<bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/mydatabase?useSSL=false&amp;serverTimezone=CTT&amp;characterEncoding=UTF-8"></property>
		<property name="username" value="root"></property>
		<property name="password" value="123456"></property>
	</bean>
	
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="myDataSource"></property>
		<property name="mapperLocations" value="classpath:entity/*.xml"></property>
	</bean>	
	
	<!-- 按指定包和注解扫描Mapper/DAO -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
		<property name="basePackage" value="dao"></property>
		<property name="annotationClass" value="annotation.MyBatisRepository"></property>
	</bean>
	
	<!-- SpringMVC -->
	<context:component-scan base-package="web"></context:component-scan>
	
	<!-- 支持@RequestMapping请求和Controller映射 -->
	<mvc:annotation-driven></mvc:annotation-driven>
	
	<!-- SpringMVC的ViewResolver -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>	
```
