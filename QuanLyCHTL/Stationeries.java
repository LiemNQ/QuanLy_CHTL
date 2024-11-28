package QuanLyCHTL;

public class Stationeries extends Products {
    protected String Sta_Type;

    public Stationeries() {
        super();
        this.Sta_Type = "a";
    }

    public Stationeries(String tenSP, String maSP, int giaMua, int giaBan, String nhaCungcap, int soLuong,
            String Sta_Type) {
        super(tenSP, maSP, giaMua, giaBan, nhaCungcap, soLuong);
        this.Sta_Type = Sta_Type;
    }

    public String get_loaiSP() {
        return Sta_Type;
    }

    public void set_loaiSP(String loaiSP) {
        this.Sta_Type = loaiSP;
    }

    @Override
    public void NhapLieu() {
        System.out.println("\nNhap ten san pham :");
        this.tenSP = reader.nextLine();
        System.out.println("\nNhap ma san pham :");
        this.maSP = reader.nextLine();
        System.out.printf("\nNhap loai van phong pham :");
        reader.nextLine();
        System.out.println("\nNhap gia mua vao san pham :");
        this.giaMua = reader.nextInt();
        System.out.println("\nNhap gia ban san pham :");
        this.giaBan = reader.nextInt();

        reader.nextLine();
        System.out.println("\nNhap nha cung cap cua san pham :");
        this.nhaCungcap = reader.nextLine();
        System.out.println("\nNhap so luong san pham :");
        this.soLuong = reader.nextInt();

    }

    @Override
    public void Xuat() {
        System.out.println("Ten san pham :" + this.tenSP);
        System.out.println("Ma san pham :" + this.maSP);
        System.out.println("Gia mua san pham :" + this.giaMua);
        System.out.println("Gia ban san pham :" + this.giaBan);
        System.out.println("Nha cung cap san pham :" + this.nhaCungcap);
        System.out.println("So luong san pham :" + this.soLuong);
        System.out.println("Loai van phong pham :" + this.Sta_Type);
    }
}
