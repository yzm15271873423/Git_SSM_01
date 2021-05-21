<%--
  Created by IntelliJ IDEA.
  User: yzm
  Date: 2021/5/20
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .progress {
            width: 400px;
            height: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin: 10px 0px;
            overflow: hidden;
        }
        /* 初始状态设置进度条宽度为0px */
        .progress > div {
            width: 0px;
            height: 100%;
            background-color: yellowgreen;
            transition: all .3s ease;
        }
    </style>


    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#uploadFile").click(function () {
                //获得想要上传的文件
                var photoFile=$("#photo")[0].files[0]

                if(photoFile==undefined){
                    alert("还未选择图片")
                    return;
                }

                //将文件装入formdata对象
                var formData = new FormData()
                formData.append("headPhoto",photoFile)
                //异步请求发送数据至服务器
                $.ajax({
                    type:"post",
                    data:formData,
                    url:"fileUpload",
                    processData:false,
                    contentType:false,
                    success:function (result) {
                        alert(result.message)
                        //照片回显
                        $("#headImg").attr("src","http://127.0.0.1:8090/upload/"+result.newName);
                        $("#inputphoto").val(result.newName)
                        $("#phototype").val(result.filetype)
                    },
                    xhr: function() {
                        var xhr = new XMLHttpRequest();
                        //使用XMLHttpRequest.upload监听上传过程，注册progress事件，打印回调函数中的event事件
                        xhr.upload.addEventListener('progress', function (e) {
                            console.log(e);
                            //loaded代表上传了多少
                            //total代表总数为多少
                            var progressRate = (e.loaded / e.total) * 100 + '%';

                            //通过设置进度条的宽度达到效果
                            $('.progress > div').css('width', progressRate);
                        })

                        return xhr;
                    }

                })


            })

        })


    </script>

</head>
<body>
    <form action="addPlayer" mehtod="get">
        <p>账号：<input type="text" name="name"></p>
        <p>密码：<input type="text" name="password"></p>
        <p>昵称：<input type="text" name="nickname"></p>
        <p>头像：
            <br/>
            <input id="photo" type="file">
            <br>
            <img id="headImg" style="width: 400px ;height: 200px" alt="你还未上传照片">
            <br>
            <div class="progress">
                <div></div>
            </div>
            <br>
            <a id="uploadFile" href="javascript:void(0)">立即上传</a>
            <input id="inputphoto" type="hidden" name="photo">
            <input id="phototype" type="hidden" name="filetype">

        </p>
        <p><input type="submit" value="注册"></p>

    </form>
</body>
</html>
