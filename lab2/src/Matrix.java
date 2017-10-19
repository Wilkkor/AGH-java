

public class Matrix {
    private double[]data;
    private int rows;
    private int cols;
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
                if(j<d[i].length){
                    data[cols*i+j]=d[i][j];
                }else {
                    data[cols*i+j]=0;
                }
            }
        }
    }
    double[][] asArray(){
        double[][] a=new double[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                a[i][j]=data[cols*i+j];
            }
        }
        return a;
    }
    double get(int r,int c){
        return data[r*cols+c];
    }
    double getrows(){
        return rows;
    }
    double getcols(){
        return cols;
    }
    void set (int r,int c, double value){
        data[r*cols+c]=value;
    }
    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for(int i=0;i<rows;i++){
            buf.append("[");
            for(int j=0;j<cols;j++){
                buf.append(data[i*cols+rows]);
                buf.append(',');
            }
            buf.deleteCharAt(buf.length()-1);
            buf.append(']');
        }
        return buf.toString();
    }
    void reshape(int newRows,int newCols){
        if(rows*cols != newRows*newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d",rows,cols,newRows,newCols));
        rows=newRows;
        cols=newCols;
    }
    int[] shape(){
        int tab[]=new int[2];
        tab[0]=rows;
        tab[1]=cols;
        return tab;
    }
    Matrix add(Matrix m)
    {
        if(m.getcols()!=cols||m.getrows()!=rows)
            throw new RuntimeException(String.format("%d x %d matrix can't be added to %d x %d",rows,cols,m.getrows(),m.getcols()));
        Matrix W=new Matrix(rows,cols);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                W.set(i,j,data[i*cols+j]+m.get(i,j));
            }
        }
        return W;
    }Matrix sub(Matrix m)
    {
        if(m.getcols()!=cols||m.getrows()!=rows)
            throw new RuntimeException(String.format("%d x %d matrix can't be substracted to %d x %d",rows,cols,m.getrows(),m.getcols()));
        Matrix W=new Matrix(rows,cols);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                W.set(i,j,data[i*cols+j]-m.get(i,j));
            }
        }
        return W;
    }
    Matrix mul(Matrix m)
    {
        if(m.getcols()!=cols||m.getrows()!=rows)
            throw new RuntimeException(String.format("%d x %d matrix can't be multiplied to %d x %d",rows,cols,m.getrows(),m.getcols()));
        Matrix W=new Matrix(rows,cols);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                W.set(i,j,data[i*cols+j]*m.get(i,j));
            }
        }
        return W;
    }
    Matrix div(Matrix m)
    {
        if(m.getcols()!=cols||m.getrows()!=rows)
            throw new RuntimeException(String.format("%d x %d matrix can't be divided to %d x %d",rows,cols,m.getrows(),m.getcols()));
        Matrix W=new Matrix(rows,cols);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                W.set(i,j,data[i*cols+j]/m.get(i,j));
            }
        }
        return W;
    }
    

}
