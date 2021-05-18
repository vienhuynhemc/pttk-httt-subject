package beans.quanLyDonHang;

import beans.DateTime;

import java.util.List;

public class QuanLyDonHang {

    private String ma_dh;
    private KhachHangDatHang nguoi_dat;
    private KhachHangDatHang nguoi_duyet;
    private KhachHangDatHang nguoi_van_chuyen;
    private KhachHangDatHang nguoi_dong_goi;

    private DateTime ngay_dat;
    private DateTime ngay_gui;

    private DateTime ngay_duyet;
    private DateTime ngay_dong_goi;
    private DateTime ngay_van_chuyen;

    private List<SanPhamDatHang> list_sp;

    private int trang_thai_van_chuyen;
    private int trang_thai_thanh_toan;
    private int tong_tien;

    public QuanLyDonHang(){

    }

    public String getMa_dh() {
        return ma_dh;
    }

    public void setMa_dh(String ma_dh) {
        this.ma_dh = ma_dh;
    }

    public KhachHangDatHang getNguoi_dat() {
        return nguoi_dat;
    }

    public void setNguoi_dat(KhachHangDatHang nguoi_dat) {
        this.nguoi_dat = nguoi_dat;
    }

    public KhachHangDatHang getNguoi_duyet() {
        return nguoi_duyet;
    }

    public void setNguoi_duyet(KhachHangDatHang nguoi_duyet) {
        this.nguoi_duyet = nguoi_duyet;
    }

    public KhachHangDatHang getNguoi_van_chuyen() {
        return nguoi_van_chuyen;
    }

    public void setNguoi_van_chuyen(KhachHangDatHang nguoi_van_chuyen) {
        this.nguoi_van_chuyen = nguoi_van_chuyen;
    }

    public KhachHangDatHang getNguoi_dong_goi() {
        return nguoi_dong_goi;
    }

    public void setNguoi_dong_goi(KhachHangDatHang nguoi_dong_goi) {
        this.nguoi_dong_goi = nguoi_dong_goi;
    }

    public DateTime getNgay_dat() {
        return ngay_dat;
    }

    public void setNgay_dat(DateTime ngay_dat) {
        this.ngay_dat = ngay_dat;
    }

    public DateTime getNgay_gui() {
        return ngay_gui;
    }

    public void setNgay_gui(DateTime ngay_gui) {
        this.ngay_gui = ngay_gui;
    }

    public int getTrang_thai_van_chuyen() {
        return trang_thai_van_chuyen;
    }

    public void setTrang_thai_van_chuyen(int trang_thai_van_chuyen) {
        this.trang_thai_van_chuyen = trang_thai_van_chuyen;
    }

    public int getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(int tong_tien) {
        this.tong_tien = tong_tien;
    }

    public List<SanPhamDatHang> getList_sp() {
        return list_sp;
    }

    public void setList_sp(List<SanPhamDatHang> list_sp) {
        this.list_sp = list_sp;
    }

    public DateTime getNgay_duyet() {
        return ngay_duyet;
    }

    public void setNgay_duyet(DateTime ngay_duyet) {
        this.ngay_duyet = ngay_duyet;
    }

    public DateTime getNgay_dong_goi() {
        return ngay_dong_goi;
    }

    public void setNgay_dong_goi(DateTime ngay_dong_goi) {
        this.ngay_dong_goi = ngay_dong_goi;
    }

    public DateTime getNgay_van_chuyen() {
        return ngay_van_chuyen;
    }

    public void setNgay_van_chuyen(DateTime ngay_van_chuyen) {
        this.ngay_van_chuyen = ngay_van_chuyen;
    }

    public int getTrang_thai_thanh_toan() {
        return trang_thai_thanh_toan;
    }

    public void setTrang_thai_thanh_toan(int trang_thai_thanh_toan) {
        this.trang_thai_thanh_toan = trang_thai_thanh_toan;
    }

}
