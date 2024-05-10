import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class VendasVIEW extends JFrame {
    private JTable table;
    private ProdutosDAO produtosDAO;

    public VendasVIEW() {
        produtosDAO = new ProdutosDAO();
        initializeUI();
        loadVendidos();
    }

    private void initializeUI() {
        setTitle("Produtos Vendidos");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Status"}, 0));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadVendidos() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 

        for (ProdutosDTO produto : produtosDAO.listarProdutosVendidos()) {
            model.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getValor(), produto.getStatus()});
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new VendasVIEW().setVisible(true);
        });
    }
}