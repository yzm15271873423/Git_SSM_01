<%--
  Created by IntelliJ IDEA.
  User: yzm
  Date: 2021/5/23
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    
    <script>
        $(function () {
            $.ajax({
                type:"post",
                data:'{"name":"张三","birthday":"2021-5-23"}',
                url:"dataformat.action",
                contentType:"application/json",
                success:function (result) {
                    console.log(result)
                }
            })
        })
        
    </script>
</head>
<body>

</body>
</html>
