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
        $('#productTable').DataTable();
    })
</script>
<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="productTable" class="display">
        <thead>
        <th>Product</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.quantity}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
