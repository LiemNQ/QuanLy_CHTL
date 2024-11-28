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

    // --------------------------------------------------------------------------------------------------------------------------//
    // ============================================================================================================================//
    // --------------------------------------------------------------------------------------------------------------------------//
    // public void NhapLieu() {
    // System.out.println("\nNhap ten san pham :");
    // this.tenSP = reader.nextLine();
    // System.out.println("\nNhap ma san pham :");
    // this.maSP = reader.nextLine();
    // System.out.println("\nNhap gia mua vao san pham :");
    // this.giaMua = reader.nextInt();
    // System.out.println("\nNhap gia ban san pham :");
    // this.giaBan = reader.nextInt();

    // reader.nextLine();
    // System.out.println("\nNhap nha cung cap cua san pham :");
    // this.nhaCungcap = reader.nextLine();
    // System.out.println("\nNhap so luong san pham :");
    // this.soLuong = reader.nextInt();
    // }

    // public void Xuat() {
    // System.out.println("Ten san pham :" + this.tenSP);
    // System.out.println("Ma san pham :" + this.maSP);
    // System.out.println("Gia mua san pham :" + this.giaMua);
    // System.out.println("Gia ban san pham :" + this.giaBan);
    // System.out.println("Nha cung cap san pham :" + this.nhaCungcap);
    // System.out.println("So luong san pham :" + this.soLuong);
    // }
}
