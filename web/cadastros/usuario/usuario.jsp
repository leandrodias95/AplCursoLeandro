<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<h2>Usuário</h2>
<table id="datatable" class="display">
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">E-mail</th>
            <th align="left">Senha</th>
             <th align="left">Nome Completo</th>
              <th align="left">Tipo Usuário</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="usuario" items="${usuarios}"> 
            <tr>
            <td align="left">${usuario.idUsuario}</td>
            <td align="left">${usuario.email}</td>
            <td align="left">${usuario.senha}</td>
            <td align="left">${usuario.nomeCompleto}</td>
            <td align="left">${usuario.tipoUsuario}</td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/UsuarioExcluir?idUsuario=${usuario.idUsuario}">Excluir</a></td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/UsuarioCarregar?idUsuario=${usuario.idUsuario}">Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div align="center">
 <a href="${pageContext.request.contextPath}/UsuarioNovo">Novo</a>  
 <a href="index.jsp">Volta à Página Inicial</a>  
</div>
 <script>
        $(document).ready(function() {
            console.log('entrei ready');
            //Carregamos a datatable
            //$("#datatable").DataTable({});
            $('#datatable').DataTable({
                "oLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Último"
                    }
                }
            });
        });
</script>

 <%@include file="/footer.jsp" %>
