package by.resliv.citymanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "information")
    private String information;

    public City() {
    }

    @Override
    public City clone() throws CloneNotSupportedException {
        return (City) super.clone();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
