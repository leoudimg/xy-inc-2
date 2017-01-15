<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../template/cabecalho.jspf"%>
<div id="main" class="container-fluid">
	<h3 class="page-header">Cadastro de modelo</h3>

		<form class="navbar-form navbar-left" action="${contextPath}/modelo/criar" method="post">
			<div class="form-group">
				<label for="nome">Nome do modelo: </label> 
				<input type="text" id="nome"
					class="form-control" placeholder="Nome" name="nome">
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>

		</form>

</div>
<%@ include file="../../../template/rodape.jspf"%>


