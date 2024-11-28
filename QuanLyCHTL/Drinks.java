package QuanLyCHTL;

public class Drinks extends Products {
    private String Drinks_type;

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
        System.out.println("\nNhap ten san pham :");
        this.tenSP = reader.nextLine();
        System.out.println("\nNhap ma san pham :");
        this.maSP = reader.nextLine();
        System.out.printf("\nNhap loai do uong :");
        this.Drinks_type = reader.nextLine();
        reader.nextInt();
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
        System.out.println("Loai do uong :" + this.Drinks_type);
    }
}
