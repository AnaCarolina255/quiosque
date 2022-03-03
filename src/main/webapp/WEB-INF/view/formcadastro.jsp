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
    <title>Formulário de Cadastro</title>
    <link rel="stylesheet" href="formcad.css">
</head>
<body>
    <main>
        <h1>Faça seu cadastro</h1>
        <div class="social-media">
            <a href="#">
                <img src="google.png" alt="Google">
            </a>
            <a href="#">
                <img src="facebook.png" alt="Facebook">
            </a>
            <a href="#">
                <img src="linkedin.png" alt="Linkedin">
            </a>
        </div>

        <div class="alternative">
            <span>OU</span>
        </div>

        <form action="salvaCliente">
        <input type="hidden" name="id" value="${cliente.id }"/>
            <label for="name">
                <span>Nome</span>
                <input type="text" name="nome" value="${cliente.nome }"/>
            </label>

            <label for="idade">
                <span>Data Nascimento</span>
                <input type="date" name="dataNascimento" value="${cliente.dataNascimento }"/>
            </label>

            <label for="end">
                <span>Endereço</span>
                <input type="text" name="endereco" value="${cliente.endereco }"/>
            </label>

            <label for="tel">
                <span>Celular</span>
                <input type="number" name="celular" value="${cliente.celular }"/>
            </label>

            <label for="email">
                <span>E-mail</span>
                <input type="text" name="email" value="${cliente.email }"/>
            </label>
            
            <label for="produtos">
                <span>Produto(s) de Interesse</span>
                <select name="tipoProduto">
                <c:forEach items="${tiposProdutos}" var="t">
					<option value="${t }">${t.toString()}</option>
				</c:forEach>
                </select>
            </label>

            <label for="gen">
            <span>Gênero</span>
                <select name="tipoGenero">
                    <c:forEach items="${tiposGeneros}" var="v">
					<option value="${v }">${v.toString()}</option>
				</c:forEach>
                </select>
            </label>
                    

            <input type="submit" value="Salvar" id="button">
        </form>
    </main>
    <section class="images">
        <img src="celular.svg" alt="Mobile">
        <div class="circle"></div>
    </section>
</body>
</html>