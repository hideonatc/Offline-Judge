package olj;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class MenuControll {
			public static String stuid;
			public static String queid;
	        ObservableList<String> id = FXCollections.observableArrayList("Student","TA");
	        @FXML
	    	public Label error_message;
	        @FXML
	        private ChoiceBox cb_id;
	        @FXML
	        private ChoiceBox cb_que;
	        @FXML
	        private TextField stu_id;
	        @FXML
	        private TextField que_id;
	        @FXML
	        private Button view_score;
	        @FXML
	        private Button ok;
	        @FXML
	        private Button leave;
	        @FXML
	        private Button check;
			@FXML
	        private void initialize() {
	        	cb_id.setItems(id);
	        }
			@FXML
			public void check_pressed() {
				if(cb_id.getValue()=="Student") {
	        		stu_id.setVisible(true);
	        		que_id.setVisible(true);
	        		view_score.setVisible(false);
	        		ok.setVisible(true);
	        	}
				else {
					stu_id.setVisible(false);
					que_id.setVisible(false);
					view_score.setVisible(true);
					ok.setVisible(false);
				}
			}
			@FXML
			public void leave_pressed() {
				Main.currentStage.close();
			}
			@FXML
			public void vs_pressed() throws IOException {
				Parent S = FXMLLoader.load(getClass().getResource("ScoreTable.fxml"));
				Scene SScene = new Scene(S);
				SScene.getRoot().requestFocus();
				Main.currentStage.setScene(SScene);
			}
			@FXML 
			public void ok_pressed() throws IOException, WriteException, BiffException{
				error_message.setVisible(false);
				String q = "./src/olj/Puzzles/"+que_id.getText()+".txt";
				File ex = new File(q);
				if(!ex.exists()||(cb_id.getValue()=="Student"&&stu_id.getText().equals(""))) {
					error_message.setVisible(true);
				}
				else{
					if(cb_id.getValue()=="Student") {
						stuid = stu_id.getText();
					}
					queid = que_id.getText();
					Parent Q = FXMLLoader.load(getClass().getResource("Q.fxml"));
					Scene QScene = new Scene(Q);
					QScene.getRoot().requestFocus();
					Main.currentStage.setScene(QScene);
				}
			}
}