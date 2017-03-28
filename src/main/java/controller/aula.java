package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/calculadora")
public class aula extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double num1 = Double.parseDouble(req.getParameter("num1"));
		double num2 = Double.parseDouble(req.getParameter("num2"));
		String opcao = req.getParameter("operador");
		double rest = 0;
		if (opcao.equals("som")) {
			rest = num1 + num2;
		}
		if (opcao.equals("sub")) {
			rest = num1 - num2;
		}
		if (opcao.equals("mult")) {
			rest = num1 * num2;
		}
		if (opcao.equals("div")) {
			rest = num1 / num2;
		}
		resp.getWriter().print("{Resultado: " + rest + "}");

	}

}
