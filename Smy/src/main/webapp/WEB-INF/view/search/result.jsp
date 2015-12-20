<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dolteng Auto Generated</title>
</head>
<body>

<table border=1>
	<c:forEach var="Items" items="${searchResultDto.Items}" varStatus="status">
		<tr>
			<th style="width:20%"><a target="_brank"><c:out value="${Items.Item.title}"/></a></th>
			<th><a href="${Items.Item.itemUrl}" target="_brank"><img src="${Items.Item.smallImageUrl}"></a></th>
			<th><c:out value="${Items.Item.itemCaption}"/></th>
		</tr>
	</c:forEach>
</table>


</body>
</html>