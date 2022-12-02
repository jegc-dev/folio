package com.dms.folio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Series")
@Table(name = "tbl_series",
        uniqueConstraints = {
                @UniqueConstraint(name = "series_code_unique", columnNames = "code")
        })
public class Series implements Serializable {

    @Id
    @SequenceGenerator(name = "series_seq", sequenceName = "series_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "series_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @NotEmpty(message = "NAME cannot be empty or null")
    @Column(name = "name", updatable = false)
    private String name;

    @NotEmpty(message = "CODE cannot be empty or null")
    @Column(name = "code", updatable = false)
    private String code;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "series_id",
            referencedColumnName = "id"
    )
    private List<SubSeries> subSeriesList;

    @JsonProperty("series_id")
    public Long getId() {
        return id;
    }

    @JsonProperty("series_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
