package com.dms.folio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "SubSeries")
@Table(name = "tbl_subseries",
        uniqueConstraints = {
                @UniqueConstraint(name = "subseries_code_unique", columnNames = "code")
        })
public class SubSeries implements Serializable {

    @Id
    @SequenceGenerator(name = "subseries_seq", sequenceName = "subseries_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subseries_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @NotEmpty(message = "NAME cannot be empty or null")
    @Column(name = "name", updatable = false)
    private String name;

    @NotEmpty(message = "CODE cannot be empty or null")
    @Column(name = "code", updatable = false)
    private String code;

    @NotEmpty(message = "HOLDING cannot be empty or null")
    @Column(name = "holding", updatable = false)
    private int holding;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "subseries_id",
            referencedColumnName = "id"
    )
    private Collection<PointOfEntry> entriesCollection;

    @JsonProperty("subseries_id")
    public Long getId() {
        return id;
    }

    @JsonProperty("subseries_name")
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
