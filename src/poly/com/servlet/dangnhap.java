package poly.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poly.com.DAO.UserDAO;
import poly.com.entity.Users;
import poly.com.ults.ShareHelper;

/**
 * Servlet implementation class dangnhap
 */
@WebServlet({ "/dangnhap", "/dangnhap/login","/dangnhap/logout" })
public class dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public dangnhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI().toString();
		if (uri.contains("logout")) {
			doSignOut(req, resp);
		}
		req.getRequestDispatcher("/trangchu/login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI().toString();
		if (uri.contains("login")) {
			doSignIn(req, resp);
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userid");
		String pw = req.getParameter("pass");
		try {
			UserDAO dao = new UserDAO();
			Users user = dao.findByID(id);
			if (!user.getPass().equals(pw)) {
				req.setAttribute("error", "Sai mật khẩu!");
				req.getRequestDispatcher("/trangchu/login.jsp").forward(req, resp);
			} else {
				ShareHelper.USER = user;
				req.setAttribute("user", user);
				req.setAttribute("message", "Đăng nhập thành công!");
				req.getRequestDispatcher("/trangchu").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doSignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShareHelper.USER = null;
	}

}
