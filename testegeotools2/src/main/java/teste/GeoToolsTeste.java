package teste;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;

public class GeoToolsTeste {

	public static void main(String[] args) throws Exception {

		File file = new File("D:\\OneDrive - Etec Centro Paula Souza\\Área de Trabalho\\3sem"
				+ "\\pi\\testes\\dados\\AGENCIA_NACIONAL_AGUAS\\geoft_bho_2017_ponto_drenagem.shp");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", file.toURI().toURL());

		DataStore dataStore = DataStoreFinder.getDataStore(map);
		String typeName = dataStore.getTypeNames()[0];

		FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
		Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);

//		try (FeatureIterator<SimpleFeature> features = collection.features()) {
//			while (features.hasNext()) {
//				SimpleFeature feature = features.next();
//	            System.out.print(feature.getID());
//	            System.out.print(": ");
//	            System.out.println(feature.getDefaultGeometryProperty().getValue());
//	            System.out.println(feature.getProperties());
//			}
//		}

		String delimitador = ", ";
		int tamanho = 0;
		ArrayList<ArrayList<String>> tabela = new ArrayList<>();
		ArrayList<String> indice = new ArrayList<>();

		try (FeatureIterator<SimpleFeature> features = collection.features()) {
			while (features.hasNext()) {
				SimpleFeature feature = features.next();
				System.out.println("");
				System.out.print(tamanho + ": ");
				indice.add(Integer.toString(tamanho));
				int x = 0;
				for (Property attribute : feature.getProperties()) {
					System.out.print(attribute.getValue());
					indice.add(String.valueOf(attribute.getValue()));
					if (x < feature.getProperties().size() - 1) {
						System.out.print(delimitador);
					}
					x++;
//					if (x > feature.getProperties().size() - 2) {
//						break;
//					}
				}
				tabela.add(indice);
				System.out.println("");
				tamanho++;
			}
		}

//		try (FeatureIterator<SimpleFeature> features = collection.features()) {
//			FileWriter myWriter = new FileWriter("D:\\OneDrive - Etec Centro Paula Souza\\Área de Trabalho\\3sem"
//					+ "\\pi\\testes\\dados\\AGENCIA_NACIONAL_AGUAS\\filename_1.txt");
//			while (features.hasNext()) {
//				SimpleFeature feature = features.next();
//				myWriter.write("");
//				myWriter.write(tamanho + ": ");
//				int x = 0;
//				for (Property attribute : feature.getProperties()) {
//					String s = (attribute.getValue()).toString();  
//					myWriter.write(s);
//					if (x < feature.getProperties().size() - 1) {
//						myWriter.write(delimitador);
//					}
//					x++;
//				}
//				myWriter.write("\n");
//				tamanho++;
//			}
//			myWriter.close();
//		} catch (IOException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
		
		// Nao esta funcionando
//		try {
//			FileWriter myWriter = new FileWriter("D:\\OneDrive - Etec Centro Paula Souza\\Área de Trabalho\\3sem"
//					+ "\\pi\\testes\\dados\\AGENCIA_NACIONAL_AGUAS\\filename_1.txt");
//			for (int i = 0; i < tabela.size(); i++) {
//				String s = (tabela.get(i)).toString();  
//				myWriter.write(s);
//				myWriter.write("\n");
//			}
//			myWriter.close();
//			System.out.println("Successfully wrote to the file.");
//		} catch (IOException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}

		// Nao esta funcionando
//		for (ArrayList<String> u : tabela) {
//			for (String i : u) {
//				System.out.print(i + " ");	
//			}
//		}
	}
}