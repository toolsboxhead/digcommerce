package com.ecommerce.specommerce.model;

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio_unit;
    private String imagen;
    private int cantidad;
    private String unidad;



    
    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, double precio_unit, int cantidad, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_unit = precio_unit;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unit() {
        return precio_unit;
    }

    public void setPrecio_unit(double precio_unit) {
        this.precio_unit = precio_unit;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio_unit="
                + precio_unit + ", imagen=" + imagen + ", cantidad=" + cantidad + ", unidad=" + unidad + "]";
    }
    

    
}
