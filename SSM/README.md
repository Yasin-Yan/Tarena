### 业务说明
实体分为图书和预约行为，主要介绍预约流程，预约时接收图书编号和学生编号，根据图书编号更新图书数量，使其减少一本，更新失败返回库存不足信息；
更新成功则将学生编号，图书编号存入预约表，插入失败则返回重复预约信息；插入成功则返回预约成功信息。

### 编码规范
+ 将spring配置文件分为spring-dao、spring-service、spring-web,spring-dao整合spring和mybatis,spring-service负责组件扫描、事务管理，spring-web实现映射
相关组件和视图解析

+ 项目分为enums、exceptions、entity、dao、dto、service、service.impl、web，enums枚举类储存状态信息，exceptions定制异常，dto数据传输对象，service服务接口，
service.impl实现服务接口

### 知识点
+ Mybatis全局配置文件
```xml
<configuration>
	<!-- 配置全局属性 -->
	<settings>
		<!-- 使用jdbc的getGenerateKeys获取数据库自增主键 -->
		<setting name="useGeneratedKeys" value="true"/>
		
		<!-- 使用列别名替换 -->
		<setting name="useColumnLabel" value="true"/>
		
		<!-- 开启驼峰命名转换:Table(create_time) -> Entity(createTime)-->
		<setting name="mapUnderscoreToCamelCase" value="true"/>
	</settings>
</configuration>
```

+ spring-dao
```xml
	<!-- 配置整合mybatis过程 -->
	<!-- 1.配置数据库相关参数properties的属性:${url} -->
	<context:property-placeholder location="classpath:jdbc.properties"/>
	
	<!-- 2.数据库连接池 -->
	<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<!-- 配置连接池属性 -->
		<property name="driverClass" value="${jdbc.driver}"></property>
		<property name="jdbcUrl" value="${jdbc.url}"></property>
		<property name="user" value="${jdbc.username}"></property>
		<property name="password" value="${jdbc.password}"></property>
		
		<!-- c3p0连接池的私有属性 -->
		<property name="maxPoolSize" value="30"></property>
		<property name="minPoolSize" value="10"></property>
		<!-- 关闭后不自动commit -->
		<property name="autoCommitOnClose" value="false"></property>
		<!-- 确定连接超时时间 -->
		<property name="checkoutTimeout" value="10000"></property>
		<!-- 当获取连接失败重试次数 -->
		<property name="acquireRetryAttempts" value="2"></property>
	</bean>
	
	<!-- 3.配置SqlSessionFactory对象 -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<!-- 注入数据库连接池 -->
		<property name="dataSource" ref="dataSource"></property>
		<!-- 配置MyBatis全局配置文件: mybatis-config.xml -->
		<property name="configLocation" value="classpath:mybatis-config.xml"></property>
		<!-- 扫描entity包使用别名 -->
		<property name="typeAliasesPackage" value="entity"></property>
		<property name="mapperLocations" value="classpath:mapper/*.xml"></property>
	</bean>
	
	<!-- 4.配置扫描Dao接口, 动态实现Dao接口, 注入到spring容器 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<!-- 注入sqlSessionFactory -->
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
		<!-- 给出需要扫描Dao接口包 -->
		<property name="basePackage" value="dao"></property>
	</bean>
</beans>
```

+ spring-service
```xml
	<!-- 组件扫描 -->
	<context:component-scan base-package="service,web"></context:component-scan>
	
	<!-- 配置事务管理器 -->
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<!-- 注入数据库连接池 -->
		<property name="dataSource" ref="dataSource"></property>
	</bean>
	
	<!-- 配置基于注解的声明式事务 -->
	<tx:annotation-driven transaction-manager="transactionManager"/>
```

+ spring-web
```xml
	<!-- SpringMVC注解 -->
	<mvc:annotation-driven/>
	
	<!-- 静态资源默认servlet配置
		1.加入对静态资源的处理：js,gif,png...
		2.允许使用/做整体映射
	 -->
	 <mvc:default-servlet-handler/>
	 
	 <!-- 配置视图解析器 -->
	 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 	<property name="prefix" value="/WEB-INF/jsp/"></property>
	 	<property name="suffix" value=".jsp"></property>
	 </bean>
```

### 注解使用
+ Mybatis注解
``` java
public List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
```

+ spring-mvc注解
```java
	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model) {
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}

	// ajax json
	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
			"application/json; charset=utf-8" })
	@ResponseBody
	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
		if (studentId == null || studentId.equals("")) {
			return new Result<>(false, "学号不能为空");
		}
		AppointExecution execution = null;
		try {
			execution = bookService.appoint(bookId, studentId);
		} catch (NoNumberException e1) {
			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (Exception e) {
			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new Result<AppointExecution>(true, execution);
	}
  
```

### 测试后台示例

