
public class IntroductionandCramersRule {

	public static void main(String[] args) {
		/* Name: Kaylee
		   Class: 
		   Due: 26 JAN
		   Description: Assignment 1
		   This code prints out 2 introductory paragraphs about me.
		   The program then provides a short demonstration on Cramer's Rule.
		*/
		
		System.out.println("   Hello World! My name is Kaylee and I am a Computer Science Major with a focus in Cybersecurity.\n");
		System.out.println("   Now I work part-time so I can focus on my degree. I started my degree in 2012; it's about time I finish.\n"
				+ "My future goals include:\n    1) Finishing my degree;\n    2) Contributing to Linux/Open-source community with code I make;\n"
				+ "    3) Learn everything I can about cybersecurity.\n\n\n");
		
		System.out.println("Cramer's Rule Demo:");
		System.out.println("Equation: x = ((e*d)-(b*f))/((a*d)-(b*c));\n"
				+ "	  y = ((a*f)-(e*c))/((a*d)-(b*c));\n\n"
				+ "Solving: 3.4x + 50.2y = 44.5 & 2.1x + 0.55y = 5.9\n");
		
		float a = 3.4f;
		float b = 50.2f;
		float c = 2.1f;
		float d = 0.55f;
		float e = 44.5f;
		float f = 5.9f;
		
		double x = ((e*d)-(b*f))/((a*d)-(b*c));
		double y = ((a*f)-(e*c))/((a*d)-(b*c));
		
		System.out.print("The value of x = " + x + "\n");
		System.out.print("The value of y = " + y);
	} // main

} // Assignment1
