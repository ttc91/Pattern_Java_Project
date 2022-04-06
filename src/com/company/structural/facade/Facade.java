package com.company.structural.facade;

class AccountService {

    public void getAccount(String email){
        System.out.println("Getting the account of " + email);
    }

}

class PaymentService{

    public void paymentByPayPal(){
        System.out.println("Payment by Paypal");
    }

    public void paymentByCreditCard(){
        System.out.println("Payment by Credit Card");
    }

    public void paymentByCash(){
        System.out.println("Payment by cash");
    }

}

class EmailService {

    public void sendMail(String mailTo) {
        System.out.println("Sending an email to " + mailTo);
    }
}

class SmsService {

    public void sendSMS(String mobilePhone) {
        System.out.println("Sending an message to " + mobilePhone);
    }
}

class ServiceFacade {

    private static final ServiceFacade INSTANCE = new ServiceFacade();

    private SmsService smsService;
    private EmailService emailService;
    private PaymentService paymentService;
    private AccountService accountService;

    private ServiceFacade(){

        SmsService smsService = new SmsService();
        EmailService emailService = new EmailService();
        PaymentService paymentService = new PaymentService();
        AccountService accountService = new AccountService();

    }

    public static ServiceFacade getInstance(){
        return INSTANCE;
    }

    public void buyProductByPaypalWithStandardShipping(String email, String mobilePhone) {

        accountService.getAccount(email);
        emailService.sendMail(email);
        smsService.sendSMS(mobilePhone);
        System.out.println("Done\n");

    }

}


public class Facade {

    public static void main(String[] args) {
        // write your code here
    }

}
