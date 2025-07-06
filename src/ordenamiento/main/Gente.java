package ordenamiento.main;



public class Gente implements Comparable<Gente> {
    private int NumeroSS,peso,altura,edad;
    private String nombre;



    public int getNss() {
        return NumeroSS;
    }

    public void setNss(int nss) {
        NumeroSS = nss;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Gente o) {
        if(NumeroSS<o.getNss()){
            return -1;
        }
        if(NumeroSS>o.getNss()){
            return 1;
        }
        return 0;
    }
}
