<%@ page import="com.zheng.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t"%>
<html>
<head>
    <title>JSTL使用</title>
</head>
<body>
  <t:set var="name" value="zheng"></t:set>
  使用el表达式获取JSTL定义的变量：${name}<br>
  <t:if test="${3.343522424242>3.34352232344}"><br>
      此乃真的
  </t:if>
  <t:choose>
      <t:when test="${3>2.999999999}">
          3大于2；
      </t:when>
  </t:choose>
       <%
           Teacher t1 = new Teacher(1,"张三");
           Teacher t2 = new Teacher(2,"李四");
           Teacher t3 = new Teacher(3,"王五");
           List<Teacher> list = new ArrayList<>();
           list.add(t1);
           list.add(t2);
           list.add(t3);
           request.setAttribute("test",list);
       %>
       <t:forEach var="teacher" items="${test}">
           姓名：${teacher.sid}
       </t:forEach>
</body>
</html>
