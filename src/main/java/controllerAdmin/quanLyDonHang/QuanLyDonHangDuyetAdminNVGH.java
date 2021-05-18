package controllerAdmin.quanLyDonHang;

import beans.DateTime;
import beans.DateTimeConfiguration;
import beans.loginAdmin.UserAdmin;
import connectionDatabase.DataSource;
import model.personalNotice.PersonalNoticeModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "QuanLyDonHangDuyetAdminNVGH", urlPatterns = "/QuanLyDonHangDuyetAdminNVGH")
public class QuanLyDonHangDuyetAdminNVGH extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String idDh = request.getParameter("ma_dh");
        int idNv =Integer.parseInt(request.getParameter("ma_nv"));
        DateTime nowDate = new DateTime(DateTimeConfiguration.NOW_DATE);

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE don_hang SET nvgh_van_chuyen =? ,trang_thai_van_chuyen= ? WHERE ma_don_hang =?");
            preparedStatement.setString(1, nowDate.toString());
            preparedStatement.setInt(2,idNv);
            preparedStatement.setString(3, idDh);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(idNv== 4){

            try {
                PreparedStatement p = connection.prepareStatement("SELECT * FROM chi_tiet_don_hang WHERE ma_don_hang = ?");
                p.setString(1,idDh);
                ResultSet r = p.executeQuery();
                while(r.next()){
                    String ma_sp = r.getString("ma_san_pham");
                    String ma_mau = r.getString("ma_mau");
                    String ma_size = r.getString("ma_size");
                    int so_luong = r.getInt("so_luong_san_pham");

                    PreparedStatement p2 = connection.prepareStatement("UPDATE thong_tin_chi_tiet_sp SET so_luong_con_lai = so_luong_con_lai + ? WHERE ma_sp = ? AND ma_mau = ? AND ma_size = ?");
                    p2.setInt(1,so_luong);
                    p2.setString(2,ma_sp);
                    p2.setString(3,ma_mau);
                    p2.setString(4,ma_size);
                    p2.executeUpdate();
                    p2.close();

                }
                r.close();
                p.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        DataSource.getInstance().releaseConnection(connection);

        request.setAttribute("more", "Duyệt đơn hàng thành công");
        request.setAttribute("more2", "Dữ liệu không có gì thay đổi");

        //  Tạo thông báo cá nhân
        PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa duyệt", "một đơn hàng" ,idNv == 3 ?"Hoàn thành":"Thất bại", "");

        //  Xong foward tới controller đỗ dữ liệu
        request.getRequestDispatcher("QuanLyDonHangControllerNVGH").forward(request, response);

    }
}
