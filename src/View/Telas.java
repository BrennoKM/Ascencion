/*package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage stage;
	
	private void setStage(Stage st) {
		stage = st;
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		setStage(arg0);
		arg0.setTitle("ASCENSION");
		TeladeLogin();
	}
	
	public static void TeladeLogin() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeLogin.fxml")); 
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela de Login");
			stage.setResizable(false);
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String args[]) {
		launch(); 
	}
}*/
