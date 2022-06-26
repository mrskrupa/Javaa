package practice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ranks")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rank_type")
    private String rankType;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ranks_coaches",
            joinColumns = @JoinColumn(name = "rank_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id"))
    private List<Coach> coaches;

    public Rank() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRankType() {
        return rankType;
    }

    public void setRankType(String rankType) {
        this.rankType = rankType;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    @Override
    public String toString() {
        return "Rank{"
                + "id=" + id
                + ", rankType='" + rankType + '\''
                + ", coaches=" + coaches
                + '}';
    }
}
