package com.powerlong.model;

import java.util.Date;

public class Receipt {
    private Long id;

    private String receiptnum;//水单号

    private String cptid; //设备号

    private Date tsdate; //交易日期

    private Double totalamount; 

    private String qrcode;

    private String tsid;

    private String merchantid;

    private Double enteramount;

    private String productif;

    private Date createtime;

    private String imageurl;

    private String paymenttype;

    private String modeltype;

    private String txtstring;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptnum() {
        return receiptnum;
    }

    public void setReceiptnum(String receiptnum) {
        this.receiptnum = receiptnum == null ? null : receiptnum.trim();
    }

    public String getCptid() {
        return cptid;
    }

    public void setCptid(String cptid) {
        this.cptid = cptid == null ? null : cptid.trim();
    }

    public Date getTsdate() {
        return tsdate;
    }

    public void setTsdate(Date tsdate) {
        this.tsdate = tsdate;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getTsid() {
        return tsid;
    }

    public void setTsid(String tsid) {
        this.tsid = tsid == null ? null : tsid.trim();
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public Double getEnteramount() {
        return enteramount;
    }

    public void setEnteramount(Double enteramount) {
        this.enteramount = enteramount;
    }

    public String getProductif() {
        return productif;
    }

    public void setProductif(String productif) {
        this.productif = productif == null ? null : productif.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype == null ? null : paymenttype.trim();
    }

    public String getModeltype() {
        return modeltype;
    }

    public void setModeltype(String modeltype) {
        this.modeltype = modeltype == null ? null : modeltype.trim();
    }

    public String getTxtstring() {
        return txtstring;
    }

    public void setTxtstring(String txtstring) {
        this.txtstring = txtstring == null ? null : txtstring.trim();
    }
}