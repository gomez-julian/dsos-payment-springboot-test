package ito.dsos.microservicios.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/api/payment")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/records")
    public List<PaymentEntity> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/records/{id}")
    public ResponseEntity<Optional<PaymentEntity>> getOne(@PathVariable String id){
        return new ResponseEntity<>(paymentService.getById(Long.parseLong(id)),HttpStatus.OK);
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentEntity> postPayment(@ModelAttribute PaymentEntity payment){
        if(payment == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        payment.setPaymentStatus('P');
        payment.setPaymentDate(LocalDateTime.now());
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/confirm/{id}")
    public ResponseEntity<PaymentEntity> putPayment(@PathVariable String id){
        PaymentEntity payment = paymentService.getById(Long.parseLong(id))
                .orElseThrow(() -> new IllegalStateException("Error al obtener la compra"));
        payment.setPaymentStatus('C');
        payment.setPositivePaymentDate(LocalDateTime.now());
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PaymentEntity> deletePayment(@PathVariable String id){
        PaymentEntity payment = paymentService.getById(Long.parseLong(id))
                .orElseThrow(() -> new IllegalStateException("Error al obtener la compra"));
        paymentService.delete(Long.parseLong(id));
        payment.setPaymentStatus('D');
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
