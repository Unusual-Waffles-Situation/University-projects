import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Operaciones 
{
	private Connection con;
	
	public Operaciones()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/bdd_prueba", "root", "");
		}
		
		catch(Exception e)
		{
			System.out.println("No se encontro la BDD");
		}
	}
	
	public void leerNombres()
	{
		try
		{	
			Statement sta = con.createStatement();
			
			ResultSet rs = sta.executeQuery("SELECT * FROM persona");

			while(rs.next())
			{
				System.out.println(rs.getString(1) + ". C.I.: " + rs.getString(2));
			}
		}
		
		catch(Exception e)
		{
			System.out.println("Ha ocurrido un error.");
		}
	}
	
	public Connection getCon(){ return con; }
}
