package hibernate.model;

//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Please enter the name")
    @Size(min = 3, max = 50, message = "The name isn't correct")
    private String name;

    @Column
    @NotEmpty(message = "Please enter phone")
    @Pattern(regexp = "(\\+7)(\\([0-9]{3}\\))[0-9]{7}", message = "the number isn't correct (+7(XXX)XXXXXXX)")
    private String phoneNumber;

    @Column
    @NotNull(message = "Please enter age")
    @Min(value = 2, message = "The age isn't correct")
    private Byte age;

    @Column
    @NotEmpty(message = "email is empty")
    @Email (message = "The email isn't correct")
    private String email;

    public User() {

    }

    public User(String name, String phoneNumber, Byte age, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User(Long id, String name, String phoneNumber, Byte age, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Byte getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
