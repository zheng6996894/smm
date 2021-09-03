<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="V"%>
<html>
<head>
    <title>学生管理信息</title>
    <style type="text/css">
        table{
            margin: auto;
        }
        div{
            width: 500px;
            text-align: right;
            margin: auto;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
           $("#checkall").click(function () {
               var statu=$(this).prop("checked");
               $(".checkone").prop("checked",statu);
           });
            $("#btn").click(function () {
               var sids=new Array();
    $(".checkone:checked").each(function (index,content) {
            var sid=$(content).val();
            sids.push(sid);
    });
            if(sids.length==0){
                alert("请选择您要删除的数据");
            }else{
                var str=sids.join();
                window.location.href="Student?flag=delAll&sids="+str;
            }
            });
        });

    </script>
</head>
<body>
       <a href="add.jsp">添加学生</a>
       <form method="post"action="Student">
       <input type="hidden" name="flag" value="getStudentBySname">
       <input type="text" name="sname" value="${sname}">
       <input type="submit" value="查询">
       </form>
   <table border="1" cellspacing="0"cellpadding="0"align="center" width="500">
       <tr>
           <th><input type="checkbox" id="checkall">全选</th>
           <th>学号</th>
           <th>姓名</th>
           <th>年龄</th>
           <th>性别</th>
           <th>邮箱</th>
           <th>头像</th>
           <th>操作</th>
       </tr>
          <V:forEach var="st" items="${stuList}">
              <tr align="center">
                  <td>
                      <input type="checkbox" class="checkone" value="${st.sid}">
                  </td>
                  <td>${st.sid}</td>
                  <td>${st.sname}</td>
                  <td>${st.sage}</td>
                  <td>${st.ssex}</td>
                  <td>${st.semail}</td>
                  <td>
                      <img src="http://localhost:8080/photo/${st.photo}"width="50">
                  </td>
                  <td>
                      <a href="Student?flag=delStudentBySid&sid=${st.sid}">删除</a>
                      <a href="Student?flag=getStudentBySid&sid=${st.sid}">更改</a>
                  </td>
              </tr>
          </V:forEach>
   </table>
   <div>
       <input type="button" value="批量删除" id="btn">
       <a href="Student?flag=getStudentBySname&sname=${sname}&page=1">首页</a>
       <a href="Student?flag=getStudentBySname&sname=${sname}&page=${pu.prevPage}">上一页</a>
       ${pu.page}/${pu.countPage}
       <a href="Student?flag=getStudentBySname&sname=${sname}&page=${pu.nextPage}">下一页</a>
       <a href="Student?flag=getStudentBySname&sname=${sname}&page=${pu.countPage}">尾页</a>
   </div>
</body>
</html>
