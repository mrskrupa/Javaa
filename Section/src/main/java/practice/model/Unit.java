package practice.model;

import javax.persistence.*;

@Entity
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "section_name")
    private String sectionName;
    @ManyToOne
    private Directory directory;

    public Unit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "Unit{"
                + "id=" + id
                + ", sectionName='" + sectionName + '\''
                + ", directory='" + directory
                + '}';
    }
}
