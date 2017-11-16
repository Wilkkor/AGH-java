import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Document {
    String title;
    Photo photo;
    List<Section> sections= new ArrayList<>();
    Document(String a){
        this.title=a;
    }
    Photo addPhoto(String url){
        photo=new Photo(url);
        return photo;
    }
    Section addSection(String title){
        Section a=new Section(title);
        sections.add(a);
        return a;
    }
    void writeHTML(PrintStream out){
        out.printf("<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>%s</h1>\n",title);
        photo.writeHTML(out);
        for (int i=0;i<sections.size();i++){
            sections.get(i).writeHTML(out);
        }
        out.printf("</body>\n" +
                "</html>");
    }
}
