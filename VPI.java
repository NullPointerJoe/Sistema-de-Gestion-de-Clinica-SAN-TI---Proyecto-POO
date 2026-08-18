package ProyectoGUIGK;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VPI extends JFrame implements ActionListener{
    private Paciente Pa;
    private final JButton C, G;
    private JLabel l1;
    private final JTextField tn, tln, tp, tpt, tt, td, tm, ty;
    private final JTextArea ta;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VPI(){
        setLayout(null);
        setTitle("Paciente - Ingresar");
        
        l1 = new JLabel("Datos del paciente");
        l1.setBounds(165,0,130,30);
        l1.setFont(titulo);
        add(l1);

        l1 = new JLabel("Nombre:");
        l1.setBounds(25,35,100,30);
        add(l1);
        
        tn = new JTextField();
        tn.setBounds(100,40,100,20);
        add(tn);
        
        l1 = new JLabel("Cod. Postal:");
        l1.setBounds(25,75,100,30);
        add(l1);
		
        tpt = new JTextField();
        tpt.setBounds(100,80,100,20);
        add(tpt);

        l1 = new JLabel("Apellido:");
        l1.setBounds(265,35,100,30);
        add(l1);
		
        tln = new JTextField();
        tln.setBounds(325,40,100,20);
        add(tln);

        l1 = new JLabel("Provincia:");
        l1.setBounds(265,75,100,30);
        add(l1);
		
        tp = new JTextField();
        tp.setBounds(325,80,100,20);
        add(tp);
        
        l1 = new JLabel("Telefono:");
        l1.setBounds(265,115,100,30);
        add(l1);
        
        tt = new JTextField();
        tt.setBounds(325,120,100,20);
        add(tt);
        
        l1 = new JLabel("Dirección:");
        l1.setBounds(25,155,100,30);
        add(l1);
        
        ta = new JTextArea();
        ta.setBounds(100,160,320,40);
        add(ta);
        
        l1 = new JLabel("F. de nac.:");
        l1.setBounds(25,115,130,30);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(130,115,40,30);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(170,115,40,30);
        add(l1);
        
        td = new JTextField();
        td.setBounds(100,120,25,20);        
        add(td);
        tm = new JTextField();
        tm.setBounds(140,120,25,20);
        add(tm);
        ty = new JTextField();
        ty.setBounds(180,120,40,20);
        add(ty);
                
        G = new JButton("Guardar");
        G.setBounds(100,210,100,30);
        add(G);
        G.addActionListener(this);

        C = new JButton("Cancelar");
        C.setBounds(240,210,100,30);
        add(C);
        C.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C){
            int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(res == 0){
                dispose();
            }
        }else if(e.getSource() == G){
            if(tn.getText().isEmpty() & tln.getText().isEmpty() & ta.getText().isEmpty() & tp.getText().isEmpty() & tpt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningun dato.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                    //Paciente
                String n = tn.getText();
                String ln = tln.getText();
                String a = ta.getText();
                String p = tp.getText();
                int pt = Integer.parseInt(tpt.getText());
                int t = Integer.parseInt(tt.getText());
                    //Fecha de nacimiento
                int d = Integer.parseInt(td.getText());
                int m = Integer.parseInt(tm.getText());
                int y = Integer.parseInt(ty.getText());
                Pa = new Paciente(n, ln, a, p, pt, t, d, m, y);
                JOptionPane.showMessageDialog(null, "Datos Guardados.", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }
    
    public Paciente ObtenerDPA(){
        return Pa;
    }
}

class VPM extends JFrame implements ActionListener{
    private final JButton C;
    private JLabel l1;
    private final JTextField tn, tln, tp, tpt, tt, tf;
    private final JTextArea ta;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VPM(ArrayList<Paciente> LP, int cod){
        setLayout(null);
        setTitle("Paciente - Mostrar");
        
        Paciente Pa = null;
        for(Paciente P: LP){
            if(P.MostrarCod() == cod){Pa = P; break;}
        }
        
        l1 = new JLabel("Datos del paciente");
        l1.setBounds(165,0,130,30);
        l1.setFont(titulo);
        add(l1);

        l1 = new JLabel("Nombre:");
        l1.setBounds(25,35,100,30);
        add(l1);
        
        tn = new JTextField(Pa.MostrarN());
        tn.setBounds(100,40,100,20);
        tn.setEditable(false);
        tn.setFocusable(false);
        add(tn);
        
        l1 = new JLabel("Cod. Postal:");
        l1.setBounds(25,75,100,30);
        add(l1);
		
        tpt = new JTextField(String.valueOf(Pa.MostrarPt()));
        tpt.setBounds(100,80,100,20);
        tpt.setEditable(false);
        tpt.setFocusable(false);
        add(tpt);

        l1 = new JLabel("Apellido:");
        l1.setBounds(265,35,100,30);
        add(l1);
		
        tln = new JTextField(Pa.MostrarLn());
        tln.setBounds(325,40,100,20);
        tln.setEditable(false);
        tln.setFocusable(false);
        add(tln);

        l1 = new JLabel("Provincia:");
        l1.setBounds(265,75,100,30);
        add(l1);
		
        tp = new JTextField(Pa.MostrarP());
        tp.setBounds(325,80,100,20);
        tp.setEditable(false);
        tp.setFocusable(false);
        add(tp);
        
        l1 = new JLabel("Telefono:");
        l1.setBounds(265,115,100,30);
        add(l1);
        
        tt = new JTextField(String.valueOf(Pa.MostrarC()));
        tt.setBounds(325,120,100,20);
        tt.setEditable(false);
        tt.setFocusable(false);
        add(tt);
        
        l1 = new JLabel("Dirección:");
        l1.setBounds(25,155,100,30);
        add(l1);
        
        ta = new JTextArea(Pa.MostrarA());
        ta.setBounds(100,160,320,40);
        ta.setEditable(false);
        ta.setFocusable(false);
        add(ta);
        
        l1 = new JLabel("F. de nac.:");
        l1.setBounds(25,115,130,30);
        add(l1);
        
        tf = new JTextField(Pa.MostrarFN());
        tf.setBounds(100,120,70,20);
        tf.setEditable(false);
        tf.setFocusable(false);
        add(tf);

        C = new JButton("Atras");
        C.setBounds(180,210,100,30);
        add(C);
        C.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==C){
            dispose();
        }
    }
}

class VPMo extends JFrame implements ActionListener{
    private ArrayList<Paciente> LPa;
    private int VC;
    private final JButton C, G;
    private JLabel l1;
    private final JTextField tn, tln, tp, tpt, tt, td, tm, ty;
    private final JTextArea ta;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VPMo(ArrayList<Paciente> LP, int cod){
        setLayout(null);
        setTitle("Paciente - Modificar");
        LPa = LP;
        VC = cod;
        
        l1 = new JLabel("Datos del paciente");
        l1.setBounds(165,0,130,30);
        l1.setFont(titulo);
        add(l1);

        l1 = new JLabel("Nombre:");
        l1.setBounds(25,35,100,30);
        add(l1);
        
        tn = new JTextField();
        tn.setBounds(100,40,100,20);
        add(tn);
        
        l1 = new JLabel("Cod. Postal:");
        l1.setBounds(25,75,100,30);
        add(l1);
		
        tpt = new JTextField();
        tpt.setBounds(100,80,100,20);
        add(tpt);

        l1 = new JLabel("Apellido:");
        l1.setBounds(265,35,100,30);
        add(l1);
		
        tln = new JTextField();
        tln.setBounds(325,40,100,20);
        add(tln);

        l1 = new JLabel("Provincia:");
        l1.setBounds(265,75,100,30);
        add(l1);
		
        tp = new JTextField();
        tp.setBounds(325,80,100,20);
        add(tp);
        
        l1 = new JLabel("Telefono:");
        l1.setBounds(265,115,100,30);
        add(l1);
        
        tt = new JTextField();
        tt.setBounds(325,120,100,20);
        add(tt);
        
        l1 = new JLabel("Dirección:");
        l1.setBounds(25,155,100,30);
        add(l1);
        
        ta = new JTextArea();
        ta.setBounds(100,160,320,40);
        add(ta);
        
        l1 = new JLabel("F. de nac.:");
        l1.setBounds(25,115,130,30);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(130,115,40,30);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(170,115,40,30);
        add(l1);
        
        td = new JTextField();
        td.setBounds(100,120,25,20);        
        add(td);
        tm = new JTextField();
        tm.setBounds(140,120,25,20);
        add(tm);
        ty = new JTextField();
        ty.setBounds(180,120,40,20);
        add(ty);
                
        G = new JButton("Guardar");
        G.setBounds(100,210,100,30);
        add(G);
        G.addActionListener(this);

        C = new JButton("Cancelar");
        C.setBounds(240,210,100,30);
        add(C);
        C.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C){
            int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(res == 0){
                dispose();
            }
        }else if(e.getSource() == G){
            if(tn.getText().isEmpty() & tln.getText().isEmpty() & ta.getText().isEmpty() & tp.getText().isEmpty() & tpt.getText().isEmpty() & tt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningun dato.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Paciente Pa = null;
                int Con = 0;
                for(Paciente P: LPa){
                    if(P.MostrarCod() == VC){
                        Pa = P; break;
                    }
                    Con++;
                }
                    //Paciente
                String n = tn.getText();
                String ln = tln.getText();
                String a = ta.getText();
                String p = tp.getText();
                int pt = Integer.parseInt(tpt.getText());
                int t = Integer.parseInt(tt.getText());
                    //Fecha de nacimiento
                int d = Integer.parseInt(td.getText());
                int m = Integer.parseInt(tm.getText());
                int y = Integer.parseInt(ty.getText());
                Pa.ModNameLn(n, ln);
                Pa.ModA(a);
                Pa.ModP(p);
                Pa.ModPt(pt);
                Pa.ModC(t);
                Pa.ModFN(d, m, y);
                LPa.set(Con, Pa);
                JOptionPane.showMessageDialog(null, "Datos Guardados.", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }
    
    public ArrayList<Paciente> ObtenerLP(){
        return LPa;
    }
}
