package olj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class DataReader {
	public static void setValueIntoCell(int qid ,int id, String rs) throws WriteException, BiffException {
            try {
            	FileInputStream in = new FileInputStream(new File("./src/olj/Score/Score.xls"));
            	Workbook wb = Workbook.getWorkbook(in);
            	WritableWorkbook book = Workbook.createWorkbook( new File("./src/olj/Score/Score.xls"),wb);
            	WritableSheet sheet = book.getSheet("Score");
            	sheet.addCell( new Label( qid-1 , id-1 , rs ));
            	book.write();
            	book.close();
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
}
