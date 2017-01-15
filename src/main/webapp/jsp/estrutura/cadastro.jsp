<%@ include file="../../../template/cabecalho.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="main" class="container-fluid">
	<h3 class="page-header">Cadastro de atributo</h3>

		<form class="navbar-form navbar-left" action="${contextPath}/estrutura/criar" method="post">
			<div class="form-group">
				<input type="hidden" name="modelo.id" value="${modelo.id}"/>
				<label for="nome">Nome do atributo: </label> 
				<input type="text" id="nome"
					class="form-control" placeholder="Nome do atributo" name="nome"><br>
				<label for="tipo">Selecione o tipo do atributo: </label> 
					<select id="tipo" name="tipo.id" class="form-control">
					  <c:forEach var="tipo" items="${listTipos}">
					  	<option value="${tipo.id}">${tipo.nome}</option>
					  </c:forEach>
					</select><br>
					
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>

		</form>

</div>
<%@ include file="../../../template/rodape.jspf"%>


