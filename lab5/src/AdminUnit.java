import java.util.List;

public class AdminUnit {
    AdminUnit parent;
    String name;
    int adminLevel;
    double area;
    double population;
    double density;
    BoundingBox bbox;
    List<AdminUnit> children;
    public String toString(){
        StringBuilder a=new StringBuilder();
        a.append(parent.name).append(name).append(adminLevel).append(area).append(population).append(density).append(bbox);
        return a.toString();
    }
}
