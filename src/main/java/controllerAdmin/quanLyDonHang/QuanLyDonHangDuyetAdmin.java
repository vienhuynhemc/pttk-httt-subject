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
import java.sql.SQLException;

@WebServlet(name = "QuanLyDonHangDuyetAdmin", urlPatterns = "/QuanLyDonHangDuyetAdmin")
public class QuanLyDonHangDuyetAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String idDh = request.getParameter("ma_dh");
        String idNv =request.getParameter("ma_nv");
        DateTime nowDate = new DateTime(DateTimeConfiguration.NOW_DATE);

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE don_hang SET ma_admin= ?,admin_duyet_don_hang =? ,trang_thai_van_chuyen= ?,ma_nvk = ? WHERE ma_don_hang =?");
            preparedStatement.setString(1, userAdmin.getAccount().getId());
            preparedStatement.setString(2, nowDate.toString());
            preparedStatement.setInt(3, 1);
            preparedStatement.setString(4,idNv);
            preparedStatement.setString(5, idDh);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);

        request.setAttribute("more", "Duyệt đơn hàng thành công cho nhân viên kho");
        request.setAttribute("more2", "Dữ liệu không có gì thay đổi");

        //  Tạo thông báo cá nhân
        PersonalNoticeModel.getInstance().addNewPersonalNoticeToDatabase(userAdmin.getAccount().getId(), "Bạn", "vừa duyệt", "một đơn hàng cho Nhân viên kho" ,"với thông tin là:", "#ID_Nhân viên: "+idNv+", #ID_Đơn hàng: "+idDh);

        //  Xong foward tới controller đỗ dữ liệu
        request.getRequestDispatcher("QuanLyDonHangController").forward(request, response);

    }
}
