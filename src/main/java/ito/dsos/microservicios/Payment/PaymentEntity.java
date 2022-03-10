package ito.dsos.microservicios.Payment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long paymentID;

    @Column(name = "reference_id", unique = true)
    private String referenceID;

    @Column(name = "address_cp", length = 5)
    private String address_cp;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_status")
    private Character paymentStatus;

    @Column(name = "positive_payment_date")
    private LocalDateTime positivePaymentDate;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "status_delete")
    private Boolean statusDelete;

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }

    public void setAddress_cp(String address_cp) {
        this.address_cp = address_cp;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentEntity() {

    }

    public PaymentEntity(String referenceID,
                         Double paymentAmount,
                         String paymentMethod) {
        this.referenceID = referenceID;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    public PaymentEntity(Character paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
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
