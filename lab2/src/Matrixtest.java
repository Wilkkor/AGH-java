import java.util.Scanner;
public class Matrixtest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj rows i cols");
        double[][] tab={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Matrix A=new Matrix(tab);
        //System.out.println(A.get(3,3));
        System.out.println("rows"+A.getrows()+" cols "+A.getcols());
        for(int i=0;i<A.getrows();i++){
            for(int j=0;j<A.getcols();j++){
                System.out.printf("%f ",A.get(i,j));
            }
            System.out.println("");
        }
        double[][] a=A.asArray();
        System.out.println("teraz wypisze tablicę");
        for(int i=0;i<A.getrows();i++){
            for(int j=0;j<A.getcols();j++){
                System.out.printf("%f ",a[i][j]);
            }
            System.out.println("");
        }
        for(int i=0;i<A.getrows();i++){
            for(int j=0;j<A.getcols();j++){
                A.set(i,j,100.0);
            }
        }
        System.out.println("teraz macierz setek");
        for(int i=0;i<A.getrows();i++){
            for(int j=0;j<A.getcols();j++){
                System.out.printf("%f ",A.get(i,j));
            }
            System.out.println("");
        }
        System.out.println(A.toString());

    }
}
