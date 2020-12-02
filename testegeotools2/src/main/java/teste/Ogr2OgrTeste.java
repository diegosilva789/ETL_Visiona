package teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ogr2OgrTeste {

	public static void main(String[] args) throws IOException {

		try {
			Process process = Runtime.getRuntime().exec("C:\\OSGeo4W64\\bin\\ogr2ogr.exe -f "
					+ "\"PostgreSQL\" " 
						// Converterá para postgis
					+ "-nlt MULTIPOINT " 
						// Converterá para o tipo suportado
					+ "-append -fieldmap -1,-1,3,-1,5,-1 " 
						// Exemplo de parametrização: 
						// O arquivo que será carregado possui 6 colunas.
						// Para cada coluna eu defino a possição na tabela do banco.
						// A coluna 0, não coloquei em nenhum lugar então recebe -1,
						// A coluna 1 -> -1
						// A coluna 2 será colocada na coluna 3 da tabela do banco
						// A coluna 3 -> -1
						// A coluna 4 -> A coluna 5
						// A coluna 5 -> -1
					+ "\"PG:host=127.0.0.1 user=postgres dbname=meuteste password=postgres\" " 
						// Conexão com o banco
					+ "\"D:\\\\geoft_bho_2017_ponto_drenagem.shp\""); 
						// Arquivo selecionado para inserção no banco
			
			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				System.exit(0);
			} else {
				//abnormal...
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
