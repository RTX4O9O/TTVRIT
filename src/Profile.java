import java.io.Serializable;

// written by chatGPT
public class Profile implements Serializable {
    private String name;
    private String id;
    private String address;

    public Profile(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
