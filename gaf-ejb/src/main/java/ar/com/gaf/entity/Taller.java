package ar.com.gaf.entity;

public class Taller {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Status status;
    private int employeesQuantity;
    private int score;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEmployeesQuantity() {
        return employeesQuantity;
    }

    public void setEmployeesQuantity(int employeesQuantity) {
        this.employeesQuantity = employeesQuantity;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
