package ito.dsos.microservicios.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/pay")
    public ResponseEntity<PaymentEntity> postPayment(@ModelAttribute PaymentEntity payment){
        if(payment == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(payment.getPaymentID() == null || payment.getPaymentID() == 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }
}
