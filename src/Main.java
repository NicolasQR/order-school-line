import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public final static String character = " ";


	public static void main(String[] args) throws IOException {
		
		String data = "";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String txtMount = br.readLine();
		int mount = Integer.parseInt(txtMount);
		
		
		double[] inOrder = null;
		String[] numbers = null;
		
		for(int i = 0; i < mount; i++) {
			
			numbers = br.readLine().split(character);
			inOrder = new double[numbers.length];
			inOrder = parseInt(inOrder, mount, numbers);
			data += lowerToHigher(inOrder) + "\n";
			
		}
		
		bw.write(data);
		
		bw.close();
		br.close();
	}
	
	
	
	
	public static double[] parseInt(double[] inOrder, int mount, String[] numbers) {
		
		if(inOrder != null && numbers != null) {
			for(int j = 0; j < inOrder.length; j ++) {
				inOrder[j] = Double.parseDouble(numbers[j]);
			}
		}
		
		return inOrder;
	}
	
	
	public static String lowerToHigher(double[] inOrder) {
		
		String data;
		double average = 0;
		double changesInIf = 0;
		double changesInFor = 0;
		
		if(inOrder != null) {
			for(int i = 1; i < inOrder.length; i++) {
				
				changesInFor++;
				
				for(int j = 0; j < (inOrder.length -i); j++) {
					
					if( inOrder[j] > inOrder[j+1]) {
						double temp = inOrder[j];
						inOrder[j] = inOrder[j+1];
						inOrder[j+1] = temp;
						changesInIf ++;
					}
				}
			
			}
			
			average = changesInIf / changesInFor;
			average = Math.round(average*100.0)/100.0;
		}
		
		data = average + "-";
		for(int i = 0; i < inOrder.length; i++) {
			data += inOrder[i] + " ";
		}
		return data;
	}
	
	
	
	
	
	
}
