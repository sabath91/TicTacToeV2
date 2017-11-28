package org.czyz;

class StartPlayerValidator {

    boolean validate(String userInput){
        return userInput.equals("X") || userInput.equals("O");
    }
}
