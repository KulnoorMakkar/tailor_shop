package com.example.proj.measexpp;

public class MesureBean {
    String orderid ,ename ,mobile ,Dress ,dod ;
    int qty ,bill  ;
    String mesurements ,worker;
    int stat;

    public MesureBean(String orderid, String ename, String mobile, String dress, String dod, int qty, int bill, String mesurements, String worker, int stat) {
        this.orderid = orderid;
        this.ename = ename;
        this.mobile = mobile;
        Dress = dress;
        this.dod = dod;
        this.qty = qty;
        this.bill = bill;
        this.mesurements = mesurements;
        this.worker = worker;
        this.stat = stat;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDress() {
        return Dress;
    }

    public void setDress(String dress) {
        Dress = dress;
    }

    public String getDod() {
        return dod;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getMesurements() {
        return mesurements;
    }

    public void setMesurements(String mesurements) {
        this.mesurements = mesurements;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
}
