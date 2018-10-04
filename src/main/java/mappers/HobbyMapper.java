package mappers;

public class HobbyMapper {
    
    public String name;
    public String desc;
    
    public HobbyMapper() {
        
    }
    
    public HobbyMapper(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HobbyMapper{" + "name=" + name + '}';
    }
    
    
    
}
