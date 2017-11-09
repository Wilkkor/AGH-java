import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    List<Listitem> listitems=new ArrayList<>();

    void additem(String name){
        listitems.add(new Listitem(name));
    }
    void additem(Listitem item){
        listitems.add(item);
    }
    void writeHTML(PrintStream out){
        out.printf("<ul>\n");
        for(int i=0;i<listitems.size();i++){
            listitems.get(i).writeHTML(out);
        }
        out.printf("</ul>\n");
    }
}
