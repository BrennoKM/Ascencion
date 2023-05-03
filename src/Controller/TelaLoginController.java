package Controller;

import Model.DAO.UsuarioDAO;
import Model.Entity.Usuario;
import Model.Service.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    	Usuario usuario = UsuarioDAO.fazerLogin("C:\\Users\\Usuário\\Documents\\GitHub\\Ascencion\\src\\Database\\usuarios.txt", login, senha);
    	if (usuario != null) {
    		labelMensagem.setText("Login bem sucedido");
    	} else {
    		labelMensagem.setText("Falha ao logar");
    	}
    }
}
