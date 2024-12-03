package QuanLyCHTL;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    Scanner reader = new Scanner(System.in);

    public Main() {
    }

    public static void main(String[] args) {
        MENU_MAIN();
    }

    public static void MENU_MAIN() {
        System.out.println("\n\n\n");
        System.out.println("\n=======================================================================");
        System.out.println("\n****************==> QUAN LY CUA HANG TIEN LOI <==****************");
        Scanner reader = new Scanner(System.in);
        ListProducts PRODUCT = new ListProducts();
        ListNhanVien NHANVIEN = new ListNhanVien();
        ListKhachHang KHACHHANG = new ListKhachHang();
        ListPhieu PHIEU = new ListPhieu();
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=======================================================================");
            System.out.println("----------MENU----------");
            System.out.printf("1.SAN PHAM");
            System.out.printf("\n2.NHAN VIEN");
            System.out.printf("\n3.KHACH HANG");
            System.out.printf("\n4.PHIEU");
            System.out.println("\n0.Exit");
            System.out.println("----------------");
            System.out.printf("\n==>Nhap lua chon: ");
            choice = reader.nextInt();
            System.out.println("\n=======================================================================");
            switch (choice) {
                case 1:
                    PRODUCT.MENU_PRODUCTS();
                    break;
                case 2:
                    NHANVIEN.MENU_NHANVIEN(NHANVIEN);
                    break;
                case 3:
                    KHACHHANG.MENU_KHACHHANG(KHACHHANG);
                    break;
                case 4:
                    PHIEU.MENU_PHIEU();
                    break;
                case 0:
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

}