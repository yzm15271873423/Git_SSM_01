<%--
  Created by IntelliJ IDEA.
  User: yzm
  Date: 2021/5/19
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    resquestScope:message:${requestScope.message},username:${requestScope.user[0].uname}<hr/>
    sessionScope:message:${sessionScope.message},username:${sessionScope.user[0].uname}<hr/>
    applicationScope:message:${applicationScope.message},username:${applicationScope.user[0].uname}<hr/>

    <%--请求参数--%>
requestParam:${param.message}<hr>
requestParam:${param.user[0].uname}
</body>
</html>
