package QuanLyCHTL;

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
        for (int index = 0; index < this.n; index++) {
            System.out.printf("Thong tin nhan vien thu %d\n", index);
            dsnv[index].xuat();
            System.out.println("------------------------");
        }
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

    public static void main(String[] args) {
        ListNhanVien danhsach1 = new ListNhanVien();
        danhsach1.them();
        danhsach1.xuatDanhSach();
        danhsach1.xoa();
        danhsach1.xuatDanhSach();
    }
}
