package com.dms.folio.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "PointOfEntry")
@Table(name = "tbl_point_of_entry")
public class PointOfEntry implements Serializable {

    @Id
    @SequenceGenerator(name = "point_of_entry_seq", sequenceName = "point_of_entry_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_of_entry_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "input_number", updatable = false)
    private Long inputNumber;

    @Column(name = "output_number", updatable = false)
    private Long outputNumber;

    private String subject;

    private String remarks;

    private LocalDateTime dateOfEntry;

    private String documentId;
}
