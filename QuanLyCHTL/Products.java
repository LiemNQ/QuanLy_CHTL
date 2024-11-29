package QuanLyCHTL;

import java.util.Scanner;

public abstract class Products {
    Scanner reader = new Scanner(System.in);

    // lớp trừu tượng
    protected String tenSP;
    protected String maSP;
    protected int giaMua;
    protected int giaBan;
    protected String nhaCungcap;
    protected int soLuong;

    // Constructor
    public Products() {
        this.tenSP = "";
        this.maSP = "";
        this.giaMua = 0;
        this.giaBan = 0;
        this.nhaCungcap = "";
        this.soLuong = 0;
    }

    public Products(String tenSP, String maSP, int giaMua, int giaBan, String nhaCungcap, int soLuong) {
        this.tenSP = tenSP;
        this.maSP = maSP;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.nhaCungcap = nhaCungcap;
        this.soLuong = soLuong;
    }

    // Getter và Setter
    public String get_maSP() {
        return maSP;
    }

    public void set_maSP(String maSP) {
        this.maSP = maSP;
    }

    public String get_tenSP() {
        return tenSP;
    }

    public void set_tenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int get_giaBan() {
        return giaBan;
    }

    public void set_giaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int get_giaMua() {
        return giaMua;
    }

    public void set_giaMua(int giaMua) {
        this.giaMua = giaMua;
    }

    public String get_nhaCungcap() {
        return nhaCungcap;
    }

    public void set_nhaCungcap(String nhaCungcap) {
        this.nhaCungcap = nhaCungcap;
    }

    public int get_soLuong() {
        return soLuong;
    }

    public void set_soLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public abstract void NhapLieu();
    // ----tenSP----maSP----giaMua----giaBan----nhaCungcap----soLuong

    public abstract void Xuat();

    public abstract String Xuat_file();

}
