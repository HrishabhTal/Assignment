<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<div class="container">
	<h1>Your Transactions</h1>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Amount</th>
                <th>Type</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${todo}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.name}</td>
					<td>${todo.amount}</td>
                    <td>${todo.type}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="common/footer.jspf" %>