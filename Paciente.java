package ProyectoGUIGK;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Paciente{
    private final int cod;
    private String name;
    private String lastn;
    private String address;
    private String provincia;
    private int postal;
    private int cell;
    private GregorianCalendar calendario;
    private Date Fecha;
    private SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private String fechaNa;
    private static int codsigt = 1;

    public Paciente(String n, String ln, String a, String p, int pt, int c, int dd, int mm, int yy){
        cod = codsigt;
        name = n;
        lastn = ln;
        address = a;
        provincia = p;
        postal = pt;
        cell = c;
        calendario = new GregorianCalendar(yy, mm - 1, dd);
        Fecha = calendario.getTime();
        fechaNa = F.format(Fecha);
        codsigt++;
    }

    public void ModNameLn(String n, String Ln){
        this.name = n;
        this.lastn = Ln;
    }

    public void ModA(String a){
        this.address = a;
    }

    public void ModP(String p){
        this.provincia = p;
    }

    public void ModPt(int pt){
        this.postal = pt;
    }

    public void ModC(int a){
        this.cell = a;
    }

    public void ModFN(int d, int m, int a){
        m--;
        calendario.set(a, m, d);
        this.Fecha = calendario.getTime();
        this.fechaNa = F.format(Fecha);
    }

    public int MostrarCod(){
        return cod;
    }

    public String MostrarN(){
        return name;
    }

    public String MostrarLn(){
        return lastn;
    }
	
    public String MostrarA(){
        return address;
    }

    public String MostrarP(){
        return provincia;
    }

    public int MostrarPt(){
        return postal;
    }

    public int MostrarC(){
        return cell;
    }

    public String MostrarFN(){
        return fechaNa;
    }
}