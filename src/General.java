import javax.swing.*;

public class General {
    public JFrame crearventana(){
        JFrame ventana = new JFrame();
        ventana.setSize(760,760);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        return ventana;
    }
}
