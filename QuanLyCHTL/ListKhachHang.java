package QuanLyCHTL;

import text2.*;
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
            System.out.printf("Nhap thong tin khach hang thu %d:\n", i + 1);
            dskh[i] = new KhachHang();
            dskh[i].nhap();
            System.out.println("-----------------------");
        }
    }

    // Ham xuat danh sach
    public void xuatDanhSach() {
        System.out.println("--------------------------Danh sach nhan vien----------------------------");
        for (int index = 0; index < this.n; index++) {
            dskh[index].xuat_DinhDang();
        }
        System.out.println("-------------------------------------------------------------------------");
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

    // Ham sua thong tin
    public void sua() {
        System.out.println("Sua thong tin KH!");
        System.out.println("1.Sua theo ma KH.");
        System.out.println("2.Sua theo ten KH");
        System.out.print("Nhap lua chon:");
        Scanner rScanner = new Scanner(System.in);
        int choice = rScanner.nextInt();
        rScanner.nextLine();
        switch (choice) {
            case 1:
                String id = rScanner.nextLine();
                for (int i = 0; i < this.n; i++) {
                    if (dskh[i].getMaHk().equalsIgnoreCase(id)) {
                        dskh[i].nhap();
                    }
                }
                break;
            case 2:
                String ten = rScanner.nextLine();
                for (int i = 0; i < this.n; i++) {
                    if (dskh[i].getHoTen().equalsIgnoreCase(ten)) {
                        dskh[i].nhap();
                    }
                }
                break;

            default:
                break;
        }
    }

    // Ham tim kiem
    public void timKiem() {
        System.out.println("Tim kiem khach hang!");
        System.out.println("1.Tim kiem theo ma KH.");
        System.out.println("2.Tim kiem theo ten KH.");
        System.out.print("Nhap lua chon:");
        Scanner rScanner = new Scanner(System.in);
        int choice = rScanner.nextInt();
        rScanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Nhap ma KH:");
                String id = rScanner.nextLine();
                int count = 0;
                for (int i = 0; i < this.n; i++) {
                    if (dskh[i].getMaHk().equalsIgnoreCase(id)) {
                        dskh[i].xuat();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Khong tim thay khach hang!");
                }
                break;
            case 2:
                System.out.print("Nhap ten khach hang: ");
                String ten = rScanner.nextLine();
                int count1 = 0;
                for (int i = 0; i < this.n; i++) {
                    if (dskh[i].getHoTen().equalsIgnoreCase(ten)) {
                        dskh[i].xuat();
                        count1++;
                    }
                }
                if (count1 == 0) {
                    System.out.println("Khong tim thay khach hang! ");
                }
                break;
            default:
                break;
        }
    }

    // Ham doc file
    public static void docfile(ListKhachHang DSKH) {
        try {
            BufferedReader input = new BufferedReader(new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\dataKH.txt"));
            String line = input.readLine();
            while (line != null) {
                int n = DSKH.n;
                DSKH.dskh = Arrays.copyOf(DSKH.dskh, n + 1);
                DSKH.dskh[n] = new KhachHang();
                // chia chuỗi thành các chuỗi con phân cách bởi dấu phẩy
                String[] arr = line.split(", ");
                // lay ma KH
                DSKH.dskh[n].setMaHk(arr[0]);
                // lay ten HK
                DSKH.dskh[n].setHoTen(arr[1]);
                // lay ngay thang nam sinh
                String arr1[] = arr[2].split("/");
                Date date = new Date(Integer.parseInt(arr1[0]), Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
                DSKH.dskh[n].setNgaySinh(date);
                // lay gioi tinh
                DSKH.dskh[n].setGioiTinh(arr[3]);
                // lay dia chi
                DiaChi diachi = new DiaChi(arr[4], arr[5], arr[6], arr[7]);
                DSKH.dskh[n].setDiaChi(diachi);
                // lay SDT
                DSKH.dskh[n].setSDT(arr[8]);
                // lay loai KH
                DSKH.dskh[n].setLoaiKH(arr[9]);
                line = input.readLine();
                DSKH.n++;
            }

            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Ham ghi file
    public static void ghiFile(ListKhachHang DSKH) {
        try {
            FileWriter fw = new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\dataKH.txt");
            int i = 0;
            while (i < DSKH.n) {
                fw.write(DSKH.dskh[i].xuat_file());
                fw.write("\n");
                i++;
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Ham menu
    public void MENU_KHACHHANG(ListKhachHang DSKH) {
        boolean flag = true;
        while (flag) {
            System.out.println("1.Nhap danh sach.");
            System.out.println("2.Them khach hang.");
            System.out.println("3.Xoa khach hang.");
            System.out.println("4.Sua thong tin khach hang.");
            System.out.println("5.Tim kiem khach hang.");
            System.out.println("6.Xuat danh sach.");
            System.out.println("7.Doc file.");
            System.out.println("8.Ghi file.");
            System.out.println("0.Thoat");
            System.out.print("Nhap lua chon: ");
            Scanner rScanner = new Scanner(System.in);
            int choice = rScanner.nextInt();
            rScanner.nextLine();
            switch (choice) {
                case 1:
                    DSKH.nhapDanhSach();
                    break;
                case 2:
                    DSKH.them();
                    break;
                case 3:
                    DSKH.xoa();
                    break;
                case 4:
                    DSKH.sua();
                    break;
                case 5:
                    DSKH.timKiem();
                    break;
                case 6:
                    DSKH.xuatDanhSach();
                    break;
                case 7:
                    docfile(DSKH);
                    break;
                case 8:
                    ghiFile(DSKH);
                    break;
                case 0:
                    flag = false;
                    break;

                default:
                    break;
            }
        }
    }

    // Ham main
    public static void main(String[] args) {
        ListKhachHang DSKH = new ListKhachHang();
        DSKH.MENU_KHACHHANG(DSKH);

    }
}
