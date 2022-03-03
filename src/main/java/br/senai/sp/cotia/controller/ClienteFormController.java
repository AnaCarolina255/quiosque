package br.senai.sp.cotia.controller;

import java.time.Period;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.cotia.dao.DaoForm;
import br.senai.sp.cotia.model.ClienteForm;
import br.senai.sp.cotia.model.TipoGeneroForm;
import br.senai.sp.cotia.model.TipoProdutoForm;

@Controller
public class ClienteFormController {

	@RequestMapping("formCadastro")
	public String formCliente(Model model) {
		model.addAttribute("tiposProdutos", TipoProdutoForm.values());
		model.addAttribute("tiposGeneros", TipoGeneroForm.values());
		return "formcadastro";
	}

	@RequestMapping("salvaCliente")
	public String salvarCliente(ClienteForm cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getDataNascimento());
		System.out.println(cliente.getEndereco());
		System.out.println(cliente.getCelular());
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getTipoGenero());
		System.out.println(cliente.getTipoProduto());

		DaoForm dao = new DaoForm();
		if (cliente.getId() == null) {
			dao.inserir(cliente);
		} else {
			dao.atualizar(cliente);
		}

		return "redirect:listarCliente";

	}

	@RequestMapping("listarCliente")
	public String listaClientes(Model model) {
		DaoForm dao = new DaoForm();
		model.addAttribute("clientes", dao.listar());
		
			List<ClienteForm> cliente = new DaoForm().listar();

			int feminino = 0;
			int masculino = 0;
			int outros = 0;
			int jovem = 0;
			int adulto = 0;
			int idoso = 0;
			int manha = 0;
			int tarde = 0;
			int noite = 0;

			for (ClienteForm c : cliente) {
				if (c.getTipoGenero().equals("masculino")) {
					masculino++;
				} else if (c.getTipoGenero().equals("feminino")){
					feminino++;
				} else {
					outros++;
				}
				
				if (c.getIdade() < 18) {
					jovem++;
				} else if (c.getIdade() < 65) {
					adulto++;
				} else {
					idoso++;
				}
				
			}
			
			return "consultacliente";
		}
	

	@RequestMapping("excluirCliente")
	public String excluir(long idCliente) {
		DaoForm dao = new DaoForm();
		dao.excluir(idCliente);
		return "redirect:listarCliente";
	}

	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		DaoForm dao = new DaoForm();
		model.addAttribute("cliente", dao.buscar(idCliente));

		return "forward:formCadastro";
	}

	@RequestMapping("contCliente")
	public String Contador(ClienteForm cliente, Model model) {

		Calendar sc = Calendar.getInstance();

		int ano = sc.get(Calendar.YEAR);
		int dom = 0;
		int seg = 0;
		int ter = 0;
		int quar = 0;
		int quin = 0;
		int sex = 0;
		int sab = 0;

		DaoForm dao = new DaoForm();

		for (ClienteForm client : dao.listar()) {

			switch (sc.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				dom++;
				break;
			case Calendar.MONDAY:
				seg++;
				break;
			case Calendar.TUESDAY:
				ter++;
				break;
			case Calendar.WEDNESDAY:
				quar++;
				break;
			case Calendar.THURSDAY:
				quin++;
				break;
			case Calendar.FRIDAY:
				sex++;
				break;
			case Calendar.SATURDAY:
				sab++;
				break;
			default:
				System.out.println("Dia inválido!!");
				break;
			}
		}

		model.addAttribute("dom", dom);
		model.addAttribute("seg", seg);
		model.addAttribute("ter", ter);
		model.addAttribute("quar", quar);
		model.addAttribute("quin", quin);
		model.addAttribute("sex", sex);
		model.addAttribute("sab", sab);

		return "redirect:listarCliente";

	}



}
