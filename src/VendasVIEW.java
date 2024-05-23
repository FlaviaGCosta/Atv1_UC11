import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class vendasVIEW extends JFrame {
    private JTable table;

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Status"}, 0));
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadVendidos();
    }

    private void loadVendidos() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        ProdutosDAO produtosDAO = new ProdutosDAO();
        ArrayList<ProdutosDTO> vendidos = produtosDAO.listarProdutosVendidos();

        for (ProdutosDTO produto : vendidos) {
            model.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getValor(), produto.getStatus()});
        }
    }
}