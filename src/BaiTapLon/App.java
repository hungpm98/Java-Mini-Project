package BaiTapLon;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int chon;
		Scanner sc = new Scanner(System.in);
		List<DieuHoa> dieuHoa = new ArrayList<DieuHoa>();
		while (true) {
			System.out.println("================== MENU ================== ");
			System.out.println("1. Nhap thong tin");
			System.out.println("2. Hien thi thong tin");
			System.out.println("3. Tim san pham theo ten");
			System.out.println("4. Hien thi san pham co muc tieu thu dien thap nhat");
			System.out.println("5. Hien thi san pham co thang bao hanh nhieu nhat");
			System.out.println("6. Hien thi san phamn co ho tro INVENTOR");
			System.out.println("7. Hien thi san pham sap xep theo ten");
			System.out.println("8. Ghi du lieu ra file dang van ban");
			System.out.println("9. Thoat");
			System.out.println("Moi ban chon tu 1->8");

			chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				int chon1;
				int n;
				do {
					System.out.println("1.Nhap so luong va thong tin dieu hoa Samsung");
					System.out.println("2.Nhap so luong va thong tin dieu hoa Daikin");
					System.out.println("3.Quay tro lai menu");
					chon1 = Integer.parseInt(sc.nextLine());
					switch (chon1) {
					case 1:

						do {
							System.out.println("Nhap so luong dieu hoa Samsung");
							n = Integer.parseInt(sc.nextLine());
							for (int i = 0; i < n; i++) {
								System.out.println("Nhap thong tin dieu hoa Samsung thu " + (i + 1));
								DHSamSung ss = new DHSamSung();
								ss.nhapTT();
								dieuHoa.add(ss);
							}

							if (n < 1) {
								System.out.println("Ban phai nhap thong tin it nhat 1 dieu hoa Samsung");
							}
						} while (n < 1);
						break;

					case 2:

						do {
							System.out.println("Nhap so luong dieu hoa Daikin");
							n = Integer.parseInt(sc.nextLine());
							for (int i = 0; i < n; i++) {
								System.out.println("Nhap thong tin dieu hoa Daikin thu " + (i + 1));
								DHDaikin dk = new DHDaikin();
								dk.nhapTT();
								dieuHoa.add(dk);
							}
							if (n < 1) {
								System.out.println("Ban phai nhap thong tin it nhat 1 dieu hoa Daikin");
							}
						} while (n < 1);
						break;
					case 3:
						System.out.println("Back...");
						sc.nextLine();
						break;
					}
				} while (chon1 != 3);

				break;
			case 2:
				System.out.println("Thong tin dieu hoa vua nhap la: ");
				for (DieuHoa dh  : dieuHoa) {
					dh.hienThiTT();
				}
				break;
			case 3:
				try {
					System.out.println("Nhap ten san pham muon tim: ");
					String search = sc.nextLine();

					for (DieuHoa dh : dieuHoa) {
						if (dh.getNhanHieu().contains(search)) {
							System.out.println("San pham tim thay la: " + dh.getNhanHieu());
							dh.hienThiTT();
						} else {
							System.out.println("Khong tim thay san pham");
						}
					}
				} catch (Exception e) {
					System.out.println("Da xay ra loi");
				}

				break;
			case 4:
				DieuHoa minTieuThu = dieuHoa.get(0);
				for (DieuHoa dh : dieuHoa) {
					if(dh.tieuThuDienNang()<minTieuThu.tieuThuDienNang()) {
						minTieuThu = dh;
					}
				}
				for (DieuHoa dh : dieuHoa) {
					if(dh.tieuThuDienNang()==minTieuThu.tieuThuDienNang()) {
						dh.hienThiTT();
					}
				}
				break;
			case 5:
				DieuHoa maxBaoHanh = dieuHoa.get(0);
				for (DieuHoa dh : dieuHoa) {
					if( dh.getThangBaoHanh()> maxBaoHanh.getThangBaoHanh()) {
						maxBaoHanh = dh;
					}
				}
				for (DieuHoa dh : dieuHoa) {
					if( dh.getThangBaoHanh()==maxBaoHanh.getThangBaoHanh()) {
						dh.hienThiTT();
					}
				}

				break;
			case 6:
				System.out.println("\nCac san pham co ho tro INVENTOR: ");
				for (DieuHoa dh : dieuHoa) {
					if(dh instanceof DHDaikin) {
						DHDaikin obj = (DHDaikin) dh;
						if(obj.isInventer()) {
							obj.hienThiTT();
						}
					}
				}

				break;
			case 7:
				Collections.sort(dieuHoa, new Comparator<DieuHoa>() {

					@Override
					public int compare(DieuHoa o1, DieuHoa o2) {
						// TODO Auto-generated method stub
						return o1.getNhanHieu().compareTo(o2.getNhanHieu());
					}
				});
				System.out.println("Danh sach san pham sap xep theo ten la: ");
				for (DieuHoa dh : dieuHoa) {
					dh.hienThiTT();
				}
				break;
			case 8:

				String fileName = "src/data/data.txt";
				File file = new File(fileName);
				if (file.exists()) {
					System.out.println("File ton tai");
					boolean bl = file.delete();
					if (bl) {
						System.out.println("Da xoa file thanh cong");
					} else {
						System.out.println("Khong the xoa file");
					}

				} else {
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
						for (DieuHoa dh : dieuHoa) {
							String line = dh.toString();
							writer.write(line);
							writer.newLine();
						}
						System.out.println("Ghi file thanh cong");

					} catch (Exception e) {
						System.out.println("Ghi file khong thanh cong " + e.getMessage());
					}
				}

				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Ban phai chon mot chuc nang");
			}
		}

	}
}
