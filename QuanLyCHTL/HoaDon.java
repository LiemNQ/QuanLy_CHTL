package QuanLyCHTL;

import text2.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import text2.*;

public class HoaDon extends Phieu implements TinhTongTien {
    private int ma;
    private String ID_HoaDon = "HD00";// RANG BUOC DINH DANG
    private String maNV;
    private String maKH;
    private Date ngayNhap;
    private double tongTien;
    private int n;
    private String maSP;
    private int soLuong;
    private double giaBan;
    private double thanhTien;

    public HoaDon() {
        super();
        this.ma = 0;
        this.maKH = "a";
        this.maNV = "b";
        this.ngayNhap = new Date();
        this.tongTien = 0.0;
        this.maSP = "c";
        this.soLuong = 0;
        this.giaBan = 0.0;
        this.thanhTien = 0.0;
    }

    public HoaDon(String maPhieu, String maNV, String maKH, Date ngayNhap,
            double tongTien, String maSP, int soLuong, double giaBan) {
        super(maPhieu, maNV);
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;

        // Gán giá trị cho thuộc tính mới
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    // Getter và Setter cho các thuộc tính mới
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = this.soLuong * this.giaBan; // Cập nhật thành tiền
    }

    public double getThanhTien() {
        return thanhTien;
    }

    HoaDon[] SP;

    @Override
    public void NhapLieu() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Nhap thong tin hoa don:");
        System.out.print("- Nhap ma hoa don:HD00-");
        this.ma = reader.nextInt();
        reader.nextLine();
        this.maPhieu = ID_HoaDon + this.ma;
        System.out.print("- Ma NV: ");
        this.maNV = reader.nextLine();
        System.out.print("- Ma KH: ");
        this.maKH = reader.nextLine();
        System.out.println("- Ngay nhap:");
        this.ngayNhap = new Date();
        this.ngayNhap.nhap();
        ///////////////////////////////////////////
        System.out.println("Nhập số lượng sản phẩm được mua:");
        n = reader.nextInt();
        tongTien = 0.0;

        SP = new HoaDon[n];

        for (int i = 0; i < n; i++) {
            SP[i] = new HoaDon();
            SP[i].maPhieu = this.maPhieu;
            SP[i].maNV = this.maNV;
            SP[i].maKH = this.maKH;
            SP[i].ngayNhap = this.ngayNhap;
            SP[i].new_NhapLieu();
            SP[i].TinhTien();
            tongTien += SP[i].thanhTien;
            try {
                BufferedWriter fr = new BufferedWriter(
                        new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt", true));

                fr.write(SP[i].maPhieu);
                fr.write(";");
                fr.write(SP[i].maNV);
                fr.write(";");
                fr.write(SP[i].maKH);
                fr.write(";");
                fr.write(SP[i].ngayNhap.xuat());
                fr.write(";");
                fr.write(String.valueOf(SP[i].TinhTien()));
                fr.write(";");
                fr.write(SP[i].maSP);
                fr.write(";");
                fr.write(String.valueOf(SP[i].soLuong));
                fr.write(";");
                fr.write(String.valueOf(SP[i].giaBan));
                fr.newLine();
                fr.close();
                System.out.println("Ghi file thành công!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }

    public void ghi_file_hoadon() {
        try {
            BufferedWriter fr = new BufferedWriter(
                    new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt", true));
            for (int i = 0; i < n; i++) {
                // HD003;NV2;KH004;15/12/2020;10000thanh tien;SP001;1;10000gia ban

                fr.write(SP[i].maPhieu);
                fr.write(";");
                fr.write(SP[i].maNV);
                fr.write(";");
                fr.write(SP[i].maKH);
                fr.write(";");
                fr.write(SP[i].ngayNhap.xuat());
                fr.write(";");
                fr.write(String.valueOf(SP[i].TinhTien()));
                fr.write(";");
                fr.write(SP[i].maSP);
                fr.write(";");
                fr.write(String.valueOf(SP[i].soLuong));
                fr.write(";");
                fr.write(String.valueOf(SP[i].giaBan));
                fr.newLine();
            }
            fr.close();
            System.out.println("Ghi file thành công!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void new_NhapLieu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.print("\n==>Ma san pham: ");
        this.maSP = scanner.nextLine();
        System.out.print("\nSo luong: ");
        this.soLuong = scanner.nextInt();
        System.out.print("\nGia Ban: ");
        this.giaBan = scanner.nextDouble();
        System.out.println("-------------------------------------------");
    }

    @Override
    public double TinhTien() {
        this.thanhTien = this.soLuong * this.giaBan;
        return thanhTien;
    }

    @Override
    public void Xuat() {
        System.out.println("-------------------------------------------");
        System.out.println("Thong tin hoa đon:");
        System.out.println("- Ma HD: " + this.maPhieu);
        System.out.println("- Ma NV: " + this.maNV);
        System.out.println("- Ma KH: " + this.maKH);
        System.out.println("- Ngay nhap: " + this.ngayNhap.xuat());
        System.out.println("-------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println("-------------------------------------------");
            System.out.println("- Ma san pham: " + SP[i].maSP);
            System.out.println("- So luong: " + SP[i].soLuong);
            System.out.println("- Đon gia: " + SP[i].giaBan);
            System.out.println("- Thanh tien: " + SP[i].thanhTien);
            System.out.println("-------------------------------------------");
        }
        System.out.println("-Tong tien: " + this.tongTien);
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        HoaDon hd1 = new HoaDon();
        hd1.NhapLieu();
        hd1.Xuat();
    }

    // HD003;NV2;KH004;15/12/2020;10000thanh tien;SP001;1;10000gia ban
    public String Xuat_file() {
        return maPhieu + ";" + maNV + ";" + maKH + ";" + ngayNhap.xuat() + ";" + TinhTien() + ";" + maSP + ";" + soLuong
                + ";" + giaBan;
    }

    public void Xuat_form() {
        System.out.printf("%-20s| %-10s| %-10s| %-15s| %-10.2f| %-10s| %-10d|%-10.2f|\n", this.maPhieu, this.maNV,
                this.maKH,
                ngayNhap.xuat(), this.TinhTien(), this.maSP, this.soLuong, this.giaBan);
    }
}

// public HoaDon(String maPhieu, String maNV, String maKH, Date ngayNhap,
// double tongTien, String maSP, int soLuong, double giaBan) {