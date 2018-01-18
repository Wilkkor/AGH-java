import java.util.ArrayList;
import java.util.List;

public class Book {
    String Wydawnictwo;
    String Tytuł;
    int Rok_wydania;
    String Kategoria;
    public String toString(){
        StringBuilder a=new StringBuilder();
        a.append("Wydawnictwo: ").append(Wydawnictwo).append(" Rok_wydania: ").append(Rok_wydania).append(" Kategoria: ").append(Kategoria);
        return a.toString();
    }
}

