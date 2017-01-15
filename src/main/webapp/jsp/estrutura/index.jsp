
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../template/cabecalho.jspf" %>
<div id="main" class="container-fluid">
 <h3 class="page-header">Lista Atributos do modelo ${modelo.nome }</h3>


<c:choose>
	<c:when test="${empty modelo.estruturas}">
		<h3 align="center">Não há atributo cadastrado para o modelo ${modelo.nome }.</h3>
		<a href="${contextPath}/estrutura/cadastro/${modelo.id}">Cadastrar um atributo</a> 
	</c:when>
	<c:otherwise>
	
		<table class="table">
			<thead>
				<tr>
				    <th>id</th>
					<th>Nome</th>
					<th>Tipo</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="estrutura" items="${modelo.estruturas}">
					<tr>
						<td>${estrutura.id}</td>
						<td>${estrutura.nome}</td>
						<td>${estrutura.tipo.nome}</td>
						<td>
							<a href="${contextPath}/estrutura/editar/${estrutura.id}">Editar</a> 
							<a href="${contextPath}/estrutura/deletar/${estrutura.id}">Deletar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<a href="${contextPath}/estrutura/cadastro/${modelo.id}">Cadastrar um atributo</a>
	</c:otherwise>

</c:choose>

</div>

<%@ include file="../../../template/rodape.jspf" %>
