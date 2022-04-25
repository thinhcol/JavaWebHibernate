<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Đăng nhập</title>
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
</head>

<body>
	<div class="nav-wrapper">
		<div class="container">
			<div class="nav">
				<a href="./index.jsp" class="logo"> <i
					class='bx bx-movie-play bx-tada main-color'></i>Fl<span
					class="main-color">i</span>m
				</a>
				<ul class="nav-menu" id="nav-menu">
					<li><a href="#">Home</a></li>
					<li><a href="#">Genre</a></li>
					<li><a href="#">Movies</a></li>
					<li><a href="#">Series</a></li>
					<li><a href="#">About</a></li>
					<li><a href="/Assignment/trangchu/register.jsp"
						class="btn btn-hover"> <span>Đăng ký</span>
					</a></li>
				</ul>
				<!-- MOBILE MENU TOGGLE -->
				<div class="hamburger-menu" id="hamburger-menu">
					<div class="hamburger"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END NAV -->
	<div class="row">
		<div class="col">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
		</div>
	</div>
	<div class="login-box">
		<h1>ĐĂNG NHẬP</h1>
		<form action="/Assignment/dangnhap" method="post">
			<div class="textbox">
				<i class="fas fa-user"></i> <input name="userid" type="text"
					placeholder="Tài khoản hoặc email">
			</div>

			<div class="textbox">
				<i class="fas fa-lock"></i> <input name="pass" type="password"
					placeholder="Mật khẩu">
			</div>
			<a href="/Assignment/trangchu/register.jsp">Bạn chưa có tài khoản
				?</a><br> <a href="/Assignment/trangchu/fogotpasss.jsp">Bạn
				quên mật khẩu của mình ?</a><br>
			<button formaction="/Assignment/dangnhap/login" name="dangnhap" class="btn btn-hover">
				<span>Đăng nhập</span>
			</button>
		</form>
	</div>
	<div class="hero-section">
		<!-- HERO SLIDE -->
		<!-- FOOTER SECTION -->
		<footer class="section">
			<div class="container">
				<div class="row">
					<div class="col-4 col-md-3 col-sm-12">
						<div class="content">
							<a href="#" class="logo"> <i
								class='bx bx-movie-play bx-tada main-color'></i>Fl<span
								class="main-color">i</span>m
							</a>
							<p>Web xem phim miễn phí</p>
							<div class="social-list">
								<a href="#" class="social-item"> <i class="bx bxl-facebook"></i>
								</a> <a href="#" class="social-item"> <i class="bx bxl-twitter"></i>
								</a> <a href="#" class="social-item"> <i
									class="bx bxl-instagram"></i>
								</a>
							</div>
						</div>
					</div>
					<div class="col-8 col-md-3 col-sm-12">
						<div class="row">
							<div class="col-3 col-md-3 col-sm-6">
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
							<div class="col-3 col-md-3 col-sm-6">
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
							<div class="col-3 col-md-3 col-sm-6">
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
	</div>

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