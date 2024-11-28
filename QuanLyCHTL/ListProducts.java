package QuanLyCHTL;

import text.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListProducts {
    Scanner reader = new Scanner(System.in);

    private Products[] SanPham;
    private int n;

    public ListProducts() {
        this.SanPham = new Products[0];
        this.n = 0;
    }

    public void MENU() {
        int choice = -1;
        while (choice != 0) {
            System.out.printf("1.ADD PRODUCT");
            System.out.printf("\n2.DELETE PRODUCT");
            System.out.printf("\n3.SHOW PRODUCT");
            System.out.printf("\n4.FIND PRODUCT");
            System.out.printf("\n5.EDIT PRODUCT");
            System.out.printf("\n0.Exit");
            System.out.printf("\nNhap lua chon: ");
            choice = reader.nextInt();
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

    // ================================================================================================================================================================//
    // ADD
    // ================================================================================================================================================================//

    public void add() {
        int choice = -1;
        while (choice != 0) {
            System.out.printf("1.Stationeries");
            System.out.printf("\n2.Personal_Belongings");
            System.out.printf("\n3.Drinks");
            System.out.printf("\n0.Exit");
            System.out.printf("\nNhap lua chon: ");
            choice = reader.nextInt();
            switch (choice) {
                case 1:
                    ADD_Stationeries();
                    break;
                case 2:
                    ADD_Personal_Belongings();
                    break;
                case 3:
                    ADD_Drinks();
                    break;
                case 0:
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    private void ADD_Stationeries() {
        try {
            BufferedReader fw = new BufferedReader(new FileReader("List_Stationeries.txt"));
            int count = 0;
            while (fw.readLine() != null) {
                ++count;
            }
            fw.close();
            BufferedReader ft = new BufferedReader(new FileReader("List_Stationeries.txt"));
            this.SanPham = new Products[count];

            for (int i = 0; i < count; i++) {
                String[] data = ft.readLine().split(";");
                this.SanPham[i] = new Stationeries(data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]);

            }

            System.out.print("The number of products you want to add: ");
            n = this.reader.nextInt();
            BufferedWriter fr = new BufferedWriter(new FileWriter("List_Stationeries.txt", true));

            // ------------------------------------------------------------------------------------------------------------------------------//
            for (int i = 0; i < n; ++i) {
                boolean signal = false;
                Products SanPham = new Stationeries();
                System.out.println("Please enter your product information!\n");
                SanPham.NhapLieu();
                String temp = SanPham.get_maSP();
                if (!SanPham.get_maSP().isEmpty() && !SanPham.get_tenSP().isEmpty() &&
                        SanPham.get_giaMua() > 0 && SanPham.get_giaBan() > 0 &&
                        !SanPham.get_nhaCungcap().isEmpty() && SanPham.get_soLuong() > 0 &&
                        ((Stationeries) SanPham).get_loaiSP() != null) {
                    for (int j = 0; j < count; ++j) {
                        if (temp.equals(this.SanPham[j].get_maSP())) {
                            System.out.println("Products already available!");
                            signal = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("You enter missing information!");
                    signal = true;
                }

                if (!signal) {
                    fr.write(SanPham.toString());
                    fr.newLine();
                    System.out.println("Stationeries added successfully.");
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

    private void ADD_Personal_Belongings() {
        try {
            BufferedReader fw = new BufferedReader(new FileReader("List_Personal_Belongings.txt"));
            int count = 0;
            while (fw.readLine() != null) {
                ++count;
            }
            fw.close();
            BufferedReader ft = new BufferedReader(new FileReader("List_Personal_Belongings.txt"));
            this.SanPham = new Products[count];

            for (int i = 0; i < count; i++) {
                String[] data = ft.readLine().split(";");
                this.SanPham[i] = new Personal_Belongings(data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]);

            }

            System.out.print("The number of products you want to add: ");
            n = this.reader.nextInt();
            BufferedWriter fr = new BufferedWriter(new FileWriter("List_Personal_Belongings.txt", true));

            // ------------------------------------------------------------------------------------------------------------------------------//
            for (int i = 0; i < n; ++i) {
                boolean signal = false;
                Products SanPham = new Personal_Belongings();
                System.out.println("Please enter your product information!\n");
                SanPham.NhapLieu();
                String temp = SanPham.get_maSP();
                if (!SanPham.get_maSP().isEmpty() && !SanPham.get_tenSP().isEmpty() &&
                        SanPham.get_giaMua() > 0 && SanPham.get_giaBan() > 0 &&
                        !SanPham.get_nhaCungcap().isEmpty() && SanPham.get_soLuong() > 0 &&
                        ((Personal_Belongings) SanPham).get_Personal_Belongings_type() != null) {
                    for (int j = 0; j < count; ++j) {
                        if (temp.equals(this.SanPham[j].get_maSP())) {
                            System.out.println("Products already available!");
                            signal = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("You enter missing information!");
                    signal = true;
                }

                if (!signal) {
                    fr.write(SanPham.toString());
                    fr.newLine();
                    System.out.println("Stationeries added successfully.");
                }
            }

            // ------------------------------------------------------------------------------------------------------------------------------//

            fr.close();
            ft.close();
            this.reader.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

    private void ADD_Drinks() {
        try {
            BufferedReader fw = new BufferedReader(new FileReader("List_Drinks.txt"));
            int count = 0;
            while (fw.readLine() != null) {
                ++count;
            }
            fw.close();
            BufferedReader ft = new BufferedReader(new FileReader("List_Drinks.txt"));
            this.SanPham = new Products[count];

            for (int i = 0; i < count; i++) {
                String[] data = ft.readLine().split(";");
                this.SanPham[i] = new Personal_Belongings(data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]);

            }

            System.out.print("The number of products you want to add: ");
            n = this.reader.nextInt();
            BufferedWriter fr = new BufferedWriter(new FileWriter("List_Drinks.txt", true));

            // ------------------------------------------------------------------------------------------------------------------------------//
            for (int i = 0; i < n; ++i) {
                boolean signal = false;
                Products SanPham = new Drinks();
                System.out.println("Please enter your product information!\n");
                SanPham.NhapLieu();
                String temp = SanPham.get_maSP();
                if (!SanPham.get_maSP().isEmpty() && !SanPham.get_tenSP().isEmpty() &&
                        SanPham.get_giaMua() > 0 && SanPham.get_giaBan() > 0 &&
                        !SanPham.get_nhaCungcap().isEmpty() && SanPham.get_soLuong() > 0 &&
                        ((Drinks) SanPham).get_Drinks_type() != null) {
                    for (int j = 0; j < count; ++j) {
                        if (temp.equals(this.SanPham[j].get_maSP())) {
                            System.out.println("Products already available!");
                            signal = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("You enter missing information!");
                    signal = true;
                }

                if (!signal) {
                    fr.write(SanPham.toString());
                    fr.newLine();
                    System.out.println("Stationeries added successfully.");
                }
            }

            // ------------------------------------------------------------------------------------------------------------------------------//

            fr.close();
            ft.close();
            this.reader.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

    // ================================================================================================================================================================//
    // DELETE
    // ================================================================================================================================================================//

    public void delete() {
        int choice = -1;
        while (choice != 0) {
            System.out.printf("1.Stationeries");
            System.out.printf("\n2.Personal_Belongings");
            System.out.printf("\n3.Drinks");
            System.out.printf("\n0.Exit");
            System.out.printf("\nEnter the type of product you want to delete:  ");
            choice = reader.nextInt();
            switch (choice) {
                case 1:
                    DELETE_Stationeries();
                    break;
                case 2:
                    DELETE_Personal_Belongings();
                    break;
                case 3:
                    DELETE_Drinks();
                    break;
                case 0:
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    public void DELETE_Stationeries() {
        try {
            BufferedReader fw = new BufferedReader(new FileReader("List_Stationeries.txt"));
            ArrayList<Products> productList = new ArrayList<>();
            String line;
            while ((line = fw.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 7) {
                    productList.add(new Stationeries(data[0], data[1], Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]));
                }
            }
            fw.close();

            System.out.print("Enter the product ID that you want to remove: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(new FileWriter("List_Stationeries.txt"));
            boolean signal = false;

            for (Products product : productList) {
                if (!product.get_maSP().equals(ma)) {
                    br.write(product.toString());
                    br.newLine();
                } else {
                    System.out.println("--Deleted Product Information--");
                    product.Xuat();
                    signal = true;
                }
            }

            if (!signal) {
                System.out.println("No products to remove in the list!");
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void DELETE_Personal_Belongings() {
        try {
            boolean signal = false;
            BufferedReader fw = new BufferedReader(new FileReader("List_Personal_Belongings.txt"));
            int count = 0;
            while (fw.readLine() != null) {
                ++count;
            }
            fw.close();
            BufferedReader ft = new BufferedReader(new FileReader("List_Personal_Belongings.txt"));
            this.SanPham = new Products[count];

            System.out.print("Enter the product ID that you want to remove: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(new FileWriter("List_Personal_Belongings.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                if (ma.equals(this.SanPham[i].get_maSP())) {
                    System.out.println("--Deleted Product Information-");
                    this.SanPham[i].Xuat();
                    signal = true;
                } else {
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                }
            }

            if (!signal) {
                System.out.println("No products to remove in the list!\n");
            }

            br.close();
            ft.close();
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    public void DELETE_Drinks() {
        try {
            boolean signal = false;
            BufferedReader fw = new BufferedReader(new FileReader("List_Drinks.txt"));
            int count = 0;
            while (fw.readLine() != null) {
                ++count;
            }
            fw.close();
            BufferedReader ft = new BufferedReader(new FileReader("List_Drinks.txt"));
            this.SanPham = new Products[count];

            System.out.print("Enter the product ID that you want to remove: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(new FileWriter("List_Drinks.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                if (ma.equals(this.SanPham[i].get_maSP())) {
                    System.out.println("--Deleted Product Information-");
                    this.SanPham[i].Xuat();
                    signal = true;
                } else {
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                }
            }

            if (!signal) {
                System.out.println("No products to remove in the list!\n");
            }

            br.close();
            ft.close();
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    // ================================================================================================================================================================//
    // FIND
    // ================================================================================================================================================================//

    private ArrayList<Products> allProducts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Đọc 3 file và tìm kiếm sản phẩm
    public void find() {
        try {
            // Đọc file Stationeries
            BufferedReader brStationeries = new BufferedReader(new FileReader("List_Stationeries.txt"));
            String line;
            while ((line = brStationeries.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 7) {
                    allProducts.add(new Stationeries(data[0], data[1], Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]));
                }
            }
            brStationeries.close();

            // Đọc file Personal_Belongings
            BufferedReader brPersonalBelongings = new BufferedReader(new FileReader("List_Personal_Belongings.txt"));
            while ((line = brPersonalBelongings.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 7) {
                    allProducts.add(new Personal_Belongings(data[0], data[1], Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]));
                }
            }
            brPersonalBelongings.close();

            // Đọc file Drinks
            BufferedReader brDrinks = new BufferedReader(new FileReader("List_Drinks.txt"));
            while ((line = brDrinks.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 7) {
                    allProducts.add(new Drinks(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                            data[4], Integer.parseInt(data[5]), data[6]));
                }
            }
            brDrinks.close();
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
            return;
        }

        // Tìm kiếm sản phẩm theo mã
        searchProductByCode();
    }

    // Tìm kiếm sản phẩm theo mã
    public void searchProductByCode() {
        System.out.print("Enter the product code to search: ");
        String searchID = scanner.nextLine();

        boolean found = false;

        // Duyệt qua tất cả các sản phẩm và so sánh mã sản phẩm
        for (Products product : allProducts) {
            if (product.get_maSP().equals(searchID)) {
                System.out.println("Product found:");
                product.Xuat(); // Hiển thị thông tin sản phẩm
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product with code " + searchID + " not found.");
        }
    }

    // ================================================================================================================================================================//
    // SHOW
    // ================================================================================================================================================================//

    public void show() {
        int choice = -1;
        while (choice != 0) {
            System.out.printf("1.Stationeries");
            System.out.printf("\n2.Personal_Belongings");
            System.out.printf("\n3.Drinks");
            System.out.printf("\n0.Exit");
            System.out.printf("\nEnter the type of product you want to show: ");
            choice = reader.nextInt();
            switch (choice) {
                case 1:
                    SHOW_Stationeries();
                    break;
                case 2:
                    SHOW_Personal_Belongings();
                    break;
                case 3:
                    SHOW_Drinks();
                    break;
                case 0:
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    public void SHOW_Stationeries() {
        try {
            BufferedReader fw = new BufferedReader(new FileReader("List_Stationeries.txt"));

            String st;
            int i = 1; // Biến đếm để đánh số sản phẩm

            while ((st = fw.readLine()) != null) { // Đọc từng dòng trong file
                System.out.println("--Product " + i + " :");
                String[] data = st.split(";"); // Tách dữ liệu bằng dấu ";"

                // Tạo đối tượng sản phẩm từ dữ liệu đọc được
                Products DS = new Stationeries(data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]);

                DS.Xuat(); // Hiển thị thông tin sản phẩm
                i++; // Tăng biến đếm
            }

            fw.close();

        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    public void SHOW_Personal_Belongings() {
        try {
            BufferedReader fw = new BufferedReader(new FileReader("List_Personal_Belongings.txt"));

            String st;
            int i = 1; // Biến đếm để đánh số sản phẩm

            while ((st = fw.readLine()) != null) { // Đọc từng dòng trong file
                System.out.println("--Product " + i + " :");
                String[] data = st.split(";"); // Tách dữ liệu bằng dấu ";"

                // Tạo đối tượng sản phẩm từ dữ liệu đọc được
                Products DS = new Personal_Belongings(data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]);

                DS.Xuat(); // Hiển thị thông tin sản phẩm
                i++; // Tăng biến đếm
            }
            fw.close();

        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    public void SHOW_Drinks() {
        try {
            BufferedReader fw = new BufferedReader(new FileReader("List_Drinks.txt"));

            String st;
            int i = 1; // Biến đếm để đánh số sản phẩm

            while ((st = fw.readLine()) != null) { // Đọc từng dòng trong file
                System.out.println("--Product " + i + " :");
                String[] data = st.split(";"); // Tách dữ liệu bằng dấu ";"

                // Tạo đối tượng sản phẩm từ dữ liệu đọc được
                Products DS = new Drinks(data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]);

                DS.Xuat(); // Hiển thị thông tin sản phẩm
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
        int choice = -1;
        while (choice != 0) {
            System.out.printf("1.Stationeries");
            System.out.printf("\n2.Personal_Belongings");
            System.out.printf("\n3.Drinks");
            System.out.printf("\n0.Exit");
            System.out.printf("\nEnter the type of product you want to edit: ");
            choice = reader.nextInt();
            switch (choice) {
                case 1:
                    EDIT_Stationeries();
                    break;
                case 2:
                    EDIT_Personal_Belongings();
                    break;
                case 3:
                    EDIT_Drinks();
                    break;
                case 0:
                    System.out.println("OUT.");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    public void EDIT_Stationeries() {
        try {
            int count = 0;
            boolean signal = false;

            for (BufferedReader fw = new BufferedReader(new FileReader("List_Stationeries.txt")); fw
                    .readLine() != null; ++count) {
            }

            this.SanPham = (Products[]) Arrays.copyOf(this.SanPham, count);
            BufferedReader ft = new BufferedReader(new FileReader("List_Stationeries.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                // Đọc dòng từ file và tách bằng dấu ";"
                String[] s = ft.readLine().split(";");

                // Tạo đối tượng Stationeries từ dữ liệu tách được
                this.SanPham[i] = new Stationeries(s[0], s[1], Integer.parseInt(s[2]),
                        Integer.parseInt(s[3]), s[4], Integer.parseInt(s[5]), s[6]);
            }

            System.out.print("\nEnter the product ID that you want to edit: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(new FileWriter("List_Stationeries.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                if (ma.equals(this.SanPham[i].get_maSP())) {
                    System.out.println("--Product information that you need to edit--");
                    this.SanPham[i].Xuat();
                    System.out.println("--Please enter the product information to be edited--");
                    this.SanPham[i].NhapLieu();
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                    signal = true;
                } else {
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                }
            }

            if (!signal) {
                System.out.println("--no products to be corrected in the name--");
            }

            br.close();
            ft.close();
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    public void EDIT_Personal_Belongings() {
        try {
            int count = 0;
            boolean signal = false;

            for (BufferedReader fw = new BufferedReader(new FileReader("List_Personal_Belongings.txt")); fw
                    .readLine() != null; ++count) {
            }

            this.SanPham = (Products[]) Arrays.copyOf(this.SanPham, count);
            BufferedReader ft = new BufferedReader(new FileReader("List_Personal_Belongings.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                // Đọc dòng từ file và tách bằng dấu ";"
                String[] s = ft.readLine().split(";");

                // Tạo đối tượng Personal_Belongings từ dữ liệu tách được
                this.SanPham[i] = new Personal_Belongings(s[0], s[1], Integer.parseInt(s[2]),
                        Integer.parseInt(s[3]), s[4], Integer.parseInt(s[5]), s[6]);
            }

            System.out.print("\nEnter the product ID that you want to edit: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(new FileWriter("List_Personal_Belongings.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                if (ma.equals(this.SanPham[i].get_maSP())) {
                    System.out.println("--Product information that you need to edit--");
                    this.SanPham[i].Xuat();
                    System.out.println("--Please enter the product information to be edited--");
                    this.SanPham[i].NhapLieu();
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                    signal = true;
                } else {
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                }
            }

            if (!signal) {
                System.out.println("--no products to be corrected in the name--");
            }

            br.close();
            ft.close();
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    public void EDIT_Drinks() {
        try {
            int count = 0;
            boolean signal = false;

            for (BufferedReader fw = new BufferedReader(new FileReader("List_Drinks.txt")); fw
                    .readLine() != null; ++count) {
            }

            this.SanPham = (Products[]) Arrays.copyOf(this.SanPham, count);
            BufferedReader ft = new BufferedReader(new FileReader("List_Drinks.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                // Đọc dòng từ file và tách bằng dấu ";"
                String[] s = ft.readLine().split(";");

                // Tạo đối tượng Drinks từ dữ liệu tách được
                this.SanPham[i] = new Drinks(s[0], s[1], Integer.parseInt(s[2]),
                        Integer.parseInt(s[3]), s[4], Integer.parseInt(s[5]), s[6]);
            }

            System.out.print("\nEnter the product ID that you want to edit: ");
            String ma = this.reader.nextLine();
            BufferedWriter br = new BufferedWriter(new FileWriter("List_Drinks.txt"));

            for (int i = 0; i < this.SanPham.length; ++i) {
                if (ma.equals(this.SanPham[i].get_maSP())) {
                    System.out.println("--Product information that you need to edit--");
                    this.SanPham[i].Xuat();
                    System.out.println("--Please enter the product information to be edited--");
                    this.SanPham[i].NhapLieu();
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                    signal = true;
                } else {
                    br.write(this.SanPham[i].toString());
                    br.newLine();
                }
            }

            if (!signal) {
                System.out.println("--no products to be corrected in the name--");
            }

            br.close();
            ft.close();
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }
}