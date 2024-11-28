package QuanLyCHTL;

import text.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListPhieuNhap {
    public static void main(String[] args) {
        String filePath = "PhieuNhap.txt";
        List<PhieuNhap> phieuNhapList = new ArrayList<>();

        // Đọc dữ liệu từ file khi khởi động chương trình
        try {
            phieuNhapList = PhieuNhap.readFromFile(filePath);
        } catch (IOException e) {
            System.out.println("Khong the đoc file du lieu! Khoi tao danh sach trong.");
        }

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("======================================");
            System.out.println("\n--- QUAN LY PHIEU NHAP ---");
            System.out.println("======================================");
            System.out.println("1. Thêm phiếu nhập");
            System.out.println("2. Sửa phiếu nhập");
            System.out.println("3. Xóa phiếu nhập");
            System.out.println("4. Tìm kiếm phiếu nhập");
            System.out.println("5. Hiển thị tất cả phiếu nhập");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    themPhieuNhap(phieuNhapList, scanner);
                    break;
                case 2:
                    suaPhieuNhap(phieuNhapList, scanner);
                    break;
                case 3:
                    xoaPhieuNhap(phieuNhapList, scanner);
                    break;
                case 4:
                    timKiemPhieuNhap(phieuNhapList, scanner);
                    break;
                case 5:
                    hienThiTatCaPhieuNhap(phieuNhapList);
                    break;
                case 0:
                    System.out.println("Đang lưu dữ liệu...");
                    try {
                        PhieuNhap.writeToFile(filePath, phieuNhapList);
                        System.out.println("Dữ liệu đã được lưu vào file.");
                    } catch (IOException e) {
                        System.out.println("Không thể lưu dữ liệu vào file!");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Thêm phiếu nhập mới
    private static void themPhieuNhap(List<PhieuNhap> phieuNhapList, Scanner scanner) {
        System.out.println("Nhập thông tin phiếu nhập mới:");

        System.out.print("ID Phiếu: ");
        String IDPhieu = scanner.nextLine();

        System.out.print("Ngày (yyyy-MM-dd): ");
        String date = scanner.nextLine();

        System.out.print("Tổng tiền: ");
        int sumMoney = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID Nhân viên: ");
        String IDNhanVien = scanner.nextLine();

        System.out.print("Danh sách mặt hàng: ");
        String items = scanner.nextLine();
        List<String> itemList = List.of(items.split(","));

        PhieuNhap newPhieu = new PhieuNhap(IDPhieu, date, sumMoney, IDNhanVien, itemList);
        phieuNhapList.add(newPhieu);
        System.out.println("Đã thêm phiếu nhập mới thành công!");
    }

    // Sửa thông tin phiếu nhập
    private static void suaPhieuNhap(List<PhieuNhap> phieuNhapList, Scanner scanner) {
        System.out.print("Nhập ID Phiếu cần sửa: ");
        String IDPhieu = scanner.nextLine();

        for (PhieuNhap phieu : phieuNhapList) {
            if (phieu.getIDPhieu().equals(IDPhieu)) {
                System.out.println("Nhập thông tin mới (bỏ trống nếu không muốn thay đổi):");

                System.out.print("Ngày (yyyy-MM-dd): ");
                String date = scanner.nextLine();
                if (!date.isEmpty())
                    phieu.setDate(date);

                System.out.print("Tổng tiền: ");
                String sumMoneyStr = scanner.nextLine();
                if (!sumMoneyStr.isEmpty())
                    phieu.setSumMoney(Integer.parseInt(sumMoneyStr));

                System.out.print("ID Nhân viên: ");
                String IDNhanVien = scanner.nextLine();
                if (!IDNhanVien.isEmpty())
                    phieu.setIDNhanVien(IDNhanVien);

                System.out.print("Danh sách mặt hàng (cách nhau bởi dấu phẩy): ");
                String items = scanner.nextLine();
                if (!items.isEmpty())
                    phieu.setItemList(List.of(items.split(",")));

                System.out.println("Đã cập nhật thông tin phiếu nhập!");
                return;
            }
        }

        System.out.println("Không tìm thấy phiếu nhập với ID đã nhập.");
    }

    // Xóa phiếu nhập
    private static void xoaPhieuNhap(List<PhieuNhap> phieuNhapList, Scanner scanner) {
        System.out.print("Nhập ID Phiếu cần xóa: ");
        String IDPhieu = scanner.nextLine();

        for (PhieuNhap phieu : phieuNhapList) {
            if (phieu.getIDPhieu().equals(IDPhieu)) {
                phieuNhapList.remove(phieu);
                System.out.println("Đã xóa phiếu nhập thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy phiếu nhập với ID đã nhập.");
    }

    // Tìm kiếm phiếu nhập
    private static void timKiemPhieuNhap(List<PhieuNhap> phieuNhapList, Scanner scanner) {
        System.out.print("Nhập ID Phiếu cần tìm: ");
        String IDPhieu = scanner.nextLine();

        for (PhieuNhap phieu : phieuNhapList) {
            if (phieu.getIDPhieu().equals(IDPhieu)) {
                phieu.displayDetails();
                return;
            }
        }

        System.out.println("Không tìm thấy phiếu nhập với ID đã nhập.");
    }

    // Hiển thị tất cả phiếu nhập
    private static void hienThiTatCaPhieuNhap(List<PhieuNhap> phieuNhapList) {
        if (phieuNhapList.isEmpty()) {
            System.out.println("Danh sách phiếu nhập rỗng.");
            return;
        }

        System.out.println("Danh sách phiếu nhập:");
        for (PhieuNhap phieu : phieuNhapList) {
            phieu.displayDetails();
            System.out.println();
        }
    }
}
