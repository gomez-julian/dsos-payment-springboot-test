package ito.dsos.microservicios.Payment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long paymentID;

    @Column(name = "reference_id", unique = true, nullable = false)
    private String referenceID;

    @Column(name = "address_cp", length = 5)
    private String address_cp;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "payment_status", columnDefinition = "P", nullable = false)
    private Character paymentStatus;

    @Column(name = "positive_payment_date")
    private LocalDateTime positivePaymentDate;

    @Column(name = "payment_amount", nullable = false, updatable = false)
    private Double paymentAmount;

    @Column(name = "payment_method", length = 16, updatable = false)
    private String paymentMethod;

    @Column(name = "status_delete")
    private Boolean statusDelete;

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public PaymentEntity() {

    }

    public PaymentEntity(String referenceID,
                         LocalDateTime paymentDate,
                         Double paymentAmount,
                         String paymentMethod) {
        this.referenceID = referenceID;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    public PaymentEntity(Character paymentStatus, LocalDateTime positivePaymentDate) {
        this.paymentStatus = paymentStatus;
        this.positivePaymentDate = positivePaymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public LocalDateTime getPositivePaymentDate() {
        return positivePaymentDate;
    }

    public Character getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Character paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getAddress_cp() {
        return address_cp;
    }

    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }

    public Long getPaymentID() {
        return paymentID;
    }

    public void setPositivePaymentDate(LocalDateTime positivePaymentDate) {
        this.positivePaymentDate = positivePaymentDate;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }
}
