/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author giron
 */
public class clsPeliculas {
    int idPeliculas;
    private String Nombre, Clasificacion, Genero, Subtitulado, Idioma;
    private Double precio;

    public clsPeliculas(int idPeliculas, String Nombre, String Clasificacion, String Genero, String Subtitulado, String Idioma, Double precio) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
        this.Clasificacion = Clasificacion;
        this.Genero = Genero;
        this.Subtitulado = Subtitulado;
        this.Idioma = Idioma;
        this.precio = precio;      
    }
    public clsPeliculas(){
    }

    public int getIdPeliculas() {
        return idPeliculas;
    }

    public void setIdPeliculas(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getSubtitulado() {
        return Subtitulado;
    }

    public void setSubtitulado(String Subtitulado) {
        this.Subtitulado = Subtitulado;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "clsPeliculas{" + "idPeliculas=" + idPeliculas + ", Nombre=" + Nombre + ", Clasificacion=" + Clasificacion + ", Genero=" + Genero + ", Subtitulado=" + Subtitulado + ", Idioma=" + Idioma + ", precio=" + precio + '}';
    }
}
