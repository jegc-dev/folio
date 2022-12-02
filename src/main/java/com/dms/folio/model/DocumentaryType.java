package com.dms.folio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
/**
 * Contrato trabajo
 * Hoja de vida
 * Examen medico
 * Propuesta
 * Acta de iniciación
 * Informe periódico
 * */
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "DocumentaryType")
@Table(name = "tbl_documentary_type",
        uniqueConstraints = {
                @UniqueConstraint(name = "documentary_type_unique", columnNames = "code")
        })
public class DocumentaryType implements Serializable {

    @Id
    @SequenceGenerator(name = "documentary_type_seq", sequenceName = "documentary_type_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documentary_type_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @NotEmpty(message = "NAME cannot be empty or null")
    @Column(name = "name", updatable = false)
    private String name;

    @NotEmpty(message = "CODE cannot be empty or null")
    @Column(name = "code", updatable = false)
    private String code;

    @JsonProperty("documentary_type_id")
    public Long getId() {
        return id;
    }

    @JsonProperty("documentary_type_name")
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
