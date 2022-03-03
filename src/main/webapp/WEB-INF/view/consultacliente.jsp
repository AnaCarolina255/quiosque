<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta Cliente</title>
</head>
<style>
    *{
        background: #600;
        background-image: url(cliente.svg);
    }
    
    h1{
        text-align: center;
        color: azure;
    }
    
    table{
        margin-left: auto;
        margin-right: auto;
        width: 700px;
        background-color: white;
        color: aliceblue;
        
    }
    
    th{
        padding: 5px;
    }
    
</style>
<body>
    <h1>Consulta de Clientes</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Data Nascimento</th>
            <th>Endereço</th>
            <th>Celular</th>
            <th>Email</th>
            <th>Gênero</th>
            <th>Produto de Interesse</th>
            <th>Idade</th>
            <th>Alterar</th>
            <th>Excluir</th>
    </tr>
    <c:forEach items="${clientes }" var="p">
    <tr>
    	<td>${p.id }</td>
    	<td>${p.nome }</td>
    	<td><fmt:formatDate pattern="yyyy/MM/dd" value="${p.dataNascimento.time }"/></td>
    	<td>${p.endereco }</td>
    	<td>${p.celular }</td>
    	<td>${p.email }</td>
    	<td>${p.tipoGenero.toString() }</td>
    	<td>${p.tipoProduto.toString() }</td>
    	<td>${p.idade }</td>
    	<td><a href="alterarCliente?idCliente=${p.id }">Alterar</a></td>
		<td><a href="excluirCliente?idCliente=${p.id }" onclick="return confirm('Deseja excluir?')">Excluir</a></td>
    </tr>
    </c:forEach>

    </table>
    
    <h1>Quantidade de clientes separados por:</h1>
    
    <table>
    	<tr>
    		<th>Feminino</th>
    		<th>Masculino</th>
    		<th>Outros</th>
    		<th>Jovem</th>
    		<th>Adulto</th>
    		<th>Idoso</th>
    		<th>Domingo</th>
    		<th>Segunda</th>
    		<th>Terça</th>
    		<th>Quarta</th>
    		<th>Quinta</th>
    		<th>Sexta</th>
    		<th>Sábado</th>
    		<th>Manhã</th>
    		<th>Tarde</th>
    		<th>Noite</th>
    	</tr>
    <c:forEach items="${cliente }" var="f">
    	<tr>
    		<td>${feminino }</td>
    		<td>${masculino }</td>
    		<td>${outros }</td>
    		<td>${jovem }</td>
    		<td>${adulto }</td>
    		<td>${idoso }</td>
    		<td>${dom }</td>
    		<td>${seg }</td>
    		<td>${ter }</td>
    		<td>${quar }</td>
    		<td>${quin }</td>
    		<td>${sex }</td>
    		<td>${sab }</td>
    		<td>${manha }</td>
    		<td>${tarde }</td>
    		<td>${noite }</td>
    	
    	</tr>
    	</c:forEach>
    </table>
</body>
</html>