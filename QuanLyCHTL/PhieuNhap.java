package QuanLyCHTL;

import text2.*;
import java.util.Scanner;

public class PhieuNhap extends Phieu implements TinhTongTien {
    protected Date ngayNhap;
    protected String ID_PhieuNhap = "PN00";
    protected String ma;
    protected String tenSP;
    protected String maSP_PhieuNhap;
    protected int soLuong;
    protected int giaNhap;
    private double ThanhTien;

    public PhieuNhap() {
        super();
        this.ngayNhap = new Date();
        this.maSP_PhieuNhap = "a";
        this.tenSP = "a";
        this.soLuong = 0;
        this.giaNhap = 0;
        this.ThanhTien = 0;
    }

    public PhieuNhap(String maPhieu, String maNV, Date ngayNhap, String tenSP, int soLuong, int giaNhap,
            double ThanhTien) {
        super(maPhieu, maNV);
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.ThanhTien = ThanhTien;
        this.tenSP = tenSP;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaSP_PhieuNhap() {
        return maSP_PhieuNhap;
    }

    public void setMaSP_PhieuNhap(String maSP_PhieuNhap) {
        this.maSP_PhieuNhap = maSP_PhieuNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double thanhTien) {
        ThanhTien = thanhTien;
    }

    @Override
    public void NhapLieu() {
        System.out.println("=======================================================================");
        System.out.println("------THONG TIN PHIEU NHAP!-----");
        Scanner reader = new Scanner(System.in);
        System.out.print("\nNhap ma phieu nhap: PN00-");
        this.ma = reader.nextLine();
        this.maPhieu = ID_PhieuNhap + ma;
        System.out.print("\nNhap ma nhan vien: ");
        this.maNV = reader.nextLine();
        System.out.println("\nNhap ngay nhap phieu: ");
        this.ngayNhap.nhap();
        System.out.print("\nNhap ma san pham :");
        this.maSP_PhieuNhap = reader.nextLine();
        System.out.print("\nNhap ten san pham :");
        this.tenSP = reader.nextLine();
        System.out.print("\nNhap so luong san pham :");
        this.soLuong = reader.nextInt();
        System.out.print("\nNhap gia mua san pham :");
        this.giaNhap = reader.nextInt();
        System.out.println("=======================================================================");
    }

    @Override
    public double TinhTien() {
        this.ThanhTien = this.soLuong * this.giaNhap;
        return ThanhTien;
    }

    @Override
    public void Xuat() {
        System.out.println("=======================================================================");
        System.out.println("------THONG TIN PHIEU NHAP!-----");
        System.out.println("Ma phieu nhap :" + this.maPhieu);
        System.out.println("Ma nhan vien :" + this.maNV);
        System.out.println("Ngay lap phieu: " + this.ngayNhap.xuat());
        System.out.println("Ma san pham :" + this.maSP_PhieuNhap);
        System.out.println("Ten san pham :" + this.tenSP);
        System.out.println("So luong nhap :" + this.soLuong);
        System.out.println("Nhap gia nhap :" + this.giaNhap);
        System.out.println("=======================================================================");
    }

    public String Xuat_file() {
        return maPhieu + ";" + maNV + ";" + ngayNhap.xuat() + ";" + tenSP + ";" + soLuong + ";" + giaNhap + ";"
                + this.TinhTien();
    }

    public static void main(String[] args) {
        PhieuNhap hd1 = new PhieuNhap();
        hd1.NhapLieu();
        hd1.Xuat_form();
        System.out.println("Tong so tien nhap:" + hd1.TinhTien());
    }

    public void Xuat_form() {
        System.out.printf("%-20s| %-10s| %-15s| %-10s| %-10d| %-10d| %-10.2f|\n", this.maPhieu, this.maNV,
                this.ngayNhap.xuat(), this.tenSP, this.soLuong, this.giaNhap, this.TinhTien());
    }
}
