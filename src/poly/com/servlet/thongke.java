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
 * Servlet implementation class thongke
 */
@WebServlet("/thongke")
public class thongke extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public thongke() {
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
		if (ShareHelper.USER.getRoler() == false || ShareHelper.USER == null) {
			request.getRequestDispatcher("/trangchu").forward(request, response);
			return;
		}else{
			edituser(request, response);
			findall(request, response);
			request.getRequestDispatcher("/trangchu/thongke.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

}
