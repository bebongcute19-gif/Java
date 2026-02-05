package BTVN03;
import java.util.ArrayList;
import java.util.List;

public class InvoiceManager implements Manage<Invoice> {

    private List<Invoice> invoices = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        invoices.add(item);
        System.out.println("Hóa đơn đã được thêm thành công.");
    }

    @Override
    public void update(int index, Invoice item) {
        invoices.set(index, item);
        System.out.println("Hóa đơn đã được sửa thành công.");
    }

    @Override
    public void delete(int index) {
        invoices.remove(index);
        System.out.println("Hóa đơn đã được xóa thành công.");
    }

    @Override
    public void display() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
            return;
        }
        for (int i = 0; i < invoices.size(); i++) {
            invoices.get(i).display(i + 1);
        }
    }

    public int findIndexById(int id) {
        if (id <= 0 || id > invoices.size()) {
            return -1;
        }
        return id - 1;
    }
}