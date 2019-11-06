## Spring + MyBatis

+ **通过spring的SqlSessionFactoryBean和MapperFactoryBean**
``` xml
	<beans:bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<beans:property name="driverClassName" value="com.mysql.jdbc.Driver"></beans:property>
		<beans:property name="url" value="jdbc:mysql://localhost:3306/test?useSSL=false&amp;serverTimezone=CTT&amp;characterEncoding=UTF-8"></beans:property>
		<beans:property name="username" value="root"></beans:property>
		<beans:property name="password" value="123456"></beans:property>
	</beans:bean>
	
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="myDataSource"></property>
		<property name="mapperLocations" value="classpath:entity/*.xml"></property>
	</bean>
	
	<!-- 定义Mapper -->
	<bean id="deptMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
		<property name="mapperInterface" value="mapper.DeptMapper"></property>
		<property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
	</bean>
```

+ **通过MapperScannerConfigurer扫描mapper接口自动生成MapperFactoryBean对象**
``` xml
	<beans:bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<beans:property name="driverClassName" value="com.mysql.jdbc.Driver"></beans:property>
		<beans:property name="url" value="jdbc:mysql://localhost:3306/test?useSSL=false&amp;serverTimezone=CTT&amp;characterEncoding=UTF-8"></beans:property>
		<beans:property name="username" value="root"></beans:property>
		<beans:property name="password" value="123456"></beans:property>
	</beans:bean>
	
	<bean id="sqlSessionFactory1" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="myDataSource"></property>
		<property name="mapperLocations" value="classpath:entity/*.xml"></property>
	</bean>
	
	<!-- Mapper扫描 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="mapper"></property>
	</bean>	
```

+ **通过MapperScannerConfigurer将带有指定注解标记的mapper接口扫描为MapperFactoryBean对象**
1. 配置
``` xml
	<beans:bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<beans:property name="driverClassName" value="com.mysql.jdbc.Driver"></beans:property>
		<beans:property name="url" value="jdbc:mysql://localhost:3306/test?useSSL=false&amp;serverTimezone=CTT&amp;characterEncoding=UTF-8"></beans:property>
		<beans:property name="username" value="root"></beans:property>
		<beans:property name="password" value="123456"></beans:property>
	</beans:bean>
	
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="myDataSource"></property>
		<property name="mapperLocations" value="classpath:entity/*.xml"></property>
	</bean>
	
	<!-- 按指定包和注解扫描标记Mapper -->	
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
		<property name="basePackage" value="mapper, entity"></property>
		<property name="annotationClass" value="annotation.MyBatisRepository"></property>
	</bean>	
```
2. 指定注解构造
```java
@Repository
public @interface MyBatisRepository {
	String value() default "";
}
```

+ **通过SqlSessionTemplate**
1. 指定注入的DAO
``` java
@Repository
public class MyBatisDeptDAO implements DeptDAO{
	
	private SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		List<Dept> list = template.selectList("findAll");
		return list;
	}

}
```
2. 配置
``` xml
	<beans:bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<beans:property name="driverClassName" value="com.mysql.jdbc.Driver"></beans:property>
		<beans:property name="url" value="jdbc:mysql://localhost:3306/test?useSSL=false&amp;serverTimezone=CTT&amp;characterEncoding=UTF-8"></beans:property>
		<beans:property name="username" value="root"></beans:property>
		<beans:property name="password" value="123456"></beans:property>
	</beans:bean>

	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="myDataSource"></property>
		<property name="mapperLocations" value="classpath:entity/*.xml"></property>
	</bean>
		
	<!-- 定义SqlSessionTemplate -->
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory"></constructor-arg>
	</bean>
	
	<!-- 扫描DAO并注入template -->
	<context:component-scan base-package="dao"></context:component-scan>
```



