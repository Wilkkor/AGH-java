import java.io.PrintStream;

public class ParagraphWithList extends Paragraph{
    UnorderedList list;
    ParagraphWithList(){
        list=new UnorderedList();
    }
    ParagraphWithList setContent(String a){
        content=a;
        return this;
    }
    ParagraphWithList addListItem(String it){
        list.additem(it);
        return this;
    }
    void writeHTML(PrintStream out){
        out.printf("<p>%s</p>\n",content);
        list.writeHTML(out);
    }
}
