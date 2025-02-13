package com.app.pojos;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Beneficiary {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beneficiaryId;

    @NotBlank
    @Column(nullable = false)
    private String beneficiaryName;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String beneficiaryEmail;

    @NotBlank
    @Column(nullable = false)
    private String beneficiaryAddress;

    @NotBlank
    @Column(nullable = false)
    private String projectAssociated;

    @ManyToOne
    @JoinColumn(name = "eventId")
    @JsonBackReference
    private Event event;

    // Add reference to User if necessary (e.g., who created/assigned this beneficiary)
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; // Added reference to User
}
