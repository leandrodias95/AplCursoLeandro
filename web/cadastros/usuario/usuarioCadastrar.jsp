<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarusuario" action="UsuarioCadastrar" 
        method="POST">

    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Usuário</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
            <td><input type="text" name="idusuario" id="idusuario" value="${usuario.idUsuario}" readonly="readonly" /></td></tr>
            <tr><td>Email: </td>
            <td><input type="text" name="email" id="emailusuario" value="${usuario.email}" 
                       size="50" maxlength="50" /></td></tr>
            <tr><td>Senha: </td>
            <td><input type="text" name="senha" id="senhausuario" value="${usuario.senha}" /></td></tr>
            <tr><td>Nome Completo: </td>
            <td><input type="text" name="nomecompleto" id="nomecompletousuario" value="${usuario.nomeCompleto}" /></td></tr>
            <tr><td>Tipo Usuário </td>
            <td><input type="text" name="tipousuario" id="tipousuario" value="${usuario.tipoUsuario}" /></td></tr>
            <tr><td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" style="color:red"/>
                    <input type="reset" name="limpar" id="limpar" value="Limpar" style="color:red; height:38px ; width: 118.1px; border-style: inset; backgrouns-color:#EEEEEE"/>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp">Voltar à Página Inicial</a></h5></td>
            </tr>
        </tbody>
    </table>
</form>  
<%@ include file="/footer.jsp" %>

