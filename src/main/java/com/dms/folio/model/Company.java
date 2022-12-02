package com.dms.folio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Company")
@Table(name = "tbl_company",
        uniqueConstraints = {
                @UniqueConstraint(name = "nit_unique", columnNames = "nit")
        })
public class Company implements Serializable {

    @Id
    @SequenceGenerator(name = "enterprise_seq", sequenceName = "enterprise_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enterprise_seq")
    @Column(name = "id", updatable = false)
    private Long id;
    @NotEmpty(message = "NIT cannot be empty or null")
    @Column(name = "nit", updatable = false)
    private String nit;
    @NotEmpty(message = "Company name cannot be empty or null")
    @Column(name = "name", updatable = false, columnDefinition = "TEXT", nullable = false)
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "company_id",
            referencedColumnName = "id"
    )
    private List<Area> areaList;

    @JsonProperty("company_id")
    public Long getId() {
        return id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
