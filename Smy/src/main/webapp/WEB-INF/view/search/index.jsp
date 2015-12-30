<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>楽天ブックスDVD/Blu-ray検索</title>
</head>
<body>
<c:forEach var="obj" items="${errorMap}" varStatus="status">
	<c:out value="${obj.value}"/><br>
</c:forEach>

<form action="result" method="post">
	<label>タイトル名</label>
	<input type="text" name="title" value="<c:out value="${kensakuJokenDto.title}"/>"><br>
	<label>出演者名</label>
	<input type="text" name="artistName"></input><br>
	<label>販売元名</label>
	<input type="text" name="label"></input><br>
	<label>JANコード</label>
	<input type="text" name="jan"></input><br>
	<label>楽天ブックジャンルID</label>
	<input type="text" name="booksGenreId"></input><br>
	<label>アフェリエイトID</label>
	<input type="text" name="affiliateId"></input><br>
	<label>出力パラメータ指定</label>
	<input type="text" name="elements"></input><br>
	<label>出力フォーマットバージョン</label>
	<input type="text" name="formatVersion"></input><br>
	<label>1ページあたりの取得件数</label>
	<input type="text" name="hits"></input><br>
	<label>取得ページ</label>
	<input type="text" name="page"></input><br>
	<label>在庫状況</label>
	<input type="text" name="availability"></input><br>
	<label>品切れ等、購入不可商品表示フラグ</label>
	<input type="text" name="outOfStockFlag"></input><br>
	<label>ソート</label>
	<input type="text" name="sort" value="<c:out value="${kensakuJokenDto.sort}"/>"><br>
	<label>限定フラグ</label>
	<input type="text" name="limitedFlag"></input><br>
	<label>キャリア</label>
	<input type="text" name="carrier"></input><br>
	<label>ジャンルごとの商品数取得フラグ</label>
	<input type="text" name="genreInformationFlag"></input><br>
	
	<input type="submit"></input>
</form>
</body>
</html>