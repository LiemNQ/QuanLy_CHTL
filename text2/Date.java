package text2;

import java.util.Scanner;

public class Date {
    private int ngay, thang, nam;

    // Ham thiet lap
    public Date() {
        this.ngay = 0;
        this.thang = 0;
        this.nam = 0;
    }

    public Date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public Date(Date other) {
        this.ngay = other.ngay;
        this.thang = other.thang;
        this.nam = other.nam;
    }

    // Ham nam nhuan
    public boolean namNhuan(int n) {
        if (n % 4 == 0 && n % 100 != 0) {
            return true;
        } else if (n % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Ham nhap
    public void nhap() {
        Scanner rScanner = new Scanner(System.in);
        int flag;
        do {
            flag = 0;
            int MAX_ngay = 0;
            System.out.printf("   -Nhap ngay: ");
            this.ngay = rScanner.nextInt();
            System.out.printf("   -Nhap thang: ");
            this.thang = rScanner.nextInt();
            System.out.printf("   -Nhap nam: ");
            this.nam = rScanner.nextInt();
            // Tim so ngay toi da
            // Thang 2 nam nhuan
            if (namNhuan(this.nam) && this.thang == 2) {
                MAX_ngay = 29;
            }
            // Thang 2 nam khong nhuan
            else if (!namNhuan(this.nam) && this.thang == 2) {
                MAX_ngay = 28;
            }
            // Thang co 31 ngay
            else if (this.thang == 1 || this.thang == 3 || this.thang == 5 || this.thang == 7 || this.thang == 8 ||
                    this.thang == 10 || this.thang == 12) {
                MAX_ngay = 31;
            }
            // Thang co 30 ngay
            else if (this.thang == 4 || this.thang == 6 || this.thang == 9 || this.thang == 11) {
                MAX_ngay = 30;
            }
            // kiem tra tinh dung dan
            // moi loi sai thi bien flag se tang len
            // neu flag > 0 thi se phai nhap lai
            if (this.nam < 0) {
                flag++;
            }
            if (this.thang < 0 || this.thang > 12) {
                flag++;
            }
            if (this.ngay < 0 || this.ngay > MAX_ngay) {
                flag++;
            }
            if (flag > 0) {
                System.out.println("Nhap khong dung !");
            }

        } while (flag > 0);
    }

    public String xuat() {
        return this.ngay + "/" + this.thang + "/" + this.nam;
    }

    public static void main(String[] args) {
        Date d1 = new Date();
        d1.nhap();
        System.out.println(d1.xuat());
    }
}
