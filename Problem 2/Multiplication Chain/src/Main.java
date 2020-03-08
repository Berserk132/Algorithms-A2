import java.util.ArrayList;
import java.util.Scanner;

class Main {


    String line = "";
    String[] nums = new String[2];
    int n = 0;


    void printParenthesis(int i, int j,
                          int[][] bracket)
    {
        // If only one matrix left in current segment
        if (i == j)
        {
            System.out.print("A" + i) ;
            return;
        }

        System.out.print("(");


        printParenthesis(i, bracket[i][j],
                bracket);

        System.out.print(" x ");

        printParenthesis(bracket[i][j] + 1, j, bracket);
        System.out.print(")");
    }


    void matrixChainOrder(int p[], int n, int caseNumber) {

        int[][] matrix = new int[n][n];


        int[][] brackets = new int[n][n];


        for (int i = 1; i < n; i++)
            matrix[i][i] = 0;

        for (int length = 2; length < n; length++) {

            for (int i = 1; i < n - length + 1; i++) {

                int j = i + length - 1;
                matrix[i][j] = 10000000;

                for (int k = i; k <= j - 1; k++) {

                    int result = matrix[i][k] + matrix[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (result < matrix[i][j]) {
                        matrix[i][j] = result;

                        brackets[i][j] = k;
                    }
                }
            }
        }

        char name = 'P';

        System.out.print("Case "+ caseNumber +": ");
        printParenthesis(1, n-1, brackets);
        System.out.println(" ");
    }


    public static void main(String[] args) {

        Main c = new Main();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();

        int index = 0;
        int[] arr;
        int tmp = 0;
        int caseNumber = 1;
        int counter = 0;

        c.n = sc.nextInt();

        while(sc.hasNextInt()){

            arr = new int[c.n + 1];
            for (int i = 0; i < c.n; i++){

                if (i == 0){

                    c.nums = c.line.split(" ");

                    arr[index++] = sc.nextInt();
                    arr[index++] = sc.nextInt();
                    continue;
                }

                tmp = sc.nextInt();
                arr[index++] = sc.nextInt();
            }
            if (counter == 0){

                System.out.println("");
            }

            int arraySize = arr.length;
            c.matrixChainOrder(arr, arraySize,caseNumber++);
            c.n = sc.nextInt();
            index = 0;
            counter++;

            if (c.n == 0) break;
        }

    }
}
