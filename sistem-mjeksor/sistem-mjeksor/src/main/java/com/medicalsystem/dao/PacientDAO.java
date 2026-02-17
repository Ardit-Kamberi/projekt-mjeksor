
package com.medicalsystem.dao;

import com.medicalsystem.model.Pacient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientDAO {
    private Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
    }

    public void init() throws Exception {
        try (Connection c = getConnection();
             Statement st = c.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS pacient (id INT AUTO_INCREMENT PRIMARY KEY, emri VARCHAR(100), mbiemri VARCHAR(100), mosha INT, gjinia VARCHAR(10), historiku_mjekesor TEXT)");
        }
    }

    public void save(Pacient p) throws Exception {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO pacient(emri,mbiemri,mosha,gjinia,historiku_mjekesor) VALUES(?,?,?,?,?)")) {
            ps.setString(1, p.getEmri());
            ps.setString(2, p.getMbiemri());
            ps.setInt(3, p.getMosha());
            ps.setString(4, p.getGjinia());
            ps.setString(5, p.getHistorikuMjekesor());
            ps.executeUpdate();
        }
    }

    public List<Pacient> findAll() throws Exception {
        List<Pacient> list = new ArrayList<>();
        try (Connection c = getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM pacient")) {
            while (rs.next()) {
                Pacient p = new Pacient();
                p.setId(rs.getInt("id"));
                p.setEmri(rs.getString("emri"));
                p.setMbiemri(rs.getString("mbiemri"));
                p.setMosha(rs.getInt("mosha"));
                p.setGjinia(rs.getString("gjinia"));
                p.setHistorikuMjekesor(rs.getString("historiku_mjekesor"));
                list.add(p);
            }
        }
        return list;
    }
}
