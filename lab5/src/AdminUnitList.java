import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUnitList {
    List<AdminUnit> units=new ArrayList<>();
    AdminUnitList() throws IOException {
        CSVReader a=new CSVReader("admin-units.csv",",",true);
        int s=0,ic=0;
        Map <Integer ,Integer> id=new HashMap<Integer, Integer>();;
        while (a.next()){
            ic++;
            if(a.columnLabels.size()==a.current.length){
                AdminUnit c=new AdminUnit();
                c.adminLevel=a.getInt("admin_level");
                c.area=a.getDouble("area");
                c.density=a.getDouble("density");
                c.population=a.getDouble("population");
                c.name=a.get("name");
                id.put(ic,a.getInt("parent"));
                double xmin=a.getDouble(8);
                double ymin=a.getDouble(9);
                double xmax=a.getDouble(8);
                double ymax=a.getDouble(9);
                for(int i=8;i<=14;i=+2){
                    if(xmin>a.getDouble(i)){
                        xmin=a.getDouble(i);
                    }
                    if(ymin>a.getDouble(1+i)){
                        ymin=a.getDouble(i+1);
                    }
                    if(xmax<a.getDouble(i)){
                        xmax=a.getDouble(i);
                    }
                    if(ymax<a.getDouble(i+1)){
                        ymax=a.getDouble(i+1);
                    }
                }
                c.bbox=new BoundingBox(xmax,ymax,xmin,ymin);
                ////referencja po id
                units.add(c);
            }else {
                s++;
                for (int i=0;i<a.current.length;i++){
                    System.out.printf("%s  ",a.get(i));
                }
                System.out.println("");
            }
        }
        for()
        System.out.println(a.getColumnLabels().size()+"     "+s+"    "+ic);
    }
    void read(){
        
    }
    void fixMissingValues(){
        
    }
    void selectAdminLevel(int a){
        
    }
    void selectNameMatches(){
        
    }
    void SelectInside(double x1,double x2,double x3, double x4){
        
    }
}
