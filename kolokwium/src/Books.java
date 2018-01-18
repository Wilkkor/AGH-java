
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Books {
    List<Book> book=new ArrayList<>();
    public static void main(String[] args) {
        Books a=new Books();
        try {
            a.read("ibuk_wykaz_pozycji.csv");
        } catch (IOException e) {
            System.out.println("o nie");
            e.printStackTrace();
        }
        a.fixMissingValues();
        a.Kategoria();
        a.Rok();
        a.selectByPWN("Wydawnictwo Naukowe PWN").list(System.out);
    }
    public void read(String filename) throws IOException {
        CSVReader a=new CSVReader(filename,";",true);//file "admin-book.csv"
        int s=0,ic=-1;
        do {
//            int Ibuk_ID;
//    String Wydawnictwo;
//    int Rok_wydania;
//    String Kategoria;Tytuł
            ic++;
            Book c = new Book();
            if (!a.isMissing("Kategoria")) {
                c.Kategoria = a.get("Kategoria");;
            }
            else {
                c.Kategoria ="";
            }
            if (!a.isMissing("Tytuł")) {
                c.Tytuł = a.get("Tytuł");;
            }
            else {
                c.Tytuł ="";
            }
            if (!a.isMissing("Rok wydania")) {
                c.Rok_wydania = a.getInt("Rok wydania");
            }
            else {
                c.Rok_wydania = -1;
            }
            if (!a.isMissing("Wydawnictwo")) {
                c.Wydawnictwo = a.get("Wydawnictwo");
            }
            else {
                c.Wydawnictwo = "";
            }
            book.add(c);
        }while (a.next()&&a!=null);
    }
    void fixMissingValues(){
        ;
    }
    void list(PrintStream out){
        for (Book x:book) {
            System.out.printf(x.toString(),out);
            System.out.printf("\n",out);
        }
    }
    void list(PrintStream out,int offset, int limit ){
        for (int i=offset;i<limit&&i<book.size();i++){
            System.out.printf(book.get(i).toString(),out);
            System.out.printf("\n",out);
        }
    }
    Books selectByYear(int pattern){
        Books ret = new Books();
        for (int i=0;i<book.size();i++){
            if(book.get(i).Rok_wydania==pattern){
                ret.book.add(book.get(i));
            }
        }
        return ret;
    }
    Books sortInplaceByRok_wydania(){
        book.sort((Book o1, Book o2)->new Double(o1.Rok_wydania).compareTo(new Double(o2.Rok_wydania)));
        return this;
    }
    Books sortInplaceByWydawnictwo(){
        book.sort((Book o1, Book o2)->new Double(o1.Wydawnictwo).compareTo(new Double(o2.Wydawnictwo)));
        return this;
    }
    Books sortInplaceByKategoria(){
        book.sort((Book o1, Book o2)->new Double(o1.Kategoria).compareTo(new Double(o2.Kategoria)));
        return this;
    }
    Books sortInplace(Comparator<Book> cmp){
        book.sort(cmp);
        return this;
    }
    Books sort(Comparator<Book> cmp){
        Books a=new Books();
        for (Book ten:this.book
                ) {
            a.book.add(ten);
        }
        sortInplace(cmp);
        return a;
    }
    Books filter(Predicate<Book> pred) {
        Books a=new Books();
        for (Book ten:this.book
                ) {
            if(pred.test(ten)==true)
                a.book.add(ten);
        }
        return a;
    }
    Books filter(Predicate<Book> pred, int limit){
        Books a=new Books();
        for (int i=0;i<this.book.size()&&a.book.size()<limit;i++) {
            if(pred.test(this.book.get(i))==true)
                a.book.add(this.book.get(i));
        }
        return a;
    }
    Books filter(Predicate<Book> pred, int offset, int limit){
        Books a=new Books();
        for (int i=0;i<this.book.size()&&a.book.size()<limit+offset;i++) {
            if(pred.test(this.book.get(i))==true)
                a.book.add(this.book.get(i));
        }
        Books b=new Books();
        for (int i=offset;i<a.book.size();i++) {
            b.book.add(a.book.get(i));
        }
        return b;
    }
    void Rok(){
        this.sortInplaceByRok_wydania();
        List<Integer> rokt=new ArrayList<Integer>();
        for(Book x:book){
            if(!rokt.contains(x.Rok_wydania)){
                rokt.add(x.Rok_wydania);
            }
        }
        for (int i=0;i<rokt.size();i++) {
            System.out.println(rokt.get(i)+"  "+this.selectByYear(rokt.get(i)).book.size()+"\n");

        }
    }
    Books selectByKategoria(String pattern){
        Books ret = new Books();
        for (int i=0;i<book.size();i++){
            if(book.get(i).Kategoria==pattern){
                ret.book.add(book.get(i));
            }
        }
        return ret;
    }
    void Kategoria(){
        this.sortInplaceByRok_wydania();
        List<String> rokt=new ArrayList<String>();
        for(Book x:book){
            if(!rokt.contains(x.Kategoria)){
                rokt.add(x.Kategoria);
            }
        }
        for (int i=0;i<rokt.size();i++) {
            System.out.println(rokt.get(i)+"  "+this.selectByKategoria(rokt.get(i)).book.size()+"\n");

        }
    }
    Books selectByPWN(String pattern){
        Books ret = new Books();
        for (int i=0;i<book.size();i++){
            if(book.get(i).Wydawnictwo==pattern){
                ret.book.add(book.get(i));
            }
        }
        return ret;
    }
}

