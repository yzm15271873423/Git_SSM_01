<%--
  Created by IntelliJ IDEA.
  User: yzm
  Date: 2021/5/21
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #playerTable{
            width: 50%;
            border: 3px solid cadetblue;
            margin: 0px auto;
            text-align: center;
        }
        #playerTable th,td{
            border: 1px solid gray;
        }
        #playerTable img{
            width: 100px;
            height: 100px;
        }
    </style>
    <script type="text/javascript" src="js/jquery.min.js"></script>

    <script>
        $(function () {
            $.ajax({
                type:"get",
                url:"getAllPlayer",
                success:function (players) {
                    $.each(players,function (i, e) {
                        $("#playerTable").append('<tr>\n' +
                            '            <th>'+e.id+'</th>\n' +
                            '            <th>'+e.name+'</th>\n' +
                            '            <th>'+e.password+'</th>\n' +
                            '            <th>'+e.nickname+'</th>\n' +
                            '            <th>\n' +
                            '                <img src="http://127.0.0.1:8090/upload/'+e.photo+'" alt="" src>\n' +
                            '            </th>\n' +
                            '            <th>\n' +
                            '                <a href="fileDownload.do?photo='+e.photo+'&filetype='+e.filetype+'">下载</a>\n' +
                            '            </th>\n' +
                            '        </tr>')
                    })
                }
            })
        })



    </script>
</head>
<body>
    <table id="playerTable" cellspacing="0xp" cellpadding="0px">
        <tr>
        <th>编号</th>
        <th>账号</th>
        <th>密码</th>
        <th>昵称</th>
        <th>头像</th>
        <th>操作</th>
        </tr>


    </table>
</body>
</html>
