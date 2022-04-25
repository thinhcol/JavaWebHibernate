<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Trang chủ</title>

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
					<input type="text" placeholder="Search..">
					<li><a href="/Assignment/trangchu/login.jsp">Home</a></li>
					<li><a href="/Assignment/trangchu/login.jsp">Home</a></li>
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
	<h2>Tìm kiếm với từ khóa: ${key}</h2>
	<div class="section">
		<div class="container">
			<div class="section-header">Phim tìm kiếm</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="view10" items="${videokey}">
					<a href="/Assignment/videochitiet?idvs=${view10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${view10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${view10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${view10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${view10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>
				</c:forEach>

			</div>
		</div>
	</div>

	<!-- LATEST MOVIES SECTION -->
	<div class="section">
		<div class="container">
			<div class="section-header">Phim yêu thích</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="view10" items="${yeuthich}">
					<a href="/Assignment/videochitiet?idvs=${view10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${view10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${view10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${view10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${view10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>
				</c:forEach>

			</div>
		</div>
	</div>
	<!-- END LATEST MOVIES SECTION -->

	<!-- LATEST SERIES SECTION -->
	<div class="section">
		<div class="container">
			<div class="section-header">Phim nhiều lượt xem</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="view10" items="${topview}">
					<a href="/Assignment/videochitiet?idvs=${view10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${view10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${view10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${view10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${view10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- END LATEST SERIES SECTION -->

	<!-- LATEST CARTOONS SECTION -->
	<div class="section">
		<div class="container">
			<div class="section-header">Phim mới ra</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="random10" items="${top10rd}">
					<a href="/Assignment/videochitiet?idvs=${random10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${random10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${random10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${random10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${random10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>

				</c:forEach>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="section-header">Phim kinh dị</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="random10" items="${kinhdi}">
					<a href="/Assignment/videochitiet?idvs=${random10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${random10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${random10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${random10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${random10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>

				</c:forEach>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="section-header">Phim hành động</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="random10" items="${hanhdong}">
					<a href="/Assignment/videochitiet?idvs=${random10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${random10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${random10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${random10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${random10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>

				</c:forEach>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="section-header">Phim hoạt hình</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="random10" items="${hoathinh}">
					<a href="/Assignment/videochitiet?idvs=${random10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${random10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${random10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${random10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${random10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>

				</c:forEach>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="section-header">Phim khoa học viễn tưởng</div>
			<div class="movies-slide carousel-nav-center owl-carousel">
				<c:forEach var="random10" items="${khoahoc}">
					<a href="/Assignment/videochitiet?idvs=${random10.idvs}"
						class="movie-item"> <img
						src="/Assignment/trangchu/images/${random10.poster}" alt="">
						<div class="movie-item-content">
							<div class="movie-item-title">${random10.tittle}</div>
							<div class="movie-infos">
								<div class="movie-info">
									<i class="bx bxs-star"></i> <span>9.5</span><span>${random10.active?'On':'Off'}</span>
								</div>
								<div class="movie-info">
									<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
										xem : ${random10.viewer}</span>
								</div>
								<div class="movie-info">
									<span>HD</span>
								</div>
								<div class="movie-info">
									<span>16+</span>
								</div>
							</div>
						</div>
					</a>

				</c:forEach>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="section-header">Phim nổi bật của tháng</div>
		<c:forEach var="random1" items="${top1rd}">
			<div class="hero-slide-item">
				<img src="/Assignment/trangchu/images/${random1.poster}" alt="">
				<div class="overlay"></div>
				<div class="hero-slide-item-content">
					<div class="item-content-wraper">
						<div class="item-content-title">${random1.tittle}</div>
						<div class="movie-infos">
							<div class="movie-info">
								<i class="bx bxs-star"></i> <span>9.5</span><span>${random1.active?'On':'Off'}</span>
							</div>
							<div class="movie-info">
								<i class="bx bxs-time"></i> <span>120 mins</span><span>Lượt
									xem : ${random1.viewer}</span>
							</div>
							<div class="movie-info">
								<span>HD</span>
							</div>
							<div class="movie-info">
								<span>16+</span>
							</div>
						</div>
						<div class="item-content-description">Lorem ipsum dolor sit
							amet consectetur adipisicing elit. Quas, possimus eius. Deserunt
							non odit, cum vero reprehenderit laudantium odio vitae autem
							quam, incidunt molestias ratione mollitia accusantium, facere ab
							suscipit.</div>
						<div class="item-action">
							<a href="/Assignment/videochitiet?idvs=${random1.idvs}"
								class="btn btn-hover"> <i class="bx bxs-right-arrow"></i> <span>Watch
									now</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- END SPECIAL MOVIE SECTION -->

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