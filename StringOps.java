package OSlab;

import java.util.*;

//Class for Reversing Name
class ReverseName extends Thread {
	public String STRArr[];

	public ReverseName(String[] STRArr) {
		this.STRArr = STRArr;
	}

	@Override
	public void run() {

		System.out.println("\n");
		for (int i = 2; i >= 0; i--) {
			System.out.print(STRArr[i] + " ");
		}
		System.out.println("\n");
	}
}

//Class for The permutation of first 4 letters of name
class printPermutations extends Thread {

	public String Name;

	public printPermutations(String Name) {
		this.Name = Name;
	}

	@Override
	public void run() {

		int[] PArray = new int[Name.length() + 1];
		PArray[0] = 1;

		for (int i = 1; i <= Name.length(); i++) {
			PArray[i] = PArray[i - 1] * i;
		}

		for (int i = 0; i < PArray[Name.length()]; i++) {
			String P1 = "";
			String temp = Name;
			int PosCode = i;

			for (int pos = Name.length(); pos > 0; pos--) {
				int selected = PosCode / PArray[pos - 1];

				P1 += temp.charAt(selected);
				PosCode = PosCode % PArray[pos - 1];

				temp = temp.substring(0, selected) + temp.substring(selected + 1);
			}
			System.out.print(P1 + " ");
		}
		System.out.println("\n");
	}
}

//Class for Rearranging Name according to D;
class RearrangeName extends Thread {

	public String FN;
	public int D;

	public RearrangeName(String FullName, int d) {
		this.FN = FullName;
		this.D = d;
	}

	@Override
	public void run() {
		int Len = FN.length(), i, j, m = 0, n = 0, count = 0, f = 0;

		// array containing the first name
		char[] Array = new char[Len];
		for (i = 0; i < Len; i++) {
			Array[i] = FN.charAt(i);
		}

		// Array of repeating letters
		char[] Repeated = new char[Len];

		// array of nonrepeating letters
		char[] NonRepeated = new char[Len];

		// array for number of repeated letters
		int[] Cntd = new int[Len];

		// CODE FOR DIFFERENTIATE REPEATING AND
		// NON REPEATING ALPHABETS
		for (i = 0; i < Len; i++) {
			char Ch = Array[i];

			for (j = i + 1; j < Len; j++) {
				if (Ch == Array[j]) {
					count++;
				}
			}
			if (count > 0) {
				for (j = 0; j < Len; j++) {
					if (Ch == Repeated[j])
						f = 1;
				}
				if (f == 0) {
					Repeated[m] = Ch;
					m++;
				}
				f = 0;
			} else {
				NonRepeated[n] = Ch;
				n++;
			}
			count = 0;
		}

		// Counts No of elements in Repeated[]
		for (i = 0; i < Len; i++) {
			if (Repeated[i] != 0) {
				count++;
			}
		}

		// Counts NO of elements in NonRepeated[]
		char Z = Array[Len - 1];
		int A = 0;
		for (i = 0; i < Len; i++) {
			if (Z == Repeated[i]) {
				f = 1;
			}

		}
		if (f == 1) {
			for (i = 0; i < Len; i++) {
				if (NonRepeated[i] != 0) {
					A++;
				}
			}
			NonRepeated[A - 1] = 0;
		}

		// IF There is no Repetition in letters in the Name
		if (count == 0) {
			System.out.print("d = " + D + ", ");
			D--;
			int temp = Len - D;
			char X = Array[temp - 1];

			for (i = 0; i < Len; i++)
				System.out.print(Array[i]);
			System.out.println(X + "\n");
		}

		// ELSE IF there is Repetition of letters
		else {
			int C = 0;
			char Y;
			for (i = 0; i < Len; i++) {
				if (Repeated[i] != 0) {
					Y = Repeated[i];
					for (j = 0; j < Len; j++) {
						if (Array[j] == Y) {
							C++;
						}
					}
					Cntd[i] = C;
					C = 0;
				}
			}
			j = Cntd[0];
			i = 0;
			n = 0;
			while (i < j) {
				System.out.print(Repeated[0]);
				m = 0;
				while (m < D - 1) {
					if (n < Len) {
						System.out.print(NonRepeated[n]);
						n++;
					}
					m++;
				}
				i++;
			}
		}
	}
}

public class Code_201951065 extends Thread {
	public static void main(String[] args) {

		 Scanner Scan = new Scanner(System.in);
		 boolean f = false;
		
		 //String array containing full name
		 String[] StrArr = new String[3];
		 String S;
		
		 //user inputs- user name
		 do {
			 System.out.println("\nEnter Your Full Name (First_name Middle_name Last_name) :-");
			 for(int i=0; i<3; i++) {
				 StrArr[i] = Scan.next();
			 }
			 if(StrArr[0].length() < 4) {
				 f = true;
				 System.out.println("ERROR! Please enter first name having more than 3 letters...");
			 }
			 else {
				 f = false;
			 }
		 } while(f);
		
		 do {
			 System.out.println("\nEnter your Roll Number :- ");
			 S = Scan.next();
			 if(S.length() != 9) {
				 f = true;
				 System.out.println("ERROR! Please enter 9-digit roll no");
			 }
			 else {
				 f = false;
			 }
		 } while(f);
		
		 int x,y,z;
		 int L = StrArr[0].length();
		 String Name = StrArr[0].substring(0,4);
		
		 x=Integer.parseInt(S.substring(0,1));
		 y=Integer.parseInt(S.substring(4,5));
		 z=Integer.parseInt(S.substring(8,9));
		
		 int d = x+y+z;
		
		 //constrain of d
		 while(d > L) {
			 if(d % 2 != 0)
			 d++;
			 d = d/2;
		 }
		
		 Thread T1 = new Thread(new ReverseName(StrArr));
		 T1.start();
		 Thread T2 = new Thread(new printPermutations(Name));
		 T2.start();
		 Thread T3 = new Thread(new RearrangeName(StrArr[0], d));
		 T3.start();

	}
}