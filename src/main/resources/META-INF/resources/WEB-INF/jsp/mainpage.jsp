<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

<div class="container">
	<h1>Welcome ${name}</h1>
	<h1>Balance: ${balance}</h1>
    <h2>Withdraw</h2>
	
	<form:form action="withdraw" method="post" modelAttribute="withdrawal">

		<fieldset class="mb-3">				
			<form:label path="amount">Amount</form:label>
			<form:input type="number" path="amount" placeholder="0.00" min="0" max="40000" required="required"/>
			<form:errors path="amount" cssClass="text-warning"/>
		</fieldset>

		<input type="submit" class="btn btn-success"/>
	
	</form:form>

	<h2>Deposit</h2>
	
	<form:form  action="deposit" method="post" modelAttribute="deposit">

		<fieldset class="mb-3">				
			<form:label path="amount">Amount</form:label>
			<form:input type="number" path="amount" placeholder="0.00" min="0" max="40000" required="required"/>
			<form:errors path="amount" cssClass="text-warning"/>
		</fieldset>

		<input type="submit" class="btn btn-success"/>
	
	</form:form>

	<a href="transactions">Transactions</a> 
</div>

<%@ include file="common/footer.jspf" %>