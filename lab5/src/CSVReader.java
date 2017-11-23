import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    List<String> columnLabels = new ArrayList<>();
    Map<String,Integer> columnLabelsToInt = new HashMap<>();
    String[]current;
    public CSVReader(String filename,String delimiter,boolean hasHeader) throws IOException {
        this(new FileReader(filename),delimiter,true);
    }
    public CSVReader(String filename,String delimiter) throws IOException {
        this(filename,delimiter,true);
    }
    public CSVReader(String filename) throws IOException {
        this(filename,",",true);
    }
    public CSVReader(Reader read, String delimiter, boolean hasHeader) throws IOException {
        reader = new BufferedReader(read);
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if (hasHeader) {
            parseHeader();
        }
        next();
    }
    void parseHeader() throws IOException {
        String line  = reader.readLine();
        if(line==null){
            return;
        }
        String[]header = line.split(delimiter);
        for(int i=0;i<header.length;i++){
            columnLabels.add(header[i]);
            columnLabelsToInt.put(header[i],i);
        }
    }
    boolean next() throws IOException {
        String line  = reader.readLine();
        if(line==null){
            return false;
        }
        String[]current = line.split(delimiter);
        current=new String[100];
        return false;
    }
    String get(int i){
        return current[i];
    }
    String get(String label){
        return current[columnLabelsToInt.get(label)];
    }
}