## spring-mvc.xml配置
```xml
	<!-- 定义请求处理映射HandlerMapping -->
	<bean id="handlerMapping" class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
	<!-- 指定请求和Controller对应关系 -->
		<property name="mappings" ref="urlMappings"></property>
	</bean>
	<!-- 定义请求映射表 -->
	<util:properties id="urlMappings">
		<prop key="/hello.do">helloController</prop>
	</util:properties>
	<!-- 控制器bean配置 -->
	<bean id="helloController" class="controller.HelloController"/>
	<!-- 定义视图解析器ViewResolver -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>
```
