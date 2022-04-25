<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Thông tin người dùng</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;700;900&display=swap"
	rel="stylesheet">
<!-- OWL CAROUSEL -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
	crossorigin="anonymous" />
<!-- BOX ICONS -->
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
<!-- APP CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- APP CSS -->
<link rel="stylesheet" href="/Assignment/trangchu/css/grid.css">
<link rel="stylesheet" href="/Assignment/trangchu/css/app.css">
<style>
.nav>ul>li>a>img {
	width: 35px !important;
	height: 35px !important;
	border-radius: 65% !important;
}
.row>img{
	margin-top: 20px;
	width:20% !important;
	height:300px;
}
</style>
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
							src="/Assignment/trangchu/ava/${nguoi.hinh}"></a></li>
					<li><a href="/Assignment/editthongtin?userid=${nguoi.userid}"
						name="userid">${nguoi.userid}</a></li>
				</ul>
				<!-- MOBILE MENU TOGGLE -->
				<div class="hamburger-menu" id="hamburger-menu">
					<div class="hamburger"></div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- END NAV -->

	<!-- HERO SECTION -->
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
	

	<!-- HERO SECTION -->
	<main class="container">
	<div class="row">
		<img src="/Assignment/trangchu/ava/${nguoi.hinh}">
		<div class="col-9">
			
			<form action="/Assignment/editthongtin" method="post">
				<div class="form-group">
					<label for="userid">Tài khoản:</label> <input type="text"
						name="userid" required value="${nguoi.userid}"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="pass">Mật khẩu:</label> <input type="password"
						name="pass" required value="${nguoi.pass}" class="form-control">
				</div>
				<div class="form-group">
					<label for="fullname">Họ và tên:</label> <input type="text"
						name="fullname" required value="${nguoi.fullname}"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="text" name="email"
						required value="${nguoi.email}" class="form-control">
				</div>
				<div class="form-group">
					<label for="Fullname">Hình:</label>
					<div class="mb-3">
						<label for="formFile" class="form-label">Default file
							input example</label> <input class="form-control" type="file"
							value="${nguoi.hinh}" name="hinh" id="formFile">
					</div>
				</div>

				<div class="form-group">
					<button formaction="/Assignment/editthongtin/update"
						class="btn btn-hover">
						<i class="bx bx-repost"></i> <span>Cập nhật</span>
					</button>
				</div>
			</form>
			
		</div>
	</div>
				

	<!-- PRICING SECTION -->
	<div class="section">
		<div class="container">
			<div class="pricing">
				<div class="pricing-header">
					Fl<span class="main-color">i</span>m pricing
				</div>
				<div class="pricing-list">
					<div class="row">
						<div class="col-4 col-md-12 col-sm-12">
							<div class="pricing-box">
								<div class="pricing-box-header">
									<div class="pricing-name">Basic</div>
									<div class="pricing-price">Free</div>
								</div>
								<div class="pricing-box-content">
									<p>Originals</p>
									<p>Swich plans anytime</p>
									<p>
										<del>65+ top Live</del>
									</p>
									<p>
										<del>TV Channels</del>
									</p>
								</div>
								<div class="pricing-box-action">
									<a href="#" class="btn btn-hover"> <span>Register
											now</span>
									</a>
								</div>
							</div>
						</div>
						<div class="col-4 col-md-12 col-sm-12">
							<div class="pricing-box hightlight">
								<div class="pricing-box-header">
									<div class="pricing-name">Premium</div>
									<div class="pricing-price">
										$35.99 <span>/month</span>
									</div>
								</div>
								<div class="pricing-box-content">
									<p>Originals</p>
									<p>Swich plans anytime</p>
									<p>
										<del>65+ top Live</del>
									</p>
									<p>
										<del>TV Channels</del>
									</p>
								</div>
								<div class="pricing-box-action">
									<a href="#" class="btn btn-hover"> <span>Register
											now</span>
									</a>
								</div>
							</div>
						</div>
						<div class="col-4 col-md-12 col-sm-12">
							<div class="pricing-box">
								<div class="pricing-box-header">
									<div class="pricing-name">VIP</div>
									<div class="pricing-price">
										$65.99 <span>/month</span>
									</div>
								</div>
								<div class="pricing-box-content">
									<p>Originals</p>
									<p>Swich plans anytime</p>
									<p>
										<del>65+ top Live</del>
									</p>
									<p>
										<del>TV Channels</del>
									</p>
								</div>
								<div class="pricing-box-action">
									<a href="#" class="btn btn-hover"> <span>Register
											now</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END PRICING SECTION -->

	<!-- FOOTER SECTION -->
	<footer class="section">
		<div class="container">
			<div class="row">
				<div class="col-4 col-md-6 col-sm-12">
					<div class="content">
						<a href="#" class="logo"> <i
							class='bx bx-movie-play bx-tada main-color'></i>Fl<span
							class="main-color">i</span>m
						</a>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Aut veniam ex quos hic id nobis beatae earum sapiente! Quod ipsa
							exercitationem officiis non error illum minima iusto et. Dolores,
							quibusdam?</p>
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
						<div class="col-3 col-md-6 col-sm-6">
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

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<!-- OWL CAROUSEL -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
		integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
		crossorigin="anonymous"></script>
	<!-- APP SCRIPT -->
	<script src="/Assignment/trangchu/app.js"></script>
</body>
</html>