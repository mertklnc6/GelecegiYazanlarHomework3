package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.entities.concretes.BodyType;

import java.util.Optional;

public class BodyTypeBusinessRules {
    BodyTypeRepository bodyTypeRepository;
    public void bodyTypeNameCanNotBeDuplicated(String bodyTypeName){
        Optional<BodyType> bodyType = bodyTypeRepository.findByNameIgnoreCase(bodyTypeName);
        if(bodyType.isPresent()){
            throw new BusinessException("BodyTypeExists");
        }
    }
    public void bodyTypeIdCanNotFound(int id){
        Optional<BodyType> bodyType = bodyTypeRepository.findById(id);
        if(!bodyType.isPresent()){
            throw new BusinessException("BodyTypeNotExists");
        }
    }
//    public void processActiveBodyTypesOnly() {
////        List<BodyType> optionalBodyTypes = bodyTypeRepository.findByDeletedDateIsNull();
//        if (!optionalBodyTypes.isEmpty()) {
//            throw new BusinessException("AllBodyTypesAreDeletedOrThereAreNoBodyTypes");
//        }
//    }
}
