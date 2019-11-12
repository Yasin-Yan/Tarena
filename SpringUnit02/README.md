### Spring&MyBatis SQL动态拼接

``` xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN"      
 "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
<mapper namespace="mapper.EmpDao">
	<select id="findByDept" parameterType="entity.Condition" resultMap="EmpMap">
		SELECT * FROM t_emp
		<if test="deptno != null">
			WHERE deptno = #{deptno}
		</if>
	</select>
	
	<!-- 查询大于当前收入的员工 -->
	<select id="findBySalary" parameterType="entity.Condition" resultMap="EmpMap">
		SELECT * FROM t_emp
		<choose>
			<when test="salary > 3000">
				WHERE sal > #{salary}
			</when>
			<otherwise>
				WHERE sal > 3000
			</otherwise>
		</choose>
	</select>
	
	<!-- 查询当前部门下，大于当前收入的员工 -->
	<select id="findByDeptAndSalary" parameterType="entity.Condition" resultMap="EmpMap">
		SELECT * FROM t_emp 
		<where>
			<if test="deptno != null">
				and deptno = #{deptno}
			</if>
			<if test="salary != null">
				and sal > #{salary}
			</if>
		</where>
	</select>
	
	<update id="updateEmp" parameterType="entity.Emp">
		UPDATE t_emp
		<set>
			<if test="name != null">
				ename = #{name},
			</if>
			<if test="job != null">
				job = #{job},
			</if>
		</set>
		WHERE empno = #{id}
	</update>
	
	<!-- 使用trim代替where -->
	<select id="findByDeptAndSalary2" parameterType="entity.Condition" resultMap="EmpMap">
		SELECT * FROM t_emp
		<trim prefix="WHERE" prefixOverrides="AND | OR">
			<if test="deptno != null">
				AND deptno = #{deptno}
			</if>
			<if test="salary != null">
				AND sal > #{salary}
			</if>
		</trim>
	</select>
	
	<!-- 使用trim代替set -->
	<update id="updateEmp2" parameterType="entity.Emp">
		UPDATE t_emp 
		<trim prefix="SET" suffixOverrides=",">
			<if test="deptno != null">
				deptno = #{deptno},
			</if>
			<if test="salary != null">
				sal = #{salary},
			</if>
		</trim>
		WHERE empno = #{id}
	</update>
	
	<!-- 根据id查询员工 -->
	<select id="findByIds" parameterType="entity.Condition" resultMap="EmpMap">
		SELECT * FROM t_emp WHERE empno IN
		<foreach collection="empnos" open="(" close=")" separator="," item="id">
			#{id}
		</foreach>
	</select>
	
	
	<resultMap type="entity.Emp" id="EmpMap">
		<result property="id" column="empno" javaType="int" jdbcType="INTEGER"/>
		<result property="name" column="ename" javaType="string" jdbcType="VARCHAR"/>
		<result property="job" column="job" javaType="string" jdbcType="VARCHAR"/>
		<result property="mgr" column="mgr" javaType="int" jdbcType="INTEGER"/>
		<result property="hiredate" column="hiredate" javaType="java.sql.Date" jdbcType="DATE"/>
		<result property="salary" column="sal" javaType="double" jdbcType="NUMERIC"/>
		<result property="comm" column="comm" javaType="double" jdbcType="NUMERIC"/>
		<result property="deptno" column="deptno" javaType="int" jdbcType="INTEGER"/>	
	</resultMap>
</mapper>
```
