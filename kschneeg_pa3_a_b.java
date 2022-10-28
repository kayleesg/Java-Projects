/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author robertkroleski
 */
import java.util.*;
import java.io.*;
import java.math.*;

public class kschneeg_pa3_a_b {

    public static void main(String[] args) {

        double[][] alpha = new double[2][2];
        double[][] aTimesS = new double[2][2];
        double[][] lambda = new double[2][2];
        double[][] shear = new double[2][2];
        double[][] rotation = new double[2][2];
        double[][] rotationTransposed = new double[2][2];
        double[][] rotationTimesLambda = new double[2][2];
        double[][] result = new double[2][2];

        alpha[0][0] = 1;
        alpha[0][1] = 2;
        alpha[1][0] = 1;
        alpha[1][1] = 2;

        double vectorb1 = -11;
        double vectorb2 = -13;
        double u1;
        double u2;

        // Part A
        System.out.println("Part A (Cramer's Rule):");
        if (alpha[0][0] * alpha[1][1] == alpha[0][1] * alpha[1][0]) {
            System.out.println("Denominator equals zero.");
        } else {
            u1 = ((vectorb1 * alpha[1][1]) - (alpha[0][1] * vectorb2)) / ((alpha[0][0] * alpha[1][1]) - (alpha[0][1] * alpha[1][0]));
            u2 = ((alpha[0][0] * vectorb2) - (vectorb1 * alpha[1][0])) / ((alpha[0][0] * alpha[1][1]) - (alpha[0][1] * alpha[1][0]));
            System.out.println("");

            System.out.println("U1:" + u1);
            System.out.println("");
            System.out.println("U2:" + u2);
            System.out.println("");
        }

        // Part B
        System.out.println("Part B (Eigen Things):");

        double diagonal = findDiagonalSum(alpha[0][0], alpha[1][1]);
        double determinant = findDeterminant(alpha);
        double insideRoot = ((diagonal*diagonal) - (4.0*determinant));
        int numberEigenvalues = checkInsideRoot(insideRoot);

        printMatrix(alpha, "Alpha Matrix:");
        
        //processLambda(lambda, numberEigenvalues, diagonal, determinant);
        findLambdaValues(lambda, alpha);
        printMatrix(lambda, "Lambda Matrix:");

        if (alpha[1][0] != 0) {
        	buildShear(shear, alpha, lambda);
            printMatrix(shear, "Shear Matrix:");
            multiplyMatrix(aTimesS, alpha, shear);
        } else {
        	for (int i = 0; i < alpha.length; i++) {
        		for (int j = 0; j < alpha[i].length; j++) {
        			aTimesS[i][j] = alpha[i][j];
        		}
        	}
        }
        
        
    	if ((aTimesS[1][1] - lambda[0][0]) == 0) {
    		rotation[0][1] = 1;
    	} else {
    		rotation[0][1] = 0;
    	}
        rotation[0][0] = buildR(aTimesS, lambda[0][0]);
        
        
    	if ((aTimesS[1][1] - lambda[1][1]) == 0) {
    		rotation[1][1] = 1;
    	} else {
    		rotation[1][1] = 0;
    	}
        rotation[0][1] = buildR(aTimesS, lambda[1][1]);

        
        printMatrix(rotation, "R Matrix:");
        buildRTransposed(rotationTransposed, rotation);

        printMatrix(rotationTransposed, "R-Transposed:");

        multiplyMatrix(rotationTimesLambda, rotation, lambda);
        printMatrix(rotationTimesLambda, "(R * Lambda:)");

        multiplyMatrix(result, rotationTimesLambda, rotationTransposed);
        printMatrix(result, "Eigendecomposition RA(R)T:");
    }

    // checkInsideRoot checks:
    public static int checkInsideRoot(double insideRoot) {
        if (insideRoot == 0) {
            return 1;
        } else if (insideRoot < 0) {
            return 0;
        } else {
            return 2;
        }
    }

    // processLambda creates the capital lambda, A, matrix in the RA(R)T formula
    public static void processLambda(double[][] lambda, int numberEigenvalues, double diagonal, double determinant) {
        
        lambda[1][0] = 0;
        lambda[0][1] = 0;
        
    	if (numberEigenvalues == 0) {
            System.out.println("No real eignevalues");
        } else if (numberEigenvalues == 1) {
            lambda[0][0] = solveQuadratic(diagonal, determinant, '+');
            lambda[1][1] = solveQuadratic(diagonal, determinant, '+');
        } else {
            if ((Math.abs(solveQuadratic(diagonal, determinant, '+'))) > (Math.abs(solveQuadratic(diagonal, determinant, '-')))) {
                lambda[0][0] = solveQuadratic(diagonal, determinant, '+');
                lambda[1][1] = solveQuadratic(diagonal, determinant, '-');
            } else {
                lambda[0][0] = solveQuadratic(diagonal, determinant, '-');
                lambda[1][1] = solveQuadratic(diagonal, determinant, '+');

            }
        }
    }

