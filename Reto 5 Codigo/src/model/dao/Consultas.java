package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.LeaderInfoDTO;
import model.dto.ProjectsByClassDTO;
import model.dto.PurchasesByPorjectDTO;
import util.JDBCUtilities;

public class Consultas {

    public ArrayList<LeaderInfoDTO> consul1() throws SQLException {
        ArrayList<LeaderInfoDTO> result = new ArrayList<LeaderInfoDTO>();
        Connection conn = JDBCUtilities.getConnection();
        try {
            String query = "SELECT"
            +    " ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia"
            + " FROM"
            +    " Lider"
            + " ORDER BY"
            +    " Ciudad_Residencia /*ASC*/";

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            while(rset.next()) {
                LeaderInfoDTO dto = new LeaderInfoDTO(rset.getInt("ID_Lider"), rset.getString("Nombre"), rset.getString("Primer_Apellido"), rset.getString("Ciudad_Residencia"));
                result.add(dto);
            }

            if(rset != null) {
                rset.close();
            }
            if(stmt != null) {
                stmt.close();
            }
        }
        catch(SQLException e) {
            System.err.println("Error al leer la información de los líderes");
        }
        finally {
            if(conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public ArrayList<ProjectsByClassDTO> consul2() throws SQLException {
        ArrayList<ProjectsByClassDTO> result = new ArrayList<ProjectsByClassDTO>();
        Connection conn = JDBCUtilities.getConnection();
        try {
            String query = "SELECT"
            +    " ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad"
            + " FROM"
            +    " Proyecto"
            + " WHERE"
            +    " Clasificacion = 'Casa Campestre' AND Ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla')";
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            while(rset.next()) {
                ProjectsByClassDTO dto = new ProjectsByClassDTO(rset.getInt("ID_Proyecto"), rset.getString("Constructora"), rset.getInt("Numero_Habitaciones"), rset.getString("Ciudad"));
                result.add(dto);
            }

            if(rset != null) {
                rset.close();
            }
            if(stmt != null) {
                stmt.close();
            }
        }
        catch(SQLException e) {
            System.err.println("Error al leer la información de los proyectos");
        }
        finally {
            if(conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public ArrayList<PurchasesByPorjectDTO> consul3() throws SQLException {
        ArrayList<PurchasesByPorjectDTO> result = new ArrayList<PurchasesByPorjectDTO>();
        Connection conn = JDBCUtilities.getConnection();
        try {
            String query = "SELECT"
            +    " ID_Compra, Constructora, Banco_Vinculado"
            + " FROM"
            +    " /*Compra JOIN Proyecto USING(ID_Proyecto)*/ Compra NATURAL JOIN Proyecto"
            + " WHERE" 
            +    " Proveedor = 'Homecenter' AND Ciudad = 'Salento'";
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            while(rset.next()) {
                PurchasesByPorjectDTO dto = new PurchasesByPorjectDTO(rset.getInt("ID_Compra"), rset.getString("Constructora"), rset.getString("Banco_Vinculado"));
                result.add(dto);
            }

            if(rset != null) {
                rset.close();
            }
            if(stmt != null) {
                stmt.close();
            }
        }
        catch(SQLException e) {
            System.err.println("Error al leer la información de las compras y los proyectos");
        }
        finally {
            if(conn != null) {
                conn.close();
            }
        }
        return result;
    }


}
