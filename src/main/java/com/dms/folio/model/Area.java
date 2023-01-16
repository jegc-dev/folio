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
@Entity(name = "Area")
@Table(name = "tbl_area",
        uniqueConstraints = {
                @UniqueConstraint(name = "area_code_unique", columnNames = "code"),
                @UniqueConstraint(name = "area_name_unique", columnNames = "name")
        })
public class Area implements Serializable {

    @Id
    @SequenceGenerator(name = "area_seq", sequenceName = "area_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_seq")
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
            name = "area_id",
            referencedColumnName = "id"
    )
    private List<Series> seriesList;

    @JsonProperty("area_id")
    public Long getId() {
        return id;
    }

    @JsonProperty("area_name")
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
