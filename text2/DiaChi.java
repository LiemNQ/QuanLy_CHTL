package text2;

import java.util.Scanner;

public class DiaChi {
    private String soNha;
    private String duong;
    private String phuong;
    private String quan;

    public DiaChi() {
        this.soNha = "";
        this.duong = "";
        this.phuong = "";
        this.quan = "";
    }

    public DiaChi(String soNha, String duong, String phuong, String quan) {
        this.soNha = soNha;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
    }

    public DiaChi(DiaChi other) {
        this.soNha = other.soNha;
        this.duong = other.duong;
        this.phuong = other.phuong;
        this.quan = other.quan;
    }

    // Ham getter va setter
    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    // Ham nhap Dia chi
    public void nhap() {
        Scanner rScanner = new Scanner(System.in);
        System.out.println("*Nhap dia chi.");
        System.out.print("   -Nhap so nha: ");
        this.soNha = rScanner.nextLine();
        System.out.print("   -Nhap ten duong: ");
        this.duong = rScanner.nextLine();
        System.out.print("   -Nhap ten phuong: ");
        this.phuong = rScanner.nextLine();
        System.out.print("   -Nhap ten quan: ");
        this.quan = rScanner.nextLine();
    }

    public String xuat() {
        return this.soNha + ", D." + this.duong + ", F." + this.phuong + ", Q." + this.quan + ".";
    }

    public static void main(String[] args) {
        DiaChi dc1 = new DiaChi();
        dc1.nhap();
        System.out.println(dc1.xuat());
    }
}
