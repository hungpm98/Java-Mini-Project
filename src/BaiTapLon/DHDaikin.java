package BaiTapLon;

import java.util.Scanner;

public class DHDaikin extends DieuHoa {
	private boolean isInventer;

	public DHDaikin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DHDaikin(String ma, String nhanHieu, String nhaSX, int congSuat, float gia, boolean isInventer) {
		super(ma, nhanHieu, nhaSX, congSuat, gia);
		this.isInventer = isInventer;
	}

	public boolean isInventer() {
		return isInventer;
	}

	public void setInventer(boolean isInventer) {
		this.isInventer = isInventer;
	}

	@Override
	public float tieuThuDienNang() {
		if (isInventer)
			return getCongSuat() * TIET_KIEM_DIEN / 100;
		else
			return getCongSuat();
	}

	@Override
	public void nhapTT() {
		super.nhapTT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap che do inventer: ");
		isInventer = Boolean.parseBoolean(sc.nextLine());
	}

	@Override
	public void hienThiTT() {
		System.out.println("Thong tin dieu hoa " + this.getNhanHieu() +" la: ");
		super.hienThiTT();
		System.out.println("\tDieu hoa " + (isInventer ? "co" : "khong") + " che do INVENTOR");

	}

	@Override
	
	public String toString() {
		return "DHSamSung [ma= " + this.getMa() + ", nhanHieu= " + this.getNhanHieu() + ", nhaSX= " + this.getNhaSX()
				+ ", congSuat= " + this.getCongSuat() + ", gia= " + this.getGia() + ", isInventer= " + isInventer
				+ "]";
	}

}
