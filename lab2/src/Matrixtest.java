import java.util.Scanner;
public class Matrixtest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj rows i cols");
        double[][] tab={{1,2,3},{5,6,7},{9,10,11}};
        Matrix A=new Matrix(tab);
        //System.out.println(A.get(3,3));
        System.out.println("rows"+A.getrows()+" cols "+A.getcols());
        A.print();
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
                A.set(i,j,10);
            }
        }
        System.out.println("teraz macierz setek");
        A.print();
        System.out.println("\n"+A.toString());
        A.multip(A).print();
        A=Matrix.random(3,3);
        A.print();
        for(int i=0;i<A.getrows();i++){
            for(int j=0;j<A.getcols();j++){
                A.set(i,j,0);
            }
        }
        for(int i=0;i<3;i++){
            A.set(i,i,11);
        }
        A.print();
        Matrix B=Matrix.eye(A.getrows(),A.getcols());
        A.inv().sub(B).print();
    }
}
