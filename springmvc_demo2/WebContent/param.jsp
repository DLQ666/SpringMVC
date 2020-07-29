<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form action="param" method="post">
        username:<input type="text" name="username"/><br/>
        password:<input type="text" name="password" /><br/>
        age:<input type="text" name="age" /><br/>
        province:<input type="text" name="address.province" /><br/>
        city:<input type="text" name="address.city" /><br/>
        country:<input type="text" name="address.country" /><br/>
        <input type="submit" value="添加"/>
    </form>
    
</body>
</html>