import javax.swing.JFrame;

public class Aplicacao {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                cadastroVIEW telaCadastro = new cadastroVIEW();
                telaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                telaCadastro.pack();
                telaCadastro.setLocationRelativeTo(null);
                telaCadastro.setVisible(true);
            }
        });
    }
}