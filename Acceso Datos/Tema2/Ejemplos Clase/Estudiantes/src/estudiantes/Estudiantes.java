package estudiantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Estudiantes extends EstudiantesDAO {

	public static void main(String[] args) {
		try {

			// Conexión
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Ficheritos\\Estudiantes.db");
			int opc;
			do {
				System.out.println("------------------- 2 DAM -------------------");
				System.out.println("1. INSERTAR UN NUEVO ESTUDIANTE");
				System.out.println("2. INSERTAR UN CURSO NUEVO");
				System.out.println("3. MATRICULAR UN ESTUDIANTE EN UN CURSO");
				System.out.println("4. BORRAR UN ESTUDIANTE");
				System.out.println("5. BORRAR UN CURSO");
				System.out.println("6. MOSTRAR CURSOS DE UN ESTUDIANTE");
				System.out.println("7. MOSTRAR ALUMNOS DE UN CURSO");
				System.out.println("8. MOSTRAR ALUMNO POR ID");
				System.out.println("9. SALIR");
				System.out.println("---------------------------------------------");

				opc = Integer.parseInt(System.console().readLine());

				switch (opc) {
				case 1: {
					// Inserccion de estudiantes con prepared statement

					System.out.println("Dime el id, el nombre y el correo del estudiante para tenerlo en mi "
							+ "base de datos dame los datos separados por comas: ");

					String datos = System.console().readLine();

					String[] val = datos.split(",");

					String sql = "INSERT INTO Estudiantes (estudiante_id, nombre, correo) VALUES (?,?,?)";

					PreparedStatement pst = con.prepareStatement(sql);

					// ResultSet id = pst.executeQuery("SELECT max(estudiantes_id) from
					// Estudiantes");
					// Primera Inserccion
					pst.setString(1, val[0]);
					pst.setString(2, val[1]);
					pst.setString(3, val[2]);

					int nf = pst.executeUpdate();

					System.out.println(nf + "registros insertados");
					System.out.println();
					break;
				}
				case 2: {
					// Inserccion de cursos con prepared statement

					System.out.println("Dime el id, el nombre y la descripcion del curso para tenerlo en mi "
							+ "base de datos dame los datos separados por comas: ");

					String datos = System.console().readLine();

					String[] val = datos.split(",");

					String sql = "INSERT INTO Cursos (curso_id, nombre_curso, descripcion) VALUES (?,?,?)";

					PreparedStatement pst = con.prepareStatement(sql);

					// Inserccion
					pst.setString(1, val[0]);
					pst.setString(2, val[1]);
					pst.setString(3, val[2]);

					int nf = pst.executeUpdate();

					System.out.println(nf + "registros insertados");
					System.out.println();

					break;
				}
				case 3: {
					System.out.println("Función por implementar");
					break;
				}
				case 4: {
					System.out.println("Función por implementar");
					break;
				}
				case 5: {
					System.out.println("Función por implementar");
					break;
				}
				case 6: {
					System.out.println("Función por implementar");
					break;
				}
				case 7: {
					System.out.println("Nombre del curso que te interesa saber quien esta matriculado:");

					String curso = System.console().readLine();

					String sql = "SELECT e.nombre, c.nombre_curso FROM estudiantes e "
							+ "JOIN Estudiante_Curso ec ON e.estudiante_id = ec.estudiante_id "
							+ "JOIN Cursos c ON ec.curso_id = c.curso_id " + "WHERE c.nombre_curso = ?";
					try {

						PreparedStatement pst = con.prepareStatement(sql);

						pst.setString(1, curso);

						ResultSet rs = pst.executeQuery();

						while (rs.next()) {
							System.out.println(rs.getString("nombre"));
						}

					} catch (SQLException e) {
						System.out.println("Error en la consulta: " + e.getMessage());
					}
					break;
				}
				case 8: {

				    System.out.println("Introduce el ID del estudiante:");
				    int estudianteId = Integer.parseInt(System.console().readLine());

				        EstudiantesDAO.mostrarEstudiantePorId(con, estudianteId);


				    break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + opc);
				}
			} while (opc != 9);

			// ResultSet rs = st.executeQuery("SELECT * FROM Estudiantes");

			// while (rs.next()) {
			// System.out.print(rs.getString("NOMBRE") + " ");
			// System.out.println(rs.getInt("CORREO"));
			// }

			// while (rs.next()) {
			// System.out.print(rs.getString("NOMBRE") + " ");
			// System.out.println(rs.getInt("EDAD"));
			// }

			// Borrado
			// sql = "DELETE FROM ciclista where NOMBRE='Pepon'";

			// nf = st.executeUpdate(sql);
			// System.out.println(nf + "registros borrados");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
