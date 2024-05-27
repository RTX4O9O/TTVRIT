import java.io.Serializable;

// written by chatGPT
public class Profile implements Serializable {
    private String name;
    private String id;
    private String address;
    private String number;
    private String email;

    public Profile(String name, String id, String address, String number, String email) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.number = number;
        this.email = email;
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

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
