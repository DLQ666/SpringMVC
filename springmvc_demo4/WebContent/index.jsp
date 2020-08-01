<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/index_like.css" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {
	    $("#btn").click(function () {
			$.ajax({
				url:"testJson",
				type:"POST",
				dataType:"json",
				success:function (msg){
					/* for ( var i in msg) {
						var emp = msg[i];
						alert("id="+emp.id+",lastName="+emp.lastName+",departmentName="+emp.department.departmentName)
					} */
					//第一种实现方式
					/* var tb = "<table>";
					tb+="<tr><th>id</th><th>lastName</th><th>email</th><th>gender</th><th>department</th></tr>"
						for ( var i in msg) {
	                        var emp = msg[i];
	                        tb+="<tr><td>"+emp.id+"</td><td>"+emp.lastName+"</td><td>"+emp.email+"</td><td>"+emp.gender+"</td><td>"+emp.department.departmentName+"</td></tr>"
	                    }
					tb += "</table>";
					$("body").append(tb); */
					//第二种实现方式
					$("body").append("<table></table>");
					$("table").append("<tr><th>id</th><th>lastName</th><th>email</th><th>gender</th><th>department</th></tr>");
					for ( var i in msg) {
                        var emp = msg[i];
                        $("table").append("<tr><td>"+emp.id+"</td><td>"+emp.lastName+"</td><td>"+emp.email+"</td><td>"+emp.gender+"</td><td>"+emp.department.departmentName+"</td></tr>");
                    }
				}
			})
		})
	})
</script>
</head>
<body>

    <input id="btn" type="button"  value="测试ajax"/>

    <a href="testJson">测试testJson</a>

</body>
</html>