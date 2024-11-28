package QuanLyCHTL;

public abstract class HoaDon {
    protected String IDPhieu;
    protected String date;
    protected String IDNhanVien;
    protected int sumMoney;

    public HoaDon() {
        this.IDPhieu = "";
        this.date = "";
        this.IDNhanVien = "";
        this.sumMoney = 0;
    }

    public HoaDon(String IDPhieu, String date, int sumMoney, String IDNhanVien) {
        setIDPhieu(IDPhieu);
        setDate(date);
        this.sumMoney = sumMoney;
        this.IDNhanVien = IDNhanVien;
    }

    @Override
    public String toString() {
        return IDPhieu + "-" + date + "-" + sumMoney + "-" + IDNhanVien;
    }

    public String getIDPhieu() {
        return IDPhieu;
    }

    public void setIDPhieu(String IDPhieu) {
        this.IDPhieu = IDPhieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    // Abstract để lớp con buộc phải triển khai
    public abstract void displayDetails();
}
