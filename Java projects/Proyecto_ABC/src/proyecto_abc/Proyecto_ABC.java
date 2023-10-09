package proyecto_abc;

public class Proyecto_ABC {

    public static void main(String[] args) {
        
        // Conectando a la base de datos.
        DatabaseConnection connection = new DatabaseConnection();
        
        Menu_Principal menu = new Menu_Principal(connection.getConnection());
    	//Administracion_json adminJson = new Administracion_json(connection.getConnection());
    	Postulante prueba = new Postulante();
    	
    	menu.setVisible(true);
    	//String herramientas[] = adminJson.obtener_herramientas("Desarrollo Web");
    	
    	/*for(int i=0; i<herramientas.length; i++) {
    		System.out.println(herramientas[i]);
    	}*/
        
        //adminJson.querySQL();
    }
    
}
