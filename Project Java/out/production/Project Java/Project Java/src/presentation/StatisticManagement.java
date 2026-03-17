package presentation;

import business.IStatisticService;
import business.impl.StatisticServiceImpl;
import model.CourseStat;

import java.util.List;
import java.util.Scanner;

public class StatisticManagement {

    private static final IStatisticService service = new StatisticServiceImpl();

    public static void menuStatistic(Scanner sc){

        while(true){
            System.out.println("===== THỐNG KÊ =====");
            System.out.println("1. Tổng học viên & khóa học");
            System.out.println("2. Số học viên theo từng khóa");
            System.out.println("3. Top 5 khóa học đông nhất");
            System.out.println("4. Khóa học > 10 học viên");
            System.out.println("0. Quay lại");

            int choice;
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Phải nhập số!");
                continue;
            }

            switch(choice){
                case 1:
                    System.out.println("Tổng học viên: " + service.countStudents());
                    System.out.println("Tổng khóa học: " + service.countCourses());
                    break;

                case 2:
                    display(service.countStudentByCourse());
                    break;

                case 3:
                    display(service.top5Courses());
                    break;

                case 4:
                    display(service.coursesMoreThan10());
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Không hợp lệ!");
            }
        }
    }

    public static void display(List<CourseStat> list){
        if(list.isEmpty()){
            System.out.println("Không có dữ liệu!");
            return;
        }

        System.out.printf("%-5s %-25s %-10s\n",
                "ID","COURSE NAME","TOTAL");

        for(CourseStat c : list){
            System.out.printf("%-5d %-25s %-10d\n",
                    c.getCourseId(),
                    c.getCourseName(),
                    c.getTotalStudent());
        }
    }
}