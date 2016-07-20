package cl.kibernum.ejercicio;

public class DataSet {
	
	public Column getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	public Table getTables() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getXml() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addReceta(final String idCampo, final Object type) {
		getColumns().add("id_usuario", Integer.TYPE);
	}

	public void addRecetas(final DataTable recetasDt) {
		getTables().add(recetasDt);
	}

	public void setTables(final Table tables) {
	}

}
