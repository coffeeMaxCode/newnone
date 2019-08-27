package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CookiesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException{
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		String db_id="test";
		String db_pw="test";
		String db_name="test";
		if((db_id.equals(mem_id))&&(db_pw.equals(mem_pw))) {
			Cookie cookie = new Cookie("c_name",db_name);
			cookie.setMaxAge(60*10);
			cookie.setPath("/");
			res.addCookie(cookie);
		}
		res.sendRedirect("layout_1.jsp");
	}
}
