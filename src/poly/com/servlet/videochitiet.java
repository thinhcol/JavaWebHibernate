package poly.com.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import poly.com.DAO.CommentDAO;
import poly.com.DAO.FavoriteDAO;
import poly.com.DAO.ShareDAO;
import poly.com.DAO.UserDAO;
import poly.com.DAO.VideoDAO;
import poly.com.entity.Comment;
import poly.com.entity.Favorite;
import poly.com.entity.Share;
import poly.com.entity.Users;
import poly.com.entity.Videos;
import poly.com.ults.ShareHelper;

/**
 * Servlet implementation class videochitiet
 */
@WebServlet({ "/videochitiet", "/videochitiet/yeuthich", "/videochitiet/binhluan", "/videochitiet/chiase" })
public class videochitiet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public videochitiet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI().toString();
		top10random(request, response);
		top1random(request, response);
		top10view(request, response);
		yeuthichid(request, response, ShareHelper.USER.getUserid());
		edituser(request, response);
		edit(request, response);
		checklike(request, response);
		if (uri.contains("yeuthich")) {
			Like(request, response);
		}
		if (uri.contains("binhluan")) {
			Cmt(request, response);
		}
		if (uri.contains("chiase")) {
			guimail(request, response);
		}
		nguoicmt(request, response);
		request.getRequestDispatcher("/trangchu/videochitiet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		top10random(request, response);
		top1random(request, response);
		top10view(request, response);
		yeuthichid(request, response, ShareHelper.USER.getUserid());
		edituser(request, response);
		edit(request, response);
		nguoicmt(request, response);
		checklike(request, response);
		String uri = request.getRequestURI().toString();
		if (uri.contains("yeuthich")) {
			Like(request, response);
		}
		if (uri.contains("binhluan")) {
			Cmt(request, response);
		}
		if (uri.contains("chiase")) {
			guimail(request, response);
		}
		request.getRequestDispatcher("/trangchu/videochitiet.jsp").forward(request, response);

	}

	protected void luotxem(HttpServletRequest request, HttpServletResponse response, String idvs)
			throws ServletException, IOException {
		try {

			VideoDAO dao = new VideoDAO();
			Videos vs = dao.findByID(idvs);
			int view = vs.getViewer();
			BeanUtils.populate(vs, request.getParameterMap());
			view++;
			vs.setViewer(view);
			dao.update(vs);
			request.setAttribute("message", "Cập nhật thành công");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			String idvs = request.getParameter("idvs");
			if (idvs != null) {
				Videos vs = dao.findByID(idvs);
				ShareHelper.Video = vs;
				System.out.println(idvs);
				luotxem(request, response, idvs);
				request.setAttribute("items", vs);
			} else {
				Videos vs = dao.findByID(ShareHelper.Video.getIdvs());
				ShareHelper.Video = vs;
				luotxem(request, response, ShareHelper.Video.getIdvs());
				System.out.println(idvs);
				request.setAttribute("items", vs);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void edituser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if (ShareHelper.USER != null) {
				String id = ShareHelper.USER.getUserid();
				UserDAO dao = new UserDAO();
				Users us = dao.findByID(id);
				request.setAttribute("user", us);
				request.setAttribute("roler", ShareHelper.USER.getRoler());
			} else {
				request.getRequestDispatcher("/trangchu/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void checklike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = ShareHelper.USER.getUserid();
			String idvs = request.getParameter("idvs");
			boolean thich;
			FavoriteDAO dao = new FavoriteDAO();
			Favorite fv = dao.findByfav(id, idvs);
			if (fv == null) {
				thich = false;
				request.setAttribute("thich123", thich);
			} else {
				thich = true;
				request.setAttribute("thich123", thich);
				System.out.println("Bỏ thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nhập thất bại");
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void Like(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = ShareHelper.USER.getUserid();
			String idvs = request.getParameter("idvs");
			FavoriteDAO dao = new FavoriteDAO();
			Favorite fv = dao.findByfav(id, idvs);
			if (fv == null) {
				FavoriteDAO dao1 = new FavoriteDAO();
				Videos video = new Videos();
				Users us = new Users();
				Favorite vs = new Favorite();
				video.setIdvs(idvs);
				us.setUserid(id);
				System.out.println(id);
				vs.setVideo(video);
				vs.setUser(us);
				dao1.update(vs);
				System.out.println("Thích thành công");
				request.setAttribute("message", "Nhập thành công");
				checklike(request, response);
			} else {
				dao.delete(fv.getIdfv());
				System.out.println("Bỏ thích thành công");
				checklike(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nhập thất bại");
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void Cmt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			Comment cm = new Comment();
			String id = ShareHelper.USER.getUserid();
			String idvs = request.getParameter("idvs");
			String cmt = request.getParameter("comment");
			if (idvs != null) {
				Videos video = new Videos();
				Users us = new Users();
				video.setIdvs(idvs);
				us.setUserid(id);
				System.out.println(id);
				cm.setVideo(video);
				cm.setUser(us);
				cm.setComment(cmt);
				CommentDAO dao = new CommentDAO();
				dao.update(cm);
				System.out.println("Nhập thành công");
			} else {
				Videos video = new Videos();
				Users us = new Users();
				video.setIdvs(ShareHelper.Video.getIdvs());
				us.setUserid(id);
				System.out.println(id);
				cm.setVideo(video);
				cm.setUser(us);
				cm.setComment(cmt);
				CommentDAO dao = new CommentDAO();
				dao.update(cm);
				System.out.println("Nhập thành công");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nhập thất bại");
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void themnguoishare(HttpServletRequest request, HttpServletResponse response, String email)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			Share cm = new Share();
			String id = ShareHelper.USER.getUserid();
			String idvs = request.getParameter("idvs");

			if (idvs != null) {
				Videos video = new Videos();
				Users us = new Users();
				video.setIdvs(idvs);
				us.setUserid(id);
				System.out.println(id);
				cm.setVideo(video);
				cm.setUser(us);
				cm.setEmail(email);
				ShareDAO dao = new ShareDAO();
				dao.update(cm);
				System.out.println("Nhập thành công");
			} else {
				Videos video = new Videos();
				Users us = new Users();
				video.setIdvs(ShareHelper.Video.getIdvs());
				us.setUserid(id);
				System.out.println(id);
				cm.setVideo(video);
				cm.setUser(us);
				cm.setEmail(email);
				ShareDAO dao = new ShareDAO();
				dao.update(cm);
				System.out.println("Nhập thành công");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nhập thất bại");
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void nguoicmt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String idvs = request.getParameter("idvs");
			if (idvs != null) {
				CommentDAO dao = new CommentDAO();
				List<Comment> cm = dao.binhluantheovideo(idvs);
				request.setAttribute("binhluan", cm);
			} else {
				CommentDAO dao = new CommentDAO();
				List<Comment> cm = dao.binhluantheovideo(ShareHelper.Video.getIdvs());
				request.setAttribute("binhluan", cm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nhập thất bại");
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void guimail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email = request.getParameter("email1");
			System.out.println(email);
			String video = ShareHelper.Video.getVideo();
			System.out.println(video);
			Properties pros = new Properties();
			pros.put("mail.smtp.auth", "true");
			pros.put("mail.smtp.starttls.enable", "true");
			pros.put("mail.smtp.host", "smtp.gmail.com");
			pros.put("mail.smtp.port", 587);
			Session session = Session.getDefaultInstance(pros, new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication("thinhphu2501@gmail.com", "ThinhPhu1230611");
				}
			});
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				msg.setSubject("Chia sẻ video", "utf-8");
				msg.setText("<iframe https://www.youtube.com/embed/" + video + "></iframe>");
				Transport.send(msg);
				themnguoishare(request, response, email);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected void yeuthichid(HttpServletRequest request, HttpServletResponse response, String name)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.videoyeuthichuserid(name);
			request.setAttribute("yeuthich", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void top10random(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.top10random();
			request.setAttribute("top10rd", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void top1random(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.top1random();
			request.setAttribute("top1rd", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void top10view(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.top10viewer();
			request.setAttribute("topview", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

}
