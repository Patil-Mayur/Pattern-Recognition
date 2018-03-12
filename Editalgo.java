package editdistance;

import java.io.*;
import java.util.Scanner;
import java.lang.Math.min;

public class Editalgo
{
  public static void main(String args[])
  {
    String s1, s2;
    Scanner sc = new Scanner();
    System.out.println("Enter First String");
    s1 = sc.nextLine();
    System.out.println("Enter Second String");
    s2 = sc.nextLine();
    int value = distance(s1, s2);
    System.out.println(value + "\n");
  }
  
  public int editDistance(String str1,String str2)
  {
    if(str1.equals(str2))
    {
      return 0;
    }
    if(str1.length() == 0) return str2.length();
    if(str2.length() == 0) return str1.length();
    int[] v0 = new int[str2.length() + 1];
    int[] v1 = new int[str2.length() + 1];
    for(int i = 0; i < v0.length; i++)
      v0[i] = i;
    for (int i = 0; i < str1.length(); i++)
    {
      v1[0] = i + 1;
    
      for(int j = 0; j < str2.length(); j++)
      {
        int cost = (str1.charAt(i) == str2.charAt(j)) ? 0 : 1;
        v1[j + 1] = Math.min(Math.min(v1[j] + 1, v0[j + 1] + 1), v0[j] + cost);
      }
      for(int j = 0; j < v0.length; j++)
        v0[j] = v1[j];
    }
    return v1[str2.length()];
  }
}