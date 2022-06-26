package practice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directories")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String town;
    private String area;

    public Directory() {
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Directory{"
                + "id=" + id
                + ", town='" + town + '\''
                + ", area='" + area + '\''
                + '}';
    }
}
