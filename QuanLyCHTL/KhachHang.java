package QuanLyCHTL;

import text2.*;

import java.util.Scanner;

public class KhachHang extends ConNguoi {
    private String maHk;
    private String loaiKH;

    public KhachHang() {
        super();
        this.maHk = "";
        this.loaiKH = "";
    }

    public KhachHang(String hoTen, Date ngaySinh, String gioiTinh, DiaChi diaChi, String SDT, String maKh,
            String loaiHK) {
        super(hoTen, ngaySinh, gioiTinh, diaChi, SDT);
        this.maHk = maKh;
        this.loaiKH = loaiHK;
    }

    public KhachHang(KhachHang other) {
        super(other);
        this.maHk = other.maHk;
        this.loaiKH = other.loaiKH;
    }

    // Ham getter va setter
    public String getMaHk() {
        return maHk;
    }

    public void setMaHk(String maHk) {
        this.maHk = maHk;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }
    // ------------------------

    // Ham nhap khach hang
    @Override
    public void nhap() {
        Scanner rScanner = new Scanner(System.in);
        System.out.print("Nhap ma khach hang: ");
        this.maHk = rScanner.nextLine();
        super.nhap();
        System.out.print("Nhap loai khach hang: ");
        this.loaiKH = rScanner.nextLine();
    }

    @Override
    public void xuat() {
        System.out.printf("Ma khach hang: %s\n", this.maHk);
        super.xuat();
        System.out.printf("Loai khach hang: %s\n", this.loaiKH);
    }

    public String xuat_file() {
        return maHk + ", " + getHoTen() + ", " + getNgaySinh().xuat() + ", " + getGioiTinh() + ", " + getDiaChi().xuat()
                + ", " + getSDT() + ", " + loaiKH;
    }

    public void xuat_DinhDang() {
        System.out.printf("%-6s| %-20s| %-12s| %-4s| %-50s| %-11s| %-30s|\n", maHk, getHoTen(),
                getNgaySinh().xuat(), getGioiTinh(), getDiaChi().xuat(), getSDT(), loaiKH);
    }

    public static void main(String[] args) {
        KhachHang kh1 = new KhachHang();
        kh1.nhap();
        kh1.xuat_DinhDang();
    }
}
