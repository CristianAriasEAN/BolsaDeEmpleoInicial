/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�a de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 19 de septiembre de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes <br>
 * <b>inv: </b> <br>
 * aspirantes != null <br>
 * En el vector de aspirantes no hay dos o m�s con el mismo nombre
 */
public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    public final static String URL_BASE_DATOS = "jdbc:h2:file:./data/bolsadeempleo";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la tabla que contiene todos los aspirantes
     */
    private Dao<Aspirante, Integer> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de empleo a partir de la base de datos.
     */
    public BolsaDeEmpleo() {
        ConnectionSource conexion = null;
        try {
            // Creamos la conexi�n a la base de datos
            conexion = new JdbcConnectionSource(URL_BASE_DATOS);

            // Y ahora traemos los datos que est�n en la tabla
            aspirantes = DaoManager.createDao(conexion, Aspirante.class);

            // Creamos la tabla, si no existe
            TableUtils.createTableIfNotExists(conexion, Aspirante.class);

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Permite cerrar base de datos
     * @throws Exception cualquier error que pueda ocurrir
     */
    public void cerrarBaseDatos() throws Exception {
        aspirantes.getConnectionSource().close();
    }

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public List<Aspirante> darAspirantes() {
        List<Aspirante> copia = new ArrayList<>();
        try {
            for (Aspirante a : aspirantes.queryForAll()) {
                copia.add(a);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     * @return Se retorn� true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(int cedula, String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA) throws SQLException {
        Aspirante aspiranteBuscado = buscarAspirante(cedula);
        boolean agregado = false;
        if (aspiranteBuscado == null) {
            Aspirante nuevoAspirante = new Aspirante(cedula, nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
            aspirantes.create(nuevoAspirante);
            agregado = true;
        }

        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        // TODO: Realizar el ejercicio correspondiente
    }

    /**
     * Retorna la cantidad de aspirantes que tienen m�s de la edad
     * que se pasa como par�metro.
     */
    public int contarPorEdad(int edad) {
        // TODO: Realizar el ejercicio correspondiente
        return 0;
    }

    /**
     * Obtiene la cantidad de aspirantes que pertenecen a la profesi�n
     * que se pasa como par�metro.
     */
    public int contarPorProfesion(String profesion) {
        // TODO: Realizar el ejercicio correspondiente
        return 0;
    }

    /**
     * Obtiene el promedio de los a�os de experiencia de todos los aspirantes
     */
    public double promedioAniosExperiencia() {
        // TODO: Realizar el ejercicio correspondiente
        return 0.0;
    }

    /**
     * Busca un Aspirante seg�n su c�dula y retorna el aspirante con esa c�dula
     * o null si no lo encontr�.
     */
    public Aspirante buscarAspirante(int cedula) throws SQLException {
        Aspirante aspirante = null;

        // TODO: B�squeda de aspirantes por c�dula

        return aspirante;
    }

    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     */
    public Aspirante buscarAspiranteMasJoven() {
        // TODO: Realizar el ejercicio correspondiente
        return null;
    }

    /**
     * Retorna la c�dula aspirante que tenga la mayor edad en la bolsa.
     */
    public int buscarAspiranteMayorEdad() {
        int cedula = -1;

        // TODO: Realizar el ejercicio correspondiente

        return cedula;
    }

    /**
     * Busca la c�dula del aspirante con m�s a�os de experiencia en la bolsa.
     */
    public int buscarAspiranteMayorExperiencia() {
        int cedula = -1;

        // TODO: Realizar el ejercicio correspondiente

        return cedula;
    }

    /**
     * Contrata a un aspirante.<br>
     * Es decir, se elimin� el aspirante de la lista de aspirantes.

     * @return Se retorn� true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) throws Exception {
        boolean contratado = false;

        // TODO: Realizar el ejercicio correspondiente

        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos a�os de experiencia <br>
     * son menores a la cantidad de a�os especificada <br>
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) throws Exception {
        int eliminados = 0;

        int cont = 0;

        // TODO: Realizar el ejercicio correspondiente

        return eliminados;
    }

}