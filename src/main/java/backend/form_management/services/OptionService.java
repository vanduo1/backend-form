package backend.form_management.services;


import backend.form_management.models.Option;

import backend.form_management.models.Question;
import backend.form_management.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public Option createOption(Question question, Option option) {
        option.setQuestionId(question.getId());     //quan hệ giữa Option và Question
        return optionRepository.save(option);
    }

    public Option updateOption(Option option) {

        return optionRepository.save(option);
    }
}
