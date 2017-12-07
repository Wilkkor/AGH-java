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
        Map <Integer ,Integer> id=new HashMap<Integer, Integer>();
        Map <Integer ,Integer> idparent=new HashMap<Integer, Integer>();
        while (a.next()){
            ic++;
            AdminUnit c=new AdminUnit();
            if(!a.isMissing("admin_level"))
                c.adminLevel=a.getInt("admin_level");
            else
                c.adminLevel=-1;
            if(!a.isMissing("area"))
                c.area=a.getDouble("area");
            else
                c.area=-1;
            if(!a.isMissing("density"))
                c.density=a.getDouble("density");
            else
                c.density=-1;
            if(!a.isMissing("population"))
                c.population=a.getDouble("population");
            else
                c.population=-1;
            if(!a.isMissing("name"))
                c.name=a.get("name");
            else
                c.name="";
            if(!a.isMissing("parent"))
                idparent.put(ic,a.getInt("parent"));
            else
                idparent.put(ic,a.getInt("parent"));
            if(!a.isMissing("id"))
                id.put(a.getInt("id"),ic);
            else
                id.put(a.getInt("id"),ic);
                double xmin=Double.NaN;
                double ymin=Double.NaN;
                double xmax=Double.NaN;
                double ymax=Double.NaN;
            if(!a.isMissing(8))
                xmin=a.getDouble(8);
            if(!a.isMissing(9))
                ymin=a.getDouble(9);
            if(!a.isMissing(8))
                xmax=a.getDouble(8);
            if(!a.isMissing(9))
                ymax=a.getDouble(9);
            for(int i=10;i<=14;i=+2) {
                if (!a.isMissing(i)){
                    if (xmin > a.getDouble(i)) {
                        xmin = a.getDouble(i);
                    }
                }
                if (!a.isMissing(i+1)) {
                    if (ymin > a.getDouble(1 + i)) {
                        ymin = a.getDouble(i + 1);
                    }
                }
                if (!a.isMissing(i)) {
                    if (xmax < a.getDouble(i)) {
                        xmax = a.getDouble(i);
                    }
                }
                if (!a.isMissing(i+1)) {
                    if (ymax < a.getDouble(i + 1)) {
                        ymax = a.getDouble(i + 1);
                    }
                }
            }
            c.bbox=new BoundingBox(xmax,ymax,xmin,ymin);
            ////referencja po id
            units.add(c);
        }
        for(int i=0;i<id.size();i++){
            if(idparent.get(i)!=0){
                units.get(i).parent=units.get(id.get(idparent.get(i)));
            }
            else{
                units.get(i).parent=null;
            }
        }
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
