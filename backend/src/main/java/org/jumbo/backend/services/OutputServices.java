package org.jumbo.backend.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class OutputServices {

	public static String extractDbtToShp(List<String> choicedColumns, String table, String host, String user,
			String database, String password) throws Exception {
		
		System.out.println("\tIniciando processo de extração");

		String palavraAleatoria = new Random().ints(48, 122 + 1).filter(i -> (i <= 57 || i >= 97)).limit(10)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		String pastaCriada = System.getProperty("user.dir") + "\\jumbo_despacha\\" + palavraAleatoria;

		System.out.println("\tCriando diretório para receber os arquivos extraídos");
		
		Files.createDirectories(Paths.get(pastaCriada));
		
		System.out.printf("\tDiretório criado: %s\n", pastaCriada);
		
		String deParaSaida = writeSqlExtract(choicedColumns);
		String endDespacho = pastaCriada + "\\" + table + ".shp";

		Ogr2ogrServices.dbtToShp(host, user, database, password, endDespacho, deParaSaida, table);

		Thread.sleep(2 * 1000);

		ZipServices.zipDirectory(pastaCriada, palavraAleatoria);

		FileUtils.deleteDirectory(new File(pastaCriada));

		String saida = System.getProperty("user.dir") + "\\jumbo_despacha\\" + palavraAleatoria + ".zip";

		return saida;

	}

	public static String writeSqlExtract(List<String> choicedColumns) {
		String saida = "Select ";
		for (String coluna : choicedColumns) {
			saida = saida + coluna + ", ";
		}
		saida = saida.substring(0, saida.length() - 1);
		saida = saida + " geom";

		return saida;
	}
}
