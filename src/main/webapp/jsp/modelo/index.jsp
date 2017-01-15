
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../template/cabecalho.jspf" %>
<div id="main" class="container-fluid">
 <h3 class="page-header">Lista de Modelos disponíveis</h3>


<c:choose>
	<c:when test="${empty listModelo}">
		<h3 align="center">Não há modelos cadastrados.</h3>
		<a href="${contextPath}/modelo/cadastro">Cadastrar um modelo</a> 
	</c:when>
	<c:otherwise>
	
		<table class="table">
			<thead>
				<tr>
				    <th>id</th>
					<th>Nome</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="modelo" items="${listModelo}">
					<tr>
						<td>${modelo.id}</td>
						<td>${modelo.nome}</td>
						<td>
							<a href="${contextPath}/editar/${modelo.id}">Editar</a> 
							<a href="${contextPath}/deletar/${modelo.id}">Deletar</a>
							<a href="${contextPath}/estrutura/index/${modelo.id}">Listar Atributos</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<a href="${contextPath}/modelo/cadastro">Cadastrar um modelo</a> 
	</c:otherwise>

</c:choose>

</div>

<%@ include file="../../../template/rodape.jspf" %>
