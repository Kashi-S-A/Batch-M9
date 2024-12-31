<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<h1>Login Here</h1>
		<h5>${msg}</h5>
		<form action="login" method="post">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Email
					address</label> <input type="email" name="email" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com"
					required>
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Password</label>
				<input type="password" name="password" class="form-control"
					id="exampleFormControlInput1" placeholder="dinga@123" required>
			</div>

			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<a href="/">Register Page</a>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>