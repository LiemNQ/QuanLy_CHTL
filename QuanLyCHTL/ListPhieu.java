package QuanLyCHTL;

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

public class ListPhieu {
    Scanner reader = new Scanner(System.in);

    private Phieu[] PH;
    private int n;

    public ListPhieu() {
        this.PH = new Phieu[0];
        this.n = 0;
    }

    public void MENU_PHIEU() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=======================================================================");
            System.out.println("----------MENU----------");
            System.out.printf("1.THEM PHIEU");
            System.out.printf("\n2.XOA PHIEU");
            System.out.printf("\n3.SHOW PHIEU");
            System.out.printf("\n4.FIND PHIEU");
            System.out.printf("\n5.EDIT PHIEU");
            System.out.println("\n0.Exit");
            System.out.println("----------------");
            System.out.printf("\n==>Nhap lua chon: ");
            choice = reader.nextInt();
            System.out.println("\n=======================================================================");
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    show();
                    break;
                case 4:
                    find();
                    break;
                case 5:
                    edit();
                    break;
                case 0:
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void main(String[] args) {
        ListPhieu ob = new ListPhieu();
        ob.MENU_PHIEU();
    }

    // ==============================================================
    // ADD
    // ==============================================================
    public void add() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n=======================================================================");
            System.out.println("-----THEM PHIEU!-----");
            System.out.printf("1.HOA ĐON");
            System.out.printf("\n2.PHIEU NHAP");
            System.out.println("\n0.Exit");
            System.out.println("----------------");
            System.out.printf("\n==>Enter the your choose ");
            int choice = reader.nextInt();
            System.out.println("\n=======================================================================");
            reader.nextLine();
            switch (choice) {
                case 1:
                    ADD_HOADON();
                    break;
                case 2:
                    ADD_PHIEUNHAP();
                    break;
                case 0:
                    flag = false;
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    private void ADD_HOADON() {
        try {
            BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));
            int count = 0;
            while (fw.readLine() != null) {
                ++count;
            }
            fw.close();
            BufferedReader ft = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));
            this.PH = new HoaDon[count];

            for (int i = 0; i < count; i++) {
                String[] data = ft.readLine().split(";");

                String[] ngayThangNam = data[3].split("/");
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                Date ngayNhap = new Date(ngay, thang, nam);

                this.PH[i] = new HoaDon(
                        data[0], // Ma hoa don (maPhieu)
                        data[1], // Ma NV (maNV)
                        data[2], // Ma KH (maKH)
                        ngayNhap, // Ngay nhap (ngayNhap)
                        Double.parseDouble(data[4]), // Tong tien (truyền giá trị mặc định là 0.0, có thể cập nhật sau)
                        data[5], // Ma san pham (maSP)
                        Integer.parseInt(data[6]), // So luong (soLuong)
                        Double.parseDouble(data[7]) // Gia ban (giaBan)
                );
            }

            // ------------------------------------------------------------------------------------------------------------------------------//
            boolean signal = false;
            Phieu PH_hd = new HoaDon(); // Khởi tạo đối tượng mới

            String temp = PH_hd.getMaPhieu();

            System.out.print("Kiem tra ma hoa don: ");
            PH_hd.maPhieu = reader.nextLine();
            if (!PH_hd.getMaPhieu().isEmpty() && !PH_hd.getMaNV().isEmpty()) {
                // Kiểm tra trùng lặp mã hoa don
                for (int j = 0; j < count; ++j) {
                    if (PH_hd.getMaPhieu().equals(this.PH[j].getMaPhieu())) {
                        System.out.println("Kiem tra ma hoa don thanh cong!");
                        System.out.println("Ma hoa don da ton tai!");
                        signal = true;
                        break;
                    }
                }
                if (!signal) {
                    PH = Arrays.copyOf(PH, count + 1);
                    this.PH[count] = PH_hd; // Gán đối tượng vào mảng PH
                    count++; // Tăng số lượng phiếu
                    System.out.println("Kiem tra ma hoa don thanh cong!");
                    System.out.println("Ma hoa don chua ton tai!");
                    System.out.println("Hay nhap thong tin hoa don moi!");
                    PH_hd.NhapLieu();

                }
            }
            // ------------------------------------------------------------------------------------------------------------------------------//

            ft.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void ADD_PHIEUNHAP() {
        try {
            BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));
            int count = 0;
            while (fw.readLine() != null) {
                ++count;
            }
            fw.close();
            BufferedReader ft = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));
            this.PH = new Phieu[count];

            for (int i = 0; i < count; i++) {
                String[] data = ft.readLine().split(";");

                // Tách chuỗi ngày tháng năm
                String[] ngayThangNam = data[2].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);

                // Khởi tạo đối tượng PhieuNhap
                this.PH[i] = new PhieuNhap(
                        data[0], // maPhieu
                        data[1], // maNV
                        ngayNhap, // ngayNhap
                        data[3], // tensp
                        Integer.parseInt(data[4]), // soLuong
                        Integer.parseInt(data[5]), // giaNhap
                        Double.parseDouble(data[6]) // ThanhTien
                );
            }

            System.out.print("Nhap so luong phieu muon them : ");
            n = this.reader.nextInt();
            BufferedWriter fr = new BufferedWriter(
                    new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt", true));

            // ------------------------------------------------------------------------------------------------------------------------------//
            for (int i = 0; i < n; ++i) {
                boolean signal = false;
                Phieu PH_n = new PhieuNhap(); // Khởi tạo đối tượng mới
                System.out.println("Nhap thong tin phieu!\n");

                // Nhập dữ liệu
                PH_n.NhapLieu();

                // Lấy mã phiếu để kiểm tra trùng lặp
                String temp = PH_n.getMaPhieu();

                // Kiểm tra tính hợp lệ của dữ liệu
                if (!PH_n.getMaPhieu().isEmpty() && !PH_n.getMaNV().isEmpty()) {
                    // Kiểm tra trùng lặp mã phiếu
                    for (int j = 0; j < count; ++j) {
                        if (PH_n.getMaPhieu().equals(this.PH[j].getMaPhieu())) {
                            System.out.println("Phieu da ton tai!");
                            signal = true;
                            break;
                        }
                    }

                    // Nếu không trùng, thêm vào danh sách
                    if (!signal) {
                        PH = Arrays.copyOf(PH, count + 1);
                        this.PH[count] = PH_n; // Gán đối tượng vào mảng PH
                        count++; // Tăng số lượng phiếu
                        System.out.println("Them Phieu hoan thanh!");
                    }
                } else {
                    System.out.println("Nhap sai thong tin!");
                    signal = true;
                }
                if (!signal) {
                    fr.write(PH_n.Xuat_file());
                    fr.newLine();
                    System.out.println("them phieu nhap hoan thanh.");
                }
            }

            // ------------------------------------------------------------------------------------------------------------------------------//

            ft.close();
            fr.close();
            this.reader.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

    // ==============================================================
    // delete
    // ==============================================================
    public void delete() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n=======================================================================");
            System.out.println("-----XOA PHIEU!-----");
            System.out.printf("1.HOA DON");
            System.out.printf("\n2.PHIEU NHAP");
            System.out.println("\n0.Exit");
            System.out.println("----------------");
            System.out.printf("\n==>Nhap lua chon: ");
            int choice = reader.nextInt();
            System.out.println("\n=======================================================================");
            reader.nextLine();
            switch (choice) {
                case 1:
                    DELETE_HOADON();
                    break;
                case 2:
                    DELETE_PHIEUNHAP();
                    break;
                case 0:
                    flag = false;
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    private void DELETE_HOADON() {

        try {
            BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));
            ArrayList<Phieu> PhieuList = new ArrayList<>();
            String line;
            while ((line = fw.readLine()) != null) {
                String[] data = line.split(";");
                String[] ngayThangNam = data[3].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);
                if (data.length == 8) {
                    PhieuList.add(new HoaDon(data[0], data[1], data[2], ngayNhap, Double.parseDouble(data[4]), data[5],
                            Integer.parseInt(data[6]), Double.parseDouble(data[7])));
                }
            }
            fw.close();

            System.out.print("Nhap ma phieu muon xoa: ");
            String FIND_ID = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(
                    new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));
            boolean signal = false;

            for (Phieu Ph : PhieuList) {
                if (!Ph.getMaPhieu().equals(FIND_ID)) {
                    br.write(Ph.Xuat_file());
                    br.newLine();
                } else {
                    System.out.println("==---------------------------==");
                    System.out.println("--Thong tin phieu nhap da xoa--");
                    System.out.printf("%-20s| %-10s| %-10s| %-15s| %-10.2s| %-10s| %-10s|%-10.2s|\n", "Ma Hoa don",
                            "ma NV",
                            "ma KH", "Ngay lap HD", "tong tien", "ma Sp", "so luong", "gia ban");
                    Ph.Xuat_form();
                    signal = true;
                }
            }

            if (!signal) {
                System.out.println("Khong co phieu muon xoa trong danh sach!");
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void DELETE_PHIEUNHAP() {
        try {
            BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));
            ArrayList<Phieu> PhieuList = new ArrayList<>();
            String line;
            while ((line = fw.readLine()) != null) {
                String[] data = line.split(";");
                String[] ngayThangNam = data[2].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);
                if (data.length == 7) {
                    PhieuList.add(new PhieuNhap(data[0], data[1], ngayNhap, data[3],
                            Integer.parseInt(data[4]), Integer.parseInt(data[5]), Double.parseDouble(data[6])));
                }
            }
            fw.close();

            System.out.print("Nhap ma phieu muon xoa: ");
            String FIND_ID = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(
                    new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));
            boolean signal = false;

            for (Phieu Ph : PhieuList) {
                if (!Ph.getMaPhieu().equals(FIND_ID)) {
                    br.write(Ph.Xuat_file());
                    br.newLine();
                } else {
                    System.out.println("==---------------------------==");
                    System.out.println("--Thong tin phieu nhap da xoa--");
                    System.out.printf("%-20s| %-10s| %-10s| %-15s| %-10.2s| %-10s| %-10s|%-10.2s|\n", "Ma Hoa don",
                            "ma NV",
                            "ma KH", "Ngay lap HD", "tong tien", "ma Sp", "so luong", "gia ban");
                    Ph.Xuat_form();
                    signal = true;
                }
            }

            if (!signal) {
                System.out.println("Khong co phieu muon xoa trong danh sach!");
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================================================================================================================================================================//
    // FIND
    // ================================================================================================================================================================//

    private ArrayList<Phieu> allPhieu = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void find() {
        try {
            // Đọc file hoadon
            BufferedReader brHOADON = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));
            String line;
            while ((line = brHOADON.readLine()) != null) {
                String[] data = line.split(";");
                // Tách chuỗi ngày tháng năm
                String[] ngayThangNam = data[3].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);
                if (data.length == 8) {
                    allPhieu.add(new HoaDon(data[0], data[1], data[2], ngayNhap, Double.parseDouble(data[4]), data[5],
                            Integer.parseInt(data[6]), Double.parseDouble(data[7])));
                }
            }
            brHOADON.close();

            // Đọc file phieu nhau
            BufferedReader brPHIEUNHAP = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));
            while ((line = brPHIEUNHAP.readLine()) != null) {
                String[] data = line.split(";");
                // Tách chuỗi ngày tháng năm
                String[] ngayThangNam = data[2].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);
                if (data.length == 7) {
                    allPhieu.add(new PhieuNhap(data[0], data[1], ngayNhap, data[3],
                            Integer.parseInt(data[4]), Integer.parseInt(data[5]), Double.parseDouble(data[6])));
                }
            }
            brPHIEUNHAP.close();
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
            return;
        }

        // Tìm kiếm sản phẩm theo mã
        searchProductByCode();
    }

    public void searchProductByCode() {
        System.out.println("\n=======================================================================");
        System.out.print("Nhap ma phieu muon tim: ");
        String searchID = scanner.nextLine();

        boolean found = false;

        // Duyệt qua tất cả các sản phẩm và so sánh mã sản phẩm
        for (Phieu Ph : allPhieu) {
            if (Ph.getMaPhieu().equals(searchID)) {
                String firstTwo = searchID.substring(0, 2);
                String ma_phieu_check_PN = "PN";
                String ma_phieu_check_HD = "HD";

                if (firstTwo.equalsIgnoreCase(ma_phieu_check_PN)) {
                    System.out.printf("%-10s| %-6s| %-15s| %-10s| %-10s| %-10s| %-10s|\n", "Ma Phieu Nhap", "Ma NV",
                            "Ngay Nhap phieu", "Ten SP", "So Luong", "Gia nhap", "tong tien");
                    Ph.Xuat_form(); // Hiển thị thông tin sản phẩm
                    found = true;
                    break;
                } else if (firstTwo.equalsIgnoreCase(ma_phieu_check_HD)) {
                    System.out.printf("%-20s| %-10s| %-10s| %-15s| %-10.2s| %-10s| %-10s|%-10.2s|\n", "Ma Hoa don",
                            "ma NV",
                            "ma KH", "Ngay lap HD", "tong tien", "ma Sp", "so luong", "gia ban");
                    Ph.Xuat_form(); // Hiển thị thông tin sản phẩm
                    found = true;
                }
            }

        }

        if (!found) {
            System.out.println("==>Phieu voi ma " + searchID + " khong ton tai>.");
        }
    }

    // ================================================================================================================================================================//
    // SHOW
    // ================================================================================================================================================================//

    public void show() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n=======================================================================");
            System.out.println("-----HIEN THONG TIN SAN PHAM!-----");
            System.out.printf("1.HOA DON");
            System.out.printf("\n2.PHIEU NHAP");
            System.out.println("\n0.Exit");
            System.out.println("----------------");
            System.out.printf("\nNhap lua chon: ");
            int choice = reader.nextInt();
            System.out.println("\n==>=======================================================================");
            switch (choice) {
                case 1:
                    SHOW_HOADON();
                    break;
                case 2:
                    SHOW_PHIEUNHAP();
                    break;
                case 0:
                    flag = false;
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    public void SHOW_HOADON() {
        try {
            BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));

            String st;
            int i = 1; // Biến đếm để đánh số sản phẩm

            System.out.printf("%-20s| %-10s| %-10s| %-15s| %-10s| %-10s| %-10s|%-10s|\n", "Ma Hoa don",
                    "ma NV",
                    "ma KH", "Ngay lap HD", "thanh tien", "ma Sp", "so luong", "gia ban");
            while ((st = fw.readLine()) != null) { // Đọc từng dòng trong file
                String[] data = st.split(";");

                String[] ngayThangNam = data[3].split("/"); // s Giả định định dạng ngày là dd/MM/yyyy

                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);

                // Tạo đối tượng sản phẩm từ dữ liệu đọc được
                // HD003;NV2;KH004;15/12/2020;10000thanh tien;SP001;1;10000gia ban
                Phieu DS = new HoaDon(
                        data[0], // Ma hoa don (maPhieu)
                        data[1], // Ma NV (maNV)
                        data[2], // Ma KH (maKH)
                        ngayNhap, // Ngay nhap (ngayNhap)
                        Double.parseDouble(data[4]), // thanh tien (truyền giá trị mặc định là 0.0, có thể cập nhật sau)
                        data[5], // Ma san pham (maSP)
                        Integer.parseInt(data[6]), // So luong (soLuong)
                        Double.parseDouble(data[7])); // Gia ban (giaBan));

                DS.Xuat_form(); // Hiển thị thông tin sản phẩm
                i++; // Tăng biến đếm
            }

            fw.close();

        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    public void SHOW_PHIEUNHAP() {
        try {
            BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));

            String st;
            int i = 1; // Biến đếm để đánh số phieu nhap

            System.out.printf("%-20s| %-10s| %-15s| %-10s| %-10s| %-10s| %-10s|\n", "Ma Phieu Nhap", "Ma NV",
                    "Ngay Nhap phieu", "Ten SP", "So Luong", "Gia nhap", "tong tien");
            while ((st = fw.readLine()) != null) { // Đọc từng dòng trong file
                String[] data = st.split(";"); // Tách dữ liệu bằng dấu ";"

                String[] ngayThangNam = data[2].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);

                // Tạo đối tượng sản phẩm từ dữ liệu đọc được
                // PN001;NV001;02/12/2024;Sản phẩm A;10;50;500.0
                Phieu DS = new PhieuNhap(
                        data[0], // maPhieu
                        data[1], // maNV
                        ngayNhap, // ngayNhap
                        data[3], // tensp
                        Integer.parseInt(data[4]), // soLuong
                        Integer.parseInt(data[5]), // giaNhap
                        Double.parseDouble(data[6])); // ThanhTien);

                DS.Xuat_form(); // Hiển thị thông tin sản phẩm
                i++; // Tăng biến đếm
            }
            fw.close();

        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    // ================================================================================================================================================================//
    // EDIT
    // ================================================================================================================================================================//

    public void edit() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n=======================================================================");
            System.out.println("-----SUA THONG TIN PHIEU!-----");
            System.out.printf("1.HOA DON");
            System.out.printf("\n2.PHIEU NHAP");
            System.out.println("\n0.Exit");
            System.out.println("----------------");
            System.out.printf("\n==>NHAP LUA CHON: ");
            int choice = reader.nextInt();
            reader.nextLine();
            System.out.println("\n=======================================================================");
            switch (choice) {
                case 1:
                    EDIT_HOADON();
                    break;
                case 2:
                    EDIT_PHIEUNHAP();
                    break;

                case 0:
                    flag = false;
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    public void EDIT_HOADON() {
        try {
            int count = 0;
            boolean signal = false;

            for (BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt")); fw
                            .readLine() != null; ++count) {
            }

            this.PH = (Phieu[]) Arrays.copyOf(this.PH, count);
            BufferedReader ft = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));

            for (int i = 0; i < this.PH.length; ++i) {
                // Đọc dòng từ file và tách bằng dấu ";"
                String[] data = ft.readLine().split(";");

                String[] ngayThangNam = data[3].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);

                // Tạo đối tượng Stationeries từ dữ liệu tách được
                this.PH[i] = new HoaDon(data[0], data[1], data[2], ngayNhap, Double.parseDouble(data[4]), data[5],
                        Integer.parseInt(data[6]), Double.parseDouble(data[7]));
            }

            System.out.print("\nNhap ma Hoa don muon sua: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(
                    new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\ListHoaDon.txt"));

            int count_2 = 0;
            for (int i = 0; i < this.PH.length; ++i) {
                if (ma.equals(this.PH[i].getMaPhieu())) {
                    System.out.println("--Thong tin Hoa don duoc sua--");
                    count_2++;

                    System.out.printf("%-20s| %-10s| %-10s| %-15s| %-10.2s| %-10s| %-10s|%-10.2s|\n", "Ma Hoa don",
                            "ma NV",
                            "ma KH", "Ngay lap HD", "tong tien", "ma Sp", "so luong", "gia ban");
                    this.PH[i].Xuat_form();

                } else {
                    br.write(this.PH[i].Xuat_file());
                    br.newLine();
                }
            }

            if (!signal) {
                System.out.println("--Khong co phieu ton tai--");
            }

            br.close();
            ft.close();
            if (count_2 != 0) {
                System.out.println("--Nhap moi thong tin Hoa don--");
                ADD_HOADON();

                signal = true;
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    public void EDIT_PHIEUNHAP() {
        try {
            int count = 0;
            boolean signal = false;

            for (BufferedReader fw = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt")); fw
                            .readLine() != null; ++count) {
            }

            this.PH = (Phieu[]) Arrays.copyOf(this.PH, count);
            BufferedReader ft = new BufferedReader(
                    new FileReader("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));

            for (int i = 0; i < this.PH.length; ++i) {
                // Đọc dòng từ file và tách bằng dấu ";"
                String[] data = ft.readLine().split(";");

                String[] ngayThangNam = data[2].split("/"); // Giả định định dạng ngày là dd/MM/yyyy
                int ngay = Integer.parseInt(ngayThangNam[0]);
                int thang = Integer.parseInt(ngayThangNam[1]);
                int nam = Integer.parseInt(ngayThangNam[2]);

                // Tạo đối tượng Date
                Date ngayNhap = new Date(ngay, thang, nam);

                // Tạo đối tượng Stationeries từ dữ liệu tách được
                this.PH[i] = new PhieuNhap(data[0], data[1], ngayNhap, data[3],
                        Integer.parseInt(data[4]), Integer.parseInt(data[5]), Double.parseDouble(data[6]));
            }

            System.out.print("\nNhap ma phieu nhap muon sua: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(
                    new FileWriter("D:\\HK1-24-25\\OOP\\Do-An\\text\\List_PhieuNhap.txt"));

            for (int i = 0; i < this.PH.length; ++i) {
                if (ma.equals(this.PH[i].getMaPhieu())) {
                    System.out.println("--Thong tin phieu nhap duoc sua--");
                    System.out.printf("%-10s| %-6s| %-15s| %-10s| %-10s| %-10s| %-10s|\n", "Ma Phieu Nhap", "Ma NV",
                            "Ngay Nhap phieu", "Ten SP", "So Luong", "Gia nhap", "tong tien");
                    this.PH[i].Xuat_form();

                    System.out.println("--Nhap moi thong tin phieu nhap--");
                    this.PH[i].NhapLieu();
                    br.write(this.PH[i].Xuat_file());
                    br.newLine();
                    signal = true;
                } else {
                    br.write(this.PH[i].Xuat_file());
                    br.newLine();
                }
            }

            if (!signal) {
                System.out.println("--Khong co phieu ton tai--");
            }

            br.close();
            ft.close();
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}
