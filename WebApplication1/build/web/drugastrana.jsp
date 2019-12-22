<%-- 
    Document   : drugastrana
    Created on : Dec 18, 2019, 7:36:48 PM
    Author     : Voja
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Covek"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link type="text/css" rel="stylesheet" href ="css/newcss.css"/> 
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            ArrayList<Covek> listaLjudi = (ArrayList<Covek>) request.getAttribute("ListaLjudi");

            String greska = (String) request.getAttribute("Greska");

        %>
        <%            if (greska != null) {
        %> <%= greska%> <%
            }
        %>
        <hr>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">


                    <%  if (listaLjudi != null) { %>
                    <table class="table table-bordered  "> 
                        <%
                            for (Covek covek : listaLjudi) {
                        %>
                        <tr> 
                            <td class="L"><%=covek.getIme()%></td>
                            <td class ="M"> <%=covek.getPrezime()%></td>

                        </tr>
                        <%
                            }
                        %> 
                    </table> 
                    <%
                        }

                    %>
                    <%if (listaLjudi.isEmpty()) {
                    %>
                    <p style="color:white; font-weight: bold; font-size: large; position: absolute; left: 27%;"> Ovaj korisnik nema traženih podataka . </p> 

                    <%
                        }
                    %>


                </div>
                <div class="col-md-2"></div>
            </div>
        </div>

        <a  class="btn btn-danger btn-sm " style =" 
            position: absolute;
            bottom: 8px;
            left: 16px;
            font-size: 18px;" href="javascript:history.go(-1)">Korak nazad</a>
        <h1></h1>
    </body>
</html>
