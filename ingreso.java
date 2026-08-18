package ProyectoGUIGK;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class ingreso extends DatosContactos{
    private final int cod;
    private int cod_paciente;
    private int cod_medico;
    private int num_hab;
    private int num_bed;
    private GregorianCalendar calendario;
    private Date Fecha;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String fechaI;
    private static int codsig = 1;
	
    public ingreso(int cp, int cm, int h, int b, int dd, int mm, int yy, String n, String a, int c){
        super(cp, n, a, c);
        cod = codsig;
        cod_paciente = cp;
        cod_medico = cm;
        num_hab = h;
        num_bed = b;
        calendario = new GregorianCalendar(yy, mm - 1, dd);
        Fecha = calendario.getTime();
        fechaI = sdf.format(Fecha);
        codsig++;
    }

    public void ModCMe(int cod){
        this.cod_medico = cod;
    }

    public void ModNH(int h){
        this.num_hab = h;
    }

    public void ModNB(int b){
        this.num_bed = b;
    }

    public void ModFI(int d, int m, int a){
        m--;
        calendario.set(a, m, a);
        this.Fecha = calendario.getTime();
        this.fechaI = sdf.format(Fecha);
    }

    public int MostrarCodI(){
        return cod;
    }
    
    public int MostrarCodPa(){
        return cod_paciente;
    }

    public int MostrarCMe(){
        return cod_medico;
    }

    public int MostrarNH(){
        return num_hab;
    }

    public int MostrarNB(){
        return num_bed;
    }

    public String MostrarFI(){
        return fechaI;
    }
}