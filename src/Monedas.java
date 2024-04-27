import com.google.gson.annotations.SerializedName;

public class Monedas {


    @SerializedName("base_code")
    private String divisaOrigen; //base_code


    public String getNombre() {
        return divisaOrigen;
    }

    public void setNombre(String nombre) {
        this.divisaOrigen = nombre; //Aquí es donde hay que ir cambiando la divisa origen
    }

    @Override
    public String toString() {
        return "Divisa Origen = " + divisaOrigen+ '\n';
    }
}
