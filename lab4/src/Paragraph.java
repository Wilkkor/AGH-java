import java.io.PrintStream;

public class Paragraph {
    String content;
    Paragraph(){}
    Paragraph(String cont){
        content=cont;
    }
    void writeHTML(PrintStream out){
        out.printf("<p>%s</p>\n",content);
    }

}
