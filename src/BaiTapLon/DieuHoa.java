package BaiTapLon;

import java.util.Scanner;

public class DieuHoa implements IDieuHoaNhietDo, IInventer {
	private String ma;
	private String nhanHieu;
	private String nhaSX;
	private int congSuat;
	private float gia;

	public DieuHoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DieuHoa(String ma, String nhanHieu, String nhaSX, int congSuat, float gia) {
		super();
		this.ma = ma;
		this.nhanHieu = nhanHieu;
		this.nhaSX = nhaSX;
		this.congSuat = congSuat;
		this.gia = gia;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getNhanHieu() {
		return nhanHieu;
	}

	public void setNhanHieu(String nhanHieu) {
		this.nhanHieu = nhanHieu;
	}

	public String getNhaSX() {
		return nhaSX;
	}

	public void setNhaSX(String nhaSX) {
		this.nhaSX = nhaSX;
	}

	public int getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(int congSuat) {
		this.congSuat = congSuat;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	@Override
	public void nhapTT() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma dieu hoa: ");
		ma = sc.nextLine();
		do {
			System.out.println("Nhap nhan hieu dieu hoa: ");
			nhanHieu = sc.nextLine();
			if (nhanHieu.length() < 5 || nhanHieu.length() > 32)
				System.out.println("Vui long nhap lai nhan hieu");

		} while (nhanHieu.length() < 5 || nhanHieu.length() > 32);

		do {
			System.out.println("Nhap nha san xuat dieu hoa: ");
			nhaSX = sc.nextLine();
			if (nhaSX.length() < 32 || nhaSX.length() > 128)
				System.out.println("Vui long nhap lai nha san xuat");
		} while (nhaSX.length() < 32 || nhaSX.length() > 128);

		do {
			System.out.println("Nhap cong suat dieu hoa: ");
			congSuat = Integer.parseInt(sc.nextLine());
			if (congSuat < 100)
				System.out.println("Vui long nhap lai cong suat");

		} while (congSuat < 100);

		do {
			System.out.println("Nhap gia dieu hoa: ");
			gia = Float.parseFloat(sc.nextLine());

			if (gia < 0)
				System.out.println("Vui long nhap lai gia");

		} while (gia < 0);

	}

	@Override
	public void hienThiTT() {
	
		System.out.println("\tMa dieu hoa la: " + ma);
		System.out.println("\tTen dieu hoa la: "+nhanHieu);
		System.out.println("\tNha san xuat dieu hoa la: " + nhaSX);
		System.out.println("\tCong suat dieu hoa la: " + congSuat);
		System.out.println("\tGia dieu hoa la: " + gia);
	}

	@Override
	public float tieuThuDienNang() {
		if (congSuat >= 101) {
			return congSuat * TIET_KIEM_DIEN / 100;

		} else {
			return congSuat;
		}

	}

	@Override
	public String toString() {
		return "DieuHoa [ma=" + ma + ", nhanHieu=" + nhanHieu + ", nhaSX=" + nhaSX + ", congSuat=" + congSuat + ", gia="
				+ gia + "]";
	}


	public int getThangBaoHanh() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
