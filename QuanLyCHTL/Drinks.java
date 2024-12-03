package QuanLyCHTL;

public class Drinks extends Products {
    private String Drinks_type;
    protected String ID_Drinks = "D00";
    protected String ma;

    public Drinks() {
        super();
        this.Drinks_type = "a";
    }

    public Drinks(String tenSP, String maSP, int giaMua, int giaBan, String nhaCungcap, int soLuong,
            String Drinks_type) {
        super(tenSP, maSP, giaMua, giaBan, nhaCungcap, soLuong);
        this.Drinks_type = Drinks_type;
    }

    public String get_Drinks_type() {
        return Drinks_type;
    }

    public void set_Drinks_type(String loaiSP) {
        this.Drinks_type = loaiSP;
    }

    @Override
    public void NhapLieu() {
        System.out.println("=======================================================================");
        System.out.println("------NHAP THONG TIN SAN PHAM!-----");
        System.out.printf("\nNhap ten san pham :");
        this.tenSP = reader.nextLine();
        System.out.printf("\nNhap ma san pham :D00-");
        this.ma = reader.nextLine();
        this.maSP = ID_Drinks + "" + this.ma;
        System.out.printf("\nNhap loai do uong :");
        this.Drinks_type = reader.nextLine();
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
        System.out.println("-----THONG TIN SAN PHAM!-----");
        System.out.println("Ten san pham :" + this.tenSP);
        System.out.println("Ma san pham :" + this.maSP);
        System.out.println("Loai do uong :" + this.Drinks_type);
        System.out.println("Gia mua san pham :" + this.giaMua);
        System.out.println("Gia ban san pham :" + this.giaBan);
        System.out.println("Nha cung cap san pham :" + this.nhaCungcap);
        System.out.println("So luong san pham :" + this.soLuong);
        System.out.println("----------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Drinks cn1 = new Drinks();
        cn1.NhapLieu();
        cn1.Xuat();
    }

    public void Xuat_form() {
        System.out.printf("%-20s| %-6s| %-10d| %-10d| %-25s| %-10d| %-20s|\n", this.tenSP, this.maSP,
                this.giaMua, this.giaBan, this.nhaCungcap, this.soLuong, this.Drinks_type);
    }

    public String Xuat_file() {
        return tenSP + ";" + maSP + ";" + giaMua + ";" + giaBan + ";" + nhaCungcap + ";" + soLuong + ";" + Drinks_type;
    }
}
