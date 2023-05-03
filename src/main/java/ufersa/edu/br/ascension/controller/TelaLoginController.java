/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ufersa.edu.br.ascension.model.service.UsuarioService;
import ufersa.edu.br.ascension.model.dao.UsuarioDao;
import ufersa.edu.br.ascension.model.entidades.Usuario;

public class TelaLoginController {
	   @FXML
	    private Button btnCriarConta;

	    @FXML
	    private Button btnEntrar;

	    @FXML
	    private Label labelMensagem;

	    @FXML
	    private PasswordField txtSenha;

	    @FXML
	    private TextField txtUsuario;
    

    
    @FXML
    void criarConta(ActionEvent event) {
    	
    }

    @FXML
    void realizarLogin(ActionEvent event) {
    	String login = txtUsuario.getText();
    	String senha = txtSenha.getText();
    	Usuario usuario = UsuarioDao.fazerLogin("C:\\Users\\Usuário\\Documents\\GitHub\\Ascencion\\src\\Database\\usuarios.txt", login, senha);
    	if (usuario != null) {
    		labelMensagem.setText("Login bem sucedido");
    	} else {
    		labelMensagem.setText("Falha ao logar");
    	}
    }
}
