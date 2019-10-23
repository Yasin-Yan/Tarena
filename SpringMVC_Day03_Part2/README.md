## springMVC基于注解配置
### spring-mvc.xml
```xml
	<context:component-scan base-package="controller"></context:component-scan>
	<mvc:annotation-driven></mvc:annotation-driven>
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>
```
