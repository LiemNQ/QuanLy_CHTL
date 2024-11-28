package QuanLyCHTL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhap extends HoaDon {
    private List<String> itemList; // Danh sách mặt hàng trong phiếu nhập

    public PhieuNhap() {
        super();
        this.itemList = new ArrayList<>();
    }

    public PhieuNhap(String IDPhieu, String date, int sumMoney, String IDNhanVien, List<String> itemList) {
        super(IDPhieu, date, sumMoney, IDNhanVien);
        this.itemList = itemList;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + String.join(",", itemList);
    }

    @Override
    public void displayDetails() {
        System.out.println("Phiếu Nhập:");
        System.out.println("ID Phiếu: " + IDPhieu);
        System.out.println("Ngày: " + date);
        System.out.println("ID Nhân Viên: " + IDNhanVien);
        System.out.println("Tổng Tiền: " + sumMoney);
        System.out.println("Danh Sách Mặt Hàng: " + String.join(", ", itemList));
    }

    // Đọc dữ liệu từ file
    public static List<PhieuNhap> readFromFile(String filePath) throws IOException {
        List<PhieuNhap> phieuNhapList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("-");
            if (parts.length < 5)
                continue;
            String IDPhieu = parts[0];
            String date = parts[1];
            int sumMoney = Integer.parseInt(parts[2]);
            String IDNhanVien = parts[3];
            List<String> items = List.of(parts[4].split(","));
            phieuNhapList.add(new PhieuNhap(IDPhieu, date, sumMoney, IDNhanVien, items));
        }

        reader.close();
        return phieuNhapList;
    }

    // Ghi dữ liệu vào file
    public static void writeToFile(String filePath, List<PhieuNhap> phieuNhapList) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (PhieuNhap phieu : phieuNhapList) {
            writer.write(phieu.toString());
            writer.newLine();
        }
        writer.close();
    }
}
