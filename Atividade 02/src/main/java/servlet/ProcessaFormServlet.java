package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cadastro;

@WebServlet("/processa")
public class ProcessaFormServlet extends HttpServlet{
	
	private static final long serialVersionUID = 4255514644284885363L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String nome = req.getParameter("field_name");
		String dataStr = req.getParameter("field_date");
		String idioma = req.getParameter("field_language");
		String [] habilidades = req.getParameterValues("field_habilidades");
		
		LocalDate data = LocalDate.parse(dataStr);
		
		try {
			Cadastro cad = new Cadastro();
			
			cad.setNome(nome);
			cad.setData(data);
			cad.setHabilidades(habilidades);
			cad.setIdioma(idioma);
			
		} catch (Exception e){
			resp.getWriter().println(e.getMessage());
		}
		
		resp.getWriter().println("Nome: " + nome);
		resp.getWriter().println("Data: " + formato.format(data));
		resp.getWriter().println("Idioma: " + idioma);
		
		for(int i = 0; i < habilidades.length; i++) {

			resp.getWriter().println("Habilidades: " + habilidades[i]);
		}
	}

}
