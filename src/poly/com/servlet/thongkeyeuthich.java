package poly.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poly.com.DAO.FavoriteDAO;
import poly.com.DAO.UserDAO;
import poly.com.DAO.VideoDAO;
import poly.com.entity.FavoriteByYear;
import poly.com.entity.Users;
import poly.com.ults.ShareHelper;

/**
 * Servlet implementation class thongkeyeuthich
 */
@WebServlet({ "/thongkeyeuthich", "/thongkeyeuthich/chonnam" })
public class thongkeyeuthich extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public thongkeyeuthich() {
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
			setYearForSelectBox(request, response);
			edituser(request, response);
			request.getRequestDispatcher("/trangchu/thongkeyeuthich.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		edituser(request, response);
		setYearForSelectBox(request, response);
		String uri = request.getRequestURI();
		if (uri.contains("chonnam")) {
			favoriteVidByYear(request, response);
		}

		request.getRequestDispatcher("/trangchu/thongkeyeuthich.jsp").forward(request, response);
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

	private void setYearForSelectBox(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDAO dao = new FavoriteDAO();
			List<Integer> listYear = dao.getYearForFavoriteVids();
			request.setAttribute("sendYear", listYear);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void favoriteVidByYear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int year = Integer.valueOf(request.getParameter("getYear"));
			System.out.print(year);
			VideoDAO dao = new VideoDAO();
			List<FavoriteByYear> list = dao.reportFavoriteByYear(year);
			request.setAttribute("fav", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
