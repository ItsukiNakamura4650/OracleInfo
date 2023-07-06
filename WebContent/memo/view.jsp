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
<div class="container mt-5" >
<h2 class="text-center">議事録情報詳細</h2>
<form>
<table class="table table-hover">
	<tr>
		<td>番号</td>
		<td><input type="number" class="form-control" readonly>${memo.number }</td>
	</tr>
	<tr>
		<td>会議の目的</td>
		<td><input type="text" name="text" class="form-control"></td>
	</tr>
	<tr>
		<td>場所</td>
		<td><input type="text" name="text" class="form-control"></td>
	</tr>
	<tr>
		<td>作成者</td>
		<td><input type="text" name="name" class="form-control"></td>
	</tr>
	<tr>
		<td>出席者</td>
		<td><input type="text" name="text" class="form-control"></td>
	</tr>
	<tr>
		<td>議事録情報</td>
		<td><input type="text" name="text" class="form-control"></td>
	</tr>
	<tr>
		<td>決定事項</td>
		<td><input type="text" name="text" class="form-control"></td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input>
			<input type="submit" value="戻る" class="btn btn-link">
			<input type="submit" value="修正" class="btn btn-warning">
			<input type="submit" value="削除" class="btn btn-danger">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>