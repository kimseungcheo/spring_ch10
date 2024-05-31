<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 김승철
  Date: 2024-05-31
  Time: 오전 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보</title>
</head>
<body>
    <p>
        id : ${member.id}
    </p>
    <p>
        name : ${member.name}
    </p>
    <p>
        email : ${member.email}
    </p>
    <p>
        registerDateTime : <tf:formatDateTime value="${member.registerDateTime }"
                                              pattern="yyyy-MM-dd HH:mm" />
    </p>


</body>
</html>
