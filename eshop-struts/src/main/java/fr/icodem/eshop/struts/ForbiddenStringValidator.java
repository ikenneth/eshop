package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class ForbiddenStringValidator extends FieldValidatorSupport {
    private String[] forbiddenStrings;

    @Override
    public void validate(Object obj) throws ValidationException {
        String input = (String) getFieldValue(getFieldName(), obj);// obj is action object

        for (String forbidden : forbiddenStrings) {
            if (input.equals(forbidden)) {
                addFieldError(getFieldName(), obj);
                break;
            }
        }
    }

    public void setForbiddenStrings(String forbiddenStrings) {
        this.forbiddenStrings = forbiddenStrings.split(",");
    }
}
