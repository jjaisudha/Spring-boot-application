<html>
   <head>
      <title>Spring-Boot-My first sample </title>
   </head>
   <body>
      <h2>Spring- Boot-Rest Application - to be deployed in AWS </h2>
      <form method="post">
         <h3>Description: </h3>
         <br>
         This is an example for making a post request from a jsp to controller via rest API. <br>
         The controller takes the name of the user and shows the welcome page of the user. <br> 
         Spring Auto-wiring and Dependency Management-->@Autowired, @Component <br> 
         Create ColorNotesController and list-colornotes.jsp<br>
         <br>
         <br> Please Login to access <br>
         Enter Name : <input type="text" name ="name" />
         Password :<input type="password" name ="password" />
         <input type="submit">
      </form>
      <font color="red">${errMsg} </font>
   </body>
</html>