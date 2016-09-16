package ar.com.gaf.entity;

public class Status {

    private Long id;
    private String name;
    private String imageName;

    public Status() {
    }

    public Status(Long id, String name, String imageName) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
