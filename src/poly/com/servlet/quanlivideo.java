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
import poly.com.DAO.VideoDAO;
import poly.com.entity.Users;
import poly.com.entity.Videos;
import poly.com.ults.ShareHelper;

/**
 * Servlet implementation class quanlivideo
 */
@WebServlet({ "/quanlivideo", "/quanlivideo/insert", "/quanlivideo/update", "/quanlivideo/edit", "/quanlivideo/delete",
		"/quanlivideo/reset" })
public class quanlivideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quanlivideo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			if (uri.contains("reset")) {
				reset(request, response);
			}
			findall(request, response);
			edituser(request, response);
			request.getRequestDispatcher("/trangchu/quanlivideo.jsp").forward(request, response);
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
		request.getRequestDispatcher("/trangchu/quanlivideo.jsp").forward(request, response);
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

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("idvs");
			System.out.println(id);
			VideoDAO dao = new VideoDAO();
			Videos vs = dao.findByID(id);
			request.setAttribute("nguoi", vs);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("idvs");
			System.out.println(id);
			VideoDAO dao = new VideoDAO();
			dao.delete(id);
			request.setAttribute("message", "Xóa thành công");
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

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Videos vs = new Videos();
			BeanUtils.populate(vs, request.getParameterMap());
			VideoDAO dao = new VideoDAO();
			dao.insert(vs);
			request.setAttribute("message", "Nhập thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Videos vs = new Videos();
			BeanUtils.populate(vs, request.getParameterMap());
			VideoDAO dao = new VideoDAO();
			dao.update(vs);
			request.setAttribute("message", "Cập nhật thành công");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

	protected void reset(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("nguoi", new Videos());
		request.setAttribute("disabled", "");
	}

}
