package de.tobi.springbootlearning.model;

public class User {
    private Long id;
    private String name;
    private String email;
    private int age;

    public User(){

    }

    public User(Long id, String name, String email, int age) {
        setId(id);
        setName(name);
        setEmail(email);
        setAge(age);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
