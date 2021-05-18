package model.quanLyDonHangModel;

import beans.quanLyDonHang.KhachHangDatHang;
import beans.quanLyDonHang.NguoiXuLyQuanLyDonHang;
import beans.quanLyDonHang.QuanLyDonHang;
import beans.quanLyDonHang.SanPhamDatHang;
import worksWithDatabase.color.ColorDataSource;
import worksWithDatabase.color.ColorWorksWithDatabase;

import java.util.ArrayList;
import java.util.List;

public class QuanLyDonHangModel {

    private static QuanLyDonHangModel quanLyDonHangModel;

    public static QuanLyDonHangModel getInstance() {
        if (quanLyDonHangModel == null) {
            quanLyDonHangModel = new QuanLyDonHangModel();
        }
        return quanLyDonHangModel;
    }

    public List<QuanLyDonHang> layDanhSachDauTien() {

        List<QuanLyDonHang> list = new ArrayList<QuanLyDonHang>();
        ColorWorksWithDatabase color = ColorDataSource.getInstance().getColorWorksWithDatabase();
        color.fillDonHang(list, "ngay_tao", "", "DESC", 1);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(color);

        return list;
    }

    public List<QuanLyDonHang> layDanhSachDauTienNVK(String ma_nvk) {

        List<QuanLyDonHang> list = new ArrayList<QuanLyDonHang>();
        ColorWorksWithDatabase color = ColorDataSource.getInstance().getColorWorksWithDatabase();
        color.fillDonHangNVK(list, "ngay_tao", "", "DESC", 1,ma_nvk);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(color);

        return list;
    }

    public List<QuanLyDonHang> layDanhSachDauTienNVGH(String ma_nvgh) {

        List<QuanLyDonHang> list = new ArrayList<QuanLyDonHang>();
        ColorWorksWithDatabase color = ColorDataSource.getInstance().getColorWorksWithDatabase();
        color.fillDonHangNVGH(list, "ngay_tao", "", "DESC", 1,ma_nvgh);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(color);

        return list;
    }

    public List<QuanLyDonHang> layDanhDanhAll(String selectSortAndSearch, String search, String sort, int nowPage) {
        List<QuanLyDonHang> list = new ArrayList<QuanLyDonHang>();
        ColorWorksWithDatabase color = ColorDataSource.getInstance().getColorWorksWithDatabase();
        color.fillDonHang(list, selectSortAndSearch, search, sort, nowPage);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(color);

        return list;
    }

    public List<QuanLyDonHang> layDanhDanhAllNVK(String selectSortAndSearch, String search, String sort, int nowPage,String ma_nvk) {
        List<QuanLyDonHang> list = new ArrayList<QuanLyDonHang>();
        ColorWorksWithDatabase color = ColorDataSource.getInstance().getColorWorksWithDatabase();
        color.fillDonHangNVK(list, selectSortAndSearch, search, sort, nowPage,ma_nvk);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(color);

        return list;
    }

    public List<QuanLyDonHang> layDanhDanhAllNVGH(String selectSortAndSearch, String search, String sort, int nowPage,String ma_nvgh) {
        List<QuanLyDonHang> list = new ArrayList<QuanLyDonHang>();
        ColorWorksWithDatabase color = ColorDataSource.getInstance().getColorWorksWithDatabase();
        color.fillDonHangNVGH(list, selectSortAndSearch, search, sort, nowPage,ma_nvgh);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(color);

        return list;
    }

    public int layDanhSachToiDaDauTien() {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        int result = colorWorksWithDatabase.getDonHangToiDa("ngay_tao", "");
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    public int layDanhSachToiDaDauTienNVK(String ma_nvk) {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        int result = colorWorksWithDatabase.getDonHangToiDaNVK("ngay_tao", "",ma_nvk);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    public int layDanhSachToiDaDauTienNVGH(String ma_nvgh) {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        int result = colorWorksWithDatabase.getDonHangToiDaNVGH("ngay_tao", "",ma_nvgh);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    public int layDanhSachToiDaFromAll(String selectSearchAndSort, String search) {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        int result = colorWorksWithDatabase.getDonHangToiDa(selectSearchAndSort, search);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    public int layDanhSachToiDaFromAllNVK(String selectSearchAndSort, String search,String ma_nvk) {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        int result = colorWorksWithDatabase.getDonHangToiDaNVK(selectSearchAndSort, search,ma_nvk);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    public int layDanhSachToiDaFromAllNVGH(String selectSearchAndSort, String search,String ma_nvgh) {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        int result = colorWorksWithDatabase.getDonHangToiDaNVGH(selectSearchAndSort, search,ma_nvgh);
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    //  Phương thức nhận vô số emailnotification tối đa, trả về số trang tối đa
    public int getMaximunNumberOfPage(int maximumEmailNotification) {
        return maximumEmailNotification % 6 > 0 ? maximumEmailNotification / 6 + 1 : maximumEmailNotification / 6;
    }

    public List<NguoiXuLyQuanLyDonHang> getListNvk() {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        List<NguoiXuLyQuanLyDonHang> result = colorWorksWithDatabase.getListNvk();
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    public List<NguoiXuLyQuanLyDonHang> getListNvgh() {
        ColorWorksWithDatabase colorWorksWithDatabase = ColorDataSource.getInstance().getColorWorksWithDatabase();
        List<NguoiXuLyQuanLyDonHang> result = colorWorksWithDatabase.getListNvgh();
        ColorDataSource.getInstance().releaseColorWorksWithDatabase(colorWorksWithDatabase);
        return result;
    }

    public static void main(String[] args) {
        List<QuanLyDonHang> list = QuanLyDonHangModel.getInstance().layDanhSachDauTien();
       for (QuanLyDonHang q : list){
           System.out.println(q.getMa_dh()+" "+q.getTrang_thai_van_chuyen()+" "+q.getNgay_dat().toString());
           KhachHangDatHang k = q.getNguoi_dat();
           System.out.println(k.getMa_kh()+" "+k.getDia_chi()+" "+k.getSo_dien_thoai()+" "+k.getEmail()+k.getLink_hinh()+k.getTen_kh());
           System.out.println(q.getNguoi_duyet());
           System.out.println(q.getNgay_dong_goi());
           System.out.println(q.getNguoi_van_chuyen());
           for(SanPhamDatHang sanPhamDatHang : q.getList_sp()){
               System.out.println(sanPhamDatHang.getMa_sp()+" "+sanPhamDatHang.getSo_luong()+" "+sanPhamDatHang.getMa_mau()+" "+sanPhamDatHang.getGia_le()+" "+sanPhamDatHang.getTong_gia()+" "+sanPhamDatHang.getTen_sp());
               System.out.println(sanPhamDatHang.getHinh_anh());
           }
       }
    }

}
