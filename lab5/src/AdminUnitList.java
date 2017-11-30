import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminUnitList {
    List<AdminUnit> units=new ArrayList<>();
    AdminUnitList() throws IOException {
        CSVReader a=new CSVReader("admin-units.csv",",",true);
        int s=0,ic=0;
        while (a.next()){
            ic++;
            if(a.columnLabels.size()==a.current.length){
                AdminUnit c=new AdminUnit();
                c.adminLevel=a.getInt("admin_level");
                c.area=a.getDouble("area");
                c.density=a.getDouble("density");
                c.population=a.getDouble("population");
                c.name=a.get("name");
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
