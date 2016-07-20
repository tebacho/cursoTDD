package cl.kibernum.ejercicio;

import java.util.List;

public class GuardaReceta {

	private static final String ETC_DOT = "Etc.";
	private static final String CONSTANTE_2 = "Constante 2";
	private static final String CONSTANTE_1 = "Constante 1";
	private static final String MAGIC_NUMBER = "1";
	private static final String ETC = "etc";
	private List<SomeEntity> recetas;
	private int claveUsuario;
	private int pagina;
	private int idCocina;
	private int usuarioLogeado;
	private int tipoId;
	private Servicio servicio;
	
	final DataSet recetasDs = new DataSet();
	final DataTable recetasDt = new DataTable();

	public int guardaRecetas() {

		if (validaDatosRequeridos()) {
			final String DESC_BLOQUEO = "desc_bloqueo";
			final String ID_CAMPO = "id_usuario";
			
			addRecetaToDataSet(ID_CAMPO, Integer.TYPE);
			addRecetaToDataSet(DESC_BLOQUEO, String.class);
			
			SomeUtility.changeMaping(recetasDs.getColumns(), SomeUtility.SOME_FLAG);
			addListRecetasToDataSet(recetasDt);
			
			addRowsToDataTable();
			
			getUserLoginInfo();

			final Peticion peticion = new Peticion(this.claveUsuario, this.pagina, this.idCocina, recetasDs.getXml(),
					this.usuarioLogeado, this.tipoId, CONSTANTE_1, CONSTANTE_2, ETC_DOT, MAGIC_NUMBER, ETC, ETC);

			final int dummy = servicio.guardaReceta(peticion);
			
			return dummy;

		} else {
			SomeStaticMessageClass.showMessage(Globals.DATOS_REQUERIDOS_MESSAGE, Globals.MESSAGE_1_2_3_4_ME,
					MessageType.OK, MessageImage.INFO);
		}
		return 0;
	}

	public void getUserLoginInfo() {
		usuarioLogeado = getUser().getIdUsuario();
		tipoId = getUser().getTipoReceta();
	}

	public void addListRecetasToDataSet(final DataTable recetasDt) {
		this.recetasDs.addRecetas(recetasDt);
	}

	public void addRecetaToDataSet(final String idCampo, final Object type) {
		recetasDs.addReceta(idCampo, type);
	}

	private void addRowsToDataTable() {
		for (final SomeEntity receta : recetas) {
			final DataRow dr = recetasDt.newRow();
			dr.put("id_usuario", receta.getIdUsuario());
			dr.put("desc_receta", receta.getDescReceta());
			recetasDt.getRows().add(dr);
		}
	}

	private User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean validaDatosRequeridos() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<SomeEntity> getRecetas() {
		return recetas;
	}

	public void setRecetas(final List<SomeEntity> recetas) {
		this.recetas = recetas;
	}

	public int getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(final int claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(final int pagina) {
		this.pagina = pagina;
	}

	public int getIdCocina() {
		return idCocina;
	}

	public void setIdCocina(final int idCocina) {
		this.idCocina = idCocina;
	}

	public int getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(final int usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(final int tipoId) {
		this.tipoId = tipoId;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(final Servicio servicio) {
		this.servicio = servicio;
	}

	public DataSet getRecetasDs() {
		return recetasDs;
	}

	public DataTable getRecetasDt() {
		return recetasDt;
	}
	
	

}