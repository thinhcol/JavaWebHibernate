package poly.com.servlet;

import java.io.IOException;
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
import poly.com.DAO.UserDAO;
import poly.com.entity.Users;

/**
 * Servlet implementation class quenmatkhau
 */
@WebServlet({"/quenmatkhau","/quenmatkhau/mail"})
public class quenmatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quenmatkhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/trangchu/fogotpasss.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI().toString();
		if(uri.contains("mail")) {
			guimail(request, response);
		}
		request.getRequestDispatcher("/trangchu/fogotpasss.jsp").forward(request, response);
	}
	protected void guimail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		try {
			UserDAO dao = new UserDAO();
			Users user = dao.findByID(id);
			if (!user.getEmail().equals(email)) {
				request.setAttribute("message", "Sai email!");
			} else {
				
				String to = email;
				String subject = "Quên mật khẩu";
				String body = "Mật khẩu của bạn là " + user.getPass();
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
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
					msg.setSubject(subject,"utf-8");
					msg.setText(body,"utf-8");
					Transport.send(msg);
					request.setAttribute("message", "Gửi mail thành công");
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception e) {
			request.setAttribute("error", "Sai tên đăng nhập!");
			e.printStackTrace();
		}
	}
	

}
