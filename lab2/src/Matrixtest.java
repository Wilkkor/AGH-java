import java.util.Scanner;
public class Matrixtest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj rows i cols");
        int rows=2,cols=3;
        double[][] tab={{1,1,1},{1,1,1},{1,1,1}};
        Matrix A=new Matrix(tab);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.printf("%f ",A.data[A.rows*i+j]);
            }
            System.out.println("");
        }
    }
}
