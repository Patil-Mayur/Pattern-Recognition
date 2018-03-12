package pseudoinverse;

import Jama.Matrix;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;


public class Psuedo
{
  public static void main(String args[])
  {
    int m, n;
    Scanner sc = new Scanner(System.in);
    System.out.println("Please Enter Non Singular Matrix");
    System.out.println("Enter m and n values");
    System.out.println("Enter m");
    m = sc.nextInt();
    System.out.println("Enter n");
    n = sc.nextInt();
    double[][] array = new double[m][n];
    System.out.println("Enter elements in matrix");
    for(int i = 0; i < m; i++)
    {
      for(int j = 0; j < n; j++)
      {
        System.out.println("Enter " + i + " * " + j);
        array[i][j] = sc.nextDouble();
      }
    }
    Matrix A = new Matrix(array);
    Matrix B = psuedoInverse(A);
    // B.getArray() converts into array and Array function deepToString() method converts into string
    System.out.print(Arrays.deepToString(B.getArray()));
  }
  
  public static Matrix psuedoInverse(Matrix X)
  {
    if(X.getColumnDimension() == X.getRowDimension())
    {
      return X.inverse();
    }
    else if(X.getColumnDimension() > X.getRowDimension())
    {
      return (((X.transpose()).times(X)).inverse()).times(X);
    }
    else
    {
      return (X.transpose()).times((X.times(X.transpose())).inverse());
    }
  }
}