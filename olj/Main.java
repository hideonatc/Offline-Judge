package olj;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.stage.Stage;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;

public class Main extends Application{
	public static Stage currentStage;
	public static Scene menuScene;
	@Override
	public void start(Stage primaryStage)throws Exception{
		currentStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		menuScene = new Scene(root);
		currentStage.setTitle("Offline Judge");
		currentStage.setScene(menuScene);
		currentStage.show();
	}
	public static void main(String[] args){
		launch(args);
	}
}