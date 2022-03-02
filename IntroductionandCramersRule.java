
public class SchneegassKayleeAssignment1 {

	public static void main(String[] args) {
		/* Name: Kaylee Schneegass
		   Class: 
		   Due: 26 JAN
		   Description: Assignment 1
		   This code prints out 2 introductory paragraphs about me.
		   The program then provides a short demonstration on Cramer's Rule.
		*/
		
		System.out.println("   Hello World! My name is Kaylee and I am a Computer Science Major with a focus in Cybersecurity.\n"
				+ "I am 28 years old this year and I grew up in Cameron Park, California.\n"
				+ "I went to two high schools in California. Both high schools didn't prepare me for college.\n"
				+ "I first started college in 2012 at Montana State University in Bozeman, MT where I was undeclared.\n"
				+ "After 1.5 years at MSU, I moved back to California where I joined the United States Army.\n");
		System.out.println("   I served in the United States Army for 6 years working on satellite communications equipment.\n"
				+ "I learned computer networking through my job and I can take those skills to enhance my education.\n"
				+ "Working in the Army was very fulfilling for me because I was able to figure out what I wanted to do in life.\n"
				+ "Now I work part-time so I can focus on my degree. I started my degree in 2012; it's about time I finish.\n"
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
