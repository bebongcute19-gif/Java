package BTVN04;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Manage<Order> {

    private List<Order> orders = new ArrayList<>();

    @Override
    public void add(Order item) {
        orders.add(item);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    @Override
    public void update(int index, Order item) {
        orders.set(index, item);
        System.out.println("Đơn hàng đã được sửa thành công.");
    }

    @Override
    public void delete(int index) {
        orders.remove(index);
        System.out.println("Đơn hàng đã được xóa thành công.");
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống.");
            return;
        }
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).display(i + 1);
        }
    }

    public int findIndexById(int id) {
        if (id <= 0 || id > orders.size()) {
            return -1;
        }
        return id - 1;
    }
}