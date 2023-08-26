package BaiTapLon;

import java.util.Scanner;

public class DHSamSung extends DieuHoa {
	private int thangBaoHanh;

	public DHSamSung() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DHSamSung(String ma, String nhanHieu, String nhaSX, int congSuat, float gia, int thangBaoHanh) {
		super(ma, nhanHieu, nhaSX, congSuat, gia);
		this.thangBaoHanh = thangBaoHanh;
	}

	public int getThangBaoHanh() {
		return thangBaoHanh;
	}

	public void setThangBaoHanh(int thangBaoHanh) {
		this.thangBaoHanh = thangBaoHanh;
	}

	@Override
	public void nhapTT() {
		super.nhapTT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thang bao hanh: ");
		thangBaoHanh = sc.nextInt();

	}

	@Override
	public void hienThiTT() {
		System.out.println("Thong tin dieu hoa " + this.getNhanHieu() + " la: ");
		super.hienThiTT();
		System.out.println("\tSo thang bao hanh la: " + thangBaoHanh);
	}

	@Override
	public String toString() {
		return "DHSamSung [ma= " + this.getMa() + ", nhanHieu= " + this.getNhanHieu() + ", nhaSX= " + this.getNhaSX()
				+ ", congSuat= " + this.getCongSuat() + ", gia= " + this.getGia() + ", thangBaoHanh= " + thangBaoHanh
				+ "]";
	}

}
