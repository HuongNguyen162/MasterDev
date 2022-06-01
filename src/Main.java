import java.util.Scanner;

import static java.lang.Math.sqrt;

class JavaProject1
{
    static int ASCII_SIZE = 256;

    public static void Summary(int n) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[n];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < n; i++)
        {
            a[i] = scanner.nextInt();
            sum = sum + a[i];
        }
        System.out.println("Sum:"+sum);
    }

    public static void getMaxOccurringChar() {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        str = scanner.nextLine();

        int[] count = new int[ASCII_SIZE];

        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;

        int max = -1;
        char result = ' ';

        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        System.out.println("Max occurring character is: " + result);
    }

    public static void SortAscending() {
        int count, temp;

        Scanner scan = new Scanner(System.in);
        count = scan.nextInt();

        int[] num = new int[count];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < count; i++)
        {
            num[i] = scan.nextInt();
        }
        scan.close();
        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count; j++) {
                if (num[i] > num[j])
                {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        System.out.print("Array Elements in Ascending Order: ");
        for (int i = 0; i < count - 1; i++)
        {
            System.out.print(num[i] + ", ");
        }
        System.out.print(num[count - 1]);
    }

    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = scanner.nextInt();
        if (isPrime(n)) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }
    }

    public static void Triangle() {
        double s, p;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first side of the triangle: ");
        float a = scanner.nextFloat();

        System.out.print("Enter the Second side of the triangle: ");
        float b = scanner.nextFloat();

        System.out.print("Enter the final side of the triangle: ");
        float c = scanner.nextFloat();

        if (a + b > c && b + c > a && c + a > b && a > 0 && b > 0 && c > 0) {
            p = (a + b + c)/2;
            s = (float)Math.sqrt(p * (p-a) * (p-b) * (p-c));
            System.out.println("Is 3 side of a triangle. Area: " + s);
        } else {
            System.out.println("Not 3 sides of a triangle");
        }
    }

    static void printPattern(int radius) {

        double dist;

        for (int i = 0; i <= 2 * radius; i++) {

            for (int j = 0; j <= 2 * radius; j++) {
                dist = Math.sqrt((i - radius) * (i - radius) +
                        (j - radius) * (j - radius));

                if (dist > radius - 0.5 && dist < radius + 0.5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int chose;

        do {
        System.out.println("****************************************");
        System.out.println("01. Sum array");
        System.out.println("02. Max occurring character");
        System.out.println("03. Array Elements in Ascending Order");
        System.out.println("04. Check prime number");
        System.out.println("05. Calculate the area of the triangle");
        System.out.println("06. Print circle pattern");
        System.out.println("07. End program");
        System.out.print("Enter your choice: ");
        chose = scanner.nextInt();


            switch (chose) {
                case 1:

                    System.out.print("Enter no. of elements you want in array:");
                    int n = scanner.nextInt();
                    Summary(n);
                    break;

                case 2:
                    getMaxOccurringChar();
                    break;

                case 3:
                    System.out.print("Enter number of elements you want in the array: ");
                    SortAscending();
                    break;

                case 4:
                    primeNum();
                    break;

                case 5:
                    Triangle();
                    break;

                case 6:
                    System.out.print("Enter radius: ");
                    int r = scanner.nextInt();
                    printPattern(r);
                    break;

                case 7:
                    System.out.print("Program ended");
                    break;
            }
        } while(chose != 7);

    }

}