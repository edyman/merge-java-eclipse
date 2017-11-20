import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;


public class MergeFiles {
	
	public static void main(String args[]) throws IOException {
		XMLSlideShow ppt = new XMLSlideShow();
	
		//taking the two presentations that are to be merged 
	      String file1 = "file1.pptx";
	      String file2 = "file2.pptx";
	      String[] inputs = {file1, file2};
	      
	      for(String arg : inputs){
	      
	         FileInputStream inputstream = new FileInputStream(arg);
	         XMLSlideShow src = new XMLSlideShow(inputstream);
	         
	         for(XSLFSlide srcSlide : src.getSlides()) {
	         
	            //merging the contents
	            ppt.createSlide().importContent(srcSlide);
	         }
	      }
	     
	      String file3 = "combinedpresentation.pptx";
	      
	      //creating the file object
	      FileOutputStream out = new FileOutputStream(file3);
	      
	      // saving the changes to a file
	      ppt.write(out);
	      System.out.println("Merging done successfully");
	      out.close();
	}

}
