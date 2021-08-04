package olj;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class scoretablecontroller {
	@FXML
	private TextField id;
	@FXML
	private Label show_id;
	@FXML
	private Button VS;
	@FXML
	private Button back;
	@FXML
	private Label q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24;
	@FXML
	public void vs() {
		Workbook workbook = null;
		String s = id.getText();
		show_id.setVisible(true);
		show_id.setText("Now showing student "+s+"'s score ...");
		int q = Integer.parseInt(s);
		String[] a = new String[24];
		try {

            workbook = Workbook.getWorkbook(new File("./src/olj/Score/Score.xls"));

            Sheet sheet = workbook.getSheet(0);
            
            for(int i=0;i<24;i++) {
            	Cell cell = sheet.getCell(i, q-1);
                a[i] = cell.getContents();
            }
            q1.setText("1."+a[0]);
            q2.setText("2."+a[1]);
            q3.setText("3."+a[2]);
            q4.setText("4."+a[3]);
            q5.setText("5."+a[4]);
            q6.setText("6."+a[5]);
            q7.setText("7."+a[6]);
            q8.setText("8."+a[7]);
            q9.setText("9."+a[8]);
            q10.setText("10."+a[9]);
            q11.setText("11."+a[10]);
            q12.setText("12."+a[11]);
            q13.setText("13."+a[12]);
            q14.setText("14."+a[13]);
            q15.setText("15."+a[14]);
            q16.setText("16."+a[15]);
            q17.setText("17."+a[16]);
            q18.setText("18."+a[17]);
            q19.setText("19."+a[18]);
            q20.setText("20."+a[19]);
            q21.setText("21."+a[20]);
            q22.setText("22."+a[21]);
            q23.setText("23."+a[22]);
            q24.setText("24."+a[23]);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }
	}
	@FXML
	public void back_pressed() throws IOException {
		Parent M = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene MScene = new Scene(M);
		MScene.getRoot().requestFocus();
		Main.currentStage.setScene(MScene);
	}
}
