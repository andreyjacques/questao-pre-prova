package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Operador;
import model.Resultado;

@WebServlet(urlPatterns = "/calculadora")
public class aula extends HttpServlet {

	private List<Object> lista = new ArrayList<Object>();
	private List<Object> listaResultado = new ArrayList<Object>();

	private JsonHelper jsonHelper = new JsonHelper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		String opcao = req.getParameter("operador");
		double resu = 0;

		Operador info = new Operador(num1, num1, opcao);

		if (opcao.equals("som")) {
			resu = num1 + num2;
		}
		if (opcao.equals("sub")) {
			resu = num1 - num2;
		}
		if (opcao.equals("mult")) {
			resu = num1 * num2;
		}
		if (opcao.equals("div")) {
			resu = num1 / num2;
		}

		// resp.getWriter().print("{Resultado: " + rest + "}");
		Resultado resultado = new Resultado(resu);

		lista.add(info);

		listaResultado.add(resultado);

		resp.getWriter().println("Add com sucesso!");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String json;
		try {
			json = jsonHelper.gerarJsonLista(listaResultado);
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
