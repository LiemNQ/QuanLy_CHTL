package QuanLyCHTL;

import text2.*;
import java.util.Scanner;

public class ConNguoi {
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private DiaChi diaChi;
    private String SDT;

    // Ham thiet lap
    public ConNguoi() {
        this.hoTen = "";
        this.ngaySinh = new Date();
        this.gioiTinh = "";
        this.diaChi = new DiaChi();
        this.SDT = "";
    }

    public ConNguoi(String hoTen, Date ngaySinh, String gioiTinh, DiaChi diaChi, String SDT) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public ConNguoi(ConNguoi other) {
        this.hoTen = other.hoTen;
        this.ngaySinh = other.ngaySinh;
        this.gioiTinh = other.gioiTinh;
        this.diaChi = other.diaChi;
        this.SDT = other.SDT;
    }

    // Ham getter va setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String sDT) {
        SDT = sDT;
    }
    // ----------------------

    public void nhap() {
        Scanner rScanner = new Scanner(System.in);
        System.out.printf("*Nhap ho ten: ");
        this.hoTen = rScanner.nextLine();
        System.out.printf("*Nhap ngay sinh:\n");
        this.ngaySinh.nhap();
        System.out.printf("*Nhap gioi tinh: ");
        this.gioiTinh = rScanner.nextLine();
        this.diaChi.nhap();
        boolean flag = false;
        do {
            System.out.print("*Nhap so dien thoai: ");
            this.SDT = rScanner.nextLine();
            String sdt = this.SDT.trim();
            for (int i = 0; i < sdt.length(); i++) {
                if (sdt.charAt(i) >= '0' && sdt.charAt(i) <= '9' && sdt.length() == 10) {
                    flag = true;
                }
            }
        } while (flag == false);

    }

    public void xuat() {
        System.out.printf("Ho ten : %s\n", hoTen);
        System.out.printf("Ngay sinh: %s\n", this.ngaySinh.xuat());
        System.out.printf("Gioi tinh: %s\n", this.gioiTinh);
        System.out.printf("Dia chi: %s\n", this.diaChi.xuat());
        System.out.printf("So dien thoai: %s\n", this.SDT);

    }

    public static void main(String[] args) {
        ConNguoi cn1 = new ConNguoi();
        cn1.nhap();
        cn1.xuat();
    }
}
