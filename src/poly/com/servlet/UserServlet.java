package poly.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.com.DAO.UserDAO;
import poly.com.entity.Users;
import poly.com.ults.ShareHelper;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/UserServlet/insert", "/UserServlet/update", "/UserServlet/delete", "/UserServlet/edit",
		"/UserServlet/reset" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		}else {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String uri = request.getRequestURI().toString();
			if (uri.contains("edit")) {
				edit(request, response);
			}
			if (uri.contains("delete")) {
				delete(request, response);
			}
			findall(request, response);
			edituser(request, response);
			request.getRequestDispatcher("/trangchu/quanli.jsp").forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI().toString();
		if (uri.contains("insert")) {
			insert(request, response);
		}
		if (uri.contains("update")) {
			update(request, response);
		}
		findall(request, response);
		edituser(request, response);
		request.getRequestDispatcher("/trangchu/quanli.jsp").forward(request, response);
	}

	protected void edituser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("userid");
			id = ShareHelper.USER.getUserid();
			UserDAO dao = new UserDAO();
			Users us = dao.findByID(id);
			request.setAttribute("user", us);
			request.setAttribute("roler", ShareHelper.USER.getRoler());
			System.out.println(ShareHelper.USER.getRoler());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Users us = new Users();
			BeanUtils.populate(us, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.insert(us);
			request.setAttribute("message", "Thêm thành công");
			System.out.println(us.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Users us = new Users();
			BeanUtils.populate(us, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.update(us);
			System.out.println(us.getUserid());
			request.setAttribute("message", "Cập nhật thành công");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (ShareHelper.USER != null) {
				String id = request.getParameter("userid");
				UserDAO dao = new UserDAO();
				Users us = dao.findByID(id);
				request.setAttribute("nguoi", us);
			} else {
				request.getRequestDispatcher("/trangchu/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String Usersid = request.getParameter("userid");
			UserDAO dao = new UserDAO();
			dao.delete(Usersid);
			request.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void findall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserDAO dao = new UserDAO();
			List<Users> list = dao.findAll();
			request.setAttribute("items", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void reset(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("nguoi", new Users());
		request.setAttribute("disabled", "");
	}

}
