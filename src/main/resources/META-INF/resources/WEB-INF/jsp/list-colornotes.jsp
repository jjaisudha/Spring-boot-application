<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
   <head>
      <title>Color-Notes-List </title>
      <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
         rel="stylesheet">
   </head>
   <body>
      <form method= "GET">
         <div class="container">
            <table class="table table-striped">
               <caption>Your todos are</caption>
               <thead>
                  <tr>
                     <th>Description</th>
                     <th>Target Date</th>
                     <th>Is it Done?</th>
                     <th>Update</th>
                     <th>Delete</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${notes}" var="todo">
                     <tr>
                        <td>${todo.desc}</td>
                        <td> <fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
                        <td>${todo.done}</td>
                        <td> <a type="button" class="btn btn-success" href='/updatecolorNotes?id=${todo.id}'>UPDATE</a></td>
                        <td> <a type="button" class="btn btn-warning" href='/deletecolorNotes?id=${todo.id}'>DELETE</a></td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
            <div> <a class="button" href="/addColorNotes">Add a Todo</a></div>
            <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
            <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
         </div>
      </form>
   </body>
</html>
<%@ include file="footer.jspf" %>