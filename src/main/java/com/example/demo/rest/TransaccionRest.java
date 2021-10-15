/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;


import com.example.demo.model.Compra;
import com.example.demo.model.Transaccionp;
import com.example.demo.negocio.NorteXploradores;
import com.example.demo.security.service.UsuarioService;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.TransaccionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author santi
 */
@RestController
@RequestMapping(value = "/pagos",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = {"http://50.56.9.170","http://198.61.156.98","http://190.216.203.233", "http://74.205.10.14"})
@Slf4j
public class TransaccionRest {
  
    @Autowired
    public TransaccionService pser;
    
    @Autowired
    public UsuarioService user;

    NorteXploradores nexp = new NorteXploradores();
    
    @GetMapping
    public ResponseEntity<List<Transaccionp>> transacciones(){
       return new ResponseEntity(pser.listar(), HttpStatus.OK);
    }
    
    @PostMapping("/confirmacion")
    public ResponseEntity<?> pagoConfirmado(@RequestParam Map<String, String> body) {
        

//         Transaccionp pay = new Transaccionp();
//        pay.setAttempts(Short.parseShort(body.get("attempts")));
//        pay.setBankId(Short.parseShort(body.get("bank_id")));
//        pay.setBillingCountry((body.get("billing_country"))+"");
//        pay.setCurrency(body.get("currency")+"");
//        pay.setDate(this.convertirFecha(body.get("date"),"\\."));
//        pay.setDescription(body.get("description")+"");
//        pay.setEmailBuyer(body.get("email_buyer")+"");
//        pay.setOperationDate(this.convertirFecha(body.get("operation_date"),"\\-"));
//        pay.setPaymentMethod(Short.parseShort(body.get("payment_method")));
//        pay.setPaymentMethodName(body.get("payment_method_name")+"");
//        pay.setPaymentMethodType(Short.parseShort(body.get("payment_method")));
//        pay.setPseBank(body.get("pse_bank")+"");
//        Compra compra = compraService.encontrar(Long.parseLong(body.get("reference_sale"))).get();
//        pay.setReferenceSale(compra);
//        pay.setResponseMessagePol(body.get("response_message_pol"));
//        pay.setShippingCountry(body.get("shipping_country"));
//        pay.setTax(body.get("tax"));
//        pay.setTransactionDate(this.convertirFecha(body.get("transaction_date"),"\\-"));
//        pay.setTransactionId(body.get("transaction_id"));
//        pay.setValue(Long.parseLong(body.get("value").split("\\.")[0]));
//        return pay;
//        
//        log.info(pay.toString());
//        
//        pser.guardar(pay);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
