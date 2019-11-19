<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="base" value="/"></c:url>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
	<meta charset="UTF-8">
	<title>emp_list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="${base}bootstrap-4.3.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet"> -->
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="${base}js/jquery-3.3.1.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="${base}js/popper.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="${base}bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
    	.table th, td{
    		text-align: center;
    	}
/*     	#row{
    		height: 600px;
    		overflow: scroll;
    		border: 1px solid pink;
    	} */
    </style>
</head>
<body>
	<div class="container">
		<div class="row" id="row">
			<table class="table">
				<caption>员工基本信息</caption>
				<thead>
					<tr>
					<td><button class="btn-sm btn-success" data-toggle="modal" data-target="#myModal2" onclick="fillModal2()">新增</button></td>
						<td>员工编号</td>
						<td>员工姓名</td>
						<td>职位</td>
						<td>薪水</td>
						<td>津贴</td>
						<td>经理编号</td>
						<td>雇佣日期</td>
						<td>部门编号</td>
						<td>操作1</td>
						<td>操作2</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="emp" varStatus="s">
						<tr>
							<td>${s.index + 1 }</td>
							<td>${emp.id }</td>
							<td>${emp.name }</td>
							<td>${emp.job }</td>
							<td>${emp.salary }</td>
							<td>${emp.comm }</td>
							<td>${emp.mgr }</td>
							<td>${emp.hiredate }</td>
							<td>${emp.deptno }</td>	
							<td><button class="btn-sm btn-info" data-toggle="modal" data-target="#myModal1" 
							onclick="fillModal1(${emp.id }, '${emp.name }', '${emp.job }', ${emp.salary }, ${emp.comm }, ${emp.mgr },
							'${emp.hiredate }', ${emp.deptno })">修改</button></td>
							<td><button class="btn-sm btn-danger" onclick="window.location.href='delete.do?id=${emp.id}'">删除</button></td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>			
		</div>

		<!-- 模态框 -->
		<div class="modal fade" id="myModal1">
		  <div class="modal-dialog">
		    <div class="modal-content">
		 
		      <!-- 模态框头部 -->
		      <div class="modal-header">
		        <h4 class="modal-title">修改员工信息</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		 
		      <!-- 模态框主体 -->
		      <form action="modify.do">
			      <div class="modal-body">  
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">员工编号</span>
						</div>
						<input type="text" class="form-control" placeholder="员工编号" name="id">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">员工姓名</span>
						</div>
						<input type="text" class="form-control" placeholder="员工姓名" name="name">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">职位</span>
						</div>
						<input type="text" class="form-control" placeholder="职位" name="job">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">薪水</span>
						</div>
						<input type="text" class="form-control" placeholder="薪水" name="salary">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">津贴</span>
						</div>
						<input type="text" class="form-control" placeholder="津贴" name="comm">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">经理编号</span>
						</div>
						<input type="text" class="form-control" placeholder="经理编号" name="mgr">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">雇佣日期</span>
						</div>
						<input type="text" class="form-control" placeholder="雇佣日期" name="hiredate">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">部门编号</span>
						</div>
						<input type="text" class="form-control" placeholder="部门编号" name="deptno">
					</div>				      	    				      				      				      				
			      </div>
			 
			      <!-- 模态框底部 -->
			      <div class="modal-footer">
			      	<input type="submit" value="提交" class="btn btn-primary">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
			      </div>
		 	  </form>
		    </div>
		  </div>
		</div>
		
		<!-- 模态框 -->
		<div class="modal fade" id="myModal2">
		  <div class="modal-dialog">
		    <div class="modal-content">
		 
		      <!-- 模态框头部 -->
		      <div class="modal-header">
		        <h4 class="modal-title">新增员工信息</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		 
		      <!-- 模态框主体 -->
		      <form action="addEmp.do">
			      <div class="modal-body">  
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">员工编号</span>
						</div>
						<input type="text" class="form-control" placeholder="员工编号" name="id">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">员工姓名</span>
						</div>
						<input type="text" class="form-control" placeholder="员工姓名" name="name">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">职位</span>
						</div>
						<input type="text" class="form-control" placeholder="职位" name="job">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">薪水</span>
						</div>
						<input type="text" class="form-control" placeholder="薪水" name="salary">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">津贴</span>
						</div>
						<input type="text" class="form-control" placeholder="津贴" name="comm">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">经理编号</span>
						</div>
						<input type="text" class="form-control" placeholder="经理编号" name="mgr">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">雇佣日期</span>
						</div>
						<input type="text" class="form-control" placeholder="雇佣日期" name="hiredate">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">部门编号</span>
						</div>
						<input type="text" class="form-control" placeholder="部门编号" name="deptno">
					</div>				      	    				      				      				      				
			      </div>
			 
			      <!-- 模态框底部 -->
			      <div class="modal-footer">
			      	<input type="submit" value="提交" class="btn btn-primary">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
			      </div>
		 	  </form>
		    </div>
		  </div>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	function fillModal1(id, name, job, salary, comm, mgr, hiredate, deptno) {
/* 		console.log(id);
		console.log(name);
		console.log(job);
		console.log(salary);
		console.log(comm);
		console.log(mgr);
		console.log(hiredate);
		console.log(deptno); */
		$("#myModal1 input[name='id']").attr("value", id); 
		$("#myModal1 input[name='name']").attr("value", name); 
		$("#myModal1 input[name='job']").attr("value", job); 
		$("#myModal1 input[name='salary']").attr("value", salary); 
		$("#myModal1 input[name='comm']").attr("value", comm); 
		$("#myModal1 input[name='mgr']").attr("value", mgr); 
		$("#myModal1 input[name='hiredate']").attr("value", hiredate); 
		$("#myModal1 input[name='deptno']").attr("value", deptno); 
	}
	
	function fillModal2(){
		$.ajax({
			type: "POST",
			dataType: "JSON",
			url: "generateInfo.do",
			success: function(data){
				$("#myModal2 input[name='id']").attr("value", data.id);
				$("#myModal2 input[name='mgr']").attr("value", data.mgr);
				$("#myModal2 input[name='salary']").attr("value", data.salary);
				$("#myModal2 input[name='comm']").attr("value", data.comm);
				$("#myModal2 input[name='deptno']").attr("value", data.deptno);
			},
			error: function(e){
				console.log("fail");
			}
		});
	}
</script>
</html>