

public class Matrix {
    double[]data;
    int rows;
    int cols;
    //...
    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
    }
    Matrix(double[][] d)
    {
        rows=d.length;
        cols=d[0].length;
        for (int i=0;i<rows;i++){
            if(d[i].length>cols){
                cols=d[i].length;
            }
        }
        data=new double[rows*cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j>d[i].length){
                    data[cols*i+j]=0;
                }
                else {
                    data[cols*i+j]=d[i][j];
                }
            }
        }
    }
}
