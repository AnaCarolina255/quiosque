package br.senai.sp.cotia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContadorServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String feminino = req.getParameter("feminino");
		String masculino = req.getParameter("masculino");
		String jovem = req.getParameter("jovem");
		String adulto = req.getParameter("adulto");
		String idoso = req.getParameter("idoso");
		String segunda = req.getParameter("segunda");
		String terca = req.getParameter("terca");
		String quarta = req.getParameter("quarta");
		String quinta = req.getParameter("quinta");
		String sexta = req.getParameter("sexta");
		String sabado = req.getParameter("sabado");
		String domingo = req.getParameter("domingo");
		String manha = req.getParameter("manha");
		String tarde = req.getParameter("tarde");
		String noite = req.getParameter("noite");
		
		
	}
}
