package poly.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poly.com.DAO.UserDAO;
import poly.com.DAO.VideoDAO;
import poly.com.entity.Users;
import poly.com.entity.Videos;
import poly.com.ults.ShareHelper;

/**
 * Servlet implementation class trangchu
 */
@WebServlet("/trangchu")
public class trangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public trangchu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		top10random(request, response);
		top1random(request, response);
		top10view(request, response);
		findall(request, response);
		edituser(request, response);
		kinhdi(request, response);
		hoatdong(request, response);
		hoathinh(request, response);
		khoahoc(request, response);
		yeuthichid(request, response, ShareHelper.USER.getUserid());

		request.getRequestDispatcher("/trangchu/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShareHelper.tieude = request.getParameter("tittle");
		request.setAttribute("key", ShareHelper.tieude);
		doGet(request, response);
	}

	protected void findall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.findAll();
			request.setAttribute("items", videos);

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

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			VideoDAO dao = new VideoDAO();
			String idvs = request.getParameter("idvs");
			Videos vs = dao.findByID(idvs);
			ShareHelper.Video = vs;
			request.setAttribute("items", vs);
			edituser(request, response);
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
				System.out.println(ShareHelper.USER.getRoler());
			} else {
				request.getRequestDispatcher("/trangchu/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void kinhdi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.kinhdi();
			request.setAttribute("kinhdi", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void hoatdong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.hanhdong();
			request.setAttribute("hanhdong", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void hoathinh(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.hoathinh();
			request.setAttribute("hoathinh", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void khoahoc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> videos = dao.khoahoc();
			request.setAttribute("khoahoc", videos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
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

	protected void theokey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO daovid = new VideoDAO();
			List<Videos> vskey = daovid.findByTitle(ShareHelper.tieude);
			request.setAttribute("videokey", vskey);
			request.setAttribute("key", ShareHelper.tieude);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
