## Mybatis核心
### Mybatis配置文件
+ SqlMapConfig
主配置文件，用于指定数据库连接参数和框架参数，1个
+ SqlMap.xml
映射定义文件，用于定义SQL语句和映射信息，n个

### 操作参考
```java
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
//		创建SessionFactory对象
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
//		创建session
		SqlSession session = sf.openSession();
		System.out.println(session);
		
//		关闭session
		session.close();
```

### SqlMapConfig.xml参考
```xml
<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE configuration PUBLIC "-//ibatis.apache.org//DTD Config 3.0//EN" 
	"http://ibatis.apache.org/dtd/ibatis-3-config.dtd">
<configuration>
	<environments default="environment">
		<environment id="environment">
			<transactionManager type="JDBC"></transactionManager>
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.jdbc.Driver"/>
				<property name="url" value="jdbc:mysql://localhost:3306/test?useSSL=false&amp;serverTimezone=CTT&amp;characterEncoding=UTF-8"/>
				<property name="username" value="root"/>
				<property name="password" value="123456"/>
			</dataSource>
		</environment>
	</environments>
	<mappers>
		<mapper resource="entity/Dept.xml"/>
	</mappers>
</configuration>
```

### SqlMap.xml参考
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN"      
 "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
 <mapper namespace="entity.DeptMapper">
	 <insert id="addDept" parameterType="entity.Dept">
	 	INSERT INTO t_dept(deptno, dname, loc) 
	 	VALUES (#{deptno}, #{dname}, #{loc})
	 </insert>
	 
	 <update id="updateDept" parameterType="entity.Dept">
	 	UPDATE t_dept SET dname = #{dname}, loc = #{loc} WHERE deptno = #{deptno}
	 </update>
	 
	 <select id="findById" parameterType="int" resultType="entity.Dept">
	 	SELECT deptno, dname, loc FROM t_dept WHERE deptno = #{deptno}
	 </select>
	 
	 <delete id="deleteById" parameterType="int">
	 	DELETE FROM t_dept WHERE deptno = #{deptno}
	 </delete>
	 
	 <select id="findAll" resultType="entity.Dept">
	 	SELECT deptno, dname, loc from t_dept
	 </select>
	 
	 <!-- 返回Map -->
	 <select id="findDept" parameterType="int" resultType="java.util.HashMap">
	 	SELECT deptno, dname, loc FROM t_dept WHERE deptno = #{deptno}
	 </select>
	 
	 <select id="findDepts" resultType="java.util.HashMap">
	 	SELECT deptno, dname, loc FROM t_dept
	 </select>
	 
	 <!-- ResultMap应用 --> 
	 <resultMap id="deptMap" type="entity.Dept1">
	 	<result property="no" column="deptno" jdbcType="INTEGER" javaType="int"/>
	 	<result property="name" column="dname" jdbcType="VARCHAR" javaType="string"/>
	 	<result property="loc" column="loc" jdbcType="VARCHAR" javaType="string"/>
	 </resultMap>
	 
	 <select id="findAll1" resultMap="deptMap">
	 	SELECT deptno, dname, loc from t_dept
	 </select>
 </mapper>
 
```
