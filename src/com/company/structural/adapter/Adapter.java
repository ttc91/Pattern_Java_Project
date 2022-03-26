package com.company.structural.adapter;

/**
 * <b>Target</b> :
 */

interface XPay {

    public String getCreditCardNo();
    public String getCustomerName();
    public String getCardExpMonth();
    public String getCardExpYear();
    public Short getCardVVNo();
    public Double getAmount();

    public void setCreditCardNo(String creditCardNo);
    public void setCustomerName(String customerName);
    public void setCardExpMonth(String cardExpMonth);
    public void setCardExpYear(String cardExpYear);
    public void setCardVVNo(Short cardVVNo);
    public void setAmount(Double amount);

}

interface DPay {

    public String getCustomerCardNo();
    public String getCardOwnerName();
    public String getCardExpMonthDate();
    public Integer getCVVNo();
    public Double getTotalAmount();

    public void setCustomerCardNo(String customerCardNo);
    public void setCardOwnerName(String cardOwnerName);
    public void setCardExpMonthDate(String cardExpMonthDate);
    public void setCVVNo(Integer cvvNo);
    public void setTotalAmount(Double amount);

}

/**
 * <b>Adaptee</b> :
 */

class XPayImpl implements XPay {

    private String creditCardNo;
    private String customerName;
    private String cardExpMonth;
    private String cardExpYear;
    private Short cardVVNo;
    private Double amount;

    @Override
    public String getCreditCardNo() {
        return this.creditCardNo;
    }

    @Override
    public String getCustomerName() {
        return this.customerName;
    }

    @Override
    public String getCardExpMonth() {
        return this.cardExpMonth;
    }

    @Override
    public String getCardExpYear() {
        return this.cardExpYear;
    }

    @Override
    public Short getCardVVNo() {
        return this.cardVVNo;
    }

    @Override
    public Double getAmount() {
        return this.amount;
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    @Override
    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    @Override
    public void setCardVVNo(Short cardVVNo) {
        this.cardVVNo = cardVVNo;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

/**
 * <b>Adapter</b> :
 */

class XPayToDPayAdapter implements DPay {

    private String customerCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cvvNo;
    private Double amount;

    private final XPay xPay;

    XPayToDPayAdapter(XPay xPay) {
        this.xPay = xPay;
        setProp();
    }

    @Override
    public String getCustomerCardNo() {
        return this.customerCardNo;
    }

    @Override
    public String getCardOwnerName() {
        return this.cardOwnerName;
    }

    @Override
    public String getCardExpMonthDate() {
        return this.cardExpMonthDate;
    }

    @Override
    public Integer getCVVNo() {
        return this.cvvNo;
    }

    @Override
    public Double getTotalAmount() {
        return this.amount;
    }

    @Override
    public void setCustomerCardNo(String customerCardNo) {
        this.customerCardNo = customerCardNo;
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    @Override
    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;
    }

    @Override
    public void setCVVNo(Integer cvvNo) {
        this.cvvNo = cvvNo;
    }

    @Override
    public void setTotalAmount(Double amount) {
        this.amount = amount;
    }

    private void setProp(){
        setCardOwnerName(this.xPay.getCustomerName());
        setCustomerCardNo(this.xPay.getCreditCardNo());
        setCardExpMonthDate(this.xPay.getCardExpMonth() + " " + this.xPay.getCardExpYear());
        setCVVNo(Integer.valueOf(this.xPay.getCardVVNo()));
        setTotalAmount(this.xPay.getAmount());

    }
}

public class Adapter {

    public static void main(String[] args) {
        // write your code here

        XPay xPay = new XPayImpl();
        xPay.setCreditCardNo("194567162");
        xPay.setCustomerName("Tat Tan Chu");
        xPay.setCardExpMonth("09");
        xPay.setCardExpYear("2027");
        xPay.setCardVVNo((short)235);
        xPay.setAmount(2565.23);

        DPay dPay = new XPayToDPayAdapter(xPay);

        System.out.println(dPay.getCardExpMonthDate());
        System.out.println(dPay.getCardOwnerName());
        System.out.println(dPay.getCustomerCardNo());
        System.out.println(dPay.getTotalAmount());

    }

}
