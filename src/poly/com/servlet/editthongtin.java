package poly.com.servlet;

import java.io.IOException;
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
 * Servlet implementation class editthongtin
 */
@WebServlet({"/editthongtin","/editthongtin/update"})
public class editthongtin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editthongtin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		edit(request, response);
		request.getRequestDispatcher("/trangchu/edit.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if(uri.contains("update")) {
			update(request, response);
		}
		edit(request, response);
		request.getRequestDispatcher("/trangchu/edit.jsp").forward(request, response);
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(ShareHelper.USER != null) {
				UserDAO dao = new UserDAO();
				Users vs = dao.findByID(ShareHelper.USER.getUserid());
				request.setAttribute("nguoi",vs);
				request.setAttribute("roler",vs.getRoler());	
			}else {
				request.getRequestDispatcher("/trangchu/login.jsp").forward(request, response);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Users us = new Users();
			BeanUtils.populate(us, request.getParameterMap());
			UserDAO dao = new UserDAO();
			us.setRoler(ShareHelper.USER.getRoler());
			dao.update(us);
			System.out.println(us.getUserid());
			request.setAttribute("message", "Cập nhật thành công");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Lỗi");
		}
	}

}
