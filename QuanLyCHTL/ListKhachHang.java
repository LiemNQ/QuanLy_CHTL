package QuanLyCHTL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ListKhachHang {
    KhachHang[] dskh;
    int n;

    public ListKhachHang() {
        this.dskh = new KhachHang[0];
        this.n = 0;
    }

    public ListKhachHang(KhachHang[] dskh, int n) {
        this.dskh = dskh;
        this.n = n;
    }

    public ListKhachHang(ListKhachHang other) {
        this.dskh = other.dskh;
        this.n = other.n;
    }

    // Ham nhap danh sach khach hang
    public void nhapDanhSach() {
        Scanner rScanner = new Scanner(System.in);
        System.out.println("---Nhap danh sach Khach hang---");
        System.out.print("Nhap so luong Khach hang: ");
        this.n = rScanner.nextInt();
        rScanner.nextLine();
        this.dskh = new KhachHang[this.n];
        for (int i = 0; i < this.n; i++) {
            System.out.printf("Nhap thong tin khach hang thu %d:\n", i);
            dskh[i] = new KhachHang();
            dskh[i].nhap();
            System.out.println("-----------------------");
        }
    }

    // Ham xuat danh sach
    public void xuatDanhSach() {
        System.out.println("---Xuat danh sach Khach hang---");
        for (int i = 0; i < this.n; i++) {
            System.out.printf("Thong tin khach hang thu %d:\n", i);
            dskh[i].xuat();
            System.out.println("----------------------");
        }
    }

    // Ham them khach hang
    public void them() {
        System.out.println("Them nhan vien.");
        System.out.println("1.Them 1 nhan vien.");
        System.out.println("2.Them n nhan vien.");
        System.out.println("0.Thoat");
        System.out.print("Nhap lua chon: ");
        Scanner rScanner = new Scanner(System.in);
        int choice = rScanner.nextInt();
        switch (choice) {
            case 1:
                dskh = Arrays.copyOf(dskh, this.n + 1);
                dskh[n] = new KhachHang();
                dskh[n].nhap();
                this.n++;
                break;
            case 2:
                System.out.print("Nhap so luong k khach hang: ");
                int k = rScanner.nextInt();
                dskh = Arrays.copyOf(dskh, this.n + k);
                for (int i = n; i < k; i++) {
                    dskh[i] = new KhachHang();
                    dskh[i].nhap();
                }
                this.n += k;

            default:
                break;
        }
    }

    // Ham xoa khach hang
    public void xoa() {
        Scanner rScanner = new Scanner(System.in);
        System.out.println("Xoa khach hang:");
        System.out.println("1.Xoa theo ma KH.");
        System.out.println("2.Xoa theo ten KH.");
        System.out.print("Nhap lua chon: ");
        int choice = rScanner.nextInt();
        rScanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Nhap ma KH can xoa: ");
                String id = rScanner.nextLine();
                for (int i = 0; i < this.n; i++) {
                    if (dskh[i].getMaHk().equalsIgnoreCase(id)) {
                        for (int j = i; j < this.n - 1; j++) {
                            dskh[j] = dskh[j + 1];
                        }
                        dskh = Arrays.copyOf(dskh, this.n - 1);
                        this.n--;
                        i--;
                    }
                }
                break;
            case 2:
                System.out.print("Nhap ten HK can xoa: ");
                String tenHK = rScanner.nextLine();
                for (int i = 0; i < this.n; i++) {
                    if (dskh[i].getMaHk().equalsIgnoreCase(tenHK)) {
                        for (int j = i; j < this.n - 1; j++) {
                            dskh[j] = dskh[j + 1];
                        }
                        dskh = Arrays.copyOf(dskh, this.n - 1);
                        this.n--;
                        i--;
                    }
                }
                break;
            default:
                break;
        }
    }

    // Ham doc file
    public static void docfile() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("data.txt"));
            String line = input.readLine();
            while (line != null) {
                // chia chuỗi thành các chuỗi con phân cách bởi dấu phẩy
                String[] arr = line.split(",");

                line = input.readLine();
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Ham ghi file
    public static void ghiFile() {
        try {
            FileWriter fw = new FileWriter("D:\\OOP\\DO_AN\\data.txt");
            fw.write("welcome to java");
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Ham main
    public static void main(String[] args) {
        docfile();
        ghiFile();
        ListKhachHang danhsach = new ListKhachHang();
        danhsach.xuatDanhSach();
    }
}