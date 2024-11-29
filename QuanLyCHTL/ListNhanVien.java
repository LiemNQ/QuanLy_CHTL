package QuanLyCHTL;

import text.*;
import text2.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ListNhanVien {
    NhanVien[] dsnv;
    int n;

    public ListNhanVien() {
        this.n = 0;
        this.dsnv = new NhanVien[0];
    }

    public ListNhanVien(NhanVien[] dsnv, int n) {
        this.dsnv = dsnv;
        this.n = n;
    }

    public ListNhanVien(ListNhanVien other) {
        this.dsnv = other.dsnv;
        this.n = other.n;
    }

    // Ham nhap
    public void nhapDanhSach() {
        Scanner rScanner = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien can nhap: ");
        this.n = rScanner.nextInt();
        dsnv = new NhanVien[this.n];
        rScanner.nextLine();
        for (int i = 0; i < this.n; i++) {
            System.out.printf("Nhap thong tin nhan vien thu %d :\n", i);
            dsnv[i] = new NhanVien();
            dsnv[i].nhap();
            System.out.println("----------------------");
        }
    }

    // Ham xuat danh sach nhan vien
    public void xuatDanhSach() {
        System.out.println("--------------------------Danh sach nhan vien----------------------------");
        for (int index = 0; index < this.n; index++) {
            dsnv[index].xuat_DinhDang();
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // Ham them nhan vien
    // Thêm 1 nhân viên
    // Thêm n nhân viên
    public void them() {
        System.out.println("Them nhan vien.");
        System.out.println("1.Them 1 nhan vien.");
        System.out.println("2.Them n nhan vien.");
        System.out.print("Nhap lua chon: ");
        Scanner rScanner = new Scanner(System.in);
        int choice = rScanner.nextInt();
        rScanner.nextLine();
        switch (choice) {
            case 1:
                dsnv = Arrays.copyOf(dsnv, this.n + 1);
                dsnv[this.n] = new NhanVien();
                dsnv[this.n].nhap();
                this.n++;
                break;
            case 2:
                System.out.print("Nhap so nhan vien can nhap k:");
                int k = rScanner.nextInt();
                dsnv = Arrays.copyOf(dsnv, this.n + k);
                for (int i = 0; i < k; i++) {
                    dsnv[this.n] = new NhanVien();
                    dsnv[this.n].nhap();
                    this.n++;
                }
                break;
            default:
                break;
        }
    }

    // Hàm xóa nhân viên theo id
    // Hàm xóa nhân viên theo hoTen
    public void xoa() {
        System.out.println("Xoa nhan vien.");
        System.out.println("1.Xoa theo id.");
        System.out.println("2.Xoa theo ten.");
        System.out.print("Nhap lua chon: ");
        Scanner rScanner = new Scanner(System.in);
        int choice = rScanner.nextInt();
        rScanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Nhap id cua nhan vien can xoa: ");
                String id = rScanner.nextLine();
                for (int i = 0; i < this.n; i++) {
                    if (dsnv[i].getMaNV().equalsIgnoreCase(id)) {
                        for (int j = i; j < this.n - 1; j++) {
                            dsnv[j] = dsnv[j + 1];
                        }
                        dsnv = Arrays.copyOf(dsnv, this.n - 1);
                        this.n--;
                        i--;
                    }
                }
                break;
            case 2:
                System.out.print("Nhap ten cua cac nhan vien can xoa: ");
                String ten = rScanner.nextLine();
                int flag = 0;
                for (int i = 0; i < this.n; i++) {
                    if (dsnv[i].layTenNhanVien().equalsIgnoreCase(ten)) {
                        for (int j = i; j < this.n - 1; j++) {
                            dsnv[j] = dsnv[j + 1];
                        }
                        dsnv = Arrays.copyOf(dsnv, this.n - 1);
                        this.n--;
                        i--;
                        flag++;
                    }
                }
                if (flag == 0) {
                    System.out.println("Khong tim duoc sinh vien de xoa!");
                }
            default:
                break;
        }
    }

    // Hàm sửa thông tin nhân viên
    public void sua() {
        System.out.println("Sua thong tin nhan vien.");
        System.out.println("1.Sua thong tin theo id.");
        System.out.println("2.Sua thong tin theo ten.");
        Scanner rScanner = new Scanner(System.in);
        int choice = rScanner.nextInt();
        rScanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Nhap id :");
                String id = rScanner.nextLine();
                rScanner.nextLine();
                int flag = 0;
                for (int i = 0; i < this.n; i++) {
                    if (dsnv[i].getMaNV().equalsIgnoreCase(id)) {
                        dsnv[i].nhap();
                    }
                    flag++;
                }
                if (flag == 0) {
                    System.out.println("Khong tim thay!");
                }
                break;
            case 2:
                System.out.println("Nhap ten: ");
                String ten = rScanner.nextLine();
                rScanner.nextLine();
                int flag1 = 0;
                for (int i = 0; i < this.n; i++) {
                    if (dsnv[i].getHoTen().equalsIgnoreCase(ten)) {
                        dsnv[i].nhap();
                        flag1++;
                    }
                }
                if (flag1 == 0) {
                    System.out.println("Khong tim thay!");
                }
                break;
            default:
                System.out.println("Ban nhap khong dung!");
                break;
        }
    }

    // Ham tim kiem
    public void timKiem() {
        System.out.println("Tim kiem nhan vien.");
        System.out.println("1.Tim theo id.");
        System.out.println("2.Tim theo ten.");
        System.out.print("Nhap lua chon: ");
        Scanner rScanner = new Scanner(System.in);
        int choice = rScanner.nextInt();
        rScanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Nhap id nhan vien can tim: ");
                String id = rScanner.nextLine();
                int flag = 0;
                for (int i = 0; i < this.n; i++) {
                    if (dsnv[i].getMaNV().equalsIgnoreCase(id)) {
                        dsnv[i].xuat();
                    }
                    flag++;
                }
                if (flag == 0) {
                    System.out.println("Khong tim thay!");
                }
                break;
            case 2:
                System.out.println("Nhap ten nhan vien can tim: ");
                String ten = rScanner.nextLine();
                int flag1 = 0;
                for (int i = 0; i < this.n; i++) {
                    if (dsnv[i].getHoTen().equalsIgnoreCase(ten)) {
                        dsnv[i].xuat();
                    }
                    flag1++;
                }
                if (flag1 == 0) {
                    System.out.println("Khong tim thay !");
                }
            default:
                System.err.println("Ban nhap khong dung!");
                break;
        }
    }

    // Ham doc file
    public static void docFile(ListNhanVien DSNV) {
        try {
            BufferedReader input = new BufferedReader(new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\dataNV.txt"));
            String line = input.readLine();
            while (line != null) {
                int n = DSNV.n;
                DSNV.dsnv = Arrays.copyOf(DSNV.dsnv, n + 1);
                DSNV.dsnv[n] = new NhanVien();
                // chia chuỗi thành các chuỗi con phân cách bởi dấu phẩy
                String[] arr = line.split(", ");
                // lay ma NV
                DSNV.dsnv[n].setMaNV(arr[0]);
                // lay ten NV
                DSNV.dsnv[n].setHoTen(arr[1]);
                // lay ngay thang nam sinh
                String arr1[] = arr[2].split("/");
                Date date1 = new Date(Integer.parseInt(arr1[0]), Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
                DSNV.dsnv[n].setNgaySinh(date1);
                // lay gioi tinh
                DSNV.dsnv[n].setGioiTinh(arr[3]);
                // lay dia chi
                DiaChi diachi = new DiaChi(arr[4], arr[5], arr[6], arr[7]);
                DSNV.dsnv[n].setDiaChi(diachi);
                // lay SDT
                DSNV.dsnv[n].setSDT(arr[8]);
                // lay ngay vao lam
                String arr2[] = arr[9].trim().split("/");
                Date date2 = new Date(Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]), Integer.parseInt(arr2[2]));
                DSNV.dsnv[n].setNgayVaoLam(date2);
                line = input.readLine();
                DSNV.n++;
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Ham ghi file
    public static void ghiFile(ListNhanVien DSNV) {
        try {
            FileWriter fw = new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\dataNV.txt");
            int i = 0;
            while (i < DSNV.n) {
                fw.write(DSNV.dsnv[i].xuat_file());
                fw.write("\n");
                i++;
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ham menu
    public static void menu(ListNhanVien DSNV) {
        boolean flag = true;
        while (flag) {
            System.out.println("----MENU-----");
            System.out.println("1.Nhap danh sach nhan vien.");
            System.out.println("2.Them nhan vien.");
            System.out.println("3.Xoa nhan vien.");
            System.out.println("4.Sua nhan vien.");
            System.out.println("5.Tim kiem nhan vien.");
            System.out.println("6.Xuat danh sach nhan vien.");
            System.out.println("7.Doc file.");
            System.out.println("8.Ghi file.");
            System.out.println("0.Thoat.");
            System.out.print("Nhap lua chon: ");
            Scanner rScanner = new Scanner(System.in);
            int choice = rScanner.nextInt();
            rScanner.nextLine();
            switch (choice) {
                case 1:
                    DSNV.nhapDanhSach();
                    break;
                case 2:
                    DSNV.them();
                    break;
                case 3:
                    DSNV.sua();
                    break;
                case 4:
                    DSNV.xoa();
                    break;
                case 5:
                    DSNV.timKiem();
                    break;
                case 6:
                    DSNV.xuatDanhSach();
                    break;
                case 7:
                    docFile(DSNV);
                    break;
                case 8:
                    ghiFile(DSNV);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        }

    }

    public static void main(String[] args) {
        ListNhanVien danhsach1 = new ListNhanVien();
        menu(danhsach1);
    }
}
