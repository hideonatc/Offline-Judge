package olj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class Q_controll {
	@FXML
	public Label Q_Label;
	@FXML
	public Label submit_notifi;
	@FXML
	public Label ac_label;
	@FXML
	public Label wa_label;
	@FXML
	public Label I_Label;
	@FXML
	public Label O_Label;
	@FXML
	private TextArea code;
	@FXML
	private Button submit;
	@FXML
	private Button back;
	@FXML
	private void initialize() throws IOException {
		
	    File tar = new File("./src/olj/Puzzles/"+MenuControll.queid+".txt");
		
	    Scanner myReader = new Scanner(tar);
	    while (myReader.hasNextLine()) {
	      String data = myReader.nextLine();
	      while(myReader.hasNextLine()) {
	    	   	data = myReader.nextLine();
	        	if(data.equals("--b--"))break;
	        	Q_Label.setText(Q_Label.getText()+data);
	        	Q_Label.setMaxWidth(535);
	        	Q_Label.setWrapText(true);
	      }
	      while(myReader.hasNextLine()) {
	        	data = myReader.nextLine();
	        	if(data.equals("--c--"))break;
	        	I_Label.setText(I_Label.getText()+data);
	        	I_Label.setMaxWidth(259);
	        	I_Label.setWrapText(true);
	      }
	      while(myReader.hasNextLine()) {
	        	data = myReader.nextLine();
	        	if(data.equals("--d--"))break;
	        	O_Label.setText(O_Label.getText()+data);
	        	O_Label.setMaxWidth(259);
	        	O_Label.setWrapText(true);
	      }
	      File file = new File("./src/olj/Compile/input.txt");
          file.createNewFile();
          FileWriter writer = new FileWriter(file); 
	      while(myReader.hasNextLine()) {
	        	data = myReader.nextLine();	
	        	if(data.equals("--e--")) break;
	        	data+="\n";
	            writer.write(data);   
	      	    writer.flush();
	      }
          writer.close();
	      file = new File("./src/olj/Compile/answer.txt");
          file.createNewFile();
          FileWriter writer2 = new FileWriter(file); 
	      while(myReader.hasNextLine()) {
	        	data = myReader.nextLine();
	        	data+="\n";
	            writer2.write(data); 
	            writer2.flush();
	      }
          writer2.close();
          break;
	    }
	    myReader.close();
	}
	@FXML
	private void submit_pressed() throws NumberFormatException, WriteException, BiffException, IOException {
		submit_notifi.setVisible(true);
        //read code
        File file = new File("./src/olj/Compile/code.cpp");
        file.createNewFile();
        FileWriter writer3 = new FileWriter(file); 
        String data = code.getText().replaceAll("\n", System.getProperty("line.separator"));
        writer3.write(data); 
        writer3.flush();
        writer3.close();       
        //execute "compiler.exe"
        
        /*Runtime rn = Runtime.getRuntime();
        Process p = null;
        String pr = System.getProperty("user.dir")+"\\src\\olj\\Compile\\c.bat";
        System.out.println(pr);*/
        ProcessBuilder builder = new ProcessBuilder(System.getProperty("user.dir")+"\\src\\olj\\Compile\\"+"compiler.exe");
    	builder = builder.directory(new File(System.getProperty("user.dir")+"\\src\\olj\\Compile\\"));
        
        try {
        	Process pp = builder.start();
        /*p = rn.exec(pr);*/
        } catch (Exception e) {
        System.out.println("Error exec!");
        }
        //read result
        try
	    {
	    Thread.currentThread().sleep(1000);
	    }
	    catch(Exception e){
	    }
        File t = new File("./src/olj/Compile/result.txt");
	    Scanner mr = new Scanner(t);
	    String res = mr.nextLine();
	    if(res.equals("AC")) {
	    	ac_label.setVisible(true);
	    	wa_label.setVisible(false);
	    }
	    else {
	    	wa_label.setVisible(true);
	    	ac_label.setVisible(false);
	    }
	    mr.close();
		DataReader.setValueIntoCell(Integer.parseInt(MenuControll.queid),Integer.parseInt(MenuControll.stuid),res);
	}
	@FXML
	private void back_pressed() throws IOException{
		Parent M = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene MScene = new Scene(M);
		MScene.getRoot().requestFocus();
		Main.currentStage.setScene(MScene);
	}
}
