package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.models.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.DeletedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.GotModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.UpdatedModelResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model createdModel =  modelRepository.save(model);
        CreatedModelResponse createdModelResponse = this.modelMapperService.forResponse().map(createdModel,CreatedModelResponse.class);
        return createdModelResponse;
    }

    @Override
    public GotModelResponse getById(int id) {
        Model model = this.modelRepository.findById(id).orElse(null);
        if(model != null){
            GotModelResponse gotModelResponse = this.modelMapperService.forResponse().map(model, GotModelResponse.class);
            return gotModelResponse;
        } else {
            return null;
        }
    }

    @Override
    public List<GotModelResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        return models.stream().map(model -> this.modelMapperService.forResponse().map(model,GotModelResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest) {
        Model model = modelRepository.findById(updateModelRequest.getId()).orElse(null);
        if(model != null){
            model.setName(updateModelRequest.getName());
            model.setUpdatedDate(LocalDateTime.now());
            modelRepository.save(model);
            return this.modelMapperService.forResponse().map(model,UpdatedModelResponse.class);
        }
        return null;
    }

    @Override
    public DeletedModelResponse delete(int id) {
        Model model = this.modelRepository.findById(id).orElse(null);
        if(model != null){
            model.setDeleted(true);
            model.setDeletedDate(LocalDateTime.now());
            return this.modelMapperService.forResponse().map(model,DeletedModelResponse.class);
        }
        return null;
    }


}
