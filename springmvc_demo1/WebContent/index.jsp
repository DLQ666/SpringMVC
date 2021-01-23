<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		// ajax请求
		$("#aaa").click(function () {
			let name = $("#name").val();
			let price = $("#price").val();
			let author = $("#author").val();
			console.log(name)
			console.log(price)
			console.log(author)
			var book = {name:name,price:price,author:author};
			var bookString  = JSON.stringify(book);
			console.log(bookString)
			$.ajax({
				url: "http://localhost:8080/springmvc/hello",
				// data: "action=jQueryAjax",
				data: book,
				type: "POST",
				//contentType:"application/json",
				/*success: function (data) {
					// alert("服务器返回的数据是：" + data);
					// var jsonObj = JSON.parse(data);
					// $("#msg").html("编号："+jsonObj.id +"，姓名："+jsonObj.name);
					alert(data)
					//$("#msg").html("ajax 编号："+data.id +"，姓名："+data.name);
				},
				dataType: "json",*/
			})
		return false;
		});
	});
</script>
<body>
	<a href="hello">测试springMVC</a><br/>
		书名：<input type="text" name="name" id="name"><br/>
		价格：<input type="text" name="price" id="price"><br/>
		作者：<input type="text" name="author" id="author"><br/>
		<button id="aaa" >提交</button>
</body>
</html>
