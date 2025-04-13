package Java;

import java.util.*;

public class hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
         * float math = sc.nextFloat();
         * float Science = sc.nextFloat();
         * float Hindi = sc.nextFloat();
         * float English = sc.nextFloat();
         * float Social_Science = sc.nextFloat();
         * 
         * double AverageOfMarks = (math + Science + Hindi + English + Social_Science) /
         * 5;
         * System.out.println(AverageOfMarks);
         */

        /*
         * int a = sc.nextInt();
         * int b = sc.nextInt();
         * int c = sc.nextInt();
         * int sum = a + b + c;
         * System.out.println(sum);
         */

        /*
         * float Science = sc.nextFloat();
         * float Hindi = sc.nextFloat();
         * float English = sc.nextFloat();
         * 
         * float percentage = ((Science + Hindi + English) / 300) * 100;
         * double cgpa = percentage / 9.5;
         * 
         * System.out.println(cgpa);
         */

        /*
         * System.out.println("Enter your name :");
         * String name = sc.next();
         * System.out.println("Hello " + name + ", have a good day" );
         */

        // System.out.println("Enter kilometers : ");
        // int kilometers = sc.nextInt();
        // System.out.println(kilometers * 1.60934);

        /*
         * System.out.println("Enter number");
         * boolean b = sc.hasNextInt();
         * if(b == true) {
         * System.out.println("Number");
         * }else {
         * System.out.println("not number");
         * }
         */

        /*
         * int i = 5;
         * System.out.println(i);// 5
         * System.out.println(i++); // 5
         * System.out.println(i); // 6
         * System.out.println(++i); // 7
         * System.out.println(i); // 7
         * System.out.println(i--); // 7
         * System.out.println(i); // 6
         * System.out.println(--i); // 5
         * System.out.println(i); // 5
         */

        /*
         * float a = 7 / 4 * 9 / 2;
         * System.out.println(a);
         */

        int age1 = 18;
        int age2 = 18;
        /*
         * boolean con = (age1 == 18);
         * if(age1 == 18 && age2 == 18) {
         * System.out.println("You can drive");
         * } else {
         * System.out.println("You can't drive");
         * }
         */
        // System.out.println("Enter your Age");
        // int age = sc.nextInt();
        /*
         * if (age1 > 18) {
         * System.out.println("You can vote");
         * } else if (age > 19 && age < 20) {
         * System.out.println("You are younger");
         * } else if (age >= 21 && age < 25) {
         * System.out.println("you are super 20's boy");
         * } else {
         * System.out.println("You are child");
         * }
         */

        // String TrafficLight = sc.nextLine();
        /*
         * switch (TrafficLight) {
         * case "red":
         * System.out.println("Stop, SomeTimes Go After green");
         * break;
         * case "green":
         * System.out.println("Go");
         * break;
         * case "yellow":
         * System.out.println("Stop, Prepare");
         * break;
         * default:
         * System.out.println("Traffic light broken");
         * }
         * 
         * switch (TrafficLight) {
         * case "red" -> System.out.println("Stop, SomeTimes Go After green");
         * case "green" -> System.out.println("Go");
         * case "yellow" -> System.out.println("Stop, Prepare");
         * 
         * default -> {
         * System.out.println("Traffic light broken");
         * }
         * }
         */
        // String var = "Shubham";
        /*
         * switch (age) {
         * case 18 -> {
         * System.out.println("You are young");
         * }
         * case 17 -> {
         * System.out.println("You are 20's boy");
         * }
         * default ->
         * System.out.println("You are child");
         * }
         */

        /*
         * int a = 11;
         * if(a == 11) {
         * System.out.println("I am 11");
         * } else {
         * System.out.println("I am not 11");
         * }
         */

        /*
         * int English = sc.nextInt();
         * int Math = sc.nextInt();
         * int Hindi = sc.nextInt();
         * double avg = (English + Math + Hindi) / 3.0;
         * System.out.println("Overall percentage is: " + avg);
         * if(avg >= 40 && English >= 33 && Math>=33 && Hindi >= 33){
         * System.out.println("Congratulations, you have been promoted");
         * } else {
         * System.out.println("Sorry, you have not been promoted");
         * }
         */

        /*
         * while (true) {
         * System.out.println("fmg");
         * }
         */

        /*
         * int a = 10;
         * while (a < 5) {
         * System.out.println(a);
         * a++;
         * }
         * 
         * do {
         * System.out.println(a);
         * a++;
         * } while (a < 5);
         */
        int n = 5;
        for (int i = 1; i <= n; i++) {
            // System.out.print(2*i + " ");
            // System.out.print(2*i+1 + " ");
        }

        for (int i = n; i >= 0; i--) {
            // System.out.println(i);
        }

        /*
         * for(int i=0; i<n; i++) {
         * System.out.println(i);
         * System.out.println("Java is great!");
         * if(i == 2) {
         * System.out.println("Ending the loop");
         * break;
         * }
         * }
         */

        /*
         * for(int i=0; i<n; i++) {
         * if(i == 2) {
         * System.out.println("Skip");
         * continue;
         * }
         * System.out.println(i);
         * System.out.println("Java is great!");
         * }
         */

        /*
         * for(int i=0; i<n; i++) {
         * for(int j=0; j<n-i; j++) {
         * System.out.print("*" + " ");
         * }
         * System.out.println();
         * }
         */

        /*
         * int sum = 0;
         * int i = 0;
         * int m = 5;
         * while (i <= m) {
         * sum += i;
         * i++;
         * }
         * System.out.println(sum);
         */

        for (int i = 1; i <= 10; i++) {
            // System.out.printf("%d X %d = %d\n", n, i, i * n);
        }

        /*
         * for(int i=10; i>=1; i--) {
         * System.out.println(i * n);
         * }
         */

        /*
         * int fac = 1;
         * for(int i=1; i<=n; i++) {
         * fac *= i;
         * }
         * System.out.println(fac);
         */

        /*
         * int marks[] = new int[5];
         * marks[0] = 100;
         * marks[1] = 60;
         * marks[2] = 70;
         * marks[3] = 90;
         * marks[4] = 86;
         */
        // marks[5] = 96;
        /*
         * for (int i = 0; i < marks.length; i++) {
         * System.out.println(marks[5]);
         * }
         * System.out.println(marks.length);
         * 
         * for (int ele : marks) {
         * System.out.println(ele);
         * }
         * 
         * for(int i=marks.length-1; i>=0; i--) {
         * System.out.println(marks[i]);
         * }
         */

        // 2-D Arrays
        /*
         * int flats[][] = new int[2][3];
         * flats[0][0] = 001;
         * flats[0][1] = 002;
         * flats[0][2] = 003;
         * flats[1][0] = 101;
         * flats[1][1] = 102;
         * flats[1][2] = 103;
         * 
         * for(int i=0; i<flats.length; i++) {
         * for(int j=0; j<flats[i].length; j++) {
         * System.out.print(flats[i][j]);
         * System.out.print(" ");
         * }
         * System.out.println("\n");
         * }
         */

        /*
         * float arr[] = {5.8f, 2.878f, 465.4f, 45.8f, 99.5f};
         * int sum = 0;
         */
        /*
         * for(int i=0; i<arr.length; i++){
         * sum += arr[i];
         * }
         * System.out.println(sum);
         * 
         * for(float ele:arr) {
         * sum += ele;
         * }
         * System.out.println(sum);
         * 
         */
        /*
         * float num = 46.4f;
         * boolean isInArray = false;
         * for(float eles: arr) {
         * if(num == eles) {
         * isInArray = true;
         * break;
         * }
         * }
         * System.out.println(isInArray);
         */

        /*
         * int mat1[][] = {{1, 2, 3}, {5, 8, 6}};
         * int mat2[][] = {{1, 8, 9}, {5, 3, 7}};
         * int res[][] = {{0, 0, 0}, {0, 0, 0}};
         * 
         * for(int i=0; i<mat1.length; i++) {
         * for(int j=0; j<mat1[i].length; j++) {
         * System.out.printf("Setting value for i=%d and j=%d", i, j);
         * res[i][j] = mat1[i][j] + mat2[i][j];
         * System.out.println();
         * }
         * System.out.println();
         * }
         */

        // Strings
        /*
         * String name = "Jaykant";
         * System.out.print("The name is:");
         * System.out.println(name);
         * 
         * int a = 6;
         * float b = 8898.57f;
         * System.out.printf("The value of a is %d and value of b is %f", a, b);
         * System.out.format("The value of a is %d and value of b is %f", a, b);
         * 
         * String str = sc.nextLine();
         * System.out.println(str);
         */

        /*
         * String name = "Jaykant";
         * System.out.println(name.length()); // 7
         * 
         * System.out.println(name.toLowerCase()); //jaykant
         * System.out.println(name.toUpperCase()); //JAYKANT
         * 
         * String nonTrimString = "       Jaykant     ";
         * System.out.println(nonTrimString);// Jaykant with space
         * System.out.println(nonTrimString.trim());//Jaykant without space
         * 
         * System.out.println(name.substring(2));//ykant
         * System.out.println(name.substring(2, 5));//yka
         * System.out.println(name.replace('y', 'a'));//Jaakant
         * System.out.println(name.replace("an", "aa"));// Jaykaat
         * 
         * System.out.println(name.startsWith("J"));//true
         * System.out.println(name.endsWith("t"));//true
         * 
         * System.out.println(name.charAt(2));//y
         * System.out.println(name.indexOf("a"));//1
         * String names = "Jaykaaant";
         * System.out.println(names.indexOf("a", 3));//4
         * 
         * System.out.println(names.lastIndexOf('a'));//6
         * System.out.println(name.lastIndexOf("a", 3));// 1
         * 
         * System.out.println(name.equals("jaykant"));//false
         * System.out.println(name.equalsIgnoreCase("JayKanT"));//True
         * 
         * System.out.println("I am escape sequence \" double quotes");
         */

    }

    public static void rightSwap(int nums[]) {
        
    }
}
