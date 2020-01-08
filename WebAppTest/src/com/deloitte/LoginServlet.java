package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.bean.User;
import com.deloitte.service.LoginService;
import com.deloitte.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login", "/create", "/logout","/usercheck" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService lService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init Called");
		lService = new LoginServiceImpl();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Destroy Called");
		lService.closeConnection();// called when servlet is removed from memory
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet Called");
		String path = request.getServletPath();
		System.out.println("Path : " + path);
		HttpSession session = request.getSession();
		switch (path) {
		case "/login":
			String login = request.getParameter("login");
			String password = request.getParameter("pswd"); // null if not present
			// System.out.println(login + ", " + password);
			User user = new User(login, password, null);
			String type = lService.getUserType(user);
			System.out.println("Type  : " + type);
			/*
			 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
			 * out.println("<html><head><title> From Servlet </title></head>");
			 * out.println("<body>"); out.println("<h1>WELCOME TO DELOITTE</h1>");
			 * out.println("<p>You are logged in as " + type + "</p>");
			 * out.println("</body>"); out.println("</html>");
			 */
			String displayPage = "customer.jsp";

			if (type == null) {
				request.setAttribute("loginerror", "Authentication failed");
				displayPage = "index.jsp";
			} else if (type.equals("admin")) {
				request.setAttribute("usertype", "Logged in as a ADMIN");
				displayPage = "admin.jsp";
			} else if (type.equals("employee")) {
				request.setAttribute("usertype", "Logged in as an EMPLOYEE");
				displayPage = "employee.jsp";
			} else {
				request.setAttribute("usertype", "Logged in as a CUSTOMER"); // default customer
			}
			if (type != null) {

				session.setAttribute("user", type);
			}
			request.getRequestDispatcher(displayPage).forward(request, response);

			break;

		case "/create":

			login = request.getParameter("login");
			password = request.getParameter("pswd");
			type = request.getParameter("type");
			user = new User(login, password, type);
			boolean success = lService.saveUser(user);
			if (success) {
				request.getRequestDispatcher("success.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("fail.jsp").forward(request, response);

			}

			break;
		case "/usercheck":
			login = request.getParameter("login");
			System.out.println("User check Login: "+login);
			response.getWriter().write(login+" already exists");
			break;
		case "/logout":
			session.invalidate(); // removes all attributes in session
			break;
         default:
        	 break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost Called");
		doGet(request, response);
	}

}
