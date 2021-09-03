<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增登记</title>
</head>
<body>
   <form action="Student" method="post" enctype="multipart/form-data">
       <input type="hidden" name="flag" value="insert">
       <h1>新增——录入</h1>
       姓名：<input type="text" name="sname"><p></p>
       年龄：<input type="text" name="sage"><p></p>
       性别：
       <input type="radio" name="ssex" value="男">男
       <input type="radio" name="ssex" value="女">女<p></p>
       邮箱：<input type="text" name="semail"><p></p>
       照片：<input type="file" name="photo"><p></p>
       <input type="submit" value="录入">
   </form>
</body>
</html>
