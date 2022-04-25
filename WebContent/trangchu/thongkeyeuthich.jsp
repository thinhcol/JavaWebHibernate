<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<title>Thống kê lượt yêu thích</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;700;900&display=swap"
	rel="stylesheet">
<!-- OWL CAROUSEL -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
	integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
	crossorigin="anonymous" />
<!-- BOX ICONS -->
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- APP CSS -->


<link rel="stylesheet" href="/Assignment/trangchu/css/grid.css">
<link rel="stylesheet" href="/Assignment/trangchu/css/app.css">
<link rel="stylesheet" href="/Assignment/trangchu/css/login.css">

<style>
.nav>ul>li>a>img {
	width: 35px !important;
	height: 35px !important;
	border-radius: 65% !important;
}

td {
	color: white;
}

.col tr>td>img {
	width: 50px;
	height: 50px;
}

h1 {
	text-align: center;
}
</style>

<title>Lab 5</title>
</head>

<body>
	<div class="nav-wrapper">
		<div class="container">
			<div class="nav">
				<a href="/Assignment/trangchu" class="logo"> <i
					class='bx bx-movie-play bx-tada main-color'></i>Fl<span
					class="main-color">i</span>m
				</a>
				<ul class="nav-menu" id="nav-menu">
					<li><a href="/Assignment/dangnhap/logout">Home</a></li>
					<li><a href="#">Genre</a></li>
					<li><a href="#">Movies</a></li>
					<c:if test="${roler == false}">

					</c:if>
					<c:if test="${roler == true}">
						<li><a href="/Assignment/UserServlet">Quản lý người dùng</a></li>
						<li><a href="/Assignment/quanlivideo">Quản lý phim</a></li>
						<li><a href="/Assignment/thongke">Thống kê</a></li>
						
					</c:if>
					<li><a href="#">Series</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#"><img
							src="/Assignment/trangchu/ava/${user.hinh}"></a></li>
					<li><a href="/Assignment/editthongtin?userid=${user.userid}"
						name="userid">${user.userid}</a></li>
				</ul>
				<!-- MOBILE MENU TOGGLE -->
				<div class="hamburger-menu" id="hamburger-menu">
					<div class="hamburger"></div>
				</div>
			</div>
		</div>
	</div>
	<h1>Thống kê lượt lượt yêu thích của từng video</h1>
	<main class="container">
	<div class="row">
		<form action="/Assignment/thongkeyeuthich/chonnam" method="post">
			<div class="form-group">
				<select class="custom-select custom-select-lg mb-3" name="getYear">
					<option selected>Choose a year</option>
					<c:forEach var="item" items="${sendYear}">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
					<button formaction="/Assignment/thongkeyeuthich/chonnam"
						class="btn btn-primary">Search</button>
				</div>
		</form>
		<div class="col-6">
			<canvas id="favvideo1"></canvas>

		</div>

		<div class="col-6">
			<table class="table table-dark">

				<tr>
					<td>Tên phim</td>
					<td>Số lần yêu thích</td>
					<td>Thời gian gần đây</td>
					<td>Thời gian đầu tiên</td>

				</tr>
				<c:forEach var="items" items="${fav}">
					<tr>
						<td>${items.group}</td>
						<td>${items.likes}</td>
						<td><fmt:formatDate value="${items.newest}"
								pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${items.oldest}"
								pattern="dd-MM-yyyy" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</main>

	<footer class="section">
		<div class="container">
			<div class="row">
				<div class="col-4 col-md-6 col-sm-12">
					<div class="content">
						<a href="#" class="logo"> <i
							class='bx bx-movie-play bx-tada main-color'></i>Fl<span
							class="main-color">i</span>m
						</a>
						<p>Web xem phim miễn phí</p>
						<div class="social-list">
							<a href="#" class="social-item"> <i class="bx bxl-facebook"></i>
							</a> <a href="#" class="social-item"> <i class="bx bxl-twitter"></i>
							</a> <a href="#" class="social-item"> <i class="bx bxl-instagram"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="col-8 col-md-6 col-sm-12">
					<div class="row">
						<div class="col-3 col-md-6 col-sm-6">
							<div class="content">
								<p>
									<b>Flim</b>
								</p>
								<ul class="footer-menu">
									<li><a href="#">About us</a></li>
									<li><a href="#">My profile</a></li>
									<li><a href="#">Pricing plans</a></li>
									<li><a href="#">Contacts</a></li>
								</ul>
							</div>
						</div>
						<div class="col-3 col-md-6 col-sm-6">
							<div class="content">
								<p>
									<b>Browse</b>
								</p>
								<ul class="footer-menu">
									<li><a href="#">About us</a></li>
									<li><a href="#">My profile</a></li>
									<li><a href="#">Pricing plans</a></li>
									<li><a href="#">Contacts</a></li>
								</ul>
							</div>
						</div>
						<div class="col-3 col-md-6 col-sm-6">
							<div class="content">
								<p>
									<b>Help</b>
								</p>
								<ul class="footer-menu">
									<li><a href="#">About us</a></li>
									<li><a href="#">My profile</a></li>
									<li><a href="#">Pricing plans</a></li>
									<li><a href="#">Contacts</a></li>
								</ul>
							</div>
						</div>
						<div class="col-3 col-md-3 col-sm-6">
							<div class="content">
								<p>
									<b>Download app</b>
								</p>
								<ul class="footer-menu">
									<li><a href="#"> <img
											src="/Assignment/trangchu/images/google-play.png" alt="">
									</a></li>
									<li><a href="#"> <img
											src="/Assignment/trangchu/images/app-store.png" alt="">
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<script src="/Assignment/trangchu/linechart1.js"></script>
	
	<script>
		let view = [], tittle = []
		<c:forEach var="item" items="${fav}">
			tittle.push('${item.group}')
			view.push(${item.likes})
		</c:forEach>
		window.onload = function() {
			linechart("favvideo1",view,tittle)
		}
	</script>

	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>

</html>