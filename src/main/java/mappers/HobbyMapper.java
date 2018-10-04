package mappers;

public class HobbyMapper {
    
    public String name;
    public String description;
    
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
