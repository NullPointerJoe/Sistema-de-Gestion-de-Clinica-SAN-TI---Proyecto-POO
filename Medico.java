package ProyectoGUIGK;

public class Medico{
    private final int cod;
    private static int codsigt = 1;
    private String name;
    private String lastn;
    private String address;
    private int cell;
    private String especialidad;
        
    public Medico(String n, String ln, String a, int c, String e){
        cod = codsigt;
        name = n;
        lastn = ln;
        address = a;
        cell = c;
        especialidad = e;
        codsigt++;
    }

    public void ModNM(String n){
        this.name = n;
    }

    public void ModLnM(String Ln){
        this.lastn = Ln;
    }

    public void ModAM(String a){
        this.address = a;
    }

    public void ModCM(int a){
        this.cell = a;
    }

    public void ModE(String e){
        this.especialidad = e;
    }

    public int MostrarCodM(){
        return cod;
    }

    public String MostrarNM(){
        return name;
    }

    public String MostrarLnM(){
        return lastn;
    }

    public String MostrarAM(){
        return address;
    }
	
    public int MostrarCM(){
        return cell;
    }

    public String MostrarEM(){
        return especialidad;
    }
}