    // ATTENTION: Is this a better option to the processLambda? The math isn't adding up for processLambda
    public static void findLambdaValues(double[][] lambda, double[][] alpha) {
    	lambda[1][0] = 0;
        lambda[0][1] = 0;
        double lambda1;
        double lambda2;
        
        // this if statement checks if the formula is x^2 + #x, where the quadratic formula is not needed
        // else goes to compute the quadratic formula
        if ((alpha[0][0] * alpha[1][1]) - (alpha[0][1] * alpha[1][0]) == 0) {
        	lambda1 = (-1) * (((-1)*alpha[0][0]) + ((-1)*alpha[1][1]));
        	lambda2 = 0;
        } else {
        	lambda1 = findLambdas(alpha, '+');
        	lambda2 = findLambdas(alpha, '-');
        }
        
        // dominant eigenvalue is set to the top left corner by checking the absolute value of each value
        if (Math.abs(lambda1) > Math.abs(lambda2)) {
        	lambda[0][0] = lambda1;
        	lambda[1][1] = lambda2;
        } else {
        	lambda[0][0] = lambda2;
        	lambda[1][1] = lambda1;
        }
    }
    
    // part 2 on findLambdaValues. This function uses the quadratic formula to find the lambda values and is working
    // (-b +/- sqrt(b^2 - 4ac)) / 2a
    public static double findLambdas(double[][] alpha, char sign) {
    	double lambda;
    	double a = 1;
    	double b = ((-1) * alpha[0][0]) + ((-1) * alpha[1][1]);
    	double c = (alpha[1][0] * alpha[0][1]) + (alpha[0][0] * alpha[1][1]);
    	if (sign == '+') {
    		lambda = ((-1)*b + (Math.sqrt((b*b) - (4*a*c)))) / (2*a);
    	} else {
    		lambda = ((-1)*b - (Math.sqrt((b*b) - (4*a*c)))) / (2*a);
    	}
    	return lambda;
    }
    
    // printMatrix is used to print any matrix that is passed to it
    public static void printMatrix(double[][] matrix, String message) {
    	System.out.println(message);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.printf("%.4f   ", matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // mulitplyMatrix multiplies two matrixes, a and b, and multiplies them together. The results are stored
    // in matrix
    public static void multiplyMatrix(double[][] matrix, double[][] a, double[][] b) {
        matrix[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        matrix[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        matrix[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        matrix[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
    }

    // findDiagonalSum does:
    public static double findDiagonalSum(double a11, double a22) {
        return (double) (a11 + a22);
    }

    // findDeterminant finds the determinant of the matrix that is passed to it
    public static double findDeterminant(double[][] a) {
        return (a[0][0] * a[1][1]) - (a[1][0] * a[0][1]);
    }

    // solveQuadratic finds the root and returns the value
    public static double solveQuadratic(double diagonal, double determinant, char operator) {
        double lambda = 0;
        if (operator == '+') {
            lambda = (double) (((diagonal * -1) + (Math.sqrt((diagonal * diagonal) - (4 * determinant)))) / 2);
        }
        if (operator == '-') {
            lambda = (double) (((diagonal * -1) - (Math.sqrt((diagonal * diagonal) - (4 * determinant)))) / 2);
        }
        return lambda * -1;
    }

    // Creates the shear matrix
    public static void buildShear(double[][] shear, double[][] alpha, double[][] lambda)
    {
        shear[0][0] = 1;
        shear[1][1] = 1;
        shear[0][1] = 0;
        shear[1][0] = -(alpha[1][0] / alpha[0][0]);
    }

    // buildR returns the second value for r that makes the R matrix in RA(R)T formula
    public static double buildR(double[][] aTimesS, double lambdaVal) {
    	double r1;
    	double a12 = aTimesS[0][1];
    	double a21 = aTimesS[1][0];
    	r1 = (-(a12 - lambdaVal) / (a21 - lambdaVal));
    	return r1;
    }

    // buildRTransposed builds (R)T in RA(R)T formula
    public static void buildRTransposed(double[][] rotationTransposed, double[][] rotation) {
        rotationTransposed[0][0] = rotation[0][0];
        rotationTransposed[1][0] = rotation[0][1];
        rotationTransposed[0][1] = rotation[1][0];
        rotationTransposed[1][1] = rotation[1][1];
    }
}
