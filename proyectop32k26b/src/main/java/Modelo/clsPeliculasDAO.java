/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.clsPeliculas;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author reyes
 */
public class clsPeliculasDAO {
 
    private static final String SQL_SELECT =
            "SELECT idPeliculas, Nombre, Clasificacion, Genero, Subtitulado, Idioma, Precio FROM peliculas";

    private static final String SQL_INSERT =
            "INSERT INTO peliculas (idPeliculas, Nombre, Clasificacion, Genero, Subtitulado, Idioma, Precio) VALUES(?, ?)";

    private static final String SQL_UPDATE =
            "UPDATE peliculas SET Nombre=?, Clasificacion=?, Genero=?, Subtitulado=?, Idioma=?, Precio=? WHERE idPeliculas=?";

    private static final String SQL_DELETE =
            "DELETE FROM peliculas WHERE idPeliculas=?";

    private static final String SQL_SELECT_ID =
            "SELECT idPeliculas, Nombre, Clasificacion, Genero, Subtitulado, Idioma, Precio FROM peliculas WHERE idPeliculas=?";


    private static final String SQL_INSERT_BITACORA =
            "INSERT INTO bitacora(usuid, aplcodigo, bitfecha, bitip, bitequipo, bitaccion) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_BITACORA =
            "SELECT bitcodigo, usuid, aplcodigo, bitfecha, bitip, bitequipo, bitaccion FROM bitacora";

    private static final String SQL_UPDATE_BITACORA =
            "UPDATE bitacora SET usuid=?, aplcodigo=?, bitfecha=?, bitip=?, bitequipo=?, bitaccion=? WHERE bitcodigo=?";

    private static final String SQL_DELETE_BITACORA =
            "DELETE FROM bitacora WHERE bitcodigo=?";


    
    public List<clsPeliculas> obtenerPeliculas(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPeliculas> lista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                clsPeliculas p = new clsPeliculas();
                p.setIdPeliculas(rs.getInt("idPeliculas"));
                p.setNombre(rs.getString("Nombre"));
                p.setClasificacion(rs.getString("Claisificacion"));
                p.setGenero(rs.getString("Genero"));
                p.setSubtitulado(rs.getString("Subtitulado"));
                p.setIdioma(rs.getString("Idioma"));
                p.setPrecio(rs.getString("Precio"));
                lista.add(p);
            }

            //bitacora.setBitaccion("SELECT Peliculas");
            //insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lista;
    }

    public int insertarPerfil(clsPeliculas Peliculas, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, Peliculas.getNombre());
            stmt.setString(2, Peliculas.getClasificacion());
            stmt.setString(3, Peliculas.getGenero());
            stmt.setString(4, Peliculas.getSubtitulado());
            stmt.setString(5, Peliculas.getIdioma());
            stmt.setString(6, Peliculas.getPrecio());

            rows = stmt.executeUpdate();

            bitacora.setBitaccion("INSERT Peliculas " + Peliculas.getNombre());
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizarPerfil(clsPeliculas Peliculas, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, Peliculas.getNombre());
            stmt.setString(2, Peliculas.getClasificacion());
            stmt.setString(3, Peliculas.getGenero());
            stmt.setString(4, Peliculas.getSubtitulado());
            stmt.setString(5, Peliculas.getIdioma());
            stmt.setString(6, Peliculas.getPrecio());
            stmt.setInt(7, Peliculas.getIdPeliculas());

            rows = stmt.executeUpdate();

            bitacora.setBitaccion("UPDATE peliculas " + Peliculas.getIdPeliculas());
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminarPerfil(clsPeliculas peliculas, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, peliculas.getIdPeliculas());

            rows = stmt.executeUpdate();

            bitacora.setBitaccion("DELETE peliculas " + peliculas.getIdPeliculas());
            insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsPeliculas obtenerPeliculaPorId(int id, clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPeliculas peliculas = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                peliculas = new clsPeliculas();
                peliculas.setIdPeliculas(rs.getInt("idPeliculas"));
                peliculas.setNombre(rs.getString("Nombre"));
                peliculas.setClasificacion(rs.getString("Clasificacion"));
                peliculas.setNombre(rs.getString("Genero"));
                peliculas.setNombre(rs.getString("Subtitulado"));
                peliculas.setNombre(rs.getString("Idioma"));
                peliculas.setNombre(rs.getString("Precio"));
            }

            //bitacora.setBitaccion("SELECT perfil ID " + id);
            //insertarBitacora(bitacora);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return peliculas;
    }


    
    public int insertarBitacora(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_BITACORA);

            stmt.setInt(1, bitacora.getUsucodigo());
            stmt.setInt(2, bitacora.getAplcodigo());
            stmt.setString(3, bitacora.getBitfecha());
            stmt.setString(4, bitacora.getBitip());
            stmt.setString(5, bitacora.getBitequipo());
            stmt.setString(6, bitacora.getBitaccion());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<clsBitacora> obtenerBitacora() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsBitacora> lista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BITACORA);
            rs = stmt.executeQuery();

            while (rs.next()) {
                clsBitacora b = new clsBitacora();
                b.setBitcodigo(rs.getInt("bitcodigo"));
                b.setUsucodigo(rs.getInt("usucodigo"));
                b.setAplcodigo(rs.getInt("aplcodigo"));
                b.setBitfecha(rs.getString("bitfecha"));
                b.setBitip(rs.getString("bitip"));
                b.setBitequipo(rs.getString("bitequipo"));
                b.setBitaccion(rs.getString("bitaccion"));
                lista.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lista;
    }

    public int actualizarBitacora(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_BITACORA);

            stmt.setInt(1, bitacora.getUsucodigo());
            stmt.setInt(2, bitacora.getAplcodigo());
            stmt.setString(3, bitacora.getBitfecha());
            stmt.setString(4, bitacora.getBitip());
            stmt.setString(5, bitacora.getBitequipo());
            stmt.setString(6, bitacora.getBitaccion());
            stmt.setInt(7, bitacora.getBitcodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminarBitacora(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_BITACORA);

            stmt.setInt(1, bitacora.getBitcodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}
