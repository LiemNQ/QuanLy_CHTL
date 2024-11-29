package QuanLyCHTL;

public class Stationeries extends Products {
    protected String Sta_Type;
    protected String ID_Stationeries = "SP00";
    protected String ma;

    public Stationeries() {
        super();
        this.Sta_Type = "a";
    }

    public Stationeries(String tenSP, String maSP, int giaMua, int giaBan, String nhaCungcap, int soLuong,
            String Sta_Type) {
        super(tenSP, maSP, giaMua, giaBan, nhaCungcap, soLuong);
        this.Sta_Type = Sta_Type;
    }

    public String get_Sta_Type() {
        return Sta_Type;
    }

    public void set_Sta_Type(String Sta_Type) {
        this.Sta_Type = Sta_Type;
    }

    @Override
    public void NhapLieu() {
        System.out.println("\n=======================================================================");
        System.out.println("------NHAP THONG TIN SAN PHAM!-----");
        System.out.printf("\nNhap ten san pham :");
        this.tenSP = reader.nextLine();
        System.out.printf("\nNhap ma san pham :SP00-");
        this.ma = reader.nextLine();
        this.maSP = ID_Stationeries + "" + this.ma;
        System.out.printf("\nNhap loai van phong pham :");
        this.Sta_Type = reader.nextLine();
        System.out.printf("\nNhap gia mua vao san pham :");
        this.giaMua = reader.nextInt();
        System.out.printf("\nNhap gia ban san pham :");
        this.giaBan = reader.nextInt();

        reader.nextLine();
        System.out.printf("\nNhap nha cung cap cua san pham :");
        this.nhaCungcap = reader.nextLine();
        System.out.printf("\nNhap so luong san pham :");
        this.soLuong = reader.nextInt();
        System.out.println("\n=======================================================================");
    }

    @Override
    public void Xuat() {
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("------THONG TIN SAN PHAM!-----");
        System.out.println("Ten san pham :" + this.tenSP);
        System.out.println("Ma san pham :" + this.maSP);
        System.out.println("Loai van phong pham :" + this.Sta_Type);
        System.out.println("Gia mua san pham :" + this.giaMua);
        System.out.println("Gia ban san pham :" + this.giaBan);
        System.out.println("Nha cung cap san pham :" + this.nhaCungcap);
        System.out.println("So luong san pham :" + this.soLuong);
        System.out.println("\n----------------------------------------------------------------------");
    }

    public String Xuat_file() {
        return tenSP + ";" + maSP + ";" + giaMua + ";" + giaBan + ";" + nhaCungcap + ";" + soLuong + ";" + Sta_Type;
    }
}
