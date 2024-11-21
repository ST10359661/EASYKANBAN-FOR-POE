/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correctionforpart2;

/**
 *
 * @author RC_Student_lab
 */
public class login {

    //check username 
    public boolean ValidateUsername(String Username) {
        if (Username.contains("_") && Username.length() <= 5) {
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username is not correctly formatted, please ensure that Username contains an underscore and is no more than 5 character in length");
            return false;
        }
    }

    //check the password complexity
    public boolean ValidatePassword(String Password) {
        if (Password != null && Password.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$&*?]).{8,}$")) {
            System.out.println("Password successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the Password contains atleast 8 characters a capital letter a number and special character ");
        }
        return false;
    }

    public boolean ValidadateMessage(boolean Message,String fname,String lname){
    if(Message){
    System.out.println("Welcome "+fname +" "+lname+" it is great to see you again");
    return true;
    }else{System.out.println("Username or Password incorrect, please try again");
    }
    return false;
    }
    
    //login
     boolean  check_user(String Username, String Password, String Login_user, String Login_password) {

if(Username.equals(Login_user) && Password.equals(Login_password)){
    //then
    return true;
}


return false;
     }
}
