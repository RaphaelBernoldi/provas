<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post" action="/login">
		<table>
			<tr>
				<td>
					<p>${message }</p>
				</td>
			</tr>
			<tr>
				<td>User</td>
				<td>
					<input type="text" name="user" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" name="password" />
				</td>
			</tr>
		</table>
		<button type="submit">Entrar</button>
	</form>
</body>
</html>