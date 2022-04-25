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

/**
 * Servlet implementation class dangky
 */
@WebServlet({"/dangky","/dangky/insert"})
public class dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangky() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/trangchu/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mk = request.getParameter("pass");
		String mk1 = request.getParameter("pass1");
		String uri = request.getRequestURI().toString();
		if(uri.contains("insert")) {
			if(mk.equals(mk1)) {
				insert(request, response);
			}else {
				System.out.println("Mật khẩu phải trùng");
			}
			
		}
		
		request.getRequestDispatcher("/trangchu/register.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Users us = new Users();
			BeanUtils.populate(us, request.getParameterMap());
			UserDAO dao = new UserDAO();
			us.setRoler(false);
			dao.insert(us);
			request.setAttribute("message", "Thêm thành công");
			System.out.println(us.getUserid());
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Lỗi");
		}
	}

}
