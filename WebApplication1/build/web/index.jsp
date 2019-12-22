<%-- 
    Document   : index
    Created on : Dec 18, 2019, 4:47:49 PM
    Author     : Voja
--%>

<%@page import="model.Covek"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link type="text/css" rel="stylesheet" href ="css/newcss.css"/> 
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>



    </head>
    <body >  


        <%
            ArrayList<Covek> listaLjudi = (ArrayList<Covek>) request.getAttribute("ListaLjudi");

            String greska = (String) request.getAttribute("Greska");

        %>
        <%            if (greska != null) {
        %> <%= greska%> <%
            }
        %>
         <% if (listaLjudi !=null ){ %>
        <h3 class ="h3" > Svi korisnici </h3>
      
        <hr style="border:1.5px solid white; opacity: 0.6;">  <% } %>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <table class="tabela">
                        <%  if (listaLjudi != null) {
                                for (Covek covek : listaLjudi) {
                        %>
                        <tr> 
                            <td class="Ime"> <%=covek.getIme()%> </td>
                            <td class="Ime"> <%=covek.getPrezime()%></td>
                            <td> <a class="licni" href ="Prijatelji?id=<%=covek.getId()%>&tip=direct">Lični prijatelji</a>        </td>
                            <td> <a class="fof" href ="Prijatelji?id=<%=covek.getId()%>&tip=fof">Prijatelji od prijatelja</a>        </td>
                            <td> <a class="sugg" href ="Prijatelji?id=<%=covek.getId()%>&tip=suggested">Preportučeni prijatelji</a>        </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>

 <% if (listaLjudi ==null ){ %>
        <a class="btn btn-primary  btn-lg" href="Svi" style="position: absolute; top: 100px; left:43%" >Lista svih korisnika</a><% } %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <% if (listaLjudi !=null ){ %>
        <a  class="btn btn-danger btn-lg" href="javascript:history.go(-1)">Korak nazad</a>
        <% } %>
        <h1></h1>


    </body>
    <script src="js/bootstrap.js"></script>
</html>
