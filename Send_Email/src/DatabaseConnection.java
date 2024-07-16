import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {

	static ArrayList<String> getMails() {
		ArrayList<String> mails = new ArrayList<>();

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mass_mailing";
			String user = "root";
			String password = "1234";

			con = DriverManager.getConnection(url, user, password);

			Statement st = con.createStatement();

			String query = "SELECT * FROM MAILINGDB";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				mails.add(rs.getString("email"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mails;
	}

}
