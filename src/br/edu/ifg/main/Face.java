package br.edu.ifg.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.edu.ifg.model.Pessoa;
import br.edu.ifg.service.Agenda;

public class Face extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel containerPrincipal;
	private JButton jbAdicionar;
	private JButton jbRemover;
	private JButton jbBuscar;
	
	private JTextField txfNomePessoa;
	private JFormattedTextField jtxfTelefone;
	private JTextField txfEmail;
	
	private JLabel jlNome;
	private JLabel jlTelefone;
	private JLabel jlEmail;
	
	private MaskFormatter mascaraTelefone;
		
	private String nome;
	private String email;
	private String telefone;
	
	private boolean encontrado=false;
	
	Agenda service = new Agenda();
	Pessoa pessoa = new Pessoa();

	
	public Face() throws IOException {
		iniciaInterface();
		
	}

	private void iniciaInterface() throws IOException{
		iniciaJP();
		defineMask();
		defineBt();
		acoesBottons();
		defineTxf();
		setVisible(true);
	};
	
	
	private void iniciaJP() {
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Agenda");
		containerPrincipal = new JPanel();
		containerPrincipal.setLayout(null);
		this.add(containerPrincipal);	
	};
	
	private void defineTxf() {
		txfNomePessoa = new JTextField();
		txfNomePessoa.setBounds(20, 20, 150, 20);
		containerPrincipal.add(txfNomePessoa);
		
		jtxfTelefone = new JFormattedTextField(mascaraTelefone);
		jtxfTelefone.setBounds(20, 60, 150, 20);
		containerPrincipal.add(jtxfTelefone);
		
		txfEmail = new JTextField();
		txfEmail.setBounds(20, 100, 200, 20);
		containerPrincipal.add(txfEmail);
		
	};
	
	
	void defineBt() {
		jbAdicionar = new JButton("Adicionar");
		jbAdicionar.setBounds(40, 370, 100, 20);
		containerPrincipal.add(jbAdicionar);

		jbRemover = new JButton("Remover");
		jbRemover.setBounds(150, 370, 100, 20);
		containerPrincipal.add(jbRemover);

		jbBuscar = new JButton("Buscar");
		jbBuscar.setBounds(260, 370, 100, 20);
		containerPrincipal.add(jbBuscar);
	};
	
	void acoesBottons() {
		jbAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adionar();
				service.adicionar(pessoa);
				limparCampos() ;
			}
		});
		
		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				encontrado= service.buscar(nome,pessoa);
				if(encontrado==true)
					JOptionPane.showMessageDialog(null, pessoa.toString());
				else
					JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
				encontrado=false;
			}
		});
		
		jbRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				encontrado=service.remover(nome);
				if(encontrado==true) {
					JOptionPane.showMessageDialog(null, "Pessoa Removida");
					
				}
				else
					JOptionPane.showMessageDialog(null, "Pessoa nao encontrada");
				encontrado=false;


					
			}
		});
		
	}
	
	void defineMask() {
		 try {
			mascaraTelefone = new MaskFormatter("(##)#####-####");
			mascaraTelefone.setPlaceholderCharacter('_');

		} catch (ParseException e) {
			e.printStackTrace();
		}
	};
	
	void adionar() {
	nome = txfNomePessoa.getText().trim();
	telefone = jtxfTelefone.getText().trim();
	email = txfEmail.getText().trim();
	
	pessoa.setEmail(email);
	pessoa.setTelefone(telefone);
	pessoa.setNomePessoa(nome);
	
	System.out.println(pessoa.getNomePessoa());
	System.out.println(pessoa.getTelefone());
	System.out.println(pessoa.getEmail());

	};
	
	void limparCampos() {
		txfNomePessoa.setText("");
		jtxfTelefone.setText("");
		txfEmail.setText("");
	}
	
	
	public static void main(String[] args) throws IOException {
		new Face();
	}
}
