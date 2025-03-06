package backend.form_management.services;

import backend.form_management.models.Answer;
import backend.form_management.models.Form;
import backend.form_management.models.Response;
import backend.form_management.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;



    //create a response of the form
    public Response createResponse(String formId, Response response) {

        response.setFormId(formId);
        return responseRepository.save(response);
    }

    //get all response of form
    public List<Response> getAllResponseByFormId(String formId) {
        return responseRepository.getAllByFormId(formId);
    }








    //delete response
    public void deleteResponse(String responseId) {
        responseRepository.deleteById(responseId);
    }
}
