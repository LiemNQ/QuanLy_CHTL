package QuanLyCHTL;

public class Personal_Belongings extends Products {
    public String Personal_Belongings_type;
    protected String ID_Personal_Belongings = "PB00";
    protected String ma;

    public Personal_Belongings() {
        super();
        this.Personal_Belongings_type = " ";
    }

    public Personal_Belongings(String tenSP, String maSP, int giaMua, int giaBan, String nhaCungcap, int soLuong,
            String Personal_Belongings_type) {
        super(tenSP, maSP, giaMua, giaBan, nhaCungcap, soLuong);
        this.Personal_Belongings_type = Personal_Belongings_type;
    }

    public String get_Personal_Belongings_type() {
        return Personal_Belongings_type;
    }

    public void set_Personal_Belongings_type(String Personal_Belongings_type) {
        this.Personal_Belongings_type = Personal_Belongings_type;
    }

    @Override
    public void NhapLieu() {
        System.out.println("=======================================================================");
        System.out.println("------NHAP THONG TIN SAN PHAM!-----");
        System.out.printf("\nNhap ten san pham :");
        this.tenSP = reader.nextLine();
        System.out.printf("\nNhap ma san pham :PB00-");
        this.ma = reader.nextLine();
        this.maSP = ID_Personal_Belongings + "" + this.ma;
        System.out.printf("\nNhap loai do dung ca nhan :");
        this.Personal_Belongings_type = reader.nextLine();
        System.out.printf("\nNhap gia mua vao san pham :");
        this.giaMua = reader.nextInt();
        System.out.printf("\nNhap gia ban san pham :");
        this.giaBan = reader.nextInt();

        reader.nextLine();
        System.out.printf("\nNhap nha cung cap cua san pham :");
        this.nhaCungcap = reader.nextLine();
        System.out.printf("\nNhap so luong san pham :");
        this.soLuong = reader.nextInt();
        System.out.println("=======================================================================");
    }

    @Override
    public void Xuat() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("------THONG TIN SAN PHAM!-----");
        System.out.println("Ten san pham :" + this.tenSP);
        System.out.println("Ma san pham :" + this.maSP);
        System.out.println("Loai do dung ca nhan :" + this.Personal_Belongings_type);
        System.out.println("Gia mua san pham :" + this.giaMua);
        System.out.println("Gia ban san pham :" + this.giaBan);
        System.out.println("Nha cung cap san pham :" + this.nhaCungcap);
        System.out.println("So luong san pham :" + this.soLuong);
        System.out.println("----------------------------------------------------------------------");
    }

    public void Xuat_form() {
        System.out.printf("%-20s| %-6s| %-10d| %-10d| %-25s| %-10d| %-20s|\n", this.tenSP, this.maSP,
                this.giaMua, this.giaBan, this.nhaCungcap, this.soLuong, this.Personal_Belongings_type);
    }

    public String Xuat_file() {
        return tenSP + ";" + maSP + ";" + giaMua + ";" + giaBan + ";" + nhaCungcap + ";" + soLuong + ";"
                + Personal_Belongings_type;
    }
}
