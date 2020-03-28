package by.resliv.citymanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "fact")
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "content")
    private String content;
    @OneToOne(mappedBy = "fact")
    private City city;

    public Fact() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
