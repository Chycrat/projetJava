
<thead>
	<tr>
		<th><h1>Id</h1></th>
		<th><h1>Nom</h1></th>
		<th><h1>Description</h1></th>
		<th><h1>DeadLine</h1></th>
	</tr>
</thead>
<tbody>
	<c:forEach items ="${taches}" var="tache">
		<tr>
			<td>${tache.id_tache}</td>
		
			<td>${tache.nom_tache} </td>
		
			<td> ${tache.description}</td>
		
			<td> ${tache.deadline}</td>
		</tr>
	</c:forEach>
</tbody>