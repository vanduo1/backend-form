package backend.form_management.controllers;

import backend.form_management.models.Response;
import backend.form_management.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @PostMapping("forms/{formId}/response")
    public Response addResponse(@PathVariable("formId") String formId, @RequestBody Response response) {
       return responseService.createResponse(formId, response);
    }
}
