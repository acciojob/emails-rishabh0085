package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(this.getPassword()) && newPassword.length()>=8) {

            if(check(newPassword)==true){
                this.password = newPassword;
//                 System.out.print("New password added");
            }
        }
    }


    public boolean check (String newPass){

        int Up =0 , Lo =0 , Di =0 , Sp = 0;

        for(int i =0;i<newPass.length();i++){
            char ch = newPass.charAt(i);

            if(ch>='A' && ch<='Z'){
                Up++;
            }
            else if(ch>='a' && ch<='z'){
                Lo++;
            }
            else if(ch>='0' && ch<='9'){
                Di++;
            }
            else{
                Sp++;
            }
        }

        if(Up>=1 && Lo>=1 && Di>=1 && Sp>=1){
            return true;
        }

        return false;
    }
}