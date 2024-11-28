package QuanLyCHTL;

import text2.*;
import java.util.Scanner;

public class NhanVien extends ConNguoi {
    private String maNV;
    private Date ngayVaoLam;

    public NhanVien() {
        super();
        this.maNV = "";
        this.ngayVaoLam = new Date();
    }

    public NhanVien(String hoTen, Date ngaySinh, String gioiTinh, DiaChi diaChi, String SDT, String maNV,
            Date ngayVaoLam) {
        super(hoTen, ngaySinh, gioiTinh, diaChi, SDT);
        this.maNV = maNV;
        this.ngayVaoLam = ngayVaoLam;
    }

    public NhanVien(NhanVien other) {
        super(other);
        this.maNV = other.maNV;
        this.ngayVaoLam = other.ngayVaoLam;
    }

    // Ham getter va setter
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    // Ham lay ten nhan vien
    public String layTenNhanVien() {
        return this.getHoTen();
    }

    // Ham nhap
    @Override
    public void nhap() {
        Scanner rScanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = rScanner.nextLine();
        super.nhap();
        System.out.println("Nhap ngay vao lam: ");
        this.ngayVaoLam.nhap();
    }

    @Override
    public void xuat() {
        System.out.printf("Ma nhan vien: %s\n", this.maNV);
        super.xuat();
        System.out.printf("Ngay vao lam: %s\n", this.ngayVaoLam.xuat());
    }

    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien();
        nv1.nhap();
        nv1.xuat();
    }

}
