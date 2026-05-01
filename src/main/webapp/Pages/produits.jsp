<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<h2>Gestion des produits | Spring MVC</h2>

<!-- FORM -->
<form action="${pageContext.request.contextPath}/${produitEdit != null ? 'updateProduit' : 'addProduit'}" method="post">

    <input type="hidden" name="idProduit"
           value="${produitEdit != null ? produitEdit.idProduit : ''}"/>

    Nom :
    <input type="text" name="nom"
           value="${produitEdit != null ? produitEdit.nom : ''}"/>
    <br/>

    Description :
    <input type="text" name="description"
           value="${produitEdit != null ? produitEdit.description : ''}"/>
    <br/>

    Prix :
    <input type="text" name="prix"
           value="${produitEdit != null ? produitEdit.prix : ''}"/>
    <br/>

    <input type="submit"
           value="${produitEdit != null ? 'Mettre à jour' : 'Ajouter'}"/>

</form>

<hr/>

<!-- TABLE -->
<table border="1">
    <tr>
        <th>ID</th><th>Nom</th><th>Description</th><th>Prix</th><th>Actions</th>
    </tr>

    <c:forEach items="${listeProduit}" var="p">
        <tr>
            <td>${p.idProduit}</td>
            <td>${p.nom}</td>
            <td>${p.description}</td>
            <td>${p.prix}</td>
            <td>
                <a href="${pageContext.request.contextPath}/deleteProduit?id=${p.idProduit}">supprimer</a>
                |
                <a href="${pageContext.request.contextPath}/editProduit?id=${p.idProduit}">modifier</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>