<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>成功</h1>
    <br />
    ${username }
    <br />
    ${requestScope.username }
    <br />
    <%=request.getAttribute("username")%>
    <br />

    <a>=================</a>
    <br />
    map：${map}
    <br />
    model：${model}
    <br />
    modelMap：${modelMap}
</body>
</html>
