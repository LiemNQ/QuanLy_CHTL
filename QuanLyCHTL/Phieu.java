package QuanLyCHTL;

public abstract class Phieu {
    protected String maPhieu;
    protected String maNV;

    public Phieu() {
        this.maPhieu = "a";
        this.maNV = "b";
    }

    public Phieu(String maPhieu, String maNV) {
        this.maPhieu = maPhieu;
        this.maNV = maNV;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public abstract void NhapLieu();

    public abstract void Xuat();

    public abstract String Xuat_file();

    public abstract void Xuat_form();
}
