package view;

import manager.DocumentManager;
import model.Book;
import model.Document;
import model.Magazine;
import model.News;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuDocument {
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    DocumentManager documentManager = new DocumentManager();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void showMenuDocument() {
        int choice;
        do {
            System.out.println("==========Quản lý tài liệu==========");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Xóa tài liệu");
            System.out.println("3. Sửa thông tin tài liệu");
            System.out.println("4. Hiển thị thông tin");
            System.out.println("5. Tìm kiếm theo loại tài liệu");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuRemove();
                    break;
                case 3:
                    showMenuUpdate();
                    break;
                case 4:
                    showMenuDisplay();
                    break;
                case 5:
                    searchByType();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý tài liệu!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAdd() {
        int choice;
        do {
            System.out.println("========Thêm mới tài liệu========");
            System.out.println("1. Thêm mới sách");
            System.out.println("2. Thêm mới tạp chí");
            System.out.println("3. Thêm mới báo");
            System.out.println("0. Quay lại trang quản lý");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMagazine();
                    break;
                case 3:
                    addNews();
                    break;
                case 0:
                    System.out.println("Quay lại trang quản lý!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void addBook() {
        System.out.println("=====Thêm mới sách=====");
        System.out.print("Nhập tên sách: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        String publishName = inputString.nextLine();
        System.out.print("Nhập số bản phát hành: ");
        int releaseNumber = inputNumber.nextInt();
        System.out.print("Nhập tên tác giả: ");
        String author = inputString.nextLine();
        System.out.print("Nhập số trang: ");
        int pageNumber = inputNumber.nextInt();
        Book book = new Book(name, publishName, releaseNumber, author, pageNumber);
        documentManager.add(book);
        System.out.println("Thêm sách thành công!");
    }

    private void addMagazine() {
        System.out.println("=====Thêm mới tạp chí=====");
        System.out.print("Nhập tên tạp chí: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        String publishName = inputString.nextLine();
        System.out.print("Nhập số bản phát hành: ");
        int releaseNumber = inputNumber.nextInt();
        System.out.print("Nhập số phát hành: ");
        int issueNumber = inputNumber.nextInt();
        int releaseMonth;
        do {
            System.out.print("Nhập tháng phát hành: ");
            releaseMonth = inputNumber.nextInt();
            if (releaseMonth < 1 || releaseMonth > 12) {
                System.out.println("Tháng không hợp lệ! Yêu cầu nhập lại.");
            }
        } while (releaseMonth < 1 || releaseMonth > 12);

        Magazine magazine = new Magazine(name, publishName, releaseNumber, issueNumber, releaseMonth);
        documentManager.add(magazine);
        System.out.println("Thêm tạp chí thành công!");
    }

    private void addNews() {
        System.out.println("=====Thêm mới báo=====");
        System.out.print("Nhập tên báo: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        String publishName = inputString.nextLine();
        System.out.print("Nhập số bản phát hành: ");
        int releaseNumber = inputNumber.nextInt();
        LocalDate releaseDate = null;
        while (releaseDate == null) {
            System.out.print("Nhập ngày phát hành: ");
            String date = inputString.nextLine();
            try {
                releaseDate = LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
            }
        }
        News news = new News(name, publishName, releaseNumber, releaseDate);
        documentManager.add(news);
        System.out.println("Thêm báo thành công!");
    }

    public void showMenuDisplay() {
        int choice;
        do {
            System.out.println("========Hiển thị thông tin========");
            System.out.println("1. Hiển thị tất cả tài liệu");
            System.out.println("2. Hiển thị thông tin sách");
            System.out.println("3. Hiển thị thông tin tạp chí");
            System.out.println("4. Hiển thị thông tin báo");
            System.out.println("0. Quay lại trang quản lý");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    showAllDocuments();
                    break;
                case 2:
                    showBookDocuments();
                    break;
                case 3:
                    showMagazineDocuments();
                    break;
                case 4:
                    showNewsDocuments();
                    break;
                case 0:
                    System.out.println("Quay lại trang quản lý!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void showAllDocuments() {
        System.out.println("=====Hiện thị tất cả tài liệu=====");
        ArrayList<Document> documents = documentManager.getAll();
        if (documents.isEmpty()) {
            System.out.println("Chưa có tài liệu nào!");
        }
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public void showBookDocuments() {
        System.out.println("=====Hiển thị thông tin sách=====");
        ArrayList<Document> documents = documentManager.getAll();
        for (Document document : documents) {
            if (document instanceof Book) {
                System.out.println(document);
            }
        }
    }

    public void showMagazineDocuments() {
        System.out.println("=====Hiển thị thông tin tạp chí=====");
        ArrayList<Document> documents = documentManager.getAll();
        for (Document document : documents) {
            if (document instanceof Magazine) {
                System.out.println(document);
            }
        }
    }

    public void showNewsDocuments() {
        System.out.println("=====Hiển thị thông tin báo=====");
        ArrayList<Document> documents = documentManager.getAll();
        for (Document document : documents) {
            if (document instanceof News) {
                System.out.println(document);
            }
        }
    }

    public void showMenuRemove() {
        System.out.println("========Xóa tài liệu========");
        int idRemove;
        System.out.print("Nhập mã tài liệu muốn xóa: ");
        idRemove = inputNumber.nextInt();
        if (documentManager.findIndexById(idRemove) == -1) {
            System.out.println("Không tìm thấy mã tài liệu!");
        } else {
            documentManager.remove(idRemove);
            System.out.println("Xóa tài liệu thành công!");
        }
    }

    public void searchByType() {
        int choice;
        do {
            System.out.println("========Tìm kiếm theo loại tài liệu========");
            System.out.println("1. Tìm kiếm sách");
            System.out.println("2. Tìm kiếm tạp chí");
            System.out.println("3. Tìm kiếm báo");
            System.out.println("0. Quay lại trang quản lý");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    searchMagazine();
                    break;
                case 3:
                    searchNews();
                    break;
                case 0:
                    System.out.println("Quay lai trang quản lý!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void searchBook(){
        System.out.println("=====Tìm kiếm sách=====");
        ArrayList<Book> books = documentManager.getBook();
        if (books.isEmpty()) {
            System.out.println("Không tìm thấy loại tài liệu sách!");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void searchMagazine(){
        System.out.println("=====Tìm kiếm tạp chí=====");
        ArrayList<Magazine> magazines = documentManager.getMagazine();
        if (magazines.isEmpty()) {
            System.out.println("Không tìm thấy loại tài liệu tạp chí!");
        } else {
            for (Magazine magazine : magazines) {
                System.out.println(magazine);
            }
        }
    }

    public void searchNews(){
        System.out.println("=====Tìm kiếm báo=====");
        ArrayList<News> news = documentManager.getNews();
        if (news.isEmpty()) {
            System.out.println("Không tìm thấy loại tài liệu báo!");
        } else {
            for (News newspaper : news){
                System.out.println(newspaper);
            }
        }
    }

    public void showMenuUpdate(){
        System.out.println("========Sửa thông tin tài liệu========");
        System.out.print("Nhập mã tài liệu muốn sửa: ");
        int idEdit = inputNumber.nextInt();
        Document oldDocument = documentManager.findDocumentById(idEdit);
        if (oldDocument != null) {
            System.out.println("Tài liệu cũ: \n" + oldDocument);
            Document newDocument = null;
            if (oldDocument instanceof Book) {
                System.out.println("=====Sửa thông tin sách=====");
                System.out.print("Nhập tên sách: ");
                String name = inputString.nextLine();
                System.out.print("Nhập tên nhà xuất bản: ");
                String publishName = inputString.nextLine();
                System.out.print("Nhập số bản phát hành: ");
                int releaseNumber = inputNumber.nextInt();
                System.out.print("Nhập tên tác giả: ");
                String author = inputString.nextLine();
                System.out.print("Nhập số trang: ");
                int pageNumber = inputNumber.nextInt();
                Book book = new Book(idEdit, name, publishName, releaseNumber, author, pageNumber);
                documentManager.update(book, idEdit);
                System.out.println("Sửa thông tin sách thành công!");
            } else if (oldDocument instanceof Magazine) {
                System.out.println("=====Sửa thông tin tạp chí=====");
                System.out.print("Nhập tên tạp chí: ");
                String name = inputString.nextLine();
                System.out.print("Nhập tên nhà xuất bản: ");
                String publishName = inputString.nextLine();
                System.out.print("Nhập số bản phát hành: ");
                int releaseNumber = inputNumber.nextInt();
                System.out.print("Nhập số phát hành: ");
                int issueNumber = inputNumber.nextInt();
                int releaseMonth;
                do {
                    System.out.print("Nhập tháng phát hành: ");
                    releaseMonth = inputNumber.nextInt();
                    if (releaseMonth < 1 || releaseMonth > 12) {
                        System.out.println("Tháng không hợp lệ! Yêu cầu nhập lại.");
                    }
                } while (releaseMonth < 1 || releaseMonth > 12);
                Magazine magazine = new Magazine(idEdit, name, publishName, releaseNumber, issueNumber, releaseMonth);
                documentManager.update(magazine, idEdit);
                System.out.println("Sửa thông tin tạp chí thành công!");
            } else if (oldDocument instanceof News){
                System.out.println("=====Sửa thông tin báo=====");
                System.out.print("Nhập tên báo: ");
                String name = inputString.nextLine();
                System.out.print("Nhập tên nhà xuất bản: ");
                String publishName = inputString.nextLine();
                System.out.print("Nhập số bản phát hành: ");
                int releaseNumber = inputNumber.nextInt();
                LocalDate releaseDate = null;
                while (releaseDate == null) {
                    System.out.print("Nhập ngày phát hành: ");
                    String date = inputString.nextLine();
                    try {
                        releaseDate = LocalDate.parse(date, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
                    }
                }
                News news = new News(idEdit, name, publishName, releaseNumber, releaseDate);
                documentManager.update(news, idEdit);
                System.out.println("Sửa thông tin báo thành công!");
            }
        } else {
            System.out.println("Không tìm thấy tài liệu!");
        }

    }

}
