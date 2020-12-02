package teste;

public class OgrJavaBindingTeste {

	public static void main(String[] args) {

		// Nao esta funcionando!

		String[] cmd = { "-t_srs", "CRS:84", "-f", "GeoJSON", "geoft_bho_2017_ponto_drenagem.geojson",
				"geoft_bho_2017_ponto_drenagem.shp" };

		ogr2ogr.main(cmd);
	}

}
