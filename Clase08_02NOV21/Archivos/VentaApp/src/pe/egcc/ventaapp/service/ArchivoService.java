package pe.egcc.ventaapp.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import pe.egcc.ventaapp.dto.ProductoDto;
import pe.egcc.ventaapp.dto.VentaDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ArchivoService {

	private final String RUTA = "E:\\Archivos";
	private final String ARCHIVO_CATEGORIAS = RUTA + "\\CATEGORIAS.TXT";
	private final String ARCHIVO_PRODUCTOS = RUTA + "\\PRODUCTOS.TXT";
	private final String ARCHIVO_VENTAS = RUTA + "\\VENTAS.TXT";
	
	/**
	 * Carga el contenido de todos los archivos en memoria.
	 */
	public void cargaDeArchivos(){
		System.out.println("INICIO DE PROCESO DE CARGA");
		cargarCategorias();
		cargarProductos();
		cargarVentas();
		System.out.println("FIN DE PROCESO DE CARGA");
	}

	/**
	 * Verifica si un archivo existe.
	 * @param nombre Nombre del archivo.
	 * @return Retorna true o false.
	 */
	public boolean existe(String nombre) {
		File archivo = new File(nombre);
		boolean existe = archivo.exists();
		if (existe) {
			existe = archivo.isFile();
		}
		return existe;
	}

	/**
	 * Crea el archivo de categorias, con las caterias respectivas.
	 */
	public void creaArchivoCategorias() {
		if (existe(ARCHIVO_CATEGORIAS)) {
			return;
		}
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(ARCHIVO_CATEGORIAS);
			printStream.println("BEBIDAS");
			printStream.println("ABARROTES");
			printStream.println("LACTEOS");
			printStream.println("FRUTAS");
			printStream.println("SNACKS");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				printStream.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Carga las categorias en memoria, desde el archivo.
	 */
	public void cargarCategorias() {
		System.out.println("Carga de categorias.");
		if (!existe(ARCHIVO_CATEGORIAS)) {
			creaArchivoCategorias();
		}
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(ARCHIVO_CATEGORIAS);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Datos.categorias.clear();
			String linea = bufferedReader.readLine();
			while (linea != null) {
				linea = linea.trim().toUpperCase();
				if (linea.length() > 0) {
					Datos.categorias.add(linea);
				}
				linea = bufferedReader.readLine();
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				fileReader.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Crea el archivo de productos, con varios productos por categoria.
	 */
	public void creaArchivoProductos() {
		if (existe(ARCHIVO_PRODUCTOS)) {
			return;
		}
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(ARCHIVO_PRODUCTOS);
			printStream.println("BEBIDAS;7UP;3");
			printStream.println("BEBIDAS;COCA COLA;4");
			printStream.println("BEBIDAS;FANTA;3");
			printStream.println("BEBIDAS;GUARANA;2");
			printStream.println("BEBIDAS;INKA KOLA;4");
			printStream.println("ABARROTES;ARROZ COSTEÑO 5KG;18");
			printStream.println("ABARROTES;ACEITE PRIMOR;8");
			printStream.println("ABARROTES;AZUCAR 1KG;3");
			printStream.println("ABARROTES;MERMELADA DE FRESA 200GR;5");
			printStream.println("ABARROTES;FILETE DE ATUN;5");
			printStream.println("LACTEOS;PEZIDURI 1LT;16");
			printStream.println("LACTEOS;LECHE GLORIA LATA GRANDE;3");
			printStream.println("LACTEOS;MANTEQUILLA GLORIA 400GR;15");
			printStream.println("LACTEOS;QUEZO MOZARELLA 200GR;11");
			printStream.println("LACTEOS;YOGURT GLORIA 1LT;6");
			printStream.println("FRUTAS;PERA POR KILO;8");
			printStream.println("FRUTAS;MANZANA POR KILO;7");
			printStream.println("FRUTAS;MANDARINA POR KILO;6");
			printStream.println("FRUTAS;FRESA POR KILO;10");
			printStream.println("FRUTAS;PLATANO POR KILO;4");
			printStream.println("SNACKS;CHIZITOS POR BOLSA;3");
			printStream.println("SNACKS;DORITOS POR BOLSA;2");
			printStream.println("SNACKS;PAPAS LAYS POR BOLSA;3");
			printStream.println("SNACKS;PIQUEO SNAX POR BOLSA;2");
			printStream.println("SNACKS;TOR-TEES POR BOLSA;2");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				printStream.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Carga los productos en memoria desde el archivo.
	 */
	public void cargarProductos() {
		System.out.println("Carga de productos.");
		if (!existe(ARCHIVO_PRODUCTOS)) {
			creaArchivoProductos();
		}
		FileReader fileReader = null;
		ProductoDto dto = null;
		String[] registro;
		try {
			fileReader = new FileReader(ARCHIVO_PRODUCTOS);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Datos.productos.clear();
			String linea = bufferedReader.readLine();
			while (linea != null) {
				linea = linea.trim().toUpperCase();
				if (linea.length() > 0) {
					dto = new ProductoDto();
					registro = linea.split(";");
					dto.setCategoria(registro[0]);
					dto.setProducto(registro[1]);
					dto.setPrecio(Integer.parseInt(registro[2]));
					Datos.productos.add(dto);
				}
				linea = bufferedReader.readLine();
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				fileReader.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Crea el archivo de ventas con algunas ventas por defecto.
	 */
	public void creaArchivoVentas() {
		if (existe(ARCHIVO_VENTAS)) {
			return;
		}
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(ARCHIVO_VENTAS);
			printStream.println("BEBIDAS;7UP;3;3;9");
			printStream.println("BEBIDAS;7UP;3;4;12");
			printStream.println("ABARROTES;ACEITE PRIMOR;8;3;24");
			printStream.println("ABARROTES;ACEITE PRIMOR;8;2;16");
			printStream.println("LACTEOS;PEZIDURI 1LT;16;2;32");
			printStream.println("LACTEOS;PEZIDURI 1LT;16;3;48");
			printStream.println("FRUTAS;MANZANA POR KILO;7;3;21");
			printStream.println("FRUTAS;MANZANA POR KILO;7;5;35");
			printStream.println("FRUTAS;FRESA POR KILO;10;2;20");
			printStream.println("FRUTAS;FRESA POR KILO;10;3;30");
			printStream.println("SNACKS;DORITOS POR BOLSA;2;5;10");
			printStream.println("SNACKS;DORITOS POR BOLSA;2;2;4");
			printStream.println("SNACKS;DORITOS POR BOLSA;2;7;14");
			printStream.println("SNACKS;PAPAS LAYS POR BOLSA;3;3;9");
			printStream.println("SNACKS;PAPAS LAYS POR BOLSA;3;4;12");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				printStream.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Carga las ventas en memoria desde el archivo.
	 */
	public void cargarVentas() {
		System.out.println("Carga de ventas.");
		if (!existe(ARCHIVO_VENTAS)) {
			creaArchivoVentas();
		}
		FileReader fileReader = null;
		VentaDto dto = null;
		String[] registro;
		try {
			fileReader = new FileReader(ARCHIVO_VENTAS);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Datos.ventas.clear();
			String linea = bufferedReader.readLine();
			while (linea != null) {
				linea = linea.trim().toUpperCase();
				if (linea.length() > 0) {
					dto = new VentaDto();
					registro = linea.split(";");
					dto.setCategoria(registro[0]);
					dto.setProducto(registro[1]);
					dto.setPrecio(Integer.parseInt(registro[2]));
					dto.setCantidad(Integer.parseInt(registro[3]));
					dto.setImporte(Integer.parseInt(registro[4]));
					Datos.ventas.add(dto);
				}
				linea = bufferedReader.readLine();
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				fileReader.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Agrega una venta en el archivo.
	 * @param dto Datos de la venta.
	 */
	public void registrarVenta(VentaDto dto) {
		if (!existe(ARCHIVO_PRODUCTOS)) {
			creaArchivoProductos();
		}
		PrintStream printStream = null;
		try {
			FileOutputStream stream = new FileOutputStream(ARCHIVO_VENTAS, true);
			printStream = new PrintStream(stream);
			printStream.println(dto.toString());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				printStream.close();
			} catch (Exception e) { }
		}
	}
}
