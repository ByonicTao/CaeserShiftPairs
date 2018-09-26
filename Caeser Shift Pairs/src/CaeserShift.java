import java.io.*;

public class CaeserShift {
	
	static char[] startArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; // regular alphabet
	
	static char[] codeArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; // coded alphabet
	
	// main
    public static void main (String args[]) {	
        String [] fileContents = getFileContents("message.txt");
        for (int i = 0; i < fileContents.length; i++) {
           System.out.println(fileContents[i]);
        }
        fileContents = shiftYeet(fileContents);
        
        
        writeArrayToFile("cypher.txt", fileContents);
    } // main

    // methods
    // -------
    public static String [] shiftYeet(String [] message) {
    	char [] shift = null;
    	String temp = message[0];
    	temp = temp.toUpperCase();
    	shift = temp.toCharArray();
    	int rand = 1 + (int)(Math.random( ) * 25);
    	String [] shifted = null;
    	
    	
    	for (int i = 0; i < startArray.length; i++) {
    		if(i + rand >= 26) {
    			codeArray[i] = startArray[(i + rand) - 26];
    		} else {
    			codeArray[i] = startArray[i + rand];
    		}//else if
    		System.out.print(codeArray[i]);
    	}//for
    	
    	for (int m = 0; m < shift.length; m++) {
			for (int i = 0; i < codeArray.length; i++) {
				if (shift[m] < 'A' || shift[m] > 'Z') {
					i++;
					continue;
				} else if (shift[m] == startArray[i]) {
					shift[m] = codeArray[i];
					break;
				} // if else
			} // for
		} // for
    	temp = "";
    	for (int i = 0; i < shift.length; i++) {
    		temp += shift[i];
    	}
    	shifted = temp.split("");
    	SOP(temp);
    	return shifted;
    }//shiftYeet
    
    
    //  reads fileName and returns the contents as String array
    //  with each line of the file as an element of the array
    public static String [] getFileContents(String fileName){

        String [] contents = null;
        int length = 0;
        try {

           // input
           String folderName = ""; // if the file is contained in the same folder as the .class file, make this equal to the empty string
           String resource = fileName;

			// this is the path within the jar file
			InputStream input = CaeserShift.class.getResourceAsStream(folderName + resource);
			if (input == null) {
				// this is how we load file within editor (eg eclipse)
				input = CaeserShift.class.getClassLoader().getResourceAsStream(resource);
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(input));	
           
           
           
           in.mark(Short.MAX_VALUE);  // see api

           // count number of lines in file
           while (in.readLine() != null) {
             length++;
           }

           in.reset(); // rewind the reader to the start of file
           contents = new String[length]; // give size to contents array

           // read in contents of file and print to screen
           for (int i = 0; i < length; i++) {
             contents[i] = in.readLine();
           }
           in.close();
       } catch (Exception e) {
           System.out.println("File Input Error");
       }

       return contents;

    } // getFileContents

    // writes the array a to fileName, one array element per line in the file
    public static void writeArrayToFile(String fileName, String [] a) {
        try {

           // output file pointer
           BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

           // write array to file
           for (int i = 0; i < a.length; i++) {
               out.write(a[i]+ "");
               out.newLine(); // adds new line to file
           } // for

           out.close();

       } catch (Exception e) {
           System.out.println("File Output Error");
       }

    } // writeArrayToFile

    //SOP methods
	public static void SOP(String talk) {
		System.out.println(talk);
	} //SOP String
	
	public static void SOP(int talk) {
		System.out.println(talk);
	} //SOP int
	
	public static void SOP(double talk) {
		System.out.println(talk);
	} //SOP double
	
	public static void SOP(char talk) {
		System.out.println(talk);
	} //SOP char
}//CaeserShift
