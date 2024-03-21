<%--
  Created by IntelliJ IDEA.
  User: carlosleon
  Date: 3/20/24
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Result" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#userTable').DataTable();
    })
</script>
<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display">
        <thead>
        <th>Name</th>
        <th>User</th>
        <th>Age</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
