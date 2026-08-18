package ProyectoGUIGK;

public class DatosContactos{
    private final int codp;
    private String name;
    private String address;
    private int cell;

    public DatosContactos(int cp, String n, String a, int c){
        codp = cp;
        name = n;
        address = a;
        cell = c;
    }

    public void ModN(String n){
        this.name = n;
    }

    public void ModA(String a){
        this.address = a;
    }

    public void ModC(int c){
        this.cell = c;
    }

    public String MostrarN(){
        return name;
    }

    public String MostrarA(){
        return address;
    }

    public int MostrarC(){
        return cell;
    }
}
