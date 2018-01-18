import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Max {
    static BlockingQueue<Double> results = new ArrayBlockingQueue<Double>(100);
    static double[] array;
    static void initArray(int size){
        array = new double[size];
        for(int i=0;i<size;i++){
            array[i]= Math.random()*size/(i+1);
        }
    }


    static class MaxCalc extends Thread{
        private final int start;
        private final int end;
        double Max = 0;

        MaxCalc(int start, int end){
            this.start = start;
            this.end=end;
        }
        public void run(){
            Max=array[start];
            for(int i=start;i<end;i++)
            {
                if(array[i]>Max){
                    Max=array[i];
                }
            }
            try {
                results.put(Max);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.printf(Locale.US,"%d-%d Max=%f\n",start,end,Max);
        }
    }
    static void parallelMax(int cnt) throws InterruptedException {
        // utwórz tablicę wątków
        double Max=0;
        MaxCalc threads[]=new MaxCalc[cnt];
        // utwórz wątki, podziel tablice na równe bloki i przekaż indeksy do wątków
        // załóż, że array.length dzieli się przez cnt)
        if(array.length%cnt!=0){
            throw new RuntimeException("nie dzieli");
        }
        for(int i=0;i<cnt;i++){
            threads[i]=new MaxCalc(array.length/cnt*i,array.length/cnt*(i+1)-1);
        }
        double t1 = System.nanoTime()/1e6;
        //uruchom wątki
        for(int i=0;i<cnt;i++){
            threads[i].start();
        }
        double t2 = System.nanoTime()/1e6;
        // czekaj na ich zakończenie używając metody ''join''
//        for(MaxCalc mc:threads) {
//            mc.join();
//        }
        // oblicz średnią ze średnich
        Max=results.take();
        double to;
        for(int i=1;i<cnt;i++){
            to=results.take();
            if(to>Max){
                Max=to;
            }
        }
        double t3 = System.nanoTime()/1e6;
        System.out.printf(Locale.US,"size = %d cnt=%d >  t2-t1=%f t3-t1=%f Max=%f\n",array.length,cnt,t2-t1,t3-t1,Max);
    }

    public static void main(String[] args) {
        initArray(100000000);
        for(int cnt:new int[]{1,2,4,8,16,32,64,128}){
            try {
                parallelMax(cnt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


