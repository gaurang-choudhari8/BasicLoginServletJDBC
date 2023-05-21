<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <%@ page import="java.util.Arrays, java.util.List, java.util.ArrayList, com.basicLogin.model.User" %>

    <%

    //list = Arrays.asList((Object[])obj);
    List<User> users=Arrays.asList((Object[])request.getAttribute("users"));
    for(User ind_user:users){
        out.println(ind_user.toString());
    }
    %>
</body>
</html>