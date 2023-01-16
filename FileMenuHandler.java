import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class FileMenuHandler implements ActionListener{
	  public static int tokens;					        //needed variables and instances of objects
	  public static TextFileInput DateFile,DateFile2;
	  public static StringTokenizer DateTokens,DateTokens2;
	  public static Date212[] DateArray;
	  public static String[] dateListUnsorted, dateListSorted;
	  static TreeMap<String,String> DateMap = new TreeMap <String, String>();	  //TreeMap 
	  DateGUI date;
	
 public FileMenuHandler (DateGUI jf) {
	   date = jf;
	 }
	  
  public void actionPerformed(ActionEvent event) {		//method which tells the program how to
	      String menuName = event.getActionCommand();	//react when 
	      if (menuName.equals("Open"))			//different buttons are clicked on
	            openFile(); 
	      else if (menuName.equals("Quit"))
	         System.exit(0);
	   } 
	  
	  
   public static void readFromFile(File filename)  {			//method which reads the file
   		int k = 0;
		String line, line2, file1 = filename.getAbsolutePath();
		 DateFile = new TextFileInput(file1);
		  line = DateFile.readLine();

	     while (line!=null) {					// count the amount of tokens
		    DateTokens = new StringTokenizer(line,",");
		 	tokens += DateTokens.countTokens();
		 		line = DateFile.readLine();
		 				}
		 	dateListUnsorted = new String[tokens];		// declare an array with the size of the tokens
		 	DateFile2 = new TextFileInput(file1);
			 line2 = DateFile2.readLine();
			 			
	          while (line2!= null) {				//while there are more lines, create tokens
		      DateTokens2 = new StringTokenizer(line2,",");	
		   while (DateTokens2.hasMoreTokens()) {		//while there are more tokens, append the tokens to the array
		 	dateListUnsorted[k++] = DateTokens2.nextToken();		
		 			}
		 	    line2= DateFile2.readLine();		//read the next line
		 				}
		 		printLists(dateListUnsorted);
		 		}
	   				
			  						
   public static void printLists(String[] list) {			 //append the unsorted array to the GUI
	    	dateListSorted = new String [dateListUnsorted.length];
	    for(int i = 0; i < dateListUnsorted.length; i++) {
	    		 DateMap.put(list[i], null);			 //append the unsorted dates to a TreeMap to be sorted 
	    	}
	    	  DateArray = new Date212[dateListUnsorted.length];
	    	int k =0;
	   	    Set DateSet = DateMap.entrySet();
	        Iterator i1 = DateSet.iterator();
	      while (i1.hasNext()) {
	        	Map.Entry Date = (Map.Entry) i1.next();
	        		DateArray[k++] = new Date212(Date.getKey());		//append the key to a Date212 array
	        }
	      for(int i = 0; i < dateListUnsorted.length; i++) {
	    		DateGUI.unsortedDates.append(dateListUnsorted[i]);		//append the unsorted dates onto the GUI
				DateGUI.unsortedDates.append("\n");
	      }
			for(int i = 0; i <dateListSorted.length; i++ ) {
				DateGUI.sortedDates.append(String.valueOf(DateArray[i]));	//append the sorted Date212's onto the GUI
			  	  DateGUI.sortedDates.append("\n"); 
			}
	    	}
	   
   private void openFile() {					//method to open file
      JFileChooser chooser;
      int          status;
      chooser = new JFileChooser();
      status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) 
	   readFromFile(chooser.getSelectedFile());		
	else 
	   JOptionPane.showMessageDialog(null, "File retrieval cancelled"); //if you click on cancel when searching for a file, this message appears.
	  }	  
}
