<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function test() {
		$.ajax({
            url:"testAjax_DELETE",
            type:"DELETE",
            data:{id:1001},
            dataType:"JSON",
            success:function(obj){
            	alert(obj);
            }
        })
	}
</script>
</head>
<body>

	<a href="testREST/1001">测试GET请求</a>
	<br />
	<form action="testREST" method="POST">
		<input type="submit" value="测试POST">
	</form>

	<br />
	<form action="testREST" method="POST">
	       <input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="测试PUT">
	</form>
	
	<br />
    <form action="testREST/1001" method="POST">
           <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" value="测试DELETE">
    </form>
    
    <input type="button" value="测试AJAX" onclick="test()"/>
</body>
</html>