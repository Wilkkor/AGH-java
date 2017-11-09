import java.io.PrintStream;

public class Listitem {
    String content;
    Listitem(String name){
        content=name;
    }
    void writeHTML(PrintStream out){
        out.printf("<li> %s </li>\n",content);
    }
}
