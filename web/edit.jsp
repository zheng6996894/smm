<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改</title>
    <style type="text/css">
        form{
            width: 400px;
            height: 400px;
            border: 1px black solid;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<form action="Student" method="post" enctype="multipart/form-data">
    <input type="hidden" name="flag" value="update">
    <input type="hidden" name="sid" value="${stu.sid}">
    <h1>修改学生信息</h1>
    姓名：<input type="text" name="sname" value="${stu.sname}"/><br><br>
    年龄：<input type="text" name="sage" value="${stu.sage}"><br><br>
    性别：
    <input type="radio" name="ssex" value="男" ${stu.ssex eq '男'?'checked':''}>男
    <input type="radio" name="ssex" value="女" ${stu.ssex eq '女'?'checked':''}>女<br><br>
    邮箱：<input type="text" name="semail" value="${stu.semail}"/><br><br>
    照片：<input type="file" name="photo"/>
    <img src="http://localhost:8080/photo/${stu.photo}" width="50">
    <input type="hidden" name="oldPhoto" value="${stu.photo}">
    <br><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
