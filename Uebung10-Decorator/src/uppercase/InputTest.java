/**
 * 
 */
package uppercase;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yehezkel Sivan
 * @version 14.April 2016, v1.0
 */
public class InputTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int c;
		try{
			InputStream in = 
					new UpperCaseInputStream(
							new BufferedInputStream(
									new FileInputStream("Input.txt")));
			while((c = in.read()) >=0){
				System.out.println((char)c);
			}
			in.close();
		}catch (IOException e){
			e.printStackTrace();
		}

	}

}