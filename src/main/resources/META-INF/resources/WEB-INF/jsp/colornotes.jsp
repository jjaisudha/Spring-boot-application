
<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<div class="container">
   
      <form:form method= "post" commandName="colorNotes">
      	 <form:hidden path="id"/>
         <fieldset class="form-group">
            <form:label path="desc">Description :</form:label>
            <form:input path="desc" name="description" type="text" class ="form-control" required="required"/>
            <form:errors path="desc" cssClass="text-warning"/>
         </fieldset>
         <fieldset class="form-group">
            <form:label path="targetDate">Target Date :</form:label>
            <form:input path="targetDate" name="targetDate" type="text" class ="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
         </fieldset>
         <button type="submit" class="btn btn-success">Add</button>	
      </form:form>
</div>
<%@ include file="footer.jspf" %>
