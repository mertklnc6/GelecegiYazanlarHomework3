package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.PaymentMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentBusinessRules {
    private PaymentRepository paymentRepository;
    public void isPaymentExistById(int id){
        if (this.paymentRepository.findById(id).isEmpty()){
            throw new BusinessException(PaymentMessages.PAYMENT_NOT_EXIST);
        }
    }
}
