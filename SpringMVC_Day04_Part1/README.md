## SpringMVC_拦截器

<hr/>

+ <p style="color:#1E90FF;">web.xml配置_处理编码问题</p>

  ```xml
    <filter>
    	<filter-name>encodingFilter</filter-name>
    	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
   	<init-param>
   		<param-name>encoding</param-name>
   		<param-value>UTF-8</param-value>
   	</init-param>
    </filter>
    <filter-mapping>
    	<filter-name>encodingFilter</filter-name>
    	<url-pattern>*.do</url-pattern>
    </filter-mapping>
  
  ```

+ <p style="color: #1E90FF;">web.xml配置_前端控制器</p>

  ```xml
    <servlet>
    	<servlet-name>springmvc</servlet-name>
    	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    	<init-param>
    		<param-name>contextConfigLocation</param-name>
    		<param-value>classpath:spring-mvc.xml</param-value>
    	</init-param>
    	<load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
      <servlet-name>springmvc</servlet-name>
      <url-pattern>*.do</url-pattern>
    </servlet-mapping>
  ```

- <p style="color: #1E90FF">spring-mvc.xml配置_拦截器</p>

  ```xml
   	<mvc:interceptors>
  <!-- 		<mvc:interceptor>
  			<mvc:mapping path="/spring/*"/>
  			<mvc:exclude-mapping path="/login/*"/>
  			<bean class="interceptor.SomeInterceptor"/>
  		</mvc:interceptor> -->
  		<mvc:interceptor>
  			<mvc:mapping path="/**"/>
  			<mvc:exclude-mapping path="/login/*"/><!-- 排除映射到登录页面的情况 -->
  			<bean class="interceptor.LoginInterceptor"/>
  		</mvc:interceptor>
  	</mvc:interceptors>
  ```

  

