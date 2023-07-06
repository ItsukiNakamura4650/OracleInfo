<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- 必須のmetaタグ -->
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- BootstrapのCSSファイル -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>


		登録された議事録情報はありません。
		<form method="post">
		<a href="/MemoInfoOracle3/memo_servlet/list.do">議事録情報一覧</a>
		<table class="table table-hover">
			<tr>
				<th><input type="checkbox"></th>
				<th>番号</th>
				<th>会議の目的</th>
				<th>場所</th>
				<th>作成者</th>
				<th>日付</th>
				<th><input type="button" value="選択した議事録情報を削除" class="btn btn-dark"></th>
			</tr>

		<c:forEach items="${memoList }" var="memo">
			<tr>
				<td><input type="checkbox"></td>
				<td></td>
				<td><a href="#" onclick="detail('${memo.idx}')">${memo.purpose }<span class="d-inline-block text-truncate" style="max-width: 150px;"></span></a></td>
				<td>${ memo.location }</td>
				<td>${ memo.writer }</td>
				<td>${memo.post_date}</td>
				<td><input type="button" value="削除" class="btn btn-danger"></td>
			</tr>
		</c:forEach>
		</table>
		</form>

</body>

</html>