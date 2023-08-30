package com.beck.day02;

public class Hello_Test {
  public static void main(String[] args) {
    System.out.println("test");
    for (int x = 1; x < 6; x++) {
      System.out.println("Hello count # " + x);
    }
    bank_account b = new bank_account(2343.32);
    System.out.println(b);
    // Print the following message with double quotation marks included.
    //I read "Java: A Beginner's Guide", by Herbert Schildt
    // Write a Student class so this code works:
    Person student = new Student("Joe", 3.4);
    System.out.println("I read \"Java: A Beginner's Guide\", by Herbert Schildt");
    int[] arr = {12, 2, 9, 18, 10, 14, 6, 16};
    //print the average of all numbers div by 3
    int total=0;
    int count =0;
    for (int i : arr){
      if (i%3==0){
        count++;
        total = total+i;
      }
      double average = total/(double)count;
      System.out.println(average);
    }
    //// Write a for loop based on the following description.
    //        //Assign 0 to a sum variable before the loop. Start the loop count variable at 1.
    //        The loop will continue while the sum is less than 50. Each time the loop iterates,
    //        add 2 to the count variable. Inside the loop, add the value of the count variable
    //        to the sum variable and print the new sum. Don't print the sum if it is divisible by 3 or 5.
    //
    int sum = 0;
    for (int i = 1; sum<50;i=i+2){
      sum=sum+i;
      if (!(sum%5==0) && !(sum%3==0) ){System.out.println(sum );}

    }
    // instantiate
    // instance of a class is an object
    // class is a representation of a real life thing
    // they have fields, instance variable, property
    // constructors are methods with the same name as the class name
    // a parameter is input variable to a method (function in python, or procedure in sql)
    // the argument is the actual numberic or string value that gets passed to the method


    mystery mystery1 = new mystery(5);
    mystery mystery2 = mystery1;
    mystery2.setNum(3);
    System.out.println(mystery1.getNum());
    // Given the following code:
    String num1 = "one";
    int num2 = 0;

    //Write a try-catch statement that handles a NumberFormatException.
    //Inside the try block, parse num1 to an Integer and assign the result to num2.
    //Inside the catch block, print "'%s' is not a valid integer". Substitute %s with the value assigned to num1.
    //Outside the try-catch statement, cast num2 to a double and assign it to a variable called num3.
    try {num2 =Integer.parseInt(num1);}
    catch (NumberFormatException n){
      System.out.printf( "%s is not a valid integer\n",num1);
    }
    double num3 = (double)num2;
    System.out.println(num3);
    //


  }




}
