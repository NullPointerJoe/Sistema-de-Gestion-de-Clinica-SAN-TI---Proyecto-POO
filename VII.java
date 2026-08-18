package ProyectoGUIGK;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VII extends JFrame implements ActionListener{
    private ingreso In;
    private final JButton C, G;
    private JLabel l1;
    private final JTextField TH, TB, TD, TME, TY, TN, TT;
    private final JTextArea TDI;
    private final JComboBox<String> Medico, Paciente;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VII(ArrayList<Medico> LM, ArrayList<Paciente> LP){
        setLayout(null);
        setTitle("Control de ingreso - ingresar");
        
        l1 = new JLabel("Datos de ingreso");
        l1.setBounds(180,10,150,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Paciente:");
        l1.setBounds(25,45,80,20);
        add(l1);
        
        Paciente = new JComboBox<>();
        for(Paciente p : LP){
            Paciente.addItem("Cod: "+p.MostrarCod()+", "+p.MostrarN()+" "+p.MostrarLn());
        }
        Paciente.setBounds(100, 45, 340, 20);
        add(Paciente);
        
        l1 = new JLabel("Medico:");
        l1.setBounds(25,80,80,20);
        add(l1);
        
        Medico = new JComboBox<>();
        for (Medico m : LM) {
            Medico.addItem("Cod: "+m.MostrarCodM()+", "+m.MostrarNM()+" "+m.MostrarLnM());
        }
        Medico.setBounds(100, 80, 340, 20);
        add(Medico);
        
        l1 = new JLabel("N° Habitación:");
        l1.setBounds(25,115,80,20);
        add(l1);
        
        TH = new JTextField();
        TH.setBounds(110,115,80,20);
        add(TH);
        
        l1 = new JLabel("N° cama:");
        l1.setBounds(220,115,80,20);
        add(l1);
        
        TB = new JTextField();
        TB.setBounds(280,115,80,20);
        add(TB);
        
        l1 = new JLabel("F. de ingreso:");
        l1.setBounds(25,150,80,20);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(140,150,40,20);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(180,150,40,20);
        add(l1);
        
        TD = new JTextField();
        TD.setBounds(110,150,25,20);        
        add(TD);
        TME = new JTextField();
        TME.setBounds(150,150,25,20);
        add(TME);
        TY = new JTextField();
        TY.setBounds(190,150,40,20);
        add(TY);
        
        l1 = new JLabel("Contactos de emergencia");
        l1.setBounds(155,185,180,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Nombre:");
        l1.setBounds(25,220,80,20);
        add(l1);
        
        TN = new JTextField();
        TN.setBounds(85, 220, 150, 20);
        add(TN);
        
        l1 = new JLabel("Teléfono:");
        l1.setBounds(250,220,80,20);
        add(l1);
        
        TT = new JTextField();
        TT.setBounds(315, 220, 80, 20);
        add(TT);
        
        l1 = new JLabel("Dirección:");
        l1.setBounds(25,255,80,20);
        add(l1);
        
        TDI = new JTextArea();
        TDI.setBounds(85, 255, 340, 40);
        add(TDI);
        
        G = new JButton("Guardar");
        G.setBounds(120,300,100,30);
        G.addActionListener(this);
        add(G);
        
        C = new JButton("Cancelar");
        C.setBounds(240,300,100,30);        
        C.addActionListener(this);
        add(C);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C ){
            int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(res == 0){
                dispose();
            }
        }else if(e.getSource() == G){
            if(TH.getText().isEmpty() & TB.getText().isEmpty() & TN.getText().isEmpty() & TT.getText().isEmpty() & TDI.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningun dato.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String Me = (String) Medico.getSelectedItem();
                int codM = Integer.parseInt(Me.substring(Me.indexOf(":") + 2, Me.indexOf(",")));
                String Pa = (String) Paciente.getSelectedItem();
                int codP = Integer.parseInt(Pa.substring(Pa.indexOf(":") + 2, Pa.indexOf(",")));
                String n = TN.getText();
                String a = TDI.getText();
                int h = Integer.parseInt(TH.getText());
                int b = Integer.parseInt(TB.getText());
                int t = Integer.parseInt(TT.getText());
                int d = Integer.parseInt(TD.getText());
                int m = Integer.parseInt(TME.getText());
                int y = Integer.parseInt(TY.getText());
                In = new ingreso(codP, codM, h, b, d, m, y, n, a, t);
                JOptionPane.showMessageDialog(null, "Datos Guardados.", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }
    
    public ingreso ObtenerIn(){
        return In;
    }
}

class VIM extends JFrame implements ActionListener{
    private final JButton C;
    private JLabel l1;
    private final JTextField TM, TP, TH, TB, TF, TN, TT;
    private final JTextArea TDI;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VIM(ArrayList<ingreso> LI, ArrayList<Paciente> LP, ArrayList<Medico> LM, int cod){
        setLayout(null);
        setTitle("Control de ingreso - Mostrar");
        
        ingreso In = null;
        for(ingreso i: LI){if(i.MostrarCodI()== cod){In = i; break;}}
        Medico Me = null;
        for(Medico m: LM){if(m.MostrarCodM() == In.MostrarCMe()){Me = m; break;}}
        Paciente Pa = null;
        for(Paciente p: LP){if(p.MostrarCod()== In.MostrarCodPa()){Pa = p; break;}}
        
        l1 = new JLabel("Datos de ingreso");
        l1.setBounds(180,10,150,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Paciente:");
        l1.setBounds(25,45,80,20);
        add(l1);
        
        TP = new JTextField(Pa.MostrarN()+" "+Pa.MostrarLn());
        TP.setBounds(100, 45, 340, 20);
        TP.setEditable(false);
        TP.setFocusable(false);
        add(TP);
        
        l1 = new JLabel("Medico:");
        l1.setBounds(25,80,80,20);
        add(l1);
        
        TM = new JTextField(Me.MostrarNM()+" "+ Me.MostrarLnM());
        TM.setBounds(100, 80, 340, 20);
        TM.setEditable(false);
        TM.setFocusable(false);
        add(TM);
        
        l1 = new JLabel("N° Habitación:");
        l1.setBounds(25,115,80,20);
        add(l1);
        
        TH = new JTextField(String.valueOf(In.MostrarNH()));
        TH.setBounds(110,115,80,20);
        TH.setEditable(false);
        TH.setFocusable(false);
        add(TH);
        
        l1 = new JLabel("N° cama:");
        l1.setBounds(220,115,80,20);
        add(l1);
        
        TB = new JTextField(String.valueOf(In.MostrarNB()));
        TB.setBounds(280,115,80,20);
        TB.setEditable(false);
        TB.setFocusable(false);
        add(TB);
        
        l1 = new JLabel("F. de ingreso:");
        l1.setBounds(25,150,80,20);
        add(l1);
        
        TF = new JTextField(In.MostrarFI());
        TF.setBounds(110,150,70,20);
        TF.setEditable(false);
        TF.setFocusable(false);
        add(TF);
        
        l1 = new JLabel("Contactos de emergencia");
        l1.setBounds(155,185,180,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Nombre:");
        l1.setBounds(25,220,80,20);
        add(l1);
        
        TN = new JTextField(In.MostrarN());
        TN.setBounds(85, 220, 150, 20);
        TN.setEditable(false);
        TN.setFocusable(false);
        add(TN);
        
        l1 = new JLabel("Teléfono:");
        l1.setBounds(250,220,80,20);
        add(l1);
        
        TT = new JTextField(String.valueOf(In.MostrarC()));
        TT.setBounds(315, 220, 80, 20);
        TT.setEditable(false);
        TT.setFocusable(false);
        add(TT);
        
        l1 = new JLabel("Dirección:");
        l1.setBounds(25,255,80,20);
        add(l1);
        
        TDI = new JTextArea(In.MostrarA());
        TDI.setBounds(85, 255, 340, 40);
        TDI.setEditable(false);
        TDI.setFocusable(false);
        add(TDI);
        
        C = new JButton("Atras");
        C.setBounds(190,300,100,30);        
        C.addActionListener(this);
        add(C);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C ){
            dispose();
        }
    }
}

class VIMO extends JFrame implements ActionListener{
    private ArrayList<ingreso> ListaI;
    private int ICod;
    private String TextN;
    private final JButton C, G;
    private JLabel l1;
    private final JTextField TP, TH, TB, TD, TME, TY, TN, TT;
    private final JTextArea TDI;
    private final JComboBox<String> Medico;
    private final Font titulo = new Font("A",Font.ITALIC,15);
    
    public VIMO(ArrayList<ingreso> LI, ArrayList<Medico> LM, ArrayList<Paciente> LP, int cod){
        setLayout(null);
        setTitle("Control de ingreso - Modificar");
        ListaI = LI;
        ICod = cod;
        ingreso In = null;
        for(ingreso i: LI){if(i.MostrarCodI() == cod){In = i;}}
        for (Paciente p: LP) {
            if(p.MostrarCod() == In.MostrarCodPa()){
                TextN = "Cod: "+p.MostrarCod()+", "+p.MostrarN()+" "+p.MostrarLn();
            }
        }
        
        l1 = new JLabel("Datos de ingreso");
        l1.setBounds(180,10,150,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Paciente:");
        l1.setBounds(25,45,80,20);
        add(l1);
        
        TP = new JTextField(TextN);
        TP.setBounds(100, 45, 340, 20);
        TP.setEditable(false);
        add(TP);
        
        l1 = new JLabel("Medico:");
        l1.setBounds(25,80,80,20);
        add(l1);
        
        Medico = new JComboBox<>();
        for (Medico m : LM) {
            Medico.addItem("Cod: "+m.MostrarCodM()+", "+m.MostrarNM()+" "+m.MostrarLnM());
        }
        Medico.setBounds(100, 80, 340, 20);
        add(Medico);
        
        l1 = new JLabel("N° Habitación:");
        l1.setBounds(25,115,80,20);
        add(l1);
        
        TH = new JTextField();
        TH.setBounds(110,115,80,20);
        add(TH);
        
        l1 = new JLabel("N° cama:");
        l1.setBounds(220,115,80,20);
        add(l1);
        
        TB = new JTextField();
        TB.setBounds(280,115,80,20);
        add(TB);
        
        l1 = new JLabel("F. de ingreso:");
        l1.setBounds(25,150,80,20);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(140,150,40,20);
        add(l1);
        l1 = new JLabel("/");
        l1.setBounds(180,150,40,20);
        add(l1);
        
        TD = new JTextField();
        TD.setBounds(110,150,25,20);        
        add(TD);
        TME = new JTextField();
        TME.setBounds(150,150,25,20);
        add(TME);
        TY = new JTextField();
        TY.setBounds(190,150,40,20);
        add(TY);
        
        l1 = new JLabel("Contactos de emergencia");
        l1.setBounds(155,185,180,20);
        l1.setFont(titulo);
        add(l1);
        
        l1 = new JLabel("Nombre:");
        l1.setBounds(25,220,80,20);
        add(l1);
        
        TN = new JTextField();
        TN.setBounds(85, 220, 150, 20);
        add(TN);
        
        l1 = new JLabel("Teléfono:");
        l1.setBounds(250,220,80,20);
        add(l1);
        
        TT = new JTextField();
        TT.setBounds(315, 220, 80, 20);
        add(TT);
        
        l1 = new JLabel("Dirección:");
        l1.setBounds(25,255,80,20);
        add(l1);
        
        TDI = new JTextArea();
        TDI.setBounds(85, 255, 340, 40);
        add(TDI);
        
        G = new JButton("Guardar");
        G.setBounds(120,300,100,30);
        G.addActionListener(this);
        add(G);
        
        C = new JButton("Cancelar");
        C.setBounds(240,300,100,30);        
        C.addActionListener(this);
        add(C);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == C){
            int res = JOptionPane.showConfirmDialog(null, "¿Desea cancelar?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(res == 0){
                dispose();
            }
        }else if(e.getSource() == G){
            if(TH.getText().isEmpty() & TB.getText().isEmpty() & TN.getText().isEmpty() & TT.getText().isEmpty() & TDI.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningun dato.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ingreso In = null;
                int Con = 0;
                for(ingreso i: ListaI){
                    if(i.MostrarCodI()==ICod){
                        In = i; break;
                    }
                    Con++;
                }
                String Me = (String) Medico.getSelectedItem();
                int codM = Integer.parseInt(Me.substring(Me.indexOf(":") + 2, Me.indexOf(",")));
                String n = TN.getText();
                String a = TDI.getText();
                int h = Integer.parseInt(TH.getText());
                int b = Integer.parseInt(TB.getText());
                int t = Integer.parseInt(TT.getText());
                int d = Integer.parseInt(TD.getText());
                int m = Integer.parseInt(TME.getText());
                int y = Integer.parseInt(TY.getText());
                In.ModCMe(codM);
                In.ModNH(h);
                In.ModNB(b);
                In.ModFI(d, m, y);
                In.ModN(n);
                In.ModC(t);
                In.ModA(a);
                ListaI.set(Con,In);
                JOptionPane.showMessageDialog(null, "Datos Guardados.", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }
    
    public ArrayList<ingreso> ObtenerModLI(){
        return ListaI;
    }
}