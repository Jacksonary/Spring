package com.hhu.actions;

import com.hhu.services.PersonService;

/**
 * Created by WeiguoLiu on 2018/3/5.
 */
public class PersonAction {

    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public String execute() {
        System.out.println("execute...");
        return "success";
    }
}
