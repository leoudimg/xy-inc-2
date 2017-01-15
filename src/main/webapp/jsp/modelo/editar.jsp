<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../template/cabecalho.jspf"%>
<div id="main" class="container-fluid">
	<h3 class="page-header">Edição de modelo</h3>

		<form class="navbar-form navbar-left" action="${contextPath}/modelo/atualizar" method="post">
			<div class="form-group">
			<label for="nome">Nome</label>
				<input  type="hidden" name="id" value="${modelo.id }"/>
				 <input id="nome" type="text"
					class="form-control" placeholder="Nome" name="nome" value="${modelo.nome }">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>

		</form>

</div>


<%@ include file="../../../template/rodape.jspf" %>