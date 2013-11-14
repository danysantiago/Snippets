
public class CTI_1dot4 {

	public static void main(String[] args) {
		char[] string = {'M','r',' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
		int trueSize = 13;
		
		int p = trueSize-1;
		int i = string.length - 1;
		while( i > 0) {
			if(string[p] == ' ') {
				string[i--] = '0';
				string[i--] = '2';
				string[i--] = '%';
			} else {
				string[i--] = string[p];
			}
			
			p--;
		}
		
		for(char c : string) {
			System.out.print(c);
		}

	}

}
