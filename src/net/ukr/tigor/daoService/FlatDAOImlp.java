package net.ukr.tigor.daoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FlatDAOImlp extends AbstractDAO {

    public FlatDAOImlp(Connection conn, String table) {
        super(conn, table);
    }

    public void initBD() {
        try {

            try (Statement st = getConn().createStatement()) {
                st.execute("DROP TABLE IF EXISTS " + getTable());
                st.execute("CREATE TABLE " + getTable() + " (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, district VARCHAR(100), " +
                        "address VARCHAR(100),price DOUBLE,area DOUBLE,roomsCount INT)");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM " + getTable() + " WHERE id = " + id ;

            try (Statement st = getConn().createStatement()) {
                st.execute(sql.toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
