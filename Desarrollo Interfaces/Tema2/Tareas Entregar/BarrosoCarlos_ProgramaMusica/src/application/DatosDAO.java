package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DatosDAO {

private Connection conexion;
    private String url = "jdbc:sqlite:musicafx.db";

    public void conectar() throws ClassNotFoundException, SQLException, IOException {

        conexion = DriverManager.getConnection(url);
        if (conexion != null) {
            String sql = "CREATE TABLE IF NOT EXISTS canciones (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "titulo TEXT NOT NULL, "+
                         "artista TEXT NOT NULL);";
            
            String sql2 = "CREATE TABLE IF NOT EXISTS artistas (" +
               "id_artista INTEGER PRIMARY KEY AUTOINCREMENT," +
               "nombre TEXT NOT NULL);";
            
            
        Statement stmt = conexion.createStatement();
        Statement stmt2 = conexion.createStatement();
            stmt.execute(sql);
            stmt2.execute(sql2);
            System.out.println("Se ha creado una conexiÃ³n con BBDD.");
        }
    }

     
    public void desconectar() throws SQLException {
        conexion.close();
    }

    public void guardarCancion(Album album) throws SQLException {
    	
    	try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        String sql = "INSERT INTO canciones (id, titulo, artista) VALUES (?, ?, ?)";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, album.getId());
        sentencia.setString(2, album.getTitulo());
        sentencia.setString(3, album.getArtista());
        sentencia.executeUpdate();
        
        this.desconectar();
    }

    public void eliminarCancion(Album album) throws SQLException {
    	try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql = "DELETE FROM canciones WHERE id = ?";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, album.getId());
        sentencia.executeUpdate();
        
        this.desconectar();
    }

    public void modificarCancion(Album albumAntiguo, Album albumNuevo) throws SQLException {
    	
    	try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        String sql = "UPDATE canciones SET id = ?, titulo = ?, artista = ? WHERE id = ?";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, albumNuevo.getId());
        sentencia.setString(2, albumNuevo.getTitulo());
        sentencia.setString(3, albumNuevo.getArtista());
        sentencia.setString(4, albumNuevo.getId());
        sentencia.executeUpdate();
        
        this.desconectar();
    }

    public List<Album> obtenerMusica() throws SQLException {
        List<Album> canciones = new ArrayList<>();
        String sql = "SELECT * FROM canciones";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Album album = new Album(" "," "," ");
            album.setId(resultado.getString(1)); 
            album.setTitulo(resultado.getString(2));
            album.setArtista(resultado.getString(3));
            canciones.add(album);
        }

        return canciones;
    }
    
    public void guardarArtista(Artista artista) throws SQLException {
    	
    	try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        String sql = "INSERT INTO artistas (id_artista, nombre) VALUES (?, ?)";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, artista.getId());
        sentencia.setString(2, artista.getNombre());
        sentencia.executeUpdate();
        
        this.desconectar();
    }
    
    public void eliminarArtista(Artista artista) throws SQLException {
    	try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql = "DELETE FROM artistas WHERE id_artista = ?";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, artista.getId());
        sentencia.executeUpdate();
        
        this.desconectar();
    }
    
    public void modificarArtista(Artista artista) throws SQLException {
        try {
            this.conectar();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar con la base de datos.", e);
        }

        String sql = "UPDATE artistas SET nombre = ? WHERE id_artista = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, artista.getNombre());
        sentencia.setString(2, artista.getId());
        sentencia.executeUpdate();

        this.desconectar();
    }
    
    public List<Artista> mostrarArtistas() throws SQLException {
        List<Artista> artistas = new ArrayList<>();
        try {
            this.conectar();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar con la base de datos.", e);
        }

        String sql = "SELECT * FROM artistas";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        while (resultado.next()) {
            String id = resultado.getString("id_artista");
            String nombre = resultado.getString("nombre");
            artistas.add(new Artista(id, nombre));
        }

        this.desconectar();
        return artistas;
    }
    public List<Album> mostrarAlbumes() throws SQLException {
        List<Album> albumes = new ArrayList<>();
        try {
            this.conectar();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar con la base de datos.", e);
        }

        String sql = "SELECT * FROM canciones";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        while (resultado.next()) {
            String id = resultado.getString("id");
            String titulo = resultado.getString("titulo");
            String artista = resultado.getString("artista");
            albumes.add(new Album(id, titulo, artista));
        }

        this.desconectar();
        return albumes;
    }
}